package com.midcities.testcases;

import org.testng.annotations.Test;

import com.midcities.pages.AccessorialChargesElements;
import com.midcities.pages.BaseClass;
import com.midcities.pages.LoginPageElements;

public class AccessorialCharges_Positive_Case extends BaseClass {
	
	@Test
	public void accessorialPositive() throws InterruptedException {
		
		logger = reports.createTest("Accessorial charge positive case");

		LoginPageElements loginFunc = new LoginPageElements(driver);

		loginFunc.Login_Positive(excel.getStringCellData("Login", 1, 0), excel.getStringCellData("Login", 1, 1));
		
		AccessorialChargesElements accessorial = new AccessorialChargesElements(driver);
		
		accessorial.accessorialCharges_Positive();
	
	}

}
