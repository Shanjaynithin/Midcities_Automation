package com.midcities.testcases;

import org.testng.annotations.Test;

import com.midcities.pages.BaseClass;
import com.midcities.pages.LoginPageElements;
import com.midcities.pages.UserManagementElements;

public class User_Positive_Case extends BaseClass {
	
	@Test
	public void UserPositiveCase() throws InterruptedException {
		
		logger = reports.createTest("Create user positive case");
		
		LoginPageElements loginFunc = new LoginPageElements(driver);
		
		loginFunc.Login_Positive(excel.getStringCellData("Login", 1, 0), excel.getStringCellData("Login", 1, 1));
		
		UserManagementElements user = new UserManagementElements(driver);
		
		user.newUser_Positive();
		
	}

}
