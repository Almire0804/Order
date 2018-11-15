package com.app.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelRead {
	
	public static void main(String[] args) throws Exception {
		String filePath = "/Users/haticeevci/Documents/MOCK_DATA.xlsx";
		
		FileInputStream inStream = new FileInputStream(filePath);
		Workbook workbook = WorkbookFactory.create(inStream);
		Sheet worksheet = workbook.getSheetAt(0);
		Row row  = worksheet.getRow(0);
		Cell cell = row.getCell(0);
		System.out.println(cell.toString());
		
		//int rowsCount = worksheet.getPhysicalNumberOfRows();
		int rowsCount = worksheet.getLastRowNum();
		System.out.println("Number of rows" + rowsCount);
		
		for (int rowNum = 1; rowNum <rowsCount; rowNum++) {
			System.out.println(rowNum+ " - " + worksheet.getRow(rowNum).getCell(1));
			
		}
		
		
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
			Row myrow = worksheet.getRow(i);
			if(myrow.getCell(1).toString().equals("Nancy")) {
				//print job id from same row
				System.out.println("Nancy is a " + myrow.getCell(4).toString());
				break;
			}
		}
		System.out.println("two" + worksheet.getRow(2).getCell(1));
		
		
		workbook.close();
		inStream.close();
		
	}
	
	

}
