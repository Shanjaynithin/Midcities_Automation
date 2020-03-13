package com.midcities.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.paulhammant.ngwebdriver.ByAngular;

public class CustomerManagementElements extends BaseClass {

	WebDriver driver;

	static String businessName = excel.getStringCellData("Admin_Features", 6, 0);
	static String poc = excel.getStringCellData("Admin_Features", 6, 1);
	static String pocPhone = excel.getStringCellData("Admin_Features", 6, 2);
	static String businessPhone = excel.getStringCellData("Admin_Features", 6, 3);
	static String customerEmail = excel.getStringCellData("Admin_Features", 6, 4);
	static String faxNumber = excel.getStringCellData("Admin_Features", 6, 5);
	static String modeOfContact = excel.getStringCellData("Admin_Features", 6, 6);
	static String customerAddress = excel.getStringCellData("Admin_Features", 6, 7);
	static String customerNotes = excel.getStringCellData("Admin_Features", 6, 8);

	public CustomerManagementElements(WebDriver driver) {

		this.driver = driver;
	}

	public void customer_Positive() throws InterruptedException {

		// Navigating to Customer section
		Thread.sleep(2000);

		WebElement leftNav = driver.findElement(By.xpath("*//mat-nav-list/mat-list-item[2]"));

		leftNav.click();

		driver.findElement(By.cssSelector("a[href='#/admin/customer']")).click();

		Thread.sleep(2000);

		// Clicking on the Create New Customer button
		driver.findElement(ByAngular.buttonText("Create New")).click();

		// Passing customer values
		driver.findElement(By.cssSelector("input[formcontrolname='businessName']")).sendKeys(businessName);

		driver.findElement(By.cssSelector("input[formcontrolname='pointOfContact']")).sendKeys(poc);

		driver.findElement(By.cssSelector("input[formcontrolname='pocPhone']")).sendKeys(pocPhone);

		driver.findElement(By.cssSelector("input[formcontrolname='businessPhone']")).sendKeys(businessPhone);

		driver.findElement(By.cssSelector("input[formcontrolname='email']")).sendKeys(customerEmail);

		driver.findElement(By.cssSelector("input[formcontrolname='fax']")).sendKeys(faxNumber);

		driver.findElement(By.cssSelector("mat-radio-button[value='" + modeOfContact + "']")).click();

		// Adding Address
		driver.findElement(By.id("mat-input-23")).sendKeys(customerAddress);

		driver.findElement(By.xpath("//mat-option/span/span[text()='" + customerAddress + "']")).click();

		// Physical Address same as Physical Address
		driver.findElement(By.cssSelector("mat-checkbox[formcontrolname='isSameAddress']")).click();

		driver.findElement(By.cssSelector("input[formcontrolname='customerNotes']")).sendKeys(customerNotes);

		// Clicking on create button
		driver.findElement(ByAngular.buttonText("Create")).click();

		// Searching and deleting the Customer
		driver.findElement(By.cssSelector("input[name='business_name']")).sendKeys(businessName);

		Thread.sleep(1000);

		driver.findElement(ByAngular.buttonText("search")).click();

		Thread.sleep(1000);

		driver.findElement(By.cssSelector("button[class*='mat-red']")).click();

		Thread.sleep(1000);

		driver.findElement(ByAngular.buttonText("Yes")).click();

		driver.findElement(ByAngular.buttonText("close")).click();
	}

	public void negative_Customer() throws InterruptedException, AWTException {

		Robot robot = new Robot();

		// Navigating to Customer section //
		Thread.sleep(2000);

		WebElement leftNav = driver.findElement(By.xpath("*//mat-nav-list/mat-list-item[2]"));

		leftNav.click();

		driver.findElement(By.cssSelector("a[href='#/admin/customer']")).click();

		Thread.sleep(2000);

		// Clicking on the Create New Customer button
		driver.findElement(ByAngular.buttonText("Create New")).click();

		// For visiting each field, so that error message will be displayed //
		for (int i = 0; i <= 10; i++) {

			robot.keyPress(KeyEvent.VK_TAB);

			Thread.sleep(1000);
		}

		// Checking if error message is displayed under all the mandatory fields //
		String businessNameError = driver.findElement(By.id("mat-error-3")).getText();
		
		Assert.assertTrue(businessNameError.contains("required"), "Issue in Business name");
		
		String businessEmailError = driver.findElement(By.id("mat-error-5")).getText();
		
		Assert.assertTrue(businessEmailError.contains("Required"), "Issue in Business email");
		
		boolean isButtonClickable = driver.findElement(ByAngular.buttonText("Create")).isEnabled();
		
		Assert.assertFalse(isButtonClickable,"Issue in Create button");
		

	}

}
