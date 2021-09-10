package com.digitalers.parser.mains;

import java.io.IOException;
import java.util.Collection;

import com.digitalers.domain.Articulos;
import com.digitalers.parser.CSVFileParser;
import com.digitalers.parser.IFileParser;

public class FileMain3 {

	public static void main(String[] args) throws IOException {
		
		String[] variosNmbres = new String[] {
				"C:/Desarrollo/educacionit/files/nuevos-productos.csv",
				"C:/Desarrollo/educacionit/files/nuevos-productos-2.csv"
		};
		
		if(variosNmbres.length > 0) {
			
			for(String path: variosNmbres) {
				
				if(path != null) {
					
					IFileParser parser = new CSVFileParser(path);
					
					Collection<Articulos> articulos = parser.parse();
					
					System.out.println(articulos);
					
				}
			}
		}
	}

}
