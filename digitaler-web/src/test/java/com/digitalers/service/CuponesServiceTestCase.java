package com.digitalers.service;

import java.util.Date;
import java.util.List;

import com.digitalers.domain.Articulos;
import com.digitalers.domain.Cupones;
import com.digitalers.service.impl.ArticulosServiceImpl;
import com.digitalers.service.impl.CuponesServiceImpl;

public class CuponesServiceTestCase {

	public static void main(String[] args) throws ServiceException {
		Cupones unCupon = new Cupones();
		unCupon.setCodigo("001");
		unCupon.setDescuento(10d);
		unCupon.setFechaVigenciaDesde(new Date());
		unCupon.setFechaVigenciaHasta(new Date());
		unCupon.setNombre("BIENVENIDA");
		
		CuponesService service = new CuponesServiceImpl();
		service.save(unCupon);
		
		System.out.println(unCupon);
	}

}
