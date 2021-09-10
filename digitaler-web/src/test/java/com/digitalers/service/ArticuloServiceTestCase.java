package com.digitalers.service;

import java.util.Date;

import com.digitalers.domain.Articulos;
import com.digitalers.service.impl.ArticulosServiceImpl;

public class ArticuloServiceTestCase {

	/**
	 * Mostrar los datos del articulo de id 1
	 * @param args
	 * @throws ServiceException 
	 */
	public static void main(String[] args) throws ServiceException {
		
		ArticulosService service = new ArticulosServiceImpl();
		
		Articulos articulo = new Articulos();
		
		articulo.setCategoriasId(1L);
		articulo.setCodigo("0003");
		articulo.setFechaCreacion(new Date());
		articulo.setMarcasId(1L);
		articulo.setPrecio(1500d);
		articulo.setStock(2L);
		articulo.setTitulo("Mouse 3");
		
		service.save(articulo);
		
		System.out.println(articulo);
		System.out.println("------------");
		
		articulo.setPrecio(articulo.getPrecio() + 150);
		articulo.setTitulo("MOUSE MAS COPADO");
		service.update(articulo);
		
		articulo = service.getOne(articulo.getId());
		System.out.println(articulo);
	}

}
