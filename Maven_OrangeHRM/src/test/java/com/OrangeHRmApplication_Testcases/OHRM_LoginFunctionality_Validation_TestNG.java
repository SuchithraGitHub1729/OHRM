package com.OrangeHRmApplication_Testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.Logs;
import org.testng.annotations.Test;

import com.BaseTset.BaseTest;
import com.Utility.Log;

public class OHRM_LoginFunctionality_Validation_TestNG extends BaseTest
{
	
	XSSFWorkbook workbook;
	XSSFSheet LoginTestDatasheet;
	FileInputStream orangeHRMApplicationPropertiesFile;
	Properties Properties;

	@Test(priority = 1, description = " Validating OrangeHRM Application Login Page ")
	public void orangeHrm_LoginPageValidation() throws IOException {
	FileInputStream file = new FileInputStream(
	"./src/main/java/com/OrangeHRM_TestData_Files/OrangeHRM_LogInTestDataFile1.xlsx");
	workbook = new XSSFWorkbook(file);
	LoginTestDatasheet = workbook.getSheet("LogInTestData");

	orangeHRMApplicationPropertiesFile = new FileInputStream(
	"./src/main/java/com/Config/OrangeHRMApplication_PropertiesFile.properties");
	Properties = new Properties();
	Properties.load(orangeHRMApplicationPropertiesFile);

	Row LoginTestDataRow = LoginTestDatasheet.getRow(1);
	Cell LoginPageTextRowOfCell = LoginTestDataRow.getCell(0);

	String expectedLoginPanelText = LoginPageTextRowOfCell.getStringCellValue();
	Log.info("The Expected Login Panel Text is:-" + " " + expectedLoginPanelText);

	// Finding the Element of LOGINPANELText To do The Validation
	// <div id="logInPanelHeading">LOGIN Panel</div>
	By actualLoginPanelProperty = By.id(Properties.getProperty("logInPageLogInPanelProperty"));
	WebElement actualLoginPanel = driver.findElement(actualLoginPanelProperty);
	String actualLoginPanelTextData = actualLoginPanel.getText();
	Log.info("The Actual Login Panel Text is:-" + " " + actualLoginPanelTextData);

	// Creating a Cell to send the actualLogin panel
	Cell actualLoginPanelTextDataLoginPageTextcell = LoginTestDataRow.createCell(2);
	actualLoginPanelTextDataLoginPageTextcell.setCellValue(actualLoginPanelTextData);

	// creating a cell to send the TestResult of LoginPanel
	Cell LoginPanelValidationTestResult = LoginTestDataRow.createCell(3);

	if (actualLoginPanelTextData.equals(expectedLoginPanelText)) {
	Log.info("Successfully Navigated OrangeHRM Application Login Page Text Matched :-PASS");
	LoginPanelValidationTestResult.setCellValue("Pass");
	} else {
	Log.info("Failed to Navigate OrangeHRM Application Login Page Text Not Matched :-Fail");
	LoginPanelValidationTestResult.setCellValue("Fail");
	}

	System.out.println();

	Cell LoginPageTitleRowOFCell = LoginTestDataRow.getCell(4);
	String expectedLoginPageTitle = LoginPageTitleRowOFCell.getStringCellValue();
	Log.info("The Expected Login Page Title" + " " + expectedLoginPageTitle);

	String Actual_LogInPageTitle = driver.getTitle();
	Log.info("The Actual Login page Title" + " " + Actual_LogInPageTitle);
	Cell actualLoginPageTitleValue = LoginTestDataRow.getCell(5);
	actualLoginPageTitleValue.setCellValue(Actual_LogInPageTitle);
	Cell LoginPageTitleResult = LoginTestDataRow.getCell(6);

	if (Actual_LogInPageTitle.equalsIgnoreCase(expectedLoginPageTitle)) {
	Log.info("Successfully Navigated OrangeHRM Application Title Matched :-PASS");
	LoginPageTitleResult.setCellValue("Pass");
	} else {
	Log.info("Faild to Navigated OrangeHRM Application Title Not Matched :-Fail");
	LoginPageTitleResult.setCellValue("Fail");
	}
	System.out.println();
	}

	@Test(priority = 2, description = " Validating OrangeHRM Application Login With Different Credentials")
	public void orangHRM_LoginValidation() throws IOException {
	int rowsCount = LoginTestDatasheet.getLastRowNum();
	for (int rowIndex = 1; rowIndex <= rowsCount; rowIndex++) {
		
	Row row = LoginTestDatasheet.getRow(rowIndex);

	if (!row.getCell(7).toString().isEmpty()) {
	Cell userNameCell = row.getCell(7);

	String userNameTextData = userNameCell.getStringCellValue();

	Log.info(userNameTextData);

	Cell passwordCell = row.getCell(8);

	String passwordTestData = passwordCell.getStringCellValue();

	Log.info(passwordTestData);

	// To send Found user name and password to their Respective fields

	By userNameProperty = By.id(Properties.getProperty("logInPageUserNameProperty"));

	WebElement userName = driver.findElement(userNameProperty);

	userName.clear();

	userName.sendKeys(userNameTextData);

	By passwordProperty = By.name(Properties.getProperty("logInPagepasswordProperty"));

	WebElement password = driver.findElement(passwordProperty);

	password.clear();

	password.sendKeys(passwordTestData);

	// Finding the Element to Click on Login
	//<input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">
	By logInButtonProperty = By.id(Properties.getProperty("logInPageLogInButtonProperty"));

	WebElement logIn = driver.findElement(logInButtonProperty);

	logIn.click();

	try {

	By welcomeAdminProperty = By.id(Properties.getProperty("orangeHRMApplicationHomePageWelComeAdminProperty"));

	WebElement welcomeAdmin = driver.findElement(welcomeAdminProperty);
	String actualwelcomeAdminText = welcomeAdmin.getText();
	// Verifying the home page of OrangeHrm
	Row row1 = LoginTestDatasheet.getRow(1);
	String expectedwelcomeAdminText = row1.getCell(9).getStringCellValue();
	row1.createCell(10).setCellValue(actualwelcomeAdminText);
	Cell homePageTestResult = row.createCell(11);
	if (actualwelcomeAdminText.contains(expectedwelcomeAdminText)) {
	Log.info("Successfully Navigated to orangeHrm Home Page:-Pass");
	homePageTestResult.setCellValue("Pass");
	}

	if (welcomeAdmin.isDisplayed()) {

	// Verify of home page of OrangeHrm

	welcomeAdmin.click();

	Thread.sleep(1000);

	By logOutProperty = By.linkText(Properties.getProperty("homePagelogOutProperty"));

	WebElement logOut = driver.findElement(logOutProperty);

	logOut.click();

	}

	
		}catch (Exception e) {
	Row row1 = LoginTestDatasheet.getRow(1);
	//<span id="spanMessage">Invalid credentials</span>
	By invalidCredentialsProperty=By.id(Properties.getProperty("loginpage_InvalidCredentials_Property"));
	WebElement invalidCredentials=driver.findElement(invalidCredentialsProperty);
	String actualinvalidCredentials=invalidCredentials.getText();
	Cell homePageTestResult = row.createCell(11);

	String expecteddataOfLoginInvalid = row1.getCell(1).getStringCellValue();

	if (actualinvalidCredentials.equalsIgnoreCase(expecteddataOfLoginInvalid)) {
	Log.info("Failed To login Because of invalid Credentials:-Fail");
	homePageTestResult.setCellValue("Fail");

	}
	File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	String screentshotName= userNameTextData+" "+  passwordTestData +".png";

	// Save screenshot with language name
	FileUtils.copyFile(screenshotFile,
	new File("./OHRM_ErrorScreenShots" + screentshotName));
	System.out.println("Screenshot taken and saved as: " + screentshotName);

	}
	System.out.println();

	}

	}

	FileOutputStream testResultFile = new FileOutputStream(
	"./src/main/java/com/OrangeHRM_TestResult_Files/OrangeHRM_LogInTestResultFile.xlsx");
	workbook.write(testResultFile);

	}

	}




	
