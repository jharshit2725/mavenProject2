package com.selenium.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

public class Excel {
	private FileInputStream file;
	private HSSFWorkbook workbook;
	private HSSFSheet    sheet;
	private HSSFCell cell;
	private DataFormatter formatter;

	public void setExcel(String path, String sheetName) throws IOException{
		file=new FileInputStream(path);
		workbook= new HSSFWorkbook(file);
		sheet= workbook.getSheet(sheetName);  		  
	}

	public String getCellValue(int row,int col){
		
		cell=sheet.getRow(row).getCell(col);
		formatter=new DataFormatter();
		return formatter.formatCellValue(cell);

	}
}
