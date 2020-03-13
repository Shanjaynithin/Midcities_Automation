package com.midcities.testcases;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.midcities.pages.BaseClass;
import com.midcities.pages.CustomerManagementElements;
import com.midcities.pages.LoginPageElements;

public class Customer_Negative_Case extends BaseClass{
	
	@Test
	public void CustomerNegativeCase() throws InterruptedException, AWTException {
		
		logger = reports.createTest("Create customer negative case");
		
		LoginPageElements loginFunc = new LoginPageElements(driver);

		loginFunc.Login_Positive(excel.getStringCellData("Login", 1, 0), excel.getStringCellData("Login", 1, 1));
		
		CustomerManagementElements custManagement = new CustomerManagementElements(driver);
		
		custManagement.negative_Customer();
		
	}

}
