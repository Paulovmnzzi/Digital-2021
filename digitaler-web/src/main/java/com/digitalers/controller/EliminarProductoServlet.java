package com.digitalers.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

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

@WebServlet("/controllers/EliminarProductoServlet")
public class EliminarProductoServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter(ViewKeyEnums.ID_PRODUCTO.getViewKey());
		
		if(id == null || "".equals(id.trim())) {
			
		}else {
			Long idL = Long.parseLong(id);
			ArticulosService ar = new ArticulosServiceImpl();
			try {
				ar.delete(idL);
				addAttribute(req, ViewKeyEnums.EXITO, "Se ha eliminado el producto id: " +id);
			} catch (ServiceException e) {
				addAttribute(req, ViewKeyEnums.ERROR_GENERAL, e.getMessage());
			}finally {
				Collection<Articulos> productos;
				try {
					productos = ar.findAll();
				} catch (ServiceException e) {
					productos = new ArrayList<>();
				}
				addAttribute(req, ViewKeyEnums.LISTADO, productos);
			}
		}
		
		redirect(ViewEnums.LISTADO_GENERAL, req, resp);
	}
}
