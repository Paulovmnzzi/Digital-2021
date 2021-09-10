package com.digitalers.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digitalers.domain.User;
import com.digitalers.enums.ViewEnums;
import com.digitalers.enums.ViewKeyEnums;
import com.digitalers.service.LoginService;
import com.digitalers.service.ServiceException;
import com.digitalers.service.impl.LoginServiceImp;

import at.favre.lib.crypto.bcrypt.BCrypt;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");//eduit
		String password = req.getParameter("password");//eduit
		
		LoginService loginService = new LoginServiceImp();
		
		ViewEnums target  = ViewEnums.LOGIN;
		
		try {
			
			if("".equals(username) || "".equals(password)) {
				req.setAttribute(ViewKeyEnums.ERROR_GENERAL.name(), "El usuario/password vacios");
			}else {
			
				User user = loginService.getUserByUserName(username);
				
				if(user != null) {
					
					BCrypt.Result result = BCrypt.verifyer().verify(password.getBytes(), user.getPassword().getBytes());					
					
					if(result.verified) {					
						req.getSession().setAttribute(ViewKeyEnums.USUARIO.name(), user);
						target = ViewEnums.LOGIN_SUCCESS;	
					}else {
						req.setAttribute(ViewKeyEnums.ERROR_GENERAL.name(), "El usuario/password no existe");
					}
				}else {
					req.setAttribute(ViewKeyEnums.ERROR_GENERAL.name(), "El usuario/password no existe");
				}
			}
		} catch (ServiceException e) {			
			req.setAttribute(ViewKeyEnums.ERROR_GENERAL.name(), e.getMessage());
		} 
		
		//redireccion a otra jsp
		RequestDispatcher rd = getServletContext().getRequestDispatcher(target.getView());		
		rd.forward(req, resp);		
	}
}
