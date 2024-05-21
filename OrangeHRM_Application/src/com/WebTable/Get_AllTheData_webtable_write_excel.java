package com.WebTable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Get_AllTheData_webtable_write_excel extends BaseTest
{
	
	public void getting_data_WebTable() throws IOException {
		
        FileInputStream file=new FileInputStream("./src/com/OrangeHRM_Application_TestresultFiles/WebTableComplteData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("WebTable_complteData");
		
		for(int rowIndex=1;rowIndex<=36;rowIndex++)
		{
			Row row=sheet.createRow(rowIndex); 
			
		for(int rowOfCellIndex=1;rowOfCellIndex<=8;rowOfCellIndex++)
		{
		By webTableDataProperty=By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr["+rowIndex+"]/td["+rowOfCellIndex+"]");
		WebElement webTableData=driver.findElement(webTableDataProperty);
		
		String webTableDataText=webTableData.getText();
		
		Cell rowofcell=row.createCell(rowOfCellIndex-1);
		rowofcell.setCellValue(webTableDataText);
		System.out.print(webTableDataText+" | ");
		
		FileOutputStream outfile=new FileOutputStream("./src/com/OrangeHRM_Application_TestresultFiles/WebTableComplteData.xlsx");
		workbook.write(outfile);
		}
		System.out.println();
		}

	}
	public static void main(String[] args) throws IOException {
		Get_AllTheData_webtable_write_excel web=new Get_AllTheData_webtable_write_excel();
		web.applicationLaunch();
		web.getting_data_WebTable();
		web.applicationClose();
		
	}
	
}
