package com.OHRM_Testing;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.Utility.Log;

public class OHRM_GetEmployeeList_WriteExcel_TestNG extends BaseTest
{
	FileInputStream file;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	Cell rowofcell;
	Row row;
	By welComeAdminProperty;
	WebElement welComeAdmin;
	By pimProperty;
	WebElement pim;
	FileInputStream OrangeHRMApplication_PropertiesFile;
	Properties properties;
	
	@Test(priority=1)
	public void oHRM_LoginPage_Validation() throws IOException {
		
		file=new FileInputStream("./src/com/OHRM_Application_TestData_Files/OHRM_EmployeeList_Testdata.xlsx");
		workbook=new XSSFWorkbook(file);
		sheet=workbook.getSheet("LogInTestData");
		
		row=sheet.getRow(1);
		
		rowofcell=row.getCell(0);
		String expected_loginpageText=rowofcell.getStringCellValue();
		System.out.println("The expected text is-"+expected_loginpageText);
		Log.info("The expected text is-"+expected_loginpageText);
		
		OrangeHRMApplication_PropertiesFile=new FileInputStream("./src/com/Config/OrangeHRMApplication_PropertiesFile.properties");
		properties=new Properties();
		properties.load(OrangeHRMApplication_PropertiesFile);
		
		By loginpanelProperty=By.id(properties.getProperty("logInPageLogInPanelProperty"));
		WebElement loginpanel=driver.findElement(loginpanelProperty);
		String actual_loginpageText=loginpanel.getText();
		
		System.out.println("atual login test is-"+actual_loginpageText);
		Log.info("atual login test is-"+actual_loginpageText);
		
		Cell actual_Text_testResult=row.createCell(1);
		actual_Text_testResult.setCellValue(actual_loginpageText);
		
		if(actual_loginpageText.equals(expected_loginpageText)) {
			
			System.out.println("The text of the loginpage is matched-PASS");
			Log.info("The text of the loginpage is matched-PASS");
			
			Cell text_Test_Result=row.createCell(2);
			text_Test_Result.setCellValue("The text of the loginpage is matched-PASS");

		}
		else
		{
			System.out.println("The text of the loginpage is Not matched-FAIL");
			Log.info("The text of the loginpage is matched-PASS");
			
			Cell text_Test_Result=row.createCell(2);
			text_Test_Result.setCellValue("The text of the loginpage is Not matched-FAIL");
		}
		rowofcell=row.getCell(3);
		String expected_loginpageTitle=rowofcell.getStringCellValue();
		Log.info("The expected title of the loginpage is-"+expected_loginpageTitle);
		
		String actual_loginpageTitle=driver.getTitle();
		Log.info("The actual title of the loginpage is-"+actual_loginpageTitle);
		
		Cell actual_title_result=row.createCell(4);
		actual_title_result.setCellValue(actual_loginpageTitle);
		
		
		
		if(actual_loginpageTitle.equalsIgnoreCase(expected_loginpageTitle)) {
			System.out.println("The title of the loginpage is matched-PASS");
			Log.info("The title of the loginpage is matched-PASS");
			
			Cell testResult_Title=row.createCell(5);
			testResult_Title.setCellValue("The title of the loginpage is matched-PASS");
					
		}
		else
		{
	         System.out.println("The title of the loginpage is Not matched-FAIL");
	         Log.info("The title of the loginpage is Not matched-FAIL");
	         
	         Cell testResult_Title=row.createCell(5);
			testResult_Title.setCellValue("The title of the loginpage is Not matched-FAIL");             
		}

	}
	
	@Test(priority=2)
	public void oHRM_Login_Test() {
		
		rowofcell=row.getCell(6);
		String usernameTestdata=rowofcell.getStringCellValue();
		
		By usernameProperty=By.id(properties.getProperty("logInPageUserNameProperty"));
		WebElement username=driver.findElement(usernameProperty);
		username.sendKeys(usernameTestdata);
		
		rowofcell=row.getCell(7);
		String passwordTestdata=rowofcell.getStringCellValue();
		
		By passwordProperty=By.name(properties.getProperty("logInPagepasswordProperty"));
		WebElement password=driver.findElement(passwordProperty);
		password.sendKeys(passwordTestdata);
		
		By loginbuttonProperty=By.name(properties.getProperty("logInPageLogInButtonProperty"));
		WebElement loginButton =driver.findElement(loginbuttonProperty);
		loginButton.click();
	}
	
	@Test(priority=3)
	public void oHRM_Homepage_Validation() {
		
		rowofcell=row.getCell(8);
		String expected_homepagetext=rowofcell.getStringCellValue();
		
		Log.info("The expected homepage text is-"+expected_homepagetext);
		
		welComeAdminProperty=By.partialLinkText(properties.getProperty("orangeHRMApplicationHomePageWelComeAdminProperty"));
		welComeAdmin=driver.findElement(welComeAdminProperty);
		
		String actual_HomepageText=welComeAdmin.getText();
		
		Log.info("The actual homepage text is-"+actual_HomepageText);
		
		Cell actualHomepageTextResult=row.createCell(9);
		actualHomepageTextResult.setCellValue(actual_HomepageText);
		
		if(actual_HomepageText.contains(expected_homepagetext)) {
			System.out.println("The text of the homepage is found-PASS");
			Log.info("The text of the homepage is found-PASS");
			
			Cell homepagetextResult=row.createCell(10);
			homepagetextResult.setCellValue("The text of the homepage is found-PASS");
		}
		else
		{
			System.out.println("The text of the homepage is Not found-FAIL");
			Log.info("The text of the homepage is Not found-FAIL");
			
			Cell homepagetextResult=row.createCell(10);
			homepagetextResult.setCellValue("The text of the homepage is Not found-FAIL");
		}
	}
	@Test(priority=4)
	public void employeeListPage_Validation() {
		
		pimProperty=By.linkText(properties.getProperty("homePagepimProperty"));
		pim=driver.findElement(pimProperty);

		Actions mouseHover= new Actions(driver);
		mouseHover.moveToElement(pim).build().perform();
		
		By employeeListProperty=By.id(properties.getProperty("employeeListElementProperty"));
		WebElement employeeList=driver.findElement(employeeListProperty);
		
		employeeList.click();
		
	
		By empInformationTextProperty=By.xpath(properties.getProperty("employeelistPagetextProperty"));
		WebElement empInformationText=driver.findElement(empInformationTextProperty);
		String employeelistPagetext=empInformationText.getText();
		
		Log.info("The text of the Employeelist page is-"+employeelistPagetext);
		
		Cell empListTextResult=row.createCell(11);
		empListTextResult.setCellValue(employeelistPagetext);
		
		if(empInformationText.isDisplayed()) {
        System.out.println("The text of the EmployeeList page is found-PASS");
        Log.info("The text of the EmployeeList page is found-PASS");
			
			Cell empListpagetextResult=row.createCell(12);
			empListpagetextResult.setCellValue("The text of the EmployeeList page is found-PASS");
		}
		else
		{
			System.out.println("The text of the EmployeeList page is Not found-FAIL");
			Log.info("The text of the EmployeeList page is Not found-FAIL");
			
			Cell empListpagetextResult=row.createCell(12);
			empListpagetextResult.setCellValue("The text of the EmployeeList page is Not found-FAIL");
		}
			
		}
	
	@Test(priority=5)
	public void getEmployeeList() throws IOException {
		
		By employeeTableListProperty=By.xpath(properties.getProperty("employeeTableListBlockProperty"));
		WebElement employeeTableList=driver.findElement(employeeTableListProperty);
		
		By rowsProperty=By.tagName(properties.getProperty("employeelistsPageRowsProperty"));
		List <WebElement> employeeListRows=driver.findElements(rowsProperty);
		
		for(int rowindex=0;rowindex<employeeListRows.size();rowindex++) {
			
			WebElement rows=employeeListRows.get(rowindex);
			
			Row row1=sheet.getRow(rowindex);
			
			if(row1==null) {
				row1=sheet.createRow(rowindex);
			}
			
			By employeeListCellsProperty=By.tagName(properties.getProperty("employeeListPageCellsProperty"));
			List<WebElement> employeeListCells=rows.findElements(employeeListCellsProperty);
			
			int cellCount=employeeListCells.size();
			
			for(int rowofcellindex=1;rowofcellindex<cellCount;rowofcellindex++) {
				
				WebElement cell=employeeListCells.get(rowofcellindex);
				String EmployeeListText=cell.getText();
				rowofcell=row1.createCell(rowofcellindex+12);
				System.out.print(EmployeeListText+"  ");
				
				Log.info(EmployeeListText+"  ");
				
				rowofcell.setCellValue(EmployeeListText);	
			}
			System.out.println();
			
		}
		
		FileOutputStream testresultfile=new FileOutputStream("./src/com/OHRM_Application_TestResult_Files/employeelist_Result.xlsx");
		workbook.write(testresultfile);
	}
	@Test(priority=6)
	public void logout_Test() throws InterruptedException {
		
		welComeAdminProperty=By.partialLinkText(properties.getProperty("orangeHRMApplicationHomePageWelComeAdminProperty"));
		welComeAdmin=driver.findElement(welComeAdminProperty);
		
		welComeAdmin.click();
		
		Thread.sleep(5000);

		
		By logoutProperty=By.linkText(properties.getProperty("homePagelogOutProperty"));
		WebElement logout=driver.findElement(logoutProperty);
		logout.click();
		
	}
	
	}

