package com.midcities.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.paulhammant.ngwebdriver.ByAngular;

public class LoginPageElements {

	WebDriver driver;
	
	public LoginPageElements(WebDriver driver){
		
		this.driver = driver;
		
	}
	
	public void Login(String uname, String pass) {
		
		driver.findElement(By.id("mat-input-0")).sendKeys(uname);
		  
		driver.findElement(By.id("mat-input-1a")).sendKeys(pass);
		  
		driver.findElement(ByAngular.buttonText("SIGN IN")).click();
		
	}
}
