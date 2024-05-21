package com.TSRTC_Homepage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TSRTC_Elments_Verification {
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
			
			tsrtcHomePageHeaderBlockLinks.get(arrayIndex).click();
			
			String title = driver.getTitle();
			System.out.println("The title of the "+text +" page "+"  "+ "is:- "+title);
			String currenturl=driver.getCurrentUrl();
			System.out.println("The current url of the "+text + " page "+"  " + "is :-" +currenturl);
			System.out.println();
			//driver.navigate().refresh();
			tsrtcHomePageHeaderBlock=driver.findElement(tsrtcHomePageHeaderBlockProperty);
			tsrtcHomePageHeaderBlockLinks=tsrtcHomePageHeaderBlock.findElements(tsrtcHomePageHeaderBlockLinksProperty);
			
		}
		
		driver.quit();
		
	}
}
