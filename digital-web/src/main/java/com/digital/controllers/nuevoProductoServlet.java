package com.digital.controllers;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digital.dao.util.ColumnEnum;
import com.digital.domain.Producto;
import com.digital.enums.ViewEnums;
import com.digital.service.GenericService;
import com.digital.service.ProductoService;
import com.digital.service.ServiceException;
import com.digital.service.impl.ProductoServiceImpl;
@WebServlet("/nuevoProducto")
public class nuevoProductoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String titulo = req.getParameter("titulo");
		String codigo = req.getParameter("codigo");
		String precio = req.getParameter("precio");
		
		Integer codigoAux = Integer.parseInt(codigo);
		Integer precioAux = Integer.parseInt(precio);
		
		Producto nuevoProducto = new Producto(titulo, codigoAux, precioAux);
		
		ProductoService prod = new ProductoServiceImpl();
		
		try {
			prod.save(nuevoProducto);
			getServletContext().getRequestDispatcher(ViewEnums.NUEVO_PRODUCTO.getView()).forward(req, resp);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
