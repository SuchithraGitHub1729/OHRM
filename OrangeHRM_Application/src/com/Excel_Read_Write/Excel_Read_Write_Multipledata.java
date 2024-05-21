package com.Excel_Read_Write;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Read_Write_Multipledata {
public static void main(String[] args) throws IOException {
	
	
	FileInputStream file=new FileInputStream("D:\\Suchi_Files\\Excel files\\Multipledta_Excel.xlsx");
	
	XSSFWorkbook workbook=new XSSFWorkbook(file);
	
	XSSFSheet sheet=workbook.getSheet("Testdata");
	int rowcount=sheet.getLastRowNum();
	
	for(int rowIndex=0;rowIndex<=rowcount;rowIndex++) {
		 Row row =sheet.getRow(rowIndex);
	int	rowofcellCount= row.getLastCellNum();
		 
	for(int rowofcellIndex=0;rowofcellIndex<rowofcellCount;rowofcellIndex++) {

		 Cell rowofActivecell=row.getCell(rowofcellIndex);
		 
		 
		String testdata=rowofActivecell.getStringCellValue();
		System.out.print(testdata+" ");
	}
	System.out.println();
}
}
}
