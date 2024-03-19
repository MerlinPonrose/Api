package com.restassured.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Api_excelread {
	public static void main(String[] args) throws IOException {
		excelread();
	}
	
	public static Object[][] excelread() throws IOException
	{
File f = new File("C:\\neworkspace\\RestAssured\\resource\\Apii_data.xlsx");
		
		FileInputStream fis = new FileInputStream(f);
		
		XSSFWorkbook book = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = book.getSheet("Sheet1");
		
		int rowcount = sheet.getLastRowNum();
		
		System.out.println("Row count ="+rowcount);
		
		
		int colcount = sheet.getRow(0).getLastCellNum();
		
		System.out.println("col count =" +colcount);
		
		
		String data[][] = new String[rowcount][colcount];
		
	
		for(int i=1;i<=rowcount;i++)
		{
			XSSFRow row = sheet.getRow(i);
			
		
			for(int j=0;j<colcount;j++)
			{
				
				XSSFCell cell = row.getCell(j);
				
				data[i-1][j] = cell.getStringCellValue();
			}
		}
	
		return data;
		
		
		
	}

}
