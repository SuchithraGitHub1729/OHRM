package com.OrangeHRM_Read_Write_Excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OHRM_Write_TestdataFile {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver; 
		String application_URL="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		
		System.setProperty("webdriver.chrome.driver","./BrowserDriverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.get(application_URL);
	
		FileInputStream file=new FileInputStream("./src/com/OrangeHRM_Application_TestdataFiles/OrangeHRM_LogInTestDataFile.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("LogInTestData");
	
		int rowcount=sheet.getLastRowNum();
	
			
		for(int rowindex=1;rowindex<=rowcount;rowindex++) {
			Row row=sheet.getRow(rowindex);

			try {
			
						
			int rowofcellount=row.getLastCellNum();
			
			String expected_loginpageText="LOGIN Panel";
			Cell Exp_Text_testResult=row.createCell(0);
			
			Exp_Text_testResult.setCellValue(expected_loginpageText);
			
			//<div id="logInPanelHeading">LOGIN Panel</div>
			Thread.sleep(3000);
			
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
			
			String expected_Title="OrangeHRM";
			System.out.println("The expected title of the login page is -"+expected_Title);
			
			Cell expected_title_result=row.createCell(4);
			
			expected_title_result.setCellValue(expected_Title);
			
			String actual_Title=driver.getTitle();
			
			Cell actual_title_result=row.createCell(5);
			actual_title_result.setCellValue(actual_Title);
			
			if(actual_Title.equals(expected_Title)) {
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
			
			
						Cell rowofcell=row.getCell(7);
			String usernametestdata=rowofcell.getStringCellValue();
			
			By usernameProperty=By.id("txtUsername");
			WebElement username=driver.findElement(usernameProperty);
			username.sendKeys(usernametestdata);
			
			rowofcell=row.getCell(8);
			String passwordtestdata=rowofcell.getStringCellValue();
			
			By passwordProperty=By.name("txtPassword");
			WebElement password=driver.findElement(passwordProperty);
			password.sendKeys(passwordtestdata);
			

			
			By loginbuttonProperty=By.name("Submit");
			WebElement loginButton =driver.findElement(loginbuttonProperty);
			loginButton.click();
			
			String expecte_url="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard";
			String actual_url=driver.getCurrentUrl();
			
			if(actual_url.equals(expecte_url)) {
				
				System.out.println("The expected current url of the Homepage is -"+expecte_url);
			}
			else
			{
				Cell expected_result=row.createCell(1);
				expected_result.setCellValue(expected_loginpageText);

			}
			
			By welComeAdminProperty=By.partialLinkText("Welcome");
			WebElement welComeAdmin=driver.findElement(welComeAdminProperty);
			
			String expected_homepageText="Admin";
			System.out.println("The expected text of the Homepage is"+expected_homepageText);
			
			Cell expected_Text_Homepage=row.createCell(9);
			expected_Text_Homepage.setCellValue(expected_homepageText);
			
			String actual_homepageText=welComeAdmin.getText();
			System.out.println("The actual text of the Homepage is"+actual_homepageText);
			
			Cell actual_Text_Homepage=row.createCell(10);
			actual_Text_Homepage.setCellValue(actual_homepageText);
			
			if(actual_homepageText.contains(expected_homepageText)) {
				
				System.out.println("The Text of the Homepage is found-PASS");
				
				Cell testResultText_homepage=row.createCell(11);
				testResultText_homepage.setCellValue("The Text of the Homepage is found-PASS");
				
			}
			
			
			welComeAdminProperty=By.partialLinkText("Welcome");
			welComeAdmin=driver.findElement(welComeAdminProperty);
			welComeAdmin.click();
			
			Thread.sleep(5000); 
			
			By logOutProperty=By.linkText("Logout"); // considering a part of the Text of the LINK as Selector
			WebElement logOut=driver.findElement(logOutProperty);
			logOut.click();
			
			
			}
			catch(Exception suchi)
			{
				
				
				
	               System.out.println("The Text of the Homepage is Not found-FAIL");
					
					Cell testResultText_homepage=row.createCell(11);
					testResultText_homepage.setCellValue("The Text of the Homepage is Not found-FAIL");
					
				
				System.out.println(suchi);
			}
			FileOutputStream testResultFile=new FileOutputStream("./src/com/OrangeHRM_Application_TestresultFiles/OHRM_Write_MultipletestData.xlsx");
			workbook.write(testResultFile);
			
			}
		
	       Thread.sleep(3000);
		      driver.quit();
	}
}
