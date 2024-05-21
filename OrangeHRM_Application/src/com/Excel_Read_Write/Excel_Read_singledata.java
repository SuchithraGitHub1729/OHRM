 package com.Excel_Read_Write;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Read_singledata {

	public static void main(String[] args) throws IOException {
		//Identify the excel file
FileInputStream file=new FileInputStream("D:\\Suchi_Files\\Web_Application_Testing\\OrangeHRM_Application\\src\\com\\ExcelOperations\\Singledata_Excel_read.xlsx");

//identify the workbook
XSSFWorkbook workbook=new XSSFWorkbook(file);


//Identify the sheet
  XSSFSheet sheet=workbook.getSheet("Sheet1");
  
  //Identify the row
  
   Row row   =sheet.getRow(0);
   
   //Identify the row of a cell
   
  Cell rowofAcell =row.getCell(0);
  
  // get the test datafrom the row of a cell
  
  String testdata=rowofAcell.getStringCellValue();
  
  System.out.println(testdata);
  
  
	}

}
