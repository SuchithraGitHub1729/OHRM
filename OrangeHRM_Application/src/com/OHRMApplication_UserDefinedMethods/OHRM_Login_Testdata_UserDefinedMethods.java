package com.OHRMApplication_UserDefinedMethods;

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

public class OHRM_Login_Testdata_UserDefinedMethods {
	
WebDriver driver;
String url="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";

FileInputStream file;
XSSFWorkbook workbook;
XSSFSheet sheet;
int rowcount;
Row row;
int rowofCellcount;
Cell rowofcell;
int rowIndex;

	public void oHRM_ApplicationLaunch() {
		 System.setProperty("webdriver.chrome.driver","D:\\Suchi_Files\\Web_Application_Testing\\OrangeHRM_Application\\BrowserDriverFiles\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.get(url);
		 
	}
	
	public void oHRM_Application_Validation_Loginpage() {
		
		//Get the Title
		
		String expected_title="OrangeHRM";
		System.out.println("The expected title of the login page is"+expected_title);
		
		String actual_title=driver.getTitle();
		System.out.println("The actual title of the login page is"+actual_title);
		
		if(actual_title.equals(expected_title)) {
			
			System.out.println("The title of the login page is matched");
		}
		else
		{
			System.out.println("The title of the login page is Not matched");
		}
		
		//Get the URL
		
		String expected_url="orangehrm-4.2.0.1";
		System.out.println("The expected url of the login page is - "+expected_url);
		
		String actual_url=driver.getCurrentUrl();
		System.out.println("The actual url of the login page is- "+actual_url);
		
		if(actual_url.contains(expected_url)) {
			System.out.println("Successfully navigated to the loginpage-PASS");
		}
		else
		{
			System.out.println("Failed to  navigate to the loginpage-FAIL ");
		}
		
		//Validate the login text
		
		String expected_loginpageText="LOGIN Panel";
		System.out.println("The expected OrangeHRM loginpage text is : "+expected_loginpageText);

		// <div id="logInPanelHeading">LOGIN Panel</div>

		By loginpageTextProperty= By.id("logInPanelHeading");
		WebElement loginpageText=driver.findElement(loginpageTextProperty);
		String actual_loginpageText=loginpageText.getText();
		System.out.println("The actual OrangeHRM loginpage text is : "+actual_loginpageText);

		if(actual_loginpageText.equals(expected_loginpageText)){
		System.out.println("The Text of the loginpage is matched-PASS ");
		}
		else
		{
		System.out.println("The Text of the loginpage is Not matched-FAIL");
		}

	}
	
	public void oHRM_Application_LoginTest() throws IOException, InterruptedException {
		
		file=new FileInputStream("./src/com/OrangeHRM_Application_TestdataFiles/OrangeHRM_Login_Testdata.xlsx");
		
		workbook=new XSSFWorkbook(file);
		
		sheet=workbook.getSheet("Testdata");
		rowcount =sheet.getLastRowNum();
		

		for(rowIndex=1;rowIndex<=rowcount;rowIndex++) {
			
			row=sheet.getRow(rowIndex);
			rowofCellcount=row.getLastCellNum();
			
			rowofcell=row.getCell(0);
			String usernametestdata=rowofcell.getStringCellValue();
			
				
			
			By usernameProperty=By.id("txtUsername");
			WebElement username=driver.findElement(usernameProperty);
			username.sendKeys(usernametestdata);
			
			rowofcell=row.getCell(1);
			String passwordtestdata=rowofcell.getStringCellValue();
			
			By passwordProperty=By.name("txtPassword");
			WebElement password=driver.findElement(passwordProperty);
			password.sendKeys(passwordtestdata);
			
			By loginbuttonProperty=By.name("Submit");
			WebElement loginButton =driver.findElement(loginbuttonProperty);
			loginButton.click();
			
			String expected_URL="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard";
			System.out.println(expected_URL);
			String actual_URL=driver.getCurrentUrl();

			if(actual_URL.equals(expected_URL))
			{
				By welComeAdminProperty=By.partialLinkText("Welcome");
				WebElement welComeAdmin=driver.findElement(welComeAdminProperty);
				welComeAdmin.click();

				Thread.sleep(5000);

				By logOutProperty=By.linkText("Logout"); // considering a part of the Text of the LINK as Selector
				WebElement logOut=driver.findElement(logOutProperty);
				logOut.click();
			System.out.println(" Successfully Navigated to the OrangeHRM Application HOME Page - PASS ");
			Cell testResultCell=row.createCell(2); 
			testResultCell.setCellValue("Successfully Navigated to the OrangeHRM Application HOME Page - PASS ");
			}
          else
			{
			System.out.println(" Failed to Navigate to the OrangeHRM Application HOME Page - FAIL ");
			Cell testResultCell=row.createCell(2);
			testResultCell.setCellValue("Failed to Navigate to the OrangeHRM Application HOME Page - FAIL  ");
			}
			
			FileOutputStream testResultFile = new FileOutputStream("./src/com/OrangeHRM_Application_TestresultFiles/OHRM_Login_userdefinedmethod  _TestResult.xlsx");
			workbook.write(testResultFile);
		}
		
		
		System.out.println();
		
}
		
	
	public void oHRM_Application_Close() {
		
		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		OHRM_Login_Testdata_UserDefinedMethods userdefinedmethod=new OHRM_Login_Testdata_UserDefinedMethods();
		
		userdefinedmethod.oHRM_ApplicationLaunch();
		
		userdefinedmethod.oHRM_Application_Validation_Loginpage();
		
		userdefinedmethod.oHRM_Application_LoginTest();
		
		userdefinedmethod.oHRM_Application_Close();
		
	}
}
