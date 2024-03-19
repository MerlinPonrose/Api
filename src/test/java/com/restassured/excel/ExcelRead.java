package com.restassured.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File f = new File("C:\\neworkspace\\RestAssured\\resource\\Apii_data.xlsx");
		
		FileInputStream fis = new FileInputStream(f);
		
		XSSFWorkbook book = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = book.getSheet("Sheet1");
		
		int rowcount = sheet.getLastRowNum()+1;
		
		System.out.println("Row count ="+rowcount);
		
		
		int colcount = sheet.getRow(0).getLastCellNum();
		
		System.out.println("col count =" +colcount);
		
		for(int i=0;i<rowcount;i++)
		{
			XSSFRow row = sheet.getRow(i);
			for(int j=0;j<colcount;j++)
			{
				
			//	XSSFCell cell2 = sheet.getRow(i).getCell(j);
				
			
				
				XSSFCell cell = row.getCell(j);
				
				if(cell.getCellType()==CellType.NUMERIC)
				{
					double numericCellValue = cell.getNumericCellValue();
				}
				
				
				
		
			String value = cell.getStringCellValue();
			
			System.out.println(value);
				
				
			}
		}
		
		
		
		

	}

}
