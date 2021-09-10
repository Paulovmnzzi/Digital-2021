package com.digital.service.impl;

import com.digital.dao.impl.ProductoDaoImpl;
import com.digital.domain.Producto;
import com.digital.service.ProductoService;

public class ProductoServiceImpl extends AbstractBaseService<Producto> implements ProductoService{

public ProductoServiceImpl() {
		super(new ProductoDaoImpl());
	}
}
