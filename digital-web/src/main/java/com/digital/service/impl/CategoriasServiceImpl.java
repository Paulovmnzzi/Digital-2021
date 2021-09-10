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
	
	@Override
	public List<Categorias> findAll() throws ServiceException {
		try {
			return this.dao.findAll();
		} catch (GenericException e) {
			throw new ServiceException("no se pudo obtener la lista mi rey", e.getCause());
		}
	}
	
	
}
