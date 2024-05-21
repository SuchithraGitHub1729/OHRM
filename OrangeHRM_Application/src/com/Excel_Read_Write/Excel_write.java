package com.Excel_Read_Write;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Excel_write {

	public static void main(String[] args) throws IOException {
		
		//Identify the excel file
		FileInputStream file=new FileInputStream("D:\\Suchi_Files\\Web_Application_Testing\\OrangeHRM_Application\\src\\com\\ExcelOperations\\Singledata_Excel_read.xlsx");
//identify the work book
		
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		//Identify the sheet
		
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		//create the new row
		
		XSSFRow newrow=sheet.createRow(5);
		
		//create row of a cell
		
		XSSFCell newrowofACell=newrow.createCell(2);
		
		//set the value into the new row
		newrowofACell.setCellValue("webdriver");
		 newrowofACell=newrow.createCell(3);
		 newrowofACell.setCellValue("testing");
		 
		 //save the excel file
		 
		 FileOutputStream testResultfile=new FileOutputStream("D:\\\\Suchi_Files\\\\Web_Application_Testing\\\\OrangeHRM_Application\\\\src\\\\com\\\\ExcelOperations\\\\Singledata_Excel_read.xlsx");
		 workbook.write(testResultfile);
	}

}
