package com.OHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OHRM_AddEmployee {
	
	WebDriver driver;
	String application_URL="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
	
	By welComeAdminProperty;
	WebElement welComeAdmin;
	
	public void applicationLaunch()
	{
		System.setProperty("webdriver.chrome.driver","./BrowserDriverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.get(application_URL);
		
	}
	
	public void loginPage_Validation()
	{
		String expected_OrangeHRMLoginPageTitle="OrangeHRM";
		System.out.println(" The Expected title of the OrangeHRM login Page is :- "+expected_OrangeHRMLoginPageTitle);

		String actual_OrangeHRMLoginPageTitle=driver.getTitle();
		System.out.println(" The Actual title of the OrangeHRM Application Login Page is :- "+actual_OrangeHRMLoginPageTitle);
		
		if(actual_OrangeHRMLoginPageTitle.equals(expected_OrangeHRMLoginPageTitle))
		{
		System.out.println("The Title of OrangeHRM Loginpage is Mateched - PASS");
		}
		else
		{
		System.out.println("The Title of OrangeHRM Loginpage is Not Matched - FAIL");
		}

		System.out.println();

		//Get the current url

		String expected_OrangeHRMLoginpageURL="orangehrm-4.2.0.1";
		System.out.println(" The Expected Current URL of the OrangeHRM Login Page is :- "+expected_OrangeHRMLoginpageURL);

		String actual_OrangeHRMLoginpageURL=driver.getCurrentUrl();
		System.out.println("The actual current url of the OrangeHRM loginpage" +actual_OrangeHRMLoginpageURL);
		
		if(actual_OrangeHRMLoginpageURL.contains(expected_OrangeHRMLoginpageURL))
		{
		System.out.println("The current URL of the Loginpage is found - PASS");
		}
		else
		{
		System.out.println("The current URL of the Loginpage is Not found - FAIL");
		}

		System.out.println();

		By logInPanelProperty=By.id("logInPanelHeading");
		   WebElement loginPanel=driver.findElement(logInPanelProperty);
		   
		   
		   String expected_OrangeHRMApplicationLoginPageText="LOGIN Panel";
		   System.out.println("The expected text of Orange HRM Application Login Page Is:-"+ expected_OrangeHRMApplicationLoginPageText);
		   
		   String actual_OrangeHRMApplicationLoginPageText=loginPanel.getText();
		   System.out.println("The actual text of Orange HRM Application Login Page Is:-"+ actual_OrangeHRMApplicationLoginPageText);
		   
		   if(actual_OrangeHRMApplicationLoginPageText.equals(expected_OrangeHRMApplicationLoginPageText))
		   {
		    System.out.println("The Text of OrangeHRM Application Login Page is matched - PASS ");
		   }
		   else
		   {
		    System.out.println("The Text of OrangeHRM Application Login Page is Not matched - FAIL ");
		   }

	}
	public void applicationLogin()
	{
		String UsernameTestdata="Suchi";
		String passwordTestdata="Suchithra@123";

		        By usernameProperty=By.id("txtUsername");
		        WebElement username=driver.findElement(usernameProperty);
		        username.sendKeys(UsernameTestdata);

		        By passwordProperty=By.id("txtPassword");
		        WebElement password=driver.findElement(passwordProperty);
		        password.sendKeys(passwordTestdata);

		        By loginProperty=By.name("Submit");
		        WebElement login=driver.findElement(loginProperty);
		        login.click();                  

	}
	
	public void homaPage_Validatiion()
	{
		//validate homepage

	       String expected_OrangeHRMHomepageTitle="OrangeHRM";

	       System.out.println(" The Expected title of the OrangeHRM Home Page is :- "+expected_OrangeHRMHomepageTitle);

	       String actual_OrangeHRMHomePageTitle=driver.getTitle();
	       System.out.println(" The Actual title of the OrangeHRM Application Login Page is :- "+actual_OrangeHRMHomePageTitle);
	       
	       if(actual_OrangeHRMHomePageTitle.equals(expected_OrangeHRMHomepageTitle))
	      {
	   System.out.println("The Title of OrangeHRM Homepage is Matched:- PASS");
	      }
	    else
	     {
	  System.out.println("The Title of OrangeHRM Homepage is Not Matched:- FAIL");
	     }

	     System.out.println();
	 
	    //Get the current URL of Home Page
	 
	    String expected_OrangeHRMHomepageURL="orangehrm-4.2.0.1";
	    System.out.println(" The Expected Current URL of the OrangeHRM Home Page is :- "+expected_OrangeHRMHomepageURL);

	    String actual_OrangeHRMHomepageURL=driver.getCurrentUrl();
	    System.out.println("The actual current url of the OrangeHRM loginpage" +actual_OrangeHRMHomepageURL);
	    if(actual_OrangeHRMHomepageURL.contains(expected_OrangeHRMHomepageURL))
	    {
	 System.out.println("The current URL of the Homepage is Found:-PASS");
	    }
	  else
	   {
	System.out.println("The current URL of the Homepage is Not Found: - FAIL");
	   }

	   System.out.println();

	     String expected_text="Admin";
	     System.out.println("The expected test of OrangeHRM application text is:-" +expected_text);

	     welComeAdminProperty =By.linkText("Welcome Admin");
	     welComeAdmin=driver.findElement(welComeAdminProperty);

	     String actual_text=welComeAdmin.getText();
	     System.out.println("The actual test of OrangeHRM application text is:-" + actual_text);

	     if(actual_text.contains(expected_text))
	     {
	 System.out.println("The Text of the Homepage is found:-PASS");
	}
	   else
	   {
	System.out.println("The Text of the Homepage is Not found:-FAIL");
	   }

	   System.out.println();
	}
	
	public void addEmployee()
	{
		 By pimProperty=By.linkText("PIM");
		   WebElement pim=driver.findElement(pimProperty);

		   Actions mouseHover= new Actions(driver);
		   mouseHover.moveToElement(pim).build().perform();

		   By addEmployeeProperty=By.linkText("Add Employee");
		   WebElement addEmployee=driver.findElement(addEmployeeProperty);
		   addEmployee.click();

		   By firstNameProperty=By.id("firstName");
		   WebElement firstName=driver.findElement(firstNameProperty);
		   firstName.sendKeys("Suchi");

		   By middleNameProperty=By.id("middleName");
		   WebElement middleName=driver.findElement(middleNameProperty);
		   middleName.sendKeys("Chithra");

		   By lastNameProperty=By.id("lastName");
		   WebElement lastName=driver.findElement(lastNameProperty);
		   lastName.sendKeys("Vara");

		   By employeeIdProperty=By.id("employeeId");
		   WebElement employeeId=driver.findElement(employeeIdProperty);
		   
		   String empId=employeeId.getAttribute("value");
		   System.out.println("The EmployeeId is :-"+empId);

		   //<input type="button" class="" id="btnSave" value="Save">
		   
		   By saveButtonProperty=By.id("btnSave");
		   WebElement saveButton=driver.findElement(saveButtonProperty);
		   saveButton.click();
		   
		   System.out.println();
	}
	
	public void employeeName_Validation()
	{
		//Validate the FirstName

		  String expected_firstname="Suchi";
		  System.out.println("The expected first name of the employee is :- "+expected_firstname);

		  By fistnameTextProperty=By.id("personal_txtEmpFirstName");
		  WebElement fistnameText=driver.findElement(fistnameTextProperty);
		  String actual_firstname=fistnameText.getAttribute("value");
		  System.out.println("The actual first name of the employee is :- "+actual_firstname);

		   if(actual_firstname.equals(expected_firstname))
		   {
		System.out.println("The first name of the Employee is matched:-PASS");
		   }
		  else
		   {
		System.out.println("The first name of the Employee is Not matched:-FAIL");
		   }

		   System.out.println();
		   
		   //Validate the Middlename

		   String expected_middleName="Chithra";
		   System.out.println("The expected middle name of the employee is :- "+expected_middleName);

		   By middlenameTextProperty=By.id("personal_txtEmpMiddleName");
		   WebElement middlenameText=driver.findElement(middlenameTextProperty);
		   String actual_MiddleName=middlenameText.getAttribute("value");
		   System.out.println("The actual middlename of the employee is :- "+actual_MiddleName);

		   if(actual_MiddleName.equals(expected_middleName))
		   {
		System.out.println("The middle name of the Employee is matched:-PASS");
		   }
		  else
		   {
		System.out.println("The middle name of the Employee is Not matched:-FAIL");
		   }

		    System.out.println();
		   
		   //Validate LastName

		    String expected_LastName="Vara";
		    System.out.println("The expected last name of the employee is :- "+expected_LastName);

		   By lastnameTextProperty=By.id("personal_txtEmpLastName");
		   WebElement lastnameText=driver.findElement(lastnameTextProperty);
		   String actual_lastName=lastnameText.getAttribute("value");
		   System.out.println("The actual lastname of the employee is :- "+actual_lastName);

		    if(actual_lastName.equals(expected_LastName))
		    {
		System.out.println("The Last name of the Employee is matched:-PASS");
		    }
		   else
		   {
		System.out.println("The Last name of the Employee is Not matched:-FAIL");
		   }
	}
	
	public void applicationClose() throws InterruptedException
	{
		welComeAdminProperty=By.linkText("Welcome Admin");
	    welComeAdmin=driver.findElement(welComeAdminProperty);
	    welComeAdmin.click();

	   Thread.sleep(5000);

	   By logOutProperty=By.linkText("Logout"); // considering a part of the Text of the LINK as Selector
	   WebElement logOut=driver.findElement(logOutProperty);
	   logOut.click();

	   driver.close();

	}
	public static void main(String[] args) throws InterruptedException {
			
		OHRM_AddEmployee emp=new OHRM_AddEmployee();
		emp.applicationLaunch();
		emp.loginPage_Validation();
		emp.applicationLogin();
		emp.homaPage_Validatiion();
		emp.addEmployee();
		emp.employeeName_Validation();
		emp.applicationClose();
				
	}

}
