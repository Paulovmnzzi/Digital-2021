package com.digital.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bouncycastle.asn1.icao.CscaMasterList;

import com.digital.dao.impl.ColumnEnum;
import com.digital.domain.Categorias;
import com.digital.domain.Producto;
import com.digital.enums.ViewEnums;
import com.digital.service.CategoriasService;
import com.digital.service.GenericService;
import com.digital.service.ProductoService;
import com.digital.service.ServiceException;
import com.digital.service.impl.CategoriasServiceImpl;
import com.digital.service.impl.ProductoServiceImpl;
@WebServlet("/nuevoProducto")
public class nuevoProductoServlet extends HttpServlet {
	
	
	CategoriasService cs = new CategoriasServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
		
			cargarCombos(req);

		String titulo = req.getParameter("titulo");
		String codigo = req.getParameter("codigo");
		String precio = req.getParameter("precio");
		String categoria = req.getParameter("categoria");
		String marca = req.getParameter("marca");
		String stock = req.getParameter("stock");
		
		if(titulo != null) {
		Long codigoAux = Long.parseLong(codigo);
		Double precioAux = Double.parseDouble(precio);
		Long stockAux = Long.parseLong(stock);
		Long marcaAux = Long.parseLong(marca);
		Long categoriaAux = Long.parseLong(categoria);
		
		
		Producto nuevoProducto = new Producto(titulo, codigo, new Date(), precioAux, stockAux, marcaAux, categoriaAux);
		
		ProductoService prod = new ProductoServiceImpl();
		
			prod.save(nuevoProducto);
		}
			getServletContext().getRequestDispatcher(ViewEnums.NUEVO_PRODUCTO.getView()).forward(req, resp);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	private void cargarCombos(HttpServletRequest req) throws ServiceException {
		List<Categorias> clist = cs.findAll();
		if(clist != null) {
			req.setAttribute("categorias", clist);
		}
	}
	
	
}
