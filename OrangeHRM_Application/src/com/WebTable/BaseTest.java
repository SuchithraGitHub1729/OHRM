package com.WebTable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest 
{

	WebDriver driver;
	String application_URL="https://www.timeanddate.com/worldclock/";
	public void applicationLaunch() {
		
		System.setProperty("webdriver.chrome.driver","./Browserdriverfiles1/chromedriver.exe");
		
		driver=new ChromeDriver();
		
		driver.get(application_URL);
		
		driver.manage().window().maximize();
	}
	
	public void applicationClose()
	{
		driver.close();
	}
}
