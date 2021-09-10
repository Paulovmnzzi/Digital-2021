package com.digitalers.controller;

import java.io.IOException;
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

@WebServlet("/controllers/ActualizarProductoServlet")
public class ActualizarProductoServlet extends BaseServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//capturar los datos que envia la jsp
		String id = req.getParameter("id");
		String codigo = req.getParameter("codigo");
		String titulo = req.getParameter("titulo");
		String precio = req.getParameter("precio");
		String categoriaId = req.getParameter("categoriasId");
		String marcasId = req.getParameter("marcasId");
		String stock = req.getParameter("stock");
		
		ViewEnums target = ViewEnums.LISTADO_GENERAL;
		
		Articulos articuloActualizar = null;
		
		Long idLong = Long.parseLong(id);
		Double precioF = Double.parseDouble(precio);
		Long categroiasIdL = Long.parseLong(categoriaId);
		Long marcasIdL = Long.parseLong(marcasId);
		Long stockL = Long.parseLong(stock);
		
		articuloActualizar = new Articulos(idLong, titulo, codigo, precioF, stockL, marcasIdL, categroiasIdL);
		
		ArticulosService ar = new ArticulosServiceImpl();
		try {
			ar.update(articuloActualizar);
			
			addAttribute(req, ViewKeyEnums.EXITO, "Se ha actualizao exitosamente el articulo id:" + articuloActualizar.getId());
			
			//RECARGO LOS DATOS PARA MOSTRARLOS EN EL LISTADO GENERAL
			Collection<Articulos> productos = ar.findAll();
			req.setAttribute(ViewKeyEnums.LISTADO.name(), productos);
			
			//calcular la suma de los productos
			Double suma = productos.stream()
				.map(a -> a.getPrecio())
				.reduce(0d, (x,y)-> x+y);
			
			addAttribute(req, ViewKeyEnums.TOTAL, suma);
		} catch (ServiceException e) {
			addAttribute(req, ViewKeyEnums.ERROR_GENERAL, e.getMessage());
			target = ViewEnums.EDITAR_PRODUCTO;
			
			addAttribute(req, ViewKeyEnums.PRODUCTO_EDITAR, articuloActualizar);
		}
		
		redirect(target, req, resp);
	}
}
