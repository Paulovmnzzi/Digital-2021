package com.digitalers.parser.mains;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryFileMain {

	public static void main(String[] args) throws IOException {

		String path = "C:/Desarrollo/educacionit/files/nuevos-productos.xlsx";
		
		//alt+shit+r
		File source = new File(path);
		
		File target = new File("C:/Desarrollo/educacionit/files/nuevos-productos-copia.xlsx");
		
		FileInputStream fin = new FileInputStream(source);
		
		FileOutputStream fout = new FileOutputStream(target);
		
		byte[] bytes = new byte[1024];		
		int noOfBytes = 0;
		
		while((noOfBytes = fin.read(bytes)) > 0) {
			fout.write(bytes,0,noOfBytes);
		}
		
		fin.close();
		fout.close();
	}

}
