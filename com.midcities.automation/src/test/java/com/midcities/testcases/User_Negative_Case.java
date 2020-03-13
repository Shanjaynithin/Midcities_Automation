package com.midcities.testcases;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.midcities.pages.BaseClass;
import com.midcities.pages.LoginPageElements;
import com.midcities.pages.UserManagementElements;

public class User_Negative_Case extends BaseClass{
	
	@Test
	public void User_Negative_Input(){
		
		logger = reports.createTest("Create user negative case");
		
		LoginPageElements loginFunc = new LoginPageElements(driver);
		
		loginFunc.Login_Positive(excel.getStringCellData("Login", 1, 0), excel.getStringCellData("Login", 1, 1));
		
		UserManagementElements user = new UserManagementElements(driver);
		
		try {
			user.newUser_Negative();
			
		} catch (Exception e) {
			
			System.out.println("Error in User negative case: "+e.getMessage());
		}
	}

}
