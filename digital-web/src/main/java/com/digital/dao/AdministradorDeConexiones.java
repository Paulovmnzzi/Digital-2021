package com.digital.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.digital.exception.GenericException;

public class AdministradorDeConexiones {

	public static Connection obtenerConexion() throws GenericException{
		
		//String url = System.getenv("SPRING_DATASOURCE_URL");
		//String user = System.getenv("SPRING_DATASOURCE_USERNAME");
		//String password = System.getenv("SPRING_DATASOURCE_PASSWORD");
		//String driverName = System.getenv("SPRING_DATASOURCE_DRIVER");	
		
		String driverName = "org.postgresql.Driver";
		String user = "urdwvlvglblxso";
		String password = "1f11831f06e895ddcd025548b5c9b0d5999d04d04cc9013d89c35289f7b1acde";
		String url = "jdbc:postgresql://ec2-34-194-14-176.compute-1.amazonaws.com/da6gesee0aud7k";
				
		//String url = "jdbc:mysql://localhost/digital?serverTimeZone=UTC&userSSL=false";
		//String user ="root";
		//String password = "";		
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
