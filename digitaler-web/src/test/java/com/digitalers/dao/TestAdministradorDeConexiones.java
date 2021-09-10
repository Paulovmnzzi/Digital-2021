package com.digitalers.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.digitalers.exception.GenericException;

public class TestAdministradorDeConexiones {

	public static void main(String[] args) {
				
		try(Connection con = AdministradorDeConexiones.obtenerConexion()) {
			//desde acá
			System.out.println("funciona");
		} catch (GenericException  | SQLException e) {			
			System.err.println(e.getMessage());
			System.err.println(e.getCause().getMessage());
		}

	}

}
