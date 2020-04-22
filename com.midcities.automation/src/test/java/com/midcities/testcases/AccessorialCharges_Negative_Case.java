package com.midcities.testcases;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.midcities.pages.AccessorialChargesElements;
import com.midcities.pages.BaseClass;
import com.midcities.pages.LoginPageElements;

public class AccessorialCharges_Negative_Case extends BaseClass{
	
	@Test
	public void accessorialNegative() throws InterruptedException, AWTException {
		
		logger = reports.createTest("Accessorial charge negative case");

		LoginPageElements loginFunc = new LoginPageElements(driver);

		loginFunc.Login_Positive(excel.getStringCellData("Login", 1, 0), excel.getStringCellData("Login", 1, 1));
		
		AccessorialChargesElements accessorial = new AccessorialChargesElements(driver);
		
		accessorial.accessorialCharges_Negative();
	}

}
