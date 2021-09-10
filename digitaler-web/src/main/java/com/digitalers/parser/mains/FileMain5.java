package com.digitalers.parser.mains;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileMain5 {

	public static void main(String[] args) throws IOException {

		String texto = "soy un texto y me van a grabar! en disco";
		
		File file = new File("C:/Desarrollo/educacionit/files/prueba.csv");
		
		FileWriter fr = new FileWriter(file);
		
		fr.write(texto);
		
		fr.close();
	}

}
