package com.MouseHover_Operations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover_Operation_Amazon {
	WebDriver driver;
	String applicationURL="https://www.amazon.in/";
	
	public void applicationLaiunch() {
		System.setProperty("webdriver.chrome.driver","./BrowserDriverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(applicationURL);
		
		driver.manage().window().maximize();
	}
	
	public void mouseHoverOperation()   {
		
		// <div class="nav-line-1-container"><span id="nav-link-accountList-nav-line-1" class="nav-line-1 nav-progressive-content">Hello, sign in</span></div>
		
	By	signInProperty=By.id("nav-link-accountList-nav-line-1");
	WebElement signIn=driver.findElement(signInProperty);
	
	Actions mousehover=new Actions(driver);
mousehover.moveToElement(signIn).build().perform();;



	}
	
	public void click_Link() throws InterruptedException {
		
		//<span class="nav-text">Your Account</span>
		Thread.sleep(5000);
	By	linkProperty=By.linkText("Your Account");
		WebElement link=driver.findElement(linkProperty);
		
		link.click();
		
		String expected_link_URL="https://www.amazon.in/gp/css/homepage.html?ref_=nav_AccountFlyout_ya";
		String actual_link_URL=driver.getCurrentUrl();
		System.out.println("The title of the current link is:-"+actual_link_URL);
		if(actual_link_URL.equals(expected_link_URL)) {
			System.out.println("successfully clicked on the link - PASS");
		}
		else
		{
			System.out.println("Failed to click on the link - FAIL");
		}
	}
	
	public void applicationClose() {
		driver.close();
		
	}
	public static void main(String[] args) throws InterruptedException {
		MouseHover_Operation_Amazon amazon=new MouseHover_Operation_Amazon();
		amazon.applicationLaiunch();
		amazon.mouseHoverOperation();
		amazon.click_Link();
		amazon.applicationClose();
		
		
	}

}
