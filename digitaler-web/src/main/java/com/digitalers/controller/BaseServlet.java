package com.digitalers.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digitalers.enums.ViewEnums;
import com.digitalers.enums.ViewKeyEnums;

public class BaseServlet extends HttpServlet {

	public void redirect(ViewEnums target, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher(target.getView()).forward(req, resp);
	}
	
	public static void addAttribute(HttpServletRequest request, ViewKeyEnums key, Object value ) {
		request.setAttribute(key.name(), value);
	}
}
