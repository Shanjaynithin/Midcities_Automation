package com.midcities.testcases;

import org.testng.annotations.Test;

import com.midcities.pages.BaseClass;
import com.midcities.pages.GeneralRouteRateElements;
import com.midcities.pages.LoginPageElements;

public class GeneralRouteRates_Positive_Cases extends BaseClass {

	@Test
	public void GeneralratesPositive() throws InterruptedException {

		logger = reports.createTest("General route rate positive case");

		LoginPageElements loginFunc = new LoginPageElements(driver);

		loginFunc.Login_Positive(excel.getStringCellData("Login", 1, 0), excel.getStringCellData("Login", 1, 1));
		
		GeneralRouteRateElements grr = new GeneralRouteRateElements(driver);
		
		grr.generalRouteRate_Positive();
	}

}
