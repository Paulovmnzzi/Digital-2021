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
import com.digitalers.domain.Categorias;
import com.digitalers.domain.Marcas;
import com.digitalers.enums.ViewEnums;
import com.digitalers.enums.ViewKeyEnums;
import com.digitalers.service.ArticulosService;
import com.digitalers.service.CategoriasService;
import com.digitalers.service.MarcasService;
import com.digitalers.service.impl.ArticulosServiceImpl;
import com.digitalers.service.impl.CategoriaServiceImpl;
import com.digitalers.service.impl.MarcasServiceImpl;

@WebServlet("/controllers/CargarParaEditarProductoServlet")
public class CargarParaEditarProductoServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		
		ViewEnums target = ViewEnums.EDITAR_PRODUCTO;
		
		ArticulosService ar = new ArticulosServiceImpl();
		CategoriasService cs = new CategoriaServiceImpl();
		MarcasService ms = new MarcasServiceImpl();
		
		try {
			Articulos articulo = ar.getOne(Long.parseLong(id));
			List<Categorias> categorias = cs.findAll();
			List<Marcas> marcas = ms.findAll();
			
			//req.setAttribute(ViewKeyEnums.PRODUCTO_EDITAR, categorias);
			addAttribute(req, ViewKeyEnums.PRODUCTO_EDITAR, articulo);
			
			req.setAttribute("categorias", categorias);
			req.setAttribute("marcas", marcas);
			
		}catch (Exception e) {
			addAttribute(req, ViewKeyEnums.ERROR_GENERAL, e.getMessage());
			target = ViewEnums.LISTADO_GENERAL;
			
			Collection<Articulos> articulos;
			try {
				articulos = ar.findAll();				
			}catch (Exception e2) {
				articulos = new ArrayList<>();
			}
			
			addAttribute(req, ViewKeyEnums.LISTADO, articulos);
		}
		
		redirect(target, req, resp);
	}
}
