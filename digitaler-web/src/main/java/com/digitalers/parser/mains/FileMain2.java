package com.digitalers.parser.mains;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.digitalers.domain.Articulos;

public class FileMain2 {

	public static void main(String[] args) throws IOException {
		
		//C:\Desarrollo\educacionit\files\nuevos-productos
		String path = "C:/Desarrollo/educacionit/files/nuevos-productos.csv";
		
		//1 puntero al archivo
		File file = new File(path);
		
		Collection<Articulos> articulos = new ArrayList<Articulos>();
		
		if(file.exists()) {
			
			//2 - lector del File 
			FileReader fr = new FileReader(file);
			
			//3 - Lector mejorado 
			BufferedReader br = new BufferedReader(fr);
			
			String linea = br.readLine();
			
			while(linea != null) {			
			
				//leo nuevamenete
				linea = br.readLine();
				
				if(linea != null) {
				
					String[] campos = linea.split(",");
					//campos[0]->codigo
					String codigo = campos[0];
					String titulo = campos[1];
					Double precio = Double.parseDouble(campos[2]);
					Long stock = Long.parseLong(campos[3]);
					Long categoria = Long.parseLong(campos[4]);
					Long marca = Long.parseLong(campos[5]);
					
					Articulos articulo = new Articulos(titulo, codigo, new Date(), precio, stock, marca, categoria);
					articulos.add(articulo);					
				}
			}			
			br.close();
		}
	}

}
