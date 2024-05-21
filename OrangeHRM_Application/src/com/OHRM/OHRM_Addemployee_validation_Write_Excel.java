package com.OHRM;

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
import org.openqa.selenium.interactions.Actions;

public class OHRM_Addemployee_validation_Write_Excel {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver;
		String application_URL="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		
		System.setProperty("webdriver.chrome.driver","./Browserdriverfiles1/chromedriver.exe");
	
		driver=new ChromeDriver();
		
		driver.get(application_URL);
		FileInputStream file=new FileInputStream("./src/com/OrangeHRM_Application_TestdataFiles/AddEmployee_validation.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("AddEmployeeTestdata");
		
		int rowcount=sheet.getLastRowNum();
		
		Row row=sheet.getRow(1);
		
		int rowofcellcount=row.getLastCellNum();
		
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
		
		rowofcell=row.getCell(7);
		String usernameTestdata=rowofcell.getStringCellValue();
		
		By usernameProperty=By.id("txtUsername");
		WebElement username=driver.findElement(usernameProperty);
		username.sendKeys(usernameTestdata);
		
		rowofcell=row.getCell(8);
		String passwordTestdata=rowofcell.getStringCellValue();
		
		By passwordProperty=By.name("txtPassword");
		WebElement password=driver.findElement(passwordProperty);
		password.sendKeys(passwordTestdata);
		
		By loginbuttonProperty=By.name("Submit");
		WebElement loginButton =driver.findElement(loginbuttonProperty);
		loginButton.click();
		
		rowofcell=row.getCell(9);
		String expected_homepagetext=rowofcell.getStringCellValue();
		
		By welComeAdminProperty=By.partialLinkText("Welcome");
		WebElement welComeAdmin=driver.findElement(welComeAdminProperty);
		
		String actual_HomepageText=welComeAdmin.getText();
		
		Cell actualHomepageTextResult=row.createCell(10);
		actualHomepageTextResult.setCellValue(actual_HomepageText);
		
		if(actual_HomepageText.contains(expected_homepagetext)) {
			System.out.println("The text of the homepage is found-PASS");
			
			Cell homepagetextResult=row.createCell(11);
			homepagetextResult.setCellValue("The text of the homepage is found-PASS");
		}
		else
		{
			Cell homepagetextResult=row.createCell(11);
			homepagetextResult.setCellValue("The text of the homepage is Not found-FAIL");
		}
		
		By pimProperty=By.linkText("PIM");
		WebElement pim=driver.findElement(pimProperty);

		Actions mouseHover= new Actions(driver);
		mouseHover.moveToElement(pim).build().perform();

		By addEmployeeProperty=By.linkText("Add Employee");
		WebElement addEmployee=driver.findElement(addEmployeeProperty);
		addEmployee.click();
		
		rowofcell=row.getCell(12);
		String expected_AddEmployeePagetext=rowofcell.getStringCellValue();
		
		By fullNameproperty=By.className("hasTopFieldHelp");
		WebElement fullname=driver.findElement(fullNameproperty);

		String actual_AddEmpText=fullname.getText();

		Cell addempText=row.createCell(13);
		addempText.setCellValue(actual_AddEmpText);

		if(actual_AddEmpText.equals(expected_AddEmployeePagetext)) {
			
			Cell addEmpTextResult=row.createCell(14);
			addEmpTextResult.setCellValue("The text of the Add employee page is matched-PASS");
			
		}
		else
		{
			Cell addEmpTextResult=row.createCell(14);
			addEmpTextResult.setCellValue("The text of the Add employee page is Not matched-FAIL");
			
		}
		for(int rowindex=1;rowindex<=3;rowindex++) {
			
			Row row1=sheet.getRow(rowindex);
			
			Cell rowofcell1=row1.getCell(15);
			
			String expected_firstname=rowofcell1.getStringCellValue();
			By firstNameProperty=By.id("firstName");
			WebElement empfirstName=driver.findElement(firstNameProperty);
			
			empfirstName.sendKeys(expected_firstname);
			
           rowofcell1=row1.getCell(16);
			
			String expected_middlename=rowofcell1.getStringCellValue();
			
			By middleNameProperty=By.id("middleName");
			WebElement empmiddleName=driver.findElement(middleNameProperty);
			empmiddleName.sendKeys(expected_middlename);
			
             rowofcell1=row1.getCell(17);
			
			String expected_lastname=rowofcell1.getStringCellValue();
			
			By lastNameProperty=By.id("lastName");
			WebElement emplastName=driver.findElement(lastNameProperty);
			emplastName.sendKeys(expected_lastname);
			
			By employeeIdProperty=By.id("employeeId");
			   WebElement employeeId=driver.findElement(employeeIdProperty);
			   
			   String expected_empId=employeeId.getAttribute("value");
			   
			   rowofcell1=row1.createCell(18);
			   
			    rowofcell1.setCellValue(expected_empId);
			   System.out.println("The EmployeeId is :-"+expected_empId);
			
			By saveButtonProperty=By.id("btnSave");
			   WebElement saveButton=driver.findElement(saveButtonProperty);
			   saveButton.click();
			   
			   rowofcell1=row1.getCell(19);
			   String expected_PersonaldetailspageText=rowofcell1.getStringCellValue();
			   
			   //<label for="Full_Name" class="hasTopFieldHelp">Full Name</label>
			   By personaldetailsPageTextproperty=By.className("hasTopFieldHelp");
			   WebElement personaldetailsPageText=driver.findElement(personaldetailsPageTextproperty);
			   String actual_personalDetailspageText=personaldetailsPageText.getText();
			   
			   rowofcell1=row1.createCell(20);
			   rowofcell1.setCellValue(actual_personalDetailspageText);
			   
			   if(actual_personalDetailspageText.equals(expected_PersonaldetailspageText))
			   {
				   rowofcell1=row1.createCell(21);
				   rowofcell1.setCellValue("The text of the personal details page is matched-PASS");
			   }
			   else
			   {
				   rowofcell1=row1.createCell(21);
				   rowofcell1.setCellValue("The text of the personal details page is Not matched-FAIL");
			   }
			   
			   //<input value="Srini01" type="text" name="personal[txtEmpFirstName]" class="block default editable" maxlength="30" title="First Name" id="personal_txtEmpFirstName" disabled="disabled">
			   
			   By fistnameTextProperty=By.id("personal_txtEmpFirstName");
				  WebElement fistnameText=driver.findElement(fistnameTextProperty);
				  String actual_firstname=fistnameText.getAttribute("value");
				  
				  rowofcell1=row1.createCell(22);
				   rowofcell1.setCellValue(actual_firstname);
				   
				  
				  System.out.println("The actual first name of the employee is :- "+actual_firstname);

				   if(actual_firstname.equals(expected_firstname))
				   {
				System.out.println("The first name of the Employee is matched:-PASS");
				
				rowofcell1=row1.createCell(23);
				   rowofcell1.setCellValue("The first name of the Employee is matched:-PASS");
				   }
				  else
				   {
				System.out.println("The first name of the Employee is Not matched:-FAIL");
				
				rowofcell1=row1.createCell(23);
				   rowofcell1.setCellValue("The first name of the Employee is Not matched:-FAIL");
				   }
				   
				   By middlenameTextProperty=By.id("personal_txtEmpMiddleName");
				   WebElement middlenameText=driver.findElement(middlenameTextProperty);
				   String actual_MiddleName=middlenameText.getAttribute("value");
				   
				   rowofcell1=row1.createCell(24);
				   rowofcell1.setCellValue(actual_MiddleName);
				   
				   System.out.println("The actual middlename of the employee is :- "+actual_MiddleName);

				   if(actual_MiddleName.equals(expected_middlename))
				   {
				System.out.println("The middle name of the Employee is matched:-PASS");
				
				rowofcell1=row1.createCell(25);
				   rowofcell1.setCellValue("The middle name of the Employee is matched:-PASS");
				   }
				  else
				   {
				System.out.println("The middle name of the Employee is Not matched:-FAIL");
				rowofcell1=row1.createCell(25);
				   rowofcell1.setCellValue("The middle name of the Employee is Not matched:-FAIL");
				   }
				   
				   By lastnameTextProperty=By.id("personal_txtEmpLastName");
				   WebElement lastnameText=driver.findElement(lastnameTextProperty);
				   String actual_lastName=lastnameText.getAttribute("value");
				   
				   
				   rowofcell1=row1.createCell(26);
				   rowofcell1.setCellValue(actual_lastName);
				   
				   System.out.println("The actual lastname of the employee is :- "+actual_lastName);

				    if(actual_lastName.equals(expected_lastname))
				    {
				System.out.println("The Last name of the Employee is matched:-PASS");
				
				rowofcell1=row1.createCell(27);
				   rowofcell1.setCellValue("The last name of the Employee is matched:-PASS");
				    }
				   else
				   {
				System.out.println("The Last name of the Employee is Not matched:-FAIL");
				
				rowofcell1=row1.createCell(27);
				   rowofcell1.setCellValue("The Last name of the Employee is Not matched:-FAIL");
				   }
				    
				    //<input value="0022" type="text" name="personal[txtEmployeeId]" maxlength="10" class="editable" id="personal_txtEmployeeId" disabled="disabled">
				    
				    By employeeidProperty=By.id("personal_txtEmployeeId");
				    WebElement employeeid=driver.findElement(employeeidProperty);
				    String actual_empId=employeeid.getAttribute("value");
				    
				    rowofcell1=row1.createCell(28);
			    	rowofcell1.setCellValue(actual_empId);
				    
				    if(actual_empId.equals(expected_empId)) {
				    	rowofcell1=row1.createCell(29);
				    	rowofcell1.setCellValue("The employee Id is matched-PASS");
				    }
				    else
				    {
				    	rowofcell1=row1.createCell(29);
				    	rowofcell1.setCellValue("The employee Id is matched-PASS");
				    }
			   addEmployeeProperty=By.linkText("Add Employee");
			   addEmployee=driver.findElement(addEmployeeProperty);
			   addEmployee.click(); 
			
		}
		
		welComeAdminProperty=By.partialLinkText("Welcome");
		 welComeAdmin=driver.findElement(welComeAdminProperty);
		 welComeAdmin.click();
		 
		 Thread.sleep(5000);

		   By logOutProperty=By.linkText("Logout"); // considering a part of the Text of the LINK as Selector
		   WebElement logOut=driver.findElement(logOutProperty);
		   logOut.click();
		   
		   rowofcell=row.getCell(30);
			
			expected_loginpageText=rowofcell.getStringCellValue();
			
			loginpanelProperty=By.id("logInPanelHeading");
			loginpanel=driver.findElement(loginpanelProperty);
			actual_loginpageText=loginpanel.getText();
			
			actual_Text_testResult=row.createCell(31);
			actual_Text_testResult.setCellValue(actual_loginpageText);
			
			if(actual_loginpageText.equals(expected_loginpageText)) {
				
				System.out.println("The text of the loginpage is matched-PASS");
				Cell text_Test_Result=row.createCell(32);
				text_Test_Result.setCellValue("The text of the loginpage is matched-PASS");

			}
			else
			{
				System.out.println("The text of the loginpage is Not matched-FAIL");
				Cell text_Test_Result=row.createCell(32);
				text_Test_Result.setCellValue("The text of the loginpage is Not matched-FAIL");
			}
			
			FileOutputStream testresultfile=new FileOutputStream("./src/com/OrangeHRM_Application_TestresultFiles/Addemployee_validationResult.xlsx");
          workbook.write(testresultfile);
			
		   driver.close();

		
	}
}
  