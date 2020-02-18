package com.midcities.testcases;

import org.testng.annotations.Test;

import com.midcities.pages.BaseClass;
import com.midcities.pages.LoginPageElements;

public class Login_Negative_Case extends BaseClass{
	
	@Test
	public void loginNegativeInput() {
		
		logger = reports.createTest("Login Negative case");
		
		LoginPageElements loginFunc = new LoginPageElements(driver);
		
		loginFunc.Login_Negative(excel.getStringCellData("Login", 2, 0), excel.getStringCellData("Login", 2, 1));
		
	}
	
}
