package com.digital.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digital.domain.Producto;
import com.digital.enums.KeysEnum;
import com.digital.enums.ViewEnums;
import com.digital.exception.GenericException;
import com.digital.service.ProductoService;
import com.digital.service.ServiceException;
import com.digital.service.impl.ProductoServiceImpl;

@WebServlet("/EliminarProducto")
public class EliminarProductoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter(KeysEnum.ID_PRODUCTO.getViewKey());
		
		if(id == null || "".equals(id.trim())) {
			
		}else {
			Long idL = Long.parseLong(id);
			ProductoService ar = new ProductoServiceImpl();
			try {
				ar.delete(idL);
				req.setAttribute(KeysEnum.EXITO.getViewKey(), "Se ha eliminado el producto id: " +id);
			} catch (ServiceException e) {
				req.setAttribute(KeysEnum.ERROR_GENERAL.getViewKey(), e.getMessage());
			}finally {
				Collection<Producto> productos;
				try {
					productos = ar.findAll();
				} catch (ServiceException e) {
					productos = new ArrayList<>();
				}
				req.setAttribute(KeysEnum.LISTADO.getViewKey(), productos);
			}
		}
		
		req.getRequestDispatcher(ViewEnums.LISTADO_GENERAL.getView()).forward(req, resp);;
	}
}
