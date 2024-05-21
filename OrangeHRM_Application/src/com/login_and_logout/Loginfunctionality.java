package com.login_and_logout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Loginfunctionality {

		 public static void main(String[] args) throws InterruptedException {

			//1.Automate the Browser

			System.setProperty("webdriver.chrome.driver","D:\\Suchi_Files\\Web_Application_Testing\\OrangeHRM_Application\\BrowserDriverFiles\\chromedriver.exe");
			ChromeDriver driver=new ChromeDriver();

			//2.Navigate to the OrangeHRM application login page

			String url="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
			driver.get(url);

			//3.Validate the Login page.
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

			//4.Login to the application with valid Testdata

			//<input name="txtUsername" id="txtUsername" type="text">

			String usernameTestdta="suchi";
			By usernameProperty=By.id("txtUsername");
			WebElement username=driver.findElement(usernameProperty);
			username.sendKeys(usernameTestdta);

			//<input name="txtPassword" id="txtPassword" autocomplete="off" type="password">

			String passwordtestdata="Suchithra@123";
			By passwordProperty=By.name("txtPassword");
			WebElement password=driver.findElement(passwordProperty);
			password.sendKeys(passwordtestdata);

			//<input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">

			By loginbuttonProperty=By.name("Submit");
			WebElement loginButton =driver.findElement(loginbuttonProperty);
			loginButton.click();

			//5.Validate OrangeHRM application Homepage
			    //Get the URL.

			String expected_OrangeHRMHomepageURL="orangehrm-4.2.0.1";
			System.out.println(" The Expected Current URL of the OrangeHRM Home Page is :- "+expected_OrangeHRMHomepageURL);
			String actual_OrangeHRMHomepageURL=driver.getCurrentUrl();
			System.out.println("The actual current url of the OrangeHRM loginpage" +actual_OrangeHRMHomepageURL);
			if(actual_OrangeHRMHomepageURL.contains(expected_OrangeHRMHomepageURL)) {
			System.out.println("The current URL of the Homepage is found - pass");
			}
			else {
			System.out.println("The current URL of the Homepage is not found - Fail");
			}

			//6.Validate Homepage
			   //Get the Title

			String expected_OrangeHRMHomepageTitle="OrangeHRM";
			System.out.println(" The Expected title of the OrangeHRM Home Page is :- "+expected_OrangeHRMHomepageTitle);
			String actual_OrangeHRMHomePageTitle=driver.getTitle();
			System.out.println(" The Actual title of the OrangeHRM Application Login Page is :- "+actual_OrangeHRMHomePageTitle);
			if(actual_OrangeHRMHomePageTitle.equals(expected_OrangeHRMHomepageTitle))
			{
			System.out.println("Title of OrangeHRM Homepage is Mateched:- PASS");
			}
			else
			{
			System.out.println("Title of OrangeHRM Homepage is Not Matched:- Fail");
			}

			//Get the welcome Admin Dropdown Text

			String expectedText ="Admin";
			System.out.println("The Expected Text of the Dropdown is -"+expectedText);

			//<a href="#" id="welcome" class="panelTrigger">Welcome Admin</a>

			By adminDropdownProperty=By.id("welcome");
			WebElement dropdown=driver.findElement(adminDropdownProperty);
			String actualText =dropdown.getText();
			System.out.println("The ActualText of the Dropdown is -"+actualText);
			if(actualText.contains(expectedText)){
			System.out.println("The Text of the Dropdown is found - pass");
			}
			else
			{
			System.out.println("The Text of the Dropdown is Not found - fail");
			}

			//7.Test Welcome Admin

			dropdown.click();
			Thread.sleep(3000);

			//8.Test Logout

			//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/auth/logout">Logout</a>

			By logoutProperty=By.linkText("Logout");
			WebElement logout=driver.findElement(logoutProperty);
			logout.click();

			//9.Validate Login page

			String expected_OrangeHRMLoginPageTitle1="OrangeHRM";
			System.out.println(" The Expected title of the OrangeHRM login Page is :- "+expected_OrangeHRMLoginPageTitle1);
			String actual_OrangeHRMLoginPageTitle1=driver.getTitle(); 
			System.out.println(" The Actual title of the OrangeHRM Application Login Page is :- "+actual_OrangeHRMLoginPageTitle1);
			if(actual_OrangeHRMLoginPageTitle1.equals(expected_OrangeHRMLoginPageTitle1))
			{
			System.out.println("Title of OrangeHRM Loginpage is Mateched:- PASS");
			}
			else
			{
			System.out.println("Title of OrangeHRM Loginpage is Not Matched:- Fail");
			}

			//Get the current url

			String expected_OrangeHRMLoginpageURL1="orangehrm-4.2.0.1";
			System.out.println(" The Expected Current URL of the OrangeHRM Login Page is :- "+expected_OrangeHRMLoginpageURL1);
			String actual_OrangeHRMLoginpageURL1=driver.getCurrentUrl();
			System.out.println("The actual current url of the OrangeHRM loginpage" +actual_OrangeHRMLoginpageURL1);
			if(actual_OrangeHRMLoginpageURL1.contains(expected_OrangeHRMLoginpageURL1)) {
			System.out.println("The current URL of the Loginpage is found - pass");
			}
			else {
			System.out.println("The current URL of the Loginpage is not found - Fail");
			}

			// Get the Login Page Text

			String expected_loginpageText1="LOGIN Panel";
			System.out.println("The expected OrangeHRM loginpage text is : "+expected_loginpageText1);
			By loginpageTextProperty1= By.id("logInPanelHeading");
			WebElement loginpageText1=driver.findElement(loginpageTextProperty1);
			String actual_loginpageText1=loginpageText1.getText();
			System.out.println("The actual OrangeHRM loginpage text is : "+actual_loginpageText1);

			if(actual_loginpageText1.equals(expected_loginpageText1)){
			System.out.println("The Text of the loginpage is matched-PASS ");
			}
			else{
			System.out.println("The Text of the loginpage is Not matched-FAIL");
			}
			Thread.sleep(2000);
			driver.close();
			}

	}


