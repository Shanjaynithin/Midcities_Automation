package com.midcities.testcases;

import java.awt.AWTException;

import com.midcities.pages.BaseClass;
import com.midcities.pages.DriverRateElements;
import com.midcities.pages.LoginPageElements;

public class DriverRates_Negative_Case extends BaseClass{
	
	public void driverRatesnegative() throws InterruptedException, AWTException {
		
		logger = reports.createTest("Driver rate negative case");

		LoginPageElements loginFunc = new LoginPageElements(driver);

		loginFunc.Login_Positive(excel.getStringCellData("Login", 1, 0), excel.getStringCellData("Login", 1, 1));
		
		DriverRateElements driverRate = new DriverRateElements(driver);
		
		driverRate.driverRate_negative();
	}

}
