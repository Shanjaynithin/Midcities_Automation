package com.midcities.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.paulhammant.ngwebdriver.ByAngular;

public class ChassisManagementElements extends BaseClass {

	WebDriver driver;

	static String chassisName = excel.getStringCellData("Admin_features", 14, 0);
	static String location = excel.getStringCellData("Admin_features", 14, 1);
	static String email = excel.getStringCellData("Admin_features", 14, 2);
	static String phone = excel.getStringCellData("Admin_features", 14, 3);

	public ChassisManagementElements(WebDriver driver) {

		this.driver = driver;
	}

	public void chassis_positive() throws InterruptedException {

		// Navigating to Chassis section //
		Thread.sleep(2000);

		WebElement leftNav = driver.findElement(By.xpath("*//mat-nav-list/mat-list-item[2]"));

		leftNav.click();

		driver.findElement(By.cssSelector("a[href='#/admin/chassis']")).click();

		Thread.sleep(2000);

		// Clicking on the Create New Chassis button //
		driver.findElement(ByAngular.buttonText("Create New")).click();

		// Passing Chassis values //

		// Passing Chassis name
		driver.findElement(By.cssSelector("input[formcontrolname='chassisName']")).sendKeys(chassisName);

		// Passing location
		driver.findElement(By.xpath("//app-midcities-name-autocomplete[@label='Location Name']//input"))
				.sendKeys(location);

		// Selecting location
		driver.findElement(By.xpath("//mat-option/span/span[text()='" + location + "']")).click();

		// Passing email
		driver.findElement(By.cssSelector("input[formcontrolname='email']")).sendKeys(email);

		// Passing phone number
		driver.findElement(By.cssSelector("input[formcontrolname='phoneNumber']")).sendKeys(phone);

		// Clicking on Save button//
		driver.findElement(ByAngular.buttonText("Create")).click();
		
		Thread.sleep(2000);

		// Searching newly added Chassis
		driver.findElement(By.cssSelector("input[name='chassis_name']")).sendKeys(chassisName);

		Thread.sleep(1000);

		driver.findElement(ByAngular.buttonText("search")).click();

		Thread.sleep(1000);

		// Clicking delete button
		driver.findElement(By.cssSelector("button[class*='mat-red']")).click();

		Thread.sleep(1000);

		driver.findElement(ByAngular.buttonText("Delete")).click();

		driver.findElement(ByAngular.buttonText("close")).click();

	}

	public void chassis_negative() throws InterruptedException, AWTException {

		Robot robot = new Robot();

		// Navigating to Chassis section //
		Thread.sleep(2000);

		WebElement leftNav = driver.findElement(By.xpath("*//mat-nav-list/mat-list-item[2]"));

		leftNav.click();

		driver.findElement(By.cssSelector("a[href='#/admin/chassis']")).click();

		Thread.sleep(2000);

		// Clicking on the Create New Chassis button //
		driver.findElement(ByAngular.buttonText("Create New")).click();

		// For visiting each field, so that error message will be displayed //
		for (int i = 0; i <= 10; i++) {

			robot.keyPress(KeyEvent.VK_TAB);

			Thread.sleep(1000);
		}

		// Checking if error message is displayed under all the mandatory fields //
		String chassisNameError = driver.findElement(By.xpath("//input[@formcontrolname='chassisName']/following::mat-error[1]")).getText();

		Assert.assertTrue(chassisNameError.contains("Required"), "Issue in Chassis name");
		
		String locationNameError = driver.findElement(By.xpath("//input[@formcontrolname='chassisName']/following::mat-error[2]")).getText();

		Assert.assertTrue(locationNameError.contains("Required"), "Issue in Location name");
		
		String addressError = driver.findElement(By.xpath("//input[@formcontrolname='chassisName']/following::mat-error[3]")).getText();

		Assert.assertTrue(addressError.contains("Required"), "Issue in Address");
		
		String emailError = driver.findElement(By.xpath("//input[@formcontrolname='chassisName']/following::mat-error[5]")).getText();

		Assert.assertTrue(emailError.contains("Required"), "Issue in Email");
		
		String phoneNumnerError = driver.findElement(By.xpath("//input[@formcontrolname='chassisName']/following::mat-error[7]")).getText();

		Assert.assertTrue(phoneNumnerError.contains("Required"), "Issue in Phone number");
		
		boolean isButtonClickable = driver.findElement(ByAngular.buttonText("Create")).isEnabled();

		Assert.assertFalse(isButtonClickable, "Issue in Create button");
	}

}
