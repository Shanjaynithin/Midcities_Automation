package com.midcities.testcases;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.midcities.pages.BaseClass;
import com.midcities.pages.LoginPageElements;
import com.midcities.pages.OrderManagementElements;

public class Orders_Negative_Case extends BaseClass{
	
	@Test
	public void ordersNegative() throws AWTException, InterruptedException {
		
		logger = reports.createTest("Create order positive case");

		LoginPageElements loginFunc = new LoginPageElements(driver);

		loginFunc.Login_Positive(excel.getStringCellData("Login", 1, 0), excel.getStringCellData("Login", 1, 1));
		
		OrderManagementElements order = new OrderManagementElements(driver);
		
		order.order_Negative();
		
	}

}
