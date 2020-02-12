package com.midcities.testcases;

import org.testng.annotations.Test;

import com.midcities.pages.BaseClass;
import com.midcities.pages.LoginPageElements;

public class Login_Positive_Case extends BaseClass{
	
	@Test
	public void loginIntoTheApplication() {
		
		logger = reports.createTest("Login Positive case");
		
		LoginPageElements loginFunc = new LoginPageElements(driver);
		
		logger.info("Starting Application");
		
		loginFunc.Login_Positive(excel.getStringCellData("Login", 1, 0), excel.getStringCellData("Login", 1, 1));
		
	}
	
}
