package com.digitalers.controller;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.digitalers.domain.Articulos;
import com.digitalers.enums.ViewEnums;
import com.digitalers.enums.ViewKeyEnums;
import com.digitalers.parser.FIleParserManager;
import com.digitalers.parser.IFileParser;

@WebServlet("/controllers/UploadServlet")
@MultipartConfig
public class UploadServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Part filePart = req.getPart(ViewKeyEnums.FILE_NAME.name());
		
		if(filePart.getSize() > 0) {
			
			String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
			
			IFileParser parser = FIleParserManager.getParser(fileName, filePart);
			
			Collection<Articulos> articulos = parser.parse();
			
			req.getSession().setAttribute(ViewKeyEnums.UPLOAD_PREVIEW_KEY.name(), articulos);
		}
		
		//redirect
		getServletContext().getRequestDispatcher(ViewEnums.UPLOAD_PREVIEW.getView()).forward(req, resp);
	}
}
