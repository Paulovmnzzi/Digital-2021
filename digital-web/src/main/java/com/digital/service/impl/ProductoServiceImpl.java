package com.digital.service.impl;

import java.util.List;

import com.digital.dao.impl.ProductoDaoImpl;
import com.digital.domain.Producto;
import com.digital.exception.GenericException;
import com.digital.service.ProductoService;
import com.digital.service.ServiceException;

public class ProductoServiceImpl extends AbstractBaseService<Producto> implements ProductoService{

public ProductoServiceImpl() {
		super(new ProductoDaoImpl());
	}

@Override
	public List<Producto> findAll() throws ServiceException {
		try {
			return this.dao.findAll();
		} catch (GenericException e) {
			throw new ServiceException("no se ha podido obtener la lista mi rey", e.getCause());
		}
	}

}
