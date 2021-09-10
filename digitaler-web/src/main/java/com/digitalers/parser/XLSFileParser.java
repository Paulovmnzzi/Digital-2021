package com.digitalers.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.Part;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.digitalers.domain.Articulos;

public class XLSFileParser extends FileParserBase implements IFileParser {

	public XLSFileParser(String path) {
		super(path);
	}
	
	public XLSFileParser(Part filePart) {
		super(filePart);
	}

	@Override
	public Collection<Articulos> parse() throws IOException {

		InputStream theFile = null;
		if(this.filePart != null) {
			theFile = this.filePart.getInputStream();
		}else {
			File file = new File(super.path);
			theFile = new FileInputStream(file);
		}		
		
		Collection<Articulos> articulos = new ArrayList<>();
				
		Workbook workbook;
		
		workbook = new XSSFWorkbook(theFile);
		
		Sheet dataTypeSheet = workbook.getSheetAt(0);		
		Iterator<Row> itRows = dataTypeSheet.iterator();
		
		//codigo|titulo|precio|stock|marca|categoria
		boolean firstRow = true;
		
		while(itRows.hasNext()) {
			Row currentRow = itRows.next();
			if(firstRow) {
				firstRow = false;
				continue;
			}
			
			Iterator<Cell> cellItertator = currentRow.iterator();
			Articulos articulo = new Articulos();
			while(cellItertator.hasNext()) {				
				setArticuloFromCell(cellItertator, articulo);
				articulos.add(articulo);
				articulo.setFechaCreacion(new Date());
			}
		}
		
		workbook.close();
		
		return articulos;
	}

	private void setArticuloFromCell(Iterator<Cell> cellItertator, Articulos articulo) {
		Cell currentCell = cellItertator.next();
		switch (currentCell.getColumnIndex()) {
		case 0:
			articulo.setCodigo(currentCell.getStringCellValue());
			break;				
		case 1:
			articulo.setTitulo(currentCell.getStringCellValue());
			break;
		case 2:
			articulo.setPrecio(currentCell.getNumericCellValue());
			break;
		case 3:
			articulo.setStock((long)currentCell.getNumericCellValue());
			break;
		case 4:
			articulo.setMarcasId((long)currentCell.getNumericCellValue());
			break;
		case 5:
			articulo.setCategoriasId((long)currentCell.getNumericCellValue());
			break;
		default:
			break;
		}
	}

}
