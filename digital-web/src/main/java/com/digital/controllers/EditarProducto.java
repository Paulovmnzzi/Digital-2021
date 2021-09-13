package com.digital.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digital.domain.Producto;
import com.digital.enums.KeysEnum;
import com.digital.enums.ViewEnums;
import com.digital.service.ProductoService;
import com.digital.service.ServiceException;
import com.digital.service.impl.ProductoServiceImpl;
@WebServlet("/controllers/editarProducto")
public class EditarProducto extends HttpServlet{

	ProductoService ps = new ProductoServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		String titulo = req.getParameter("titulo");
		String codigo = req.getParameter("codigo");
		String precio = req.getParameter("precio");
		String categoria = req.getParameter("categoria");
		String marca = req.getParameter("marca");
		String stock = req.getParameter("stock");
		
		if(titulo != null) {
		Long idAux = Long.parseLong(id);
		Double precioAux = Double.parseDouble(precio);
		Long stockAux = Long.parseLong(stock);
		Long marcaAux = Long.parseLong(marca);
		Long categoriaAux = Long.parseLong(categoria);
		
		Producto nuevoProducto = new Producto(idAux, titulo, codigo, precioAux, stockAux, marcaAux, categoriaAux);
		ViewEnums target = ViewEnums.LISTADO_GENERAL;
		try {
			ps.update(nuevoProducto);
			req.setAttribute(KeysEnum.EXITO.getViewKey(), "Producto cargado con éxito");
			
		} catch (ServiceException e) {
			target = ViewEnums.EDITAR_PRODUCTO;
			req.setAttribute(KeysEnum.ERROR_GENERAL.getViewKey(), "No se pudo cargar el producto, intentelo nuevamente.");
		}
		
		getServletContext().getRequestDispatcher(target.getView()).forward(req, resp);
		
		}
		
		
		
		
	}
	
}
