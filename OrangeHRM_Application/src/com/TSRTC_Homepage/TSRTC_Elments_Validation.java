package com.TSRTC_Homepage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TSRTC_Elments_Validation {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","D:\\Suchi_Files\\Web_Application_Testing\\OrangeHRM_Application\\BrowserDriverFiles\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		String url="https://www.tsrtconline.in/oprs-web/guest/home.do?h=1";
		driver.get(url);
		
		
		By tsrtcHomePageHeaderBlockProperty=By.className("menu-wrap");
		WebElement tsrtcHomePageHeaderBlock=driver.findElement(tsrtcHomePageHeaderBlockProperty);
		
		By tsrtcHomePageHeaderBlockLinksProperty=By.tagName("a");
		List<WebElement>tsrtcHomePageHeaderBlockLinks=tsrtcHomePageHeaderBlock.findElements(tsrtcHomePageHeaderBlockLinksProperty);
		int tsrtcHeaderBlockLinksCount=tsrtcHomePageHeaderBlockLinks.size();
		
		for(int arrayIndex=0;arrayIndex<tsrtcHeaderBlockLinksCount;arrayIndex++) {
			String text=tsrtcHomePageHeaderBlockLinks.get(arrayIndex).getText();
			System.out.println();
			System.out.println(arrayIndex+" -"+ text);
			
			String expectedurl=tsrtcHomePageHeaderBlockLinks.get(arrayIndex).getAttribute("href");
			System.out.println("The expected url is - "+expectedurl);
			tsrtcHomePageHeaderBlockLinks.get(arrayIndex).click();
			System.out.println();
			String title = driver.getTitle();
			System.out.println("The title of the "+text +" page "+"  "+ "is:- "+title);
			System.out.println();
			
			String actualcurrenturl=driver.getCurrentUrl();
			System.out.println("The actual url is - "+actualcurrenturl);
			//System.out.println("The current url of the "+text + " page "+"  " + "is :-" +actualcurrenturl);
			System.out.println();
			if(actualcurrenturl.equals(expectedurl)) {
				System.out.println("The url of the " +text+ " page is matched - PASS");
			}
			else {
				System.out.println("The url of the " +text+ " page is Not matched - FAIL");
			}
			driver.navigate().refresh();
			tsrtcHomePageHeaderBlock=driver.findElement(tsrtcHomePageHeaderBlockProperty);
			tsrtcHomePageHeaderBlockLinks=tsrtcHomePageHeaderBlock.findElements(tsrtcHomePageHeaderBlockLinksProperty);
			
		}
		
		driver.quit();
	}

}
