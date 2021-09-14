package com.digital.controllers;

import java.io.IOException;


import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digital.domain.User;
import com.digital.enums.KeysEnum;
import com.digital.enums.ViewEnums;
import com.digital.exception.GenericException;
import com.digital.service.LoginService;
import com.digital.service.ServiceException;
import com.digital.service.impl.LoginServiceImpl;

import at.favre.lib.crypto.bcrypt.BCrypt;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		LoginService login = new LoginServiceImpl();
		
		ViewEnums target = ViewEnums.LOGIN;
		
		try {
			
			if("".equals(username) || "".equals(password)) {
				req.setAttribute(KeysEnum.ERROR_GENERAL.getViewKey(), "El usuario/password vacios");
			}else {
				
				User user = login.findByUsername(username);
				if(user != null) {	
					if(password.equals(user.getPassword())) {
							req.getSession().setAttribute(KeysEnum.USUARIO.getViewKey(), user);
							target = ViewEnums.LOGIN_SUCCESS;
					}else {
						req.getSession().setAttribute(KeysEnum.ERROR_GENERAL.getViewKey(), "El usuario/Password es incorrecto");
					}
					req.getSession().setAttribute(KeysEnum.ERROR_GENERAL.getViewKey(), "El usuario/Password es incorrecto");
				}else {
					req.getSession().setAttribute(KeysEnum.ERROR_GENERAL.getViewKey(), "El usuario/Password es incorrecto");

				}
			}
			} catch (SQLException | GenericException e) {
				req.getSession().setAttribute(KeysEnum.ERROR_GENERAL.getViewKey(), e.getMessage());
			}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(target.getView());
	
		rd.forward(req, resp);
		
	}
	
}
