package com.OHRM;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OHRM_LoginFunctionality_Excel_Testdata {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver; 
		String application_URL="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		
		System.setProperty("webdriver.chrome.driver","./BrowserDriverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.get(application_URL);
		
		FileInputStream file=new FileInputStream("./src/com/OrangeHRM_Application_TestdataFiles/OrangeHRM_LogInTestDataFile1.xlsx");
	XSSFWorkbook workbook=new XSSFWorkbook(file);
	XSSFSheet sheet=workbook.getSheet("LogInTestData");
	
	Row row=sheet.getRow(1);
	
	Cell rowofcell=row.getCell(0);
	String expected_loginpageText=rowofcell.getStringCellValue();
	
	By loginpanelProperty=By.id("logInPanelHeading");
	WebElement loginpanel=driver.findElement(loginpanelProperty);
	String actual_loginpageText=loginpanel.getText();
	
	Cell actual_Text_testResult=row.createCell(2);
	actual_Text_testResult.setCellValue(actual_loginpageText);
	
	if(actual_loginpageText.equals(expected_loginpageText)) {
		
		System.out.println("The text of the loginpage is matched-PASS");
		Cell text_Test_Result=row.createCell(3);
		text_Test_Result.setCellValue("The text of the loginpage is matched-PASS");

	}
	else
	{
		System.out.println("The text of the loginpage is Not matched-FAIL");
		Cell text_Test_Result=row.createCell(3);
		text_Test_Result.setCellValue("The text of the loginpage is Not matched-FAIL");
	}
	rowofcell=row.getCell(4);
	String expected_loginpageTitle=rowofcell.getStringCellValue();
	
	String actual_loginpageTitle=driver.getTitle();
	
	Cell actual_title_result=row.createCell(5);
	actual_title_result.setCellValue(actual_loginpageTitle);
	
	if(actual_loginpageTitle.equals(expected_loginpageTitle)) {
		System.out.println("The title of the loginpage is matched-PASS");
		
		Cell testResult_Title=row.createCell(6);
		testResult_Title.setCellValue("The title of the loginpage is matched-PASS");
		
	}
	else
	{
         System.out.println("The title of the loginpage is Not matched-FAIL");
		
		Cell testResult_Title=row.createCell(6);
		testResult_Title.setCellValue("The title of the loginpage is Not matched-FAIL");             
	}
	
	
	
	int rowcount=sheet.getLastRowNum();
	
	for(int rowindex=1;rowindex<rowcount;rowindex++) 
	{
		Row row1=sheet.getRow(rowindex);
		try {
	
	int rowofcellCount=row1.getLastCellNum();
	
	Cell rowofcell1=row1.getCell(7);
	String usernameTestdata=rowofcell1.getStringCellValue();
	
	By usernameProperty=By.id("txtUsername");
	WebElement username=driver.findElement(usernameProperty);
	username.sendKeys(usernameTestdata);
	
	rowofcell1=row1.getCell(8);
	String passwordTestdata=rowofcell1.getStringCellValue();
	
	By passwordProperty=By.name("txtPassword");
	WebElement password=driver.findElement(passwordProperty);
	password.sendKeys(passwordTestdata);
	
	By loginbuttonProperty=By.name("Submit");
	WebElement loginButton =driver.findElement(loginbuttonProperty);
	loginButton.click();
	
	
	rowofcell1=row1.getCell(9);
	String expected_HomepageText=rowofcell1.getStringCellValue();
	
	By welComeAdminProperty=By.partialLinkText("Welcome");
	WebElement welComeAdmin=driver.findElement(welComeAdminProperty);
	
	String actual_HomepageText=welComeAdmin.getText();
	
	Cell actualHomepageTextResult=row1.createCell(10);
	actualHomepageTextResult.setCellValue(actual_HomepageText);
	
	if(actual_HomepageText.contains(expected_HomepageText)) {
		System.out.println("The text of the homepage is found-PASS");
		
		Cell homepagetextResult=row1.createCell(11);
		homepagetextResult.setCellValue("The text of the homepage is found-PASS");
	}
	
	welComeAdmin.click();
	
	Thread.sleep(5000); 
	
	By logOutProperty=By.linkText("Logout"); // considering a part of the Text of the LINK as Selector
	WebElement logOut=driver.findElement(logOutProperty);
	logOut.click();
	
	
		
	}
		catch(Exception suchi) {
			
			Cell homepagetextResult=row1.createCell(11);
			homepagetextResult.setCellValue("The text of the homepage is Not found-FAIL");
		
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	
	    	FileUtils.copyFile(screenshot, new File("./src/com/Scrrenshots/"+"Rowindex"+" "+rowindex+" - "+"Inavalid Credentials"+" "+"Screenshot"+".png"));
	    	
	    	//<span id="spanMessage">Invalid credentials</span>
	    	
	    	Cell rowofcell1=row1.getCell(1);
	    	String expected_text_invalid=rowofcell1.getStringCellValue();
	    	
	    	By invalidCredentialsProperty=By.id("spanMessage");
	    	WebElement invalidCredentials=driver.findElement(invalidCredentialsProperty);
	    	String actual_text_invalid=invalidCredentials.getText();
	    	
	    	if(actual_text_invalid.equals(expected_text_invalid)) {
	    		System.out.println("The text of the loginpage for invalid credentials is matched-PASS");
	    	}
	    	else
	    	{
	    		System.out.println("The text of the loginpage for invalid credentials is Not matched-FAIL");
	    	}
	}
		
		FileOutputStream testresultfile=new FileOutputStream("./src/com/OrangeHRM_Application_TestresultFiles/OrangeHRM_LogInTestDataResult.xlsx");
		workbook.write(testresultfile);
	  
	}
	
	
	
	Thread.sleep(3000);
	
	driver.quit();
	
}
}
