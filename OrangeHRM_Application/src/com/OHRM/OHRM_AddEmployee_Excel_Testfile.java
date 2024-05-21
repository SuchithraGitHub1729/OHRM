package com.OHRM;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OHRM_AddEmployee_Excel_Testfile {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver;
		String application_URL="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		
		System.setProperty("webdriver.chrome.driver","./Browserdriverfiles1/chromedriver.exe");
	
		driver=new ChromeDriver();
		
		driver.get(application_URL);
		
		FileInputStream file=new FileInputStream("./src/com/OrangeHRM_Application_TestdataFiles/AddEmployee.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("AddEmployeeTestdata");
		
		int rowcount=sheet.getLastRowNum();
		
		for(int rowindex=1;rowindex<rowcount;rowindex++) {
			
			Row row=sheet.getRow(rowindex);
			
			int rowofcellCount=row.getLastCellNum();
			
			String expected_loginpageText="LOGIN Panel";
			Cell Exp_Text_testResult=row.createCell(0);
			
			Exp_Text_testResult.setCellValue(expected_loginpageText);
			
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
else
{
   System.out.println("The Text of the Homepage is Not found-FAIL");
	
	Cell testResultText_homepage=row.createCell(11);
	testResultText_homepage.setCellValue("The Text of the Homepage is Not found-FAIL");
	
}
 
By pimProperty=By.linkText("PIM");
WebElement pim=driver.findElement(pimProperty);

Actions mouseHover= new Actions(driver);
mouseHover.moveToElement(pim).build().perform();

By addEmployeeProperty=By.linkText("Add Employee");
WebElement addEmployee=driver.findElement(addEmployeeProperty);
addEmployee.click();


Cell expectedValue=row.getCell(12);
String expected_AddEmpText=expectedValue.getStringCellValue();

//<label class="hasTopFieldHelp">Full Name</label>

By fullNameproperty=By.className("hasTopFieldHelp");
WebElement fullname=driver.findElement(fullNameproperty);

String actual_AddEmpText=fullname.getText();

Cell addempText=row.createCell(13);
addempText.setCellValue(actual_AddEmpText);

if(actual_AddEmpText.equals(expected_AddEmpText)) {
	
	Cell addEmpTextResult=row.createCell(14);
	addEmpTextResult.setCellValue("The text of the Add employee page is matched-PASS");
	
}
else
{
	Cell addEmpTextResult=row.createCell(14);
	addEmpTextResult.setCellValue("The text of the Add employee page is Not matched-FAIL");
	
}

By firstNameProperty=By.id("firstName");
WebElement empfirstName=driver.findElement(firstNameProperty);
//firstName.sendKeys("Srini01");

By middleNameProperty=By.id("middleName");
WebElement empmiddleName=driver.findElement(middleNameProperty);
//middleName.sendKeys("Hello01");

By lastNameProperty=By.id("lastName");
WebElement emplastName=driver.findElement(lastNameProperty);
//lastName.sendKeys("Chello01");

String empDetails[][]=new String[3][3];
empDetails[0][0]="Srini01";
empDetails[0][1]="Hello01";
empDetails[0][2]="Chello01";
empDetails[1][0]="Ram02";
empDetails[1][1]="HEllo02";
empDetails[1][2]="Chello02";
empDetails[2][0]="Raj03";
empDetails[2][1]="Hello03";
empDetails[2][2]="Chello03";

for(String[] empFullName:empDetails) {
	
	
	String firstname=empFullName[0];
	String middlename=empFullName[1];
	String lastname=empFullName[2];
	
	firstNameProperty=By.id("firstName");
	empfirstName=driver.findElement(firstNameProperty);
	//firstName.sendKeys("Srini01");

	middleNameProperty=By.id("middleName");
empmiddleName=driver.findElement(middleNameProperty);
	//middleName.sendKeys("Hello01");

	lastNameProperty=By.id("lastName");
 emplastName=driver.findElement(lastNameProperty);
	//lastName.sendKeys("Chello01");

	empfirstName.sendKeys(firstname);
	empmiddleName.sendKeys(middlename);
	emplastName.sendKeys(lastname);
	
	By employeeIdProperty=By.id("employeeId");
	   WebElement employeeId=driver.findElement(employeeIdProperty);
	   
	   String empId=employeeId.getAttribute("value");
	   System.out.println("The EmployeeId is :-"+empId);
	   
	   Cell empIdTestResult=row.createCell(18);
	   empIdTestResult.setCellValue(empId);

	   //<input type="button" class="" id="btnSave" value="Save">
	   
	   By saveButtonProperty=By.id("btnSave");
	   WebElement saveButton=driver.findElement(saveButtonProperty);
	   saveButton.click();
	   
	   addEmployeeProperty=By.linkText("Add Employee");
	   addEmployee=driver.findElement(addEmployeeProperty);
	   addEmployee.click(); 

}



FileOutputStream addemployeeTestResult=new FileOutputStream("./src/com/OrangeHRM_Application_TestresultFiles/AddemployeeTestResult.xlsx");
workbook.write(addemployeeTestResult);

			
		}
	}
}
