package com.digital.service.impl;

import java.util.List;

import com.digital.dao.impl.CategoriasDaoImpl;
import com.digital.domain.Categorias;
import com.digital.exception.GenericException;
import com.digital.service.CategoriasService;
import com.digital.service.ServiceException;

public class CategoriasServiceImpl extends AbstractBaseService<Categorias> implements CategoriasService{

	public CategoriasServiceImpl() {
		super(new CategoriasDaoImpl());
	}
	

	
}
