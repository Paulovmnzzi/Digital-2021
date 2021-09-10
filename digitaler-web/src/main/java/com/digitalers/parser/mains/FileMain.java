package com.digitalers.parser.mains;

import java.io.File;

public class FileMain {

	public static void main(String[] args) {
		
		//C:\Desarrollo\educacionit\files\nuevos-productos
		String path = "C:/Desarrollo/educacionit/files/nuevos-productos.csv";
		
		File file = new File(path);

		if(file.exists()) {
			System.out.println(path + " existe");
			
			String fileName = file.getName();
			
			System.out.println(fileName);
			
			//ext
			int lastIndex = path.lastIndexOf(".");//int
			if(lastIndex > -1) {
				int size = path.length();			
				String ext = path.substring(lastIndex+1, size);			
				System.out.println(ext);
			}
		}else {
			System.out.println(path + " no existe");
		}
		
	}

}
