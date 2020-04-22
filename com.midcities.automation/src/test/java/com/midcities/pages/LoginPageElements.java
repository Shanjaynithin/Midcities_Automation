package com.midcities.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.midcities.utility.Helper;
import com.paulhammant.ngwebdriver.ByAngular;

public class LoginPageElements {

	WebDriver driver;
	
	public LoginPageElements(WebDriver driver){
		
		this.driver = driver;
		
	}
	
	public void Login_Positive(String uname, String pass) {
		
		driver.findElement(By.id("mat-input-0")).sendKeys(uname);
		  
		driver.findElement(By.id("mat-input-1")).sendKeys(pass);
		  
		driver.findElement(ByAngular.buttonText("SIGN IN")).click();
		
	}
	
	public void Login_Negative(String uname, String pass) {
		
		String errorMessage = "Invalid Email Id or Password";
		
		driver.findElement(By.id("mat-input-0")).sendKeys(uname);
		  
		driver.findElement(By.id("mat-input-1")).sendKeys(pass);
		
		driver.findElement(ByAngular.buttonText("SIGN IN"));
		
		String error = driver.findElement(By.cssSelector("small[class*='form-error-msg']")).getText(); 
		
		Assert.assertEquals(error, errorMessage);
		
	}
}
