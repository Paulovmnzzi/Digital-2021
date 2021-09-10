package com.digital.service.impl;

import com.digital.dao.util.ProductoDaoImpl;
import com.digital.domain.Producto;
import com.digital.service.ProductoService;

public class ProductoServiceImpl extends AbstractBaseService<Producto> implements ProductoService{

public ProductoServiceImpl() {
		super(new ProductoDaoImpl());
	}
}
