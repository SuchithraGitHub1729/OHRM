package com.Screenshots_Capture;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TSRTC_Links_Screenshots_capture {
	
	WebDriver driver;
	String applicationURL="https://www.tsrtconline.in/oprs-web/";
	
	public void applicationLaiunch() {
		System.setProperty("webdriver.chrome.driver","./BrowserDriverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(applicationURL);
		
		driver.manage().window().maximize();
	}
	
	public void capture_Screenshots() throws IOException {
		
		//Identify the Header Block
		
		 //<div class="menu-wrap"><div class="menu"></div> 
		By headerBlockProperty=By.className("menu-wrap");
		WebElement headerBlock=driver.findElement(headerBlockProperty);
		
		By headerBlockLinksproperty=By.tagName("a");
		
	List<WebElement>headerBlockLinks= headerBlock.findElements(headerBlockLinksproperty);
     int	headerBlocksLinksCount=headerBlockLinks.size();
     
     for(int arrayIndex=0;arrayIndex<headerBlocksLinksCount;arrayIndex++) {
    	
    	 String headerLinkText= headerBlockLinks.get(arrayIndex).getText();
    	System.out.println();
    	System.out.println(arrayIndex+" - "+headerLinkText);
    	
    	headerBlockLinks.get(arrayIndex).click();
    	
    	File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	
    	FileUtils.copyFile(screenshot, new File("./src/com/Scrrenshots/"+headerLinkText+" "+"Page"+" "+"Screenshot"+".png"));
    	
    	 headerBlockProperty=By.className("menu-wrap");
		 headerBlock=driver.findElement(headerBlockProperty);
		
		 headerBlockLinksproperty=By.tagName("a");
		
	headerBlockLinks= headerBlock.findElements(headerBlockLinksproperty);
    	
     }
  
	}
	
	public void applicationClose() {
		
		driver.quit();
	}
	
	public static void main(String[] args) throws IOException {
		
		TSRTC_Links_Screenshots_capture tsrtc=new TSRTC_Links_Screenshots_capture();
		tsrtc.applicationLaiunch();
		tsrtc.capture_Screenshots();
		tsrtc.applicationClose();
		
	}

}
