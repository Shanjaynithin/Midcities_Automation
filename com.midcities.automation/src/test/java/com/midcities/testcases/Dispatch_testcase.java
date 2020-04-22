package com.midcities.testcases;

import org.testng.annotations.Test;

import com.midcities.pages.BaseClass;
import com.midcities.pages.DispatchElements;
import com.midcities.pages.LoginPageElements;

public class Dispatch_testcase extends BaseClass{
	
	@Test
	public void dipatchLegs() throws InterruptedException {
		
		logger = reports.createTest("Dispatch test case");

		LoginPageElements loginFunc = new LoginPageElements(driver);

		loginFunc.Login_Positive(excel.getStringCellData("Login", 1, 0), excel.getStringCellData("Login", 1, 1));
		
		DispatchElements dispatch = new DispatchElements(driver);
		
		dispatch.dispatch_legs();
	}

}
