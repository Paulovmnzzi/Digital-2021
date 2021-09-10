package com.digitalers.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.Part;

import com.digitalers.domain.Articulos;

public class CSVFileParser extends FileParserBase implements IFileParser{

	public CSVFileParser(String name) {
		super(name);
	}
	
	public CSVFileParser(Part filePart) {
		super(filePart);
	}

	@Override
	public Collection<Articulos> parse() throws IOException {
		
		BufferedReader br = null;
		
		if(this.filePart != null) {
			InputStream fileContent = this.filePart.getInputStream();
			br = new BufferedReader(new InputStreamReader(fileContent));
		}else {			
			//1 puntero al archivo
			File file = new File(path);
			
			if(file.exists()) {
				FileReader fr = new FileReader(file);
				br = new BufferedReader(fr);
			}
		}
		
		Collection<Articulos> articulos = new ArrayList<>();
		
		//if(file.exists()) {			
			//2 - lector del File 
			//FileReader fr = new FileReader(file);			
			//3 - Lector mejorado 
			//BufferedReader br = new BufferedReader(fr);			
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
		//}		
		return articulos;
	}
}
