package com.digital.controllers.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.digital.domain.User;
import com.digital.enums.KeysEnum;
import com.digital.enums.ViewEnums;
@WebFilter(filterName = "/SessionFilter", urlPatterns = "/*")
public class SessionFIlter implements Filter{

	private ServletContext context;

	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("AuthenticationFilter initialized");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		//HttpServletResponse res = (HttpServletResponse) response;

		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		
		this.context.log("Requested Resource::" + uri);

		HttpSession session = req.getSession(false);

		final List<String> validatePath = Arrays.asList(
				contextPath+"/controllers/",
				"/views/editarProducto.jsp", "/views/productoNuevo.jsp"
		);
				
		boolean mustValidatePath = validatePath.stream()
				.filter(x -> uri.contains(x) )
				.count() > 0;
		
		if(mustValidatePath) {

			if (session == null) {
				this.context.log("Unauthorized access request");
				request.setAttribute(KeysEnum.ERROR_GENERAL.getViewKey(), KeysEnum.USUARIO_SESSION_INVALIDA.getViewKey());
				//res.sendRedirect(req.getContextPath()+"/login.jsp");
				req.getRequestDispatcher(ViewEnums.LOGIN.getView()).forward(request, response);
			} else {
				
				User loggedUser = (User)session.getAttribute(KeysEnum.USUARIO.getViewKey());
				
				if(loggedUser != null) {
					// pass the request along the filter chain
					chain.doFilter(request, response);
				}else {
					this.context.log("Unauthorized access request");
					request.setAttribute(KeysEnum.ERROR_GENERAL.getViewKey(), KeysEnum.USUARIO_SESSION_INVALIDA.getViewKey());
					//res.sendRedirect(req.getContextPath()+"/login.jsp");
					req.getRequestDispatcher(ViewEnums.LOGIN.getView()).forward(request, response);
				}
			}
		}else {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
	}

	public void destroy() {
		// close any resources here
	}

}
