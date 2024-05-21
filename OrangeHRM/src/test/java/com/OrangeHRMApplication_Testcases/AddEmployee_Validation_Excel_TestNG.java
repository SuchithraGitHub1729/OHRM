package com.OrangeHRMApplication_Testcases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.BaseTest.BaseTest;
import com.Utility.Log;

public class AddEmployee_Validation_Excel_TestNG extends BaseTest
{

	FileInputStream file;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	int rowcount;
	Row row;
	int rowofcellcount;
	Cell rowofcell;
	By loginpanelProperty;
	WebElement loginpanel;
	By welComeAdminProperty;
	WebElement welComeAdmin;
	By pimProperty;
	WebElement pim;
	By addEmployeeProperty;
	WebElement addEmployee;
	By fullNameproperty;
	WebElement fullname;
	String expected_loginpageText;
	String actual_loginpageText;
	Cell actual_Text_testResult;
	FileInputStream OrangeHRMApplication_PropertiesFile;
	Properties properties;
	
	@Test(priority=1)
	public void oHRM_LOginpage_Validation() throws IOException {
		
		 file=new FileInputStream("./src/main/java/com/OrangeHRM_TestdataFiles/AddEmployee_validation.xlsx");
		 workbook=new XSSFWorkbook(file);
	   sheet=workbook.getSheet("AddEmployeeTestdata");
		
		 rowcount=sheet.getLastRowNum();
		
	    row=sheet.getRow(1);
		
	    rowofcellcount=row.getLastCellNum();
		
		rowofcell=row.getCell(0);
		
		expected_loginpageText=rowofcell.getStringCellValue();
		
		OrangeHRMApplication_PropertiesFile=new FileInputStream("./src/main/java/com/Config/OrangeHRMApplication_PropertiesFile.properties");
		properties=new Properties();
		properties.load(OrangeHRMApplication_PropertiesFile);
		
		loginpanelProperty=By.id(properties.getProperty("logInPageLogInPanelProperty"));
		loginpanel=driver.findElement(loginpanelProperty);
		actual_loginpageText=loginpanel.getText();
		
		actual_Text_testResult=row.createCell(2);
		actual_Text_testResult.setCellValue(actual_loginpageText);
		
		if(actual_loginpageText.equals(expected_loginpageText)) {
			
			System.out.println("The text of the loginpage is matched-PASS");
			Log.info("The text of the loginpage is matched-PASS");
			
			Cell text_Test_Result=row.createCell(3);
			text_Test_Result.setCellValue("The text of the loginpage is matched-PASS");

		}
		else
		{
			System.out.println("The text of the loginpage is Not matched-FAIL");
			Log.info("The text of the loginpage is Not matched-FAIL");
			
			Cell text_Test_Result=row.createCell(3);
			text_Test_Result.setCellValue("The text of the loginpage is Not matched-FAIL");
		}
		rowofcell=row.getCell(4);
		String expected_loginpageTitle=rowofcell.getStringCellValue();
		
		String actual_loginpageTitle=driver.getTitle();
		
		Cell actual_title_result=row.createCell(5);
		actual_title_result.setCellValue(actual_loginpageTitle);
		
		if(actual_loginpageTitle.equalsIgnoreCase(expected_loginpageTitle)) {
			System.out.println("The title of the loginpage is matched-PASS");
			Log.info("The title of the loginpage is matched-PASS");
			
			Cell testResult_Title=row.createCell(6);
			testResult_Title.setCellValue("The title of the loginpage is matched-PASS");
			
		}
		else
		{
	         System.out.println("The title of the loginpage is Not matched-FAIL");
			Log.info("The title of the loginpage is Not matched-FAIL");
			
			Cell testResult_Title=row.createCell(6);
			testResult_Title.setCellValue("The title of the loginpage is Not matched-FAIL");             
		}
			
}
	@Test(priority=2)
	public void oHRM_LoginPage_Test() {
		
		rowofcell=row.getCell(7);
		String usernameTestdata=rowofcell.getStringCellValue();
		
		By usernameProperty=By.id(properties.getProperty("logInPageUserNameProperty"));
		WebElement username=driver.findElement(usernameProperty);
		username.sendKeys(usernameTestdata);
		
		rowofcell=row.getCell(8);
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
		
		rowofcell=row.getCell(9);
		String expected_homepagetext=rowofcell.getStringCellValue();
		
		welComeAdminProperty=By.partialLinkText(properties.getProperty("orangeHRMApplicationHomePageWelComeAdminProperty"));
		welComeAdmin=driver.findElement(welComeAdminProperty);
		
		String actual_HomepageText=welComeAdmin.getText();
		
		Cell actualHomepageTextResult=row.createCell(10);
		actualHomepageTextResult.setCellValue(actual_HomepageText);
		
		if(actual_HomepageText.contains(expected_homepagetext)) {
			System.out.println("The text of the homepage is found-PASS");
			Log.info("The text of the homepage is found-PASS");
			
			Cell homepagetextResult=row.createCell(11);
			homepagetextResult.setCellValue("The text of the homepage is found-PASS");
		}
		else
		{
			System.out.println("The text of the homepage is Not found-FAIL");
			Log.info("The text of the homepage is Not found-FAIL");
			
			Cell homepagetextResult=row.createCell(11);
			homepagetextResult.setCellValue("The text of the homepage is Not found-FAIL");
		}
	}
	
	@Test(priority=4)
	public void addEmployeePage_Validation() {
		
		pimProperty=By.linkText(properties.getProperty("homePagepimProperty"));
		pim=driver.findElement(pimProperty);

		Actions mouseHover= new Actions(driver);
		mouseHover.moveToElement(pim).build().perform();

		addEmployeeProperty=By.linkText(properties.getProperty("homePageAddEmployeeProperty"));
		addEmployee=driver.findElement(addEmployeeProperty);
		addEmployee.click();
		
		rowofcell=row.getCell(12);
		String expected_AddEmployeePagetext=rowofcell.getStringCellValue();
		
		By addEmployeeTextProperty=By.xpath(properties.getProperty("text_addEmployeeProperty"));
		WebElement addemployeeText=driver.findElement(addEmployeeTextProperty);
		

		String actual_AddEmpText=addemployeeText.getText();

		Cell addempText=row.createCell(13);
		addempText.setCellValue(actual_AddEmpText);

		if(actual_AddEmpText.equals(expected_AddEmployeePagetext)) {
			
			Cell addEmpTextResult=row.createCell(14);
			addEmpTextResult.setCellValue("The text of the Add employee page is matched-PASS");
			Log.info("The text of the Add employee page is matched-PASS");
		}
		else
		{
			Cell addEmpTextResult=row.createCell(14);
			addEmpTextResult.setCellValue("The text of the Add employee page is Not matched-FAIL");
			Log.info("The text of the Add employee page is Not matched-FAIL");
		}
	}
	
	@Test(priority=5)
	public void addEmployeePage_Test() {
		
           for(int rowindex=1;rowindex<=3;rowindex++) {
			
			Row row1=sheet.getRow(rowindex);
			
			Cell rowofcell1=row1.getCell(15);
			
			String expected_firstname=rowofcell1.getStringCellValue();
			By firstNameProperty=By.id(properties.getProperty("add_EmployeefirstNameProperty"));
			WebElement empfirstName=driver.findElement(firstNameProperty);
			
			empfirstName.sendKeys(expected_firstname);
			
           rowofcell1=row1.getCell(16);
			
			String expected_middlename=rowofcell1.getStringCellValue();
			
			By middleNameProperty=By.id(properties.getProperty("add_EmployeemiddleNameProperty"));
			WebElement empmiddleName=driver.findElement(middleNameProperty);
			empmiddleName.sendKeys(expected_middlename);
			
             rowofcell1=row1.getCell(17);
			
			String expected_lastname=rowofcell1.getStringCellValue();
			
			By lastNameProperty=By.id(properties.getProperty("add_EmployeelastNameProperty"));
			WebElement emplastName=driver.findElement(lastNameProperty);
			emplastName.sendKeys(expected_lastname);
			
			By add_Emp_EmployeeIdProperty=By.id(properties.getProperty("empId_AddEmployeeProperty"));
			   WebElement employeeId=driver.findElement(add_Emp_EmployeeIdProperty);
			   
			   String expected_empId=employeeId.getAttribute("value");
			   
			   rowofcell1=row1.createCell(18);
			   
			    rowofcell1.setCellValue(expected_empId);
			   System.out.println("The EmployeeId is :-"+expected_empId);
			Log.info("The EmployeeId is :-"+expected_empId);
			
			By saveButtonProperty=By.id(properties.getProperty("add_Employee_saveButtonProperty"));
			   WebElement saveButton=driver.findElement(saveButtonProperty);
			   saveButton.click();
			   
			   rowofcell1=row1.getCell(19);
			   String expected_PersonaldetailspageText=rowofcell1.getStringCellValue();
			   Log.info("The expected text of the personal details page is"+expected_PersonaldetailspageText);
			   
			   //<label for="Full_Name" class="hasTopFieldHelp">Full Name</label>
			   By personaldetails_Text_Property=By.xpath(properties.getProperty("personaldetailsPageTextproperty"));
			   WebElement personaldetailsPageText=driver.findElement(personaldetails_Text_Property);
			   
			   ///html/body/div[1]/div[3]/div/div[2]/div[1]/h1
			   
			   String actual_personalDetailspageText=personaldetailsPageText.getText();
			   Log.info("The Actual text of Personal details page is"+actual_personalDetailspageText);
			   
			   rowofcell1=row1.createCell(20);
			   rowofcell1.setCellValue(actual_personalDetailspageText);
			   
			   if(actual_personalDetailspageText.equals(expected_PersonaldetailspageText))
			   {
				   rowofcell1=row1.createCell(21);
				   rowofcell1.setCellValue("The text of the personal details page is matched-PASS");
				   
				   Log.info("The text of the personal details page is matched-PASS");
			   }
			   else
			   {
				   rowofcell1=row1.createCell(21);
				   rowofcell1.setCellValue("The text of the personal details page is Not matched-FAIL");
				   
				   Log.info("The text of the personal details page is Not matched-FAIL");
			   }
			   
			   //<input value="Srini01" type="text" name="personal[txtEmpFirstName]" class="block default editable" maxlength="30" title="First Name" id="personal_txtEmpFirstName" disabled="disabled">
			   
			   By fistnameTextProperty=By.id(properties.getProperty("personal_Details_fistnameTextProperty"));
				  WebElement fistnameText=driver.findElement(fistnameTextProperty);
				  String actual_firstname=fistnameText.getAttribute("value");
				  
				  rowofcell1=row1.createCell(22);
				   rowofcell1.setCellValue(actual_firstname);
				   
				  
				  System.out.println("The actual first name of the employee is :- "+actual_firstname);

				   if(actual_firstname.equals(expected_firstname))
				   {
				System.out.println("The first name of the Employee is matched:-PASS");
				Log.info("The first name of the Employee is matched:-PASS");
				
				rowofcell1=row1.createCell(23);
				   rowofcell1.setCellValue("The first name of the Employee is matched:-PASS");
				   }
				  else
				   {
				System.out.println("The first name of the Employee is Not matched:-FAIL");
				Log.info("The first name of the Employee is Not matched:-FAIL");
				
				rowofcell1=row1.createCell(23);
				   rowofcell1.setCellValue("The first name of the Employee is Not matched:-FAIL");
				   }
				   
				   By middlenameTextProperty=By.id(properties.getProperty("personal_Details_middlenameTextProperty"));
				   WebElement middlenameText=driver.findElement(middlenameTextProperty);
				   String actual_MiddleName=middlenameText.getAttribute("value");
				   
				   rowofcell1=row1.createCell(24);
				   rowofcell1.setCellValue(actual_MiddleName);
				   
				   System.out.println("The actual middlename of the employee is :- "+actual_MiddleName);

				   if(actual_MiddleName.equals(expected_middlename))
				   {
				System.out.println("The middle name of the Employee is matched:-PASS");
				Log.info("The middle name of the Employee is matched:-PASS");
				
				rowofcell1=row1.createCell(25);
				   rowofcell1.setCellValue("The middle name of the Employee is matched:-PASS");
				   }
				  else
				   {
				System.out.println("The middle name of the Employee is Not matched:-FAIL");
				Log.info("The middle name of the Employee is Not matched:-FAIL");
				
				rowofcell1=row1.createCell(25);
				   rowofcell1.setCellValue("The middle name of the Employee is Not matched:-FAIL");
				   }
				   
				   By lastnameTextProperty=By.id(properties.getProperty("personal_Details_lastnameTextProperty"));
				   WebElement lastnameText=driver.findElement(lastnameTextProperty);
				   String actual_lastName=lastnameText.getAttribute("value");
				   
				   
				   rowofcell1=row1.createCell(26);
				   rowofcell1.setCellValue(actual_lastName);
				   
				   System.out.println("The actual lastname of the employee is :- "+actual_lastName);

				    if(actual_lastName.equals(expected_lastname))
				    {
				System.out.println("The Last name of the Employee is matched:-PASS");
				Log.info("The Last name of the Employee is matched:-PASS");
				
				rowofcell1=row1.createCell(27);
				   rowofcell1.setCellValue("The last name of the Employee is matched:-PASS");
				    }
				   else
				   {
				System.out.println("The Last name of the Employee is Not matched:-FAIL");
				Log.info("The Last name of the Employee is Not matched:-FAIL");
				
				rowofcell1=row1.createCell(27);
				   rowofcell1.setCellValue("The Last name of the Employee is Not matched:-FAIL");
				   }
				    
				    //<input value="0022" type="text" name="personal[txtEmployeeId]" maxlength="10" class="editable" id="personal_txtEmployeeId" disabled="disabled">
				    
				    By employeeidProperty=By.id(properties.getProperty("personal_Details_employeeidProperty"));
				    WebElement employeeid=driver.findElement(employeeidProperty);
				    String actual_empId=employeeid.getAttribute("value");
				    
				    rowofcell1=row1.createCell(28);
			    	rowofcell1.setCellValue(actual_empId);
				    
				    if(actual_empId.equals(expected_empId)) {
				    	rowofcell1=row1.createCell(29);
				    	rowofcell1.setCellValue("The employee Id is matched-PASS");
				    	Log.info("The employee Id is matched-PASS");
				    }
				    else
				    {
				    	rowofcell1=row1.createCell(29);
				    	rowofcell1.setCellValue("The employee Id is Not matched-FAIL");
				    	
				    	Log.info("The employee Id is Not matched-FAIL");
				    }
			   addEmployeeProperty=By.linkText("Add Employee");
			   addEmployee=driver.findElement(addEmployeeProperty);
			   addEmployee.click(); 
			
		}
}
	
	@Test(priority=6)
	public void logout_Test() throws InterruptedException
	{
		
		welComeAdminProperty=By.partialLinkText(properties.getProperty("orangeHRMApplicationHomePageWelComeAdminProperty"));
		 welComeAdmin=driver.findElement(welComeAdminProperty);
		 welComeAdmin.click();
		 
		 Thread.sleep(5000);

		   By logOutProperty=By.linkText(properties.getProperty("homePagelogOutProperty")); 
		   WebElement logOut=driver.findElement(logOutProperty);
		   logOut.click();

	}
	
	@Test(priority=7)
	public void loginPage_Validation_AfterLogout() throws IOException {
		rowofcell=row.getCell(30);
		
		expected_loginpageText=rowofcell.getStringCellValue();
		
		loginpanelProperty=By.id(properties.getProperty("logInPageLogInPanelProperty"));
		loginpanel=driver.findElement(loginpanelProperty);
		actual_loginpageText=loginpanel.getText();
		
		actual_Text_testResult=row.createCell(31);
		actual_Text_testResult.setCellValue(actual_loginpageText);
		
		if(actual_loginpageText.equals(expected_loginpageText)) {
			
			System.out.println("The text of the loginpage is matched-PASS");
			Log.info("The text of the loginpage is matched-PASS");
			
			Cell text_Test_Result=row.createCell(32);
			text_Test_Result.setCellValue("The text of the loginpage is matched-PASS");

		}
		else
		{
			System.out.println("The text of the loginpage is Not matched-FAIL");
			Log.info("The text of the loginpage is Not matched-FAIL");
			
			Cell text_Test_Result=row.createCell(32);
			text_Test_Result.setCellValue("The text of the loginpage is Not matched-FAIL");
		}
		
		FileOutputStream testresultfile=new FileOutputStream("./src/main/java/com/OrangeHRM_TestResultFiles/AddEmployee_Validation_TestResult.xlsx");
      workbook.write(testresultfile);
	}
}
