package com.digital.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digital.domain.User;
import com.digital.enums.KeysEnum;
import com.digital.enums.ViewEnums;
import com.mysql.cj.Session;

@WebServlet("/Logout")
public class LogoutControllerServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User usuario = (User)req.getAttribute(KeysEnum.USUARIO.getViewKey());
		
		if(usuario != null) {
			req.setAttribute(KeysEnum.USUARIO.getViewKey(), null);
			req.setAttribute(KeysEnum.EXITO.getViewKey(), "Hasta la proxima " + usuario.getUsuario());
			req.getServletContext().getRequestDispatcher(ViewEnums.INICIO.getView()).forward(req, resp);
		}else {
			req.setAttribute(KeysEnum.ERROR_GENERAL.getViewKey(), KeysEnum.USUARIO_SESSION_INVALIDA.getViewKey());
			req.getServletContext().getRequestDispatcher(ViewEnums.INICIO.getView()).forward(req, resp);
		}
		
	}
	
	
}
