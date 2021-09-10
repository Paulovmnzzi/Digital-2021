package com.digitalers.parser;

import javax.servlet.http.Part;

public abstract class FileParserBase {

	protected String path;
	protected Part filePart;
	
	public FileParserBase(String path) {
		this.path = path;
	}
	
	public FileParserBase(Part filePart) {
		this.filePart = filePart;
	}
}
