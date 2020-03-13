package com.midcities.testcases;

import org.testng.annotations.Test;

import com.midcities.pages.BaseClass;
import com.midcities.pages.LocationManagementElements;
import com.midcities.pages.LoginPageElements;

public class Location_Positive_Case extends BaseClass{
	
	@Test
	public void locationPositive() throws InterruptedException {
		
		logger = reports.createTest("Add location positive case");
		
		LoginPageElements loginFunc = new LoginPageElements(driver);

		loginFunc.Login_Positive(excel.getStringCellData("Login", 1, 0), excel.getStringCellData("Login", 1, 1));
		
		LocationManagementElements location = new LocationManagementElements(driver);
		
		location.location_positive();
	}

}
