package com.digitalers.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digitalers.domain.Articulos;
import com.digitalers.enums.ViewEnums;
import com.digitalers.enums.ViewKeyEnums;
import com.digitalers.service.ArticulosService;
import com.digitalers.service.ServiceException;
import com.digitalers.service.impl.ArticulosServiceImpl;

@WebServlet("/controllers/CargarProductosServlet")
public class CargarProductosServlet extends BaseServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//casteo
		Collection<Articulos> articulos = (Collection<Articulos>)req.getSession().getAttribute(ViewKeyEnums.UPLOAD_PREVIEW_KEY.name());
		
		ArticulosService ar = new ArticulosServiceImpl();
		
		List<Articulos> exitos = new ArrayList<>();
		List<Articulos> errores = new ArrayList<>();
		
		//grabar cada articulo
		for(Articulos art : articulos) {
			try {
				ar.save(art);
				exitos.add(art);
			} catch (ServiceException e) {
				errores.add(art);
			}
		}
		
		//guarda en la sesion y request
		req.getSession().setAttribute(ViewKeyEnums.LISTADO_FAIL.name(), errores);
		
		req.setAttribute(ViewKeyEnums.LISTADO_OK.name(), exitos);
		
		redirect(ViewEnums.RESULTADO_PREVIEW, req, resp);
	}
}
