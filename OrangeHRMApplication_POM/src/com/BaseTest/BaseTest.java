package com.BaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.Utility.Log;

public class BaseTest 
{
	public static WebDriver driver;
	@BeforeTest
	public void applicationLaunch() {
		
		
		String application_URL="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		
		System.setProperty("webdriver.chrome.driver","./BrowserDriverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.get(application_URL);
		
		System.out.println("====================Application Launched successfully==================");
Log.info("====================Application Launched successfully==================");
	}

	
	@AfterTest
	public void applicationClose() {
		driver.close();
		
		System.out.println("******************Application closed successfully*********************");
		Log.info("******************Application closed successfully*********************");
	}
}

