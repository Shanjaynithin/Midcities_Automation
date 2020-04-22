package com.midcities.testcases;

import org.testng.annotations.Test;

import com.midcities.pages.BaseClass;
import com.midcities.pages.InvoiceManagementElements;
import com.midcities.pages.LoginPageElements;

public class Invoice_Testcase extends BaseClass{
	
	@Test
	public void invoiceTestcase() throws InterruptedException {
		
		logger = reports.createTest("General route rate positive case");

		LoginPageElements loginFunc = new LoginPageElements(driver);

		loginFunc.Login_Positive(excel.getStringCellData("Login", 1, 0), excel.getStringCellData("Login", 1, 1));
		
		InvoiceManagementElements invoice = new InvoiceManagementElements(driver);
		
		invoice.invoice_testcase();
	}

}
