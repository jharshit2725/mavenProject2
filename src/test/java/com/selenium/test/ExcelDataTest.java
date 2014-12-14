package com.selenium.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.selenium.util.Excel;

public class ExcelDataTest {
	Excel exl=new Excel();

	
	@Test
	public void data() throws IOException{

		exl.setExcel("src//test//resources//testData//testdata.xls","sheet1");
		System.out.println("fetching data from excel");
		System.out.println(exl.getCellValue(0, 1));
		System.out.println(exl.getCellValue(0, 2));
		
	}
}
