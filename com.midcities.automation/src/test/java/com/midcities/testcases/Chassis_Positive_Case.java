package com.midcities.testcases;

import org.testng.annotations.Test;

import com.midcities.pages.BaseClass;
import com.midcities.pages.ChassisManagementElements;
import com.midcities.pages.LoginPageElements;

public class Chassis_Positive_Case extends BaseClass {
	
	@Test
	public void chassisPositive() throws InterruptedException{
		
		logger = reports.createTest("Create Chassis positive case");
		
		LoginPageElements loginFunc = new LoginPageElements(driver);

		loginFunc.Login_Positive(excel.getStringCellData("Login", 1, 0), excel.getStringCellData("Login", 1, 1));
		
		ChassisManagementElements chassis = new ChassisManagementElements(driver);
		
		chassis.chassis_positive();
	}

}
