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

public class OrangeHRM_Login_Excel_Testdata {
public static void main(String[] args) throws IOException, InterruptedException {
	
	WebDriver driver;
	
	System.setProperty("webdriver.chrome.driver","D:\\Suchi_Files\\Web_Application_Testing\\OrangeHRM_Application\\BrowserDriverFiles\\chromedriver.exe");
	
	driver=new ChromeDriver();
	
	String url="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
	driver.get(url);
	
	// Get the Title

				String expected_OrangeHRMLoginPageTitle="OrangeHRM";
				System.out.println(" The Expected title of the OrangeHRM login Page is :- "+expected_OrangeHRMLoginPageTitle);
				String actual_OrangeHRMLoginPageTitle=driver.getTitle();
				System.out.println(" The Actual title of the OrangeHRM Application Login Page is :- "+actual_OrangeHRMLoginPageTitle);
				if(actual_OrangeHRMLoginPageTitle.equals(expected_OrangeHRMLoginPageTitle))
				{
				System.out.println("Title of OrangeHRM Loginpage is Mateched:- PASS");
				}
				else
				{
				System.out.println("Title of OrangeHRM Loginpage is Not Matched:- Fail");
				}

				     //Get the URL

				String expected_OrangeHRMLoginpageURL="orangehrm-4.2.0.1";
				System.out.println(" The Expected Current URL of the OrangeHRM Login Page is :- "+expected_OrangeHRMLoginpageURL);
				String actual_OrangeHRMLoginpageURL=driver.getCurrentUrl();
				System.out.println("The actual current url of the OrangeHRM loginpage" +actual_OrangeHRMLoginpageURL);
				if(actual_OrangeHRMLoginpageURL.contains(expected_OrangeHRMLoginpageURL)) {
				System.out.println("The current URL of the Loginpage is found - pass");
				}
				else {
				System.out.println("The current URL of the Loginpage is not found - Fail");
				}

				// Get the Loginpage Text

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
				else{
				System.out.println("The Text of the loginpage is Not matched-FAIL");
				}

				
				FileInputStream file=new FileInputStream("./src/com/OrangeHRM_Application_TestdataFiles/OrangeHRM_Login_Testdata.xlsx");
				
				XSSFWorkbook workbook=new XSSFWorkbook(file);
				
				XSSFSheet sheet=workbook.getSheet("Testdata");
				int rowcount=sheet.getLastRowNum();
				for(int rowIndex=1;rowIndex<=rowcount;rowIndex++) {
					
					Row row=sheet.getRow(rowIndex);
					int rowofCellcount=row.getLastCellNum();
					
					Cell rowofcell=row.getCell(0);
					String usernametestdata=rowofcell.getStringCellValue();
					try {
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
					
					FileOutputStream testResultFile = new FileOutputStream("./src/com/OrangeHRM_Application_TestresultFiles/OHRM_Login_TestResult.xlsx");
					workbook.write(testResultFile);
					
					
					By welComeAdminProperty=By.partialLinkText("Welcome");
					WebElement welComeAdmin=driver.findElement(welComeAdminProperty);
					welComeAdmin.click();

					Thread.sleep(5000);

					By logOutProperty=By.linkText("Logout"); // considering a part of the Text of the LINK as Selector
					WebElement logOut=driver.findElement(logOutProperty);
					logOut.click();
					}
					catch(Exception suchi) {
						System.out.println(suchi);
					}
				}
				driver.quit();
				
}
}
