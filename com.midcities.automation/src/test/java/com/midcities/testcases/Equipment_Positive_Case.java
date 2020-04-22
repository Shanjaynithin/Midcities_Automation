package com.midcities.testcases;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.midcities.pages.BaseClass;
import com.midcities.pages.EquipmentManagementElements;
import com.midcities.pages.LoginPageElements;

public class Equipment_Positive_Case extends BaseClass{
		
		@Test
		public void equipmentPositive() throws AWTException, InterruptedException {
		
		logger = reports.createTest("Create equipment positive case");
		
		LoginPageElements loginFunc = new LoginPageElements(driver);

		loginFunc.Login_Positive(excel.getStringCellData("Login", 1, 0), excel.getStringCellData("Login", 1, 1));
		
		EquipmentManagementElements equip = new EquipmentManagementElements(driver);
		
		equip.equipment_positive();
		
		}

}
