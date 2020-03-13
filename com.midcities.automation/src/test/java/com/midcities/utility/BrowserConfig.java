package com.midcities.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.paulhammant.ngwebdriver.NgWebDriver;

public class BrowserConfig {
	
	public static WebDriver startApplication(String browsername, String AppUrl) {
		
		WebDriver driver = null;
		
		if(browsername.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			
			driver = new ChromeDriver();
			
		} else if(browsername.equalsIgnoreCase("firefox")){
			
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			
			driver = new FirefoxDriver();
			
		} else {
			
			System.out.println("Browser not supported");
		}
		
		NgWebDriver ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);
		  
		ngWebDriver.waitForAngularRequestsToFinish();
		
		driver.manage().window().maximize();
		
		driver.get(AppUrl);
		
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    
		return driver;
	}
	
	public static void quitBrowser(WebDriver driver) {
		
		driver.quit();
	}

}
