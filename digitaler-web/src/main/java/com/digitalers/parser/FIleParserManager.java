package com.digitalers.parser;

import javax.servlet.http.Part;

public class FIleParserManager {

	public static IFileParser getParser(String path) {
		
		String ext = getExt(path);
		
		IFileParser parser = null;
		
		if("csv".equals(ext) ) {
			parser = new CSVFileParser(path);
		}else {
			parser = new XLSFileParser(path);
		}
		
		return parser;
	}

	public static String getExt(String path) {
		
		if(path == null) {
			throw new IllegalArgumentException("Path es nulo");
		}
		
		String ext = null;
		int lastIndex = path.lastIndexOf(".");//int
		if(lastIndex > -1) {
			int size = path.length();			
			ext = path.substring(lastIndex+1, size);			
		}
		return ext;
	}

	public static IFileParser getParser(String fileName, Part filePart) {
		String ext = getExt(fileName);
		
		IFileParser parser = null;
		
		if("csv".equals(ext) ) {
			parser = new CSVFileParser(filePart);
		}else {
			parser = new XLSFileParser(filePart);
		}
		
		return parser;
	}
}
