package com.digitalers.dao;

import java.util.List;

import com.digitalers.dao.impl.ArticulosDaoImpl;
import com.digitalers.domain.Articulos;
import com.digitalers.exception.GenericException;

public class ArticulosDaoTestCase {

	public static void main(String[] args) throws GenericException {
		
		Long id = 1L;
		
		ArticulosDao dao = new ArticulosDaoImpl();
		
		Articulos articulo = dao.getOne(id);
		
		System.out.println(articulo);
		
		System.out.println("--------------------");
		
		List<Articulos> list = dao.findAll();
		for(Articulos entity : list) {
			System.out.println(entity);
		}
	}

}
