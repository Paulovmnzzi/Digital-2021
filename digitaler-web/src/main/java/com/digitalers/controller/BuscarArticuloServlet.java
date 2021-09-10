package com.digitalers.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digitalers.controller.comparator.OrdenAsc;
import com.digitalers.controller.comparator.OrdenDesc;
import com.digitalers.domain.Articulos;
import com.digitalers.enums.ViewEnums;
import com.digitalers.enums.ViewKeyEnums;
import com.digitalers.service.ArticulosService;
import com.digitalers.service.ServiceException;
import com.digitalers.service.impl.ArticulosServiceImpl;

@WebServlet("/controllers/BuscarArticuloServlet")
public class BuscarArticuloServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String claveBusqueda = req.getParameter(ViewKeyEnums.CLAVE_BUSQUEDA.getViewKey());
		
		if(claveBusqueda == null || claveBusqueda.trim().equals("")) {
			claveBusqueda = "";
		}
		
		ArticulosService as = new ArticulosServiceImpl();
		
		Collection<Articulos> articulos = new ArrayList<>(); 
		
		try {
			if(!claveBusqueda.equals("")) {
				articulos = as.findAllBy(claveBusqueda);
			}else {
				articulos = as.findAll();
			}
			req.setAttribute(ViewKeyEnums.LISTADO.name(), articulos);
			
			if(articulos.isEmpty()) {
				req.setAttribute(ViewKeyEnums.WARNING_GENERAL.name(), "No hay datos para: " + claveBusqueda);
			}
			
			
			String orden = req.getParameter("orden");
			if(orden != null) {
				if("asc".equals(orden)) {
					Collections.sort((List)articulos, new OrdenAsc());
				}else {
					Collections.sort((List)articulos, new OrdenDesc());
				}
			}
			
			//cargar el total
			Double suma = articulos.stream()
				.map(a -> a.getPrecio())
				.reduce(0d, (x,y)-> x+y);
			
			addAttribute(req, ViewKeyEnums.TOTAL, suma);
		} catch (ServiceException e) {				
			req.setAttribute(ViewKeyEnums.ERROR_GENERAL.getViewKey(), e.getMessage());
		}
		
		redirect(ViewEnums.LISTADO_GENERAL, req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
