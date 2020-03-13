package com.midcities.testcases;

import org.testng.annotations.Test;

import com.midcities.pages.BaseClass;
import com.midcities.pages.CustomerManagementElements;
import com.midcities.pages.LoginPageElements;

public class Customer_Positive_Case extends BaseClass {

	@Test
	public void CustomerPositiveCase() throws InterruptedException {

		logger = reports.createTest("Create customer positive case");

		LoginPageElements loginFunc = new LoginPageElements(driver);

		loginFunc.Login_Positive(excel.getStringCellData("Login", 1, 0), excel.getStringCellData("Login", 1, 1));
		
		CustomerManagementElements custManagement = new CustomerManagementElements(driver);
		
		custManagement.customer_Positive();
	}

}
