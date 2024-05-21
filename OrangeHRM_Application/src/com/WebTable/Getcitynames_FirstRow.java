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

public class Getcitynames_FirstRow extends BaseTest
{
	String citynamesText;
	public void gettingCityNames() throws IOException 
	{
		
FileInputStream file=new FileInputStream("./src/com/OrangeHRM_Application_TestresultFiles/WebTableFirstRow_Data.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("WebTableData_FirstRow");
		///html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]
		
		for(int rowindex=1;rowindex<=36;rowindex++) {
			
		By	citynamesProperty=By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr["+rowindex+"]/td[1]");
		WebElement citynames=driver.findElement(citynamesProperty);
		citynamesText=citynames.getText();

		Row row=sheet.createRow(rowindex);
		
		Cell rowofcell=row.createCell(0);
		rowofcell.setCellValue(citynamesText);
			
FileOutputStream testresultfile=new FileOutputStream("./src/com/OrangeHRM_Application_TestresultFiles/WebTableFirstRow_Data.xlsx");
		
		workbook.write(testresultfile);	
		}
		
		}	
	
	public static void main(String[] args) throws IOException {
		Getcitynames_FirstRow webtable=new Getcitynames_FirstRow();
		
		webtable.applicationLaunch();
		webtable.gettingCityNames();
		webtable.applicationClose();
		
	}
}
