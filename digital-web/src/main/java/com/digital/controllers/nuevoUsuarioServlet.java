package com.digital.controllers;

import java.io.IOException;
import java.sql.SQLException;

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

@WebServlet("/Register/nuevoUsuario")
public class nuevoUsuarioServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String newUser = req.getParameter("newUsuario");
		String password = req.getParameter("newPassword");
		String password2 = req.getParameter("newPassword2");

		LoginService login = new LoginServiceImpl();
		ViewEnums target = ViewEnums.LOGIN;

		try {
			if ("".equals(newUser) || "".equals(password)) {
				req.setAttribute(KeysEnum.ERROR_GENERAL.getViewKey(), "El usuario/password vacios");
				target = ViewEnums.REGISTRO;
			} else {
				User user = login.findByUsername(newUser);
				if (user != null) {
					if (user.getUsuario().equals(newUser)) {
						req.setAttribute(KeysEnum.ERROR_GENERAL.getViewKey(), "El usuario ya existe");
						target = ViewEnums.REGISTRO;
					} 
				} else {
					if (password.equals(password2)) {
						User newUserr = new User(newUser, password2);
						login.save(newUserr);
					} else {
						req.setAttribute(KeysEnum.ERROR_GENERAL.getViewKey(), "Las contraseñas no coinciden");
						target = ViewEnums.REGISTRO;
					}
				}
			}
		} catch (SQLException | GenericException | ServiceException e) {

		}
		req.getServletContext().getRequestDispatcher(target.getView()).forward(req, resp);
	}
}
