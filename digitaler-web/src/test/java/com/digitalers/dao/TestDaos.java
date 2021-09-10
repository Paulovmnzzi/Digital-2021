package com.digitalers.dao;

import com.digitalers.dao.impl.ArticulosDaoImpl;
import com.digitalers.dao.impl.CategoriasDaoImpl;
import com.digitalers.dao.impl.CuponesDaoImpl;
import com.digitalers.domain.Articulos;
import com.digitalers.domain.Categorias;
import com.digitalers.domain.Cupones;
import com.digitalers.exception.GenericException;

public class TestDaos {

	public static void main(String[] args) throws GenericException {
		
		Long id = 1l;
		
		ArticulosDao articuloDao = new ArticulosDaoImpl();
		CategoriasDao categoriaDao = new CategoriasDaoImpl();		
		CuponesDao cuponDao = new CuponesDaoImpl();
		
		Articulos articulo = articuloDao.getOne(id);
		Categorias categoria = categoriaDao.getOne(id);
		Cupones cupon = cuponDao.getOne(id);
		
		System.out.println(articulo);
		System.out.println(categoria);
		System.out.println(cupon);
	}

}

