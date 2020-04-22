package com.midcities.testcases;

import org.testng.annotations.Test;

import com.midcities.pages.BaseClass;
import com.midcities.pages.DriverRateElements;
import com.midcities.pages.LoginPageElements;

public class DriverRates_Positive_Case extends BaseClass {

	@Test
	public void driverRatesPositive() throws InterruptedException {

		logger = reports.createTest("Driver rate positive case");

		LoginPageElements loginFunc = new LoginPageElements(driver);

		loginFunc.Login_Positive(excel.getStringCellData("Login", 1, 0), excel.getStringCellData("Login", 1, 1));
		
		DriverRateElements driverRate = new DriverRateElements(driver);
		
		driverRate.driverRate_Positive();

	}

}
