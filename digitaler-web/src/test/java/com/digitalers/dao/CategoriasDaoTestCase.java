package com.digitalers.dao;

import com.digitalers.dao.impl.CategoriasDaoImpl;
import com.digitalers.domain.Categorias;
import com.digitalers.exception.GenericException;

public class CategoriasDaoTestCase {

	public static void main(String[] args) throws GenericException {
		
		Long id = 1L;
		
		CategoriasDao dao = new CategoriasDaoImpl();
		
		Categorias entity = dao.getOne(id);
		
		System.out.println(entity);
		
		System.out.println(dao.findAll());
	}

}
