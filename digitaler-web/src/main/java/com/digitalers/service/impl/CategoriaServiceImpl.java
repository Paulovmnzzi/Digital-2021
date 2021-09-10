package com.digitalers.service.impl;

import java.util.List;

import com.digitalers.dao.impl.CategoriasDaoImpl;
import com.digitalers.domain.Categorias;
import com.digitalers.exception.GenericException;
import com.digitalers.service.CategoriasService;
import com.digitalers.service.ServiceException;


public class CategoriaServiceImpl extends AbstractBaseService<Categorias> implements CategoriasService {

	public CategoriaServiceImpl() {
		super(new CategoriasDaoImpl());
	}
	
	@Override
	public List<Categorias> findAll() throws ServiceException {		
		try {
			return this.dao.findAll();
		} catch (GenericException e) {
			throw new ServiceException(e);
		}
	}

}
