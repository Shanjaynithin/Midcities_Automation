package com.midcities.testcases;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.midcities.pages.BaseClass;
import com.midcities.pages.GeneralRouteRateElements;
import com.midcities.pages.LoginPageElements;

public class GeneralRouteRate_Negative_Case extends BaseClass{
	
	@Test
	public void GeneralratesNegative() throws InterruptedException, AWTException {

		logger = reports.createTest("General route rate negativee case");

		LoginPageElements loginFunc = new LoginPageElements(driver);

		loginFunc.Login_Positive(excel.getStringCellData("Login", 1, 0), excel.getStringCellData("Login", 1, 1));
		
		GeneralRouteRateElements grr = new GeneralRouteRateElements(driver);
		
		grr.generalRouteRate_Negative();
	}

}
