package com.digitalers.dao;

import java.util.List;

import com.digitalers.dao.impl.CuponesDaoImpl;
import com.digitalers.domain.Cupones;
import com.digitalers.exception.GenericException;

public class CuponesDaoTestCase {

	public static void main(String[] args) throws GenericException {
		
		Long id = 1l;
		
		CuponesDao dao = new CuponesDaoImpl();
		
		Cupones entity = dao.getOne(id);
		
		System.out.println(entity);

		System.out.println("---------------");
		
		List<Cupones> list = dao.findAll();		
		System.out.println(list);
	}

}
