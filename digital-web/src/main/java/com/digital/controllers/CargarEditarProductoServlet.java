package com.digital.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.batik.apps.svgbrowser.JSVGViewerFrame.ViewSourceAction;

import com.digital.domain.Categorias;
import com.digital.domain.Marcas;
import com.digital.domain.Producto;
import com.digital.enums.KeysEnum;
import com.digital.enums.ViewEnums;
import com.digital.service.CategoriasService;
import com.digital.service.MarcasService;
import com.digital.service.ProductoService;
import com.digital.service.ServiceException;
import com.digital.service.impl.CategoriasServiceImpl;
import com.digital.service.impl.MarcasServiceImpl;
import com.digital.service.impl.ProductoServiceImpl;

@WebServlet("/controllers/CargarEditarProducto")
public class CargarEditarProductoServlet extends HttpServlet {

	MarcasService ms = new MarcasServiceImpl();
	CategoriasService cs = new CategoriasServiceImpl();
	ProductoService ps = new ProductoServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String idAux = req.getParameter("id");
		
		try {
			cargarCombos(req);
			Long id = Long.parseLong(idAux);
			Producto prod = ps.getOne(id);
			req.setAttribute(KeysEnum.PRODUCTO_EDITAR.getViewKey(), prod);
			getServletContext().getRequestDispatcher(ViewEnums.EDITAR_PRODUCTO.getView()).forward(req, resp);
			
		} catch (ServiceException e) {
			getServletContext().getRequestDispatcher(ViewEnums.LISTADO_GENERAL.getView()).forward(req, resp);
		}

	}

	private void cargarCombos(HttpServletRequest req) throws ServiceException {
		List<Categorias> clist = cs.findAll();
		List<Marcas> mlist = ms.findAll();
		if (clist != null || mlist != null) {
			req.setAttribute("categorias", clist);
			req.setAttribute("marcas", mlist);
		}
	}

}
