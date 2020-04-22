package com.midcities.testcases;

import org.testng.annotations.Test;

import com.midcities.pages.BaseClass;
import com.midcities.pages.ContainerManagementElements;
import com.midcities.pages.LoginPageElements;

public class Container_Positive_Case extends BaseClass {

	@Test
	public void containerPositive() throws InterruptedException {
		
		logger = reports.createTest("Create Container positive case");

		LoginPageElements loginFunc = new LoginPageElements(driver);

		loginFunc.Login_Positive(excel.getStringCellData("Login", 1, 0), excel.getStringCellData("Login", 1, 1));
		
		ContainerManagementElements container = new ContainerManagementElements(driver);
		
		container.container_positive();

	}

}
