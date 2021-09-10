package com.digital.service.impl;

import com.digital.dao.impl.CategoriasDaoImpl;
import com.digital.domain.Categorias;
import com.digital.service.CategoriasService;

public class CategoriasServiceImpl extends AbstractBaseService<Categorias> implements CategoriasService{

	public CategoriasServiceImpl() {
		super(new CategoriasDaoImpl());
	}
	
}
