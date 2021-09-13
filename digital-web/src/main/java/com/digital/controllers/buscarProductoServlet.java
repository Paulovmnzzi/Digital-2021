package com.digital.controllers;

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

import com.digital.controllers.orden.OrdenAsc;
import com.digital.controllers.orden.OrdenDesc;
import com.digital.dao.impl.ColumnEnum;
import com.digital.domain.Producto;
import com.digital.enums.KeysEnum;
import com.digital.enums.ViewEnums;
import com.digital.exception.GenericException;
import com.digital.service.ProductoService;
import com.digital.service.ServiceException;
import com.digital.service.impl.ProductoServiceImpl;
@WebServlet("/controllers/buscarProducto")
public class buscarProductoServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String claveBusqueda = req.getParameter(KeysEnum.CLAVE_BUSQUEDA.getViewKey());
		String claveBusquedaPrecio = req.getParameter(KeysEnum.CLAVE_BUSQUEDA_PRECIO.getViewKey());
		
		ProductoService ps = new ProductoServiceImpl();
		String columna = ColumnEnum.TITULO.getColumn();
		
		if(claveBusqueda == null || claveBusqueda.trim().equals("") && claveBusquedaPrecio != null) {
			columna = ColumnEnum.PRECIO.getColumn();
			claveBusqueda = claveBusquedaPrecio;
		}
		List<Producto> lista = new ArrayList<Producto>();
		
		try {
			if(claveBusqueda.equals("")) {
				lista = ps.findAll();
			}else {
				lista = ps.findAllBy(claveBusqueda, columna);
			}
			req.setAttribute(KeysEnum.LISTADO.name(), lista);
			
			String orden = req.getParameter("orden");
			if(orden != null) {
				if(orden.equals("asc")) {
					Collections.sort(lista, new OrdenAsc());
				}else {
					Collections.sort(lista, new OrdenDesc());
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		getServletContext().getRequestDispatcher(ViewEnums.LISTADO_GENERAL.getView()).forward(req, resp);
	}
	
}
