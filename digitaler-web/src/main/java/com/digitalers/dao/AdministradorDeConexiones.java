package com.digitalers.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.digitalers.exception.GenericException;

public class AdministradorDeConexiones {

	public static Connection obtenerConexion() throws GenericException{
		
		String url = System.getenv("SPRING_DATASOURCE_URL");
		String user = System.getenv("SPRING_DATASOURCE_USERNAME");
		String password = System.getenv("SPRING_DATASOURCE_PASSWORD");
		String driverName = System.getenv("SPRING_DATASOURCE_DRIVER");
				
		//String url = "jdbc:mysql://127.0.0.1/digitalers?serverTimeZone=UTC&userSSL=false";
		//String user ="root";
		//String password = "root";		
		//String driverName = "com.mysql.cj.jdbc.Driver";
		
		Connection connection = null;
		try {
			
			//crear una instancia del driver
			Class.forName(driverName);
			
			connection = DriverManager.getConnection(url, user, password);
			
			return connection;
		} catch (SQLException e) {
			throw new GenericException("No se ha podido obtener una conexion", e);
		} catch(ClassNotFoundException e) {
			throw new GenericException("No se ha encontrado la clase " + driverName, e);
		}
	}
}
