package com.digitalers.parser.mains;

import java.io.IOException;
import java.util.Collection;

import com.digitalers.domain.Articulos;
import com.digitalers.parser.FIleParserManager;
import com.digitalers.parser.IFileParser;

public class FileMain6 {

	public static void main(String[] args) throws IOException {

		String path = "C:/Desarrollo/educacionit/files/nuevos-productos.xlsx";
		
		IFileParser parser = FIleParserManager.getParser(path);
		
		Collection<Articulos> articulos = parser.parse();
		
		System.out.println(articulos);
	}

}
