package com.midcities.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.paulhammant.ngwebdriver.ByAngular;

public class LocationManagementElements extends BaseClass {

	WebDriver driver;
	static Robot robot;

	static String locationType = excel.getStringCellData("Admin_features", 10, 0);
	static String locationName = excel.getStringCellData("Admin_features", 10, 1);
	static String address = excel.getStringCellData("Admin_features", 10, 2);
	static String phoneNumber = excel.getStringCellData("Admin_features", 10, 3);

	public LocationManagementElements(WebDriver driver) {

		this.driver = driver;
	}

	public void location_positive() throws InterruptedException {

		// Navigating to Location section //
		Thread.sleep(2000);

		WebElement leftNav = driver.findElement(By.xpath("*//mat-nav-list/mat-list-item[2]"));

		leftNav.click();

		driver.findElement(By.cssSelector("a[href='#/admin/location']")).click();

		Thread.sleep(2000);

		// Clicking on the Create New Location button //
		driver.findElement(ByAngular.buttonText("Create New")).click();

		// Passing Location values //

		// Selecting location type from the drop-down
		driver.findElement(By.cssSelector("mat-select[formcontrolname='locationType']")).click();

		switch (locationType) {

		case "Railss":
			driver.findElement(By.xpath("//mat-option//span[contains(text(),'Railss')]")).click();
			break;
		case "Chassis Depots":
			driver.findElement(By.xpath("//mat-option//span[contains(text(),'Chassis Depots')]")).click();
			break;
		case "Home Yard":
			driver.findElement(By.xpath("//mat-option//span[contains(text(),'Home Yard')]")).click();
			break;
		case "Consignor/Consignee":
			driver.findElement(By.xpath("//mat-option//span[contains(text(),'Consignor/Consignee')]")).click();
			break;
		case "Repair":
			driver.findElement(By.xpath("//mat-option//span[contains(text(),'Repair')]")).click();
			break;
		case "Container Depot":
			driver.findElement(By.xpath("//mat-option//span[contains(text(),'Container Depot')]")).click();
			break;
		case "SteamShip":
			driver.findElement(By.xpath("//mat-option//span[contains(text(),'SteamShip')]")).click();
			break;
		case "Hub":
			driver.findElement(By.xpath("//mat-option//span[contains(text(),'Hub')]")).click();
			break;
		case "Rail yard":
			driver.findElement(By.xpath("//mat-option//span[contains(text(),'Rail yard')]")).click();
			break;
		default:
			System.out.println("Could not find the location type option");
		}

		// Passing Location name //
		driver.findElement(By.cssSelector("input[formcontrolname='locationName']")).sendKeys(locationName);

		// Passing Address//
		driver.findElement(By.xpath("//app-bing-autocomplete//div[@class='mat-form-field-infix']//input[@role='combobox']")).sendKeys(address);

		driver.findElement(By.xpath("//div//div//mat-option//span//span")).click();
		
		//driver.findElement(By.xpath("//div//div//mat-option//span//span[contains(text(),'Test Farm Rd')]")).click();

		// Passing PhoneNumber//
		driver.findElement(By.cssSelector("input[formcontrolname='phoneNumber']")).sendKeys(phoneNumber);

		// Clicking on Save button//
		driver.findElement(ByAngular.buttonText("Create")).click();

		Thread.sleep(1000);

		// Deleting the newly added location//
		driver.findElement(By.id("mat-input-4")).sendKeys(locationName);

		Thread.sleep(1000);

		driver.findElement(ByAngular.buttonText("search")).click();

		Thread.sleep(1000);

		driver.findElement(By.cssSelector("button[class*='mat-red']")).click();

		Thread.sleep(1000);

		driver.findElement(ByAngular.buttonText("Delete")).click();

		driver.findElement(ByAngular.buttonText("close")).click();
	}

	public void location_negative() throws InterruptedException, AWTException {

		robot = new Robot();

		// Navigating to Location section //
		Thread.sleep(2000);

		WebElement leftNav = driver.findElement(By.xpath("*//mat-nav-list/mat-list-item[2]"));

		leftNav.click();

		driver.findElement(By.cssSelector("a[href='#/admin/location']")).click();

		Thread.sleep(2000);

		// Clicking on the Create New Location button //
		driver.findElement(ByAngular.buttonText("Create New")).click();

		// For visiting each field, so that error message will be displayed //
		for (int i = 0; i <= 8; i++) {

			robot.keyPress(KeyEvent.VK_TAB);

			Thread.sleep(1000);
		}

		// Checking if error message is displayed under all the mandatory fields //
		String locationTypeError = driver.findElement(By.xpath("//mat-select[@formcontrolname='locationType']/following::mat-error[1]")).getText();

		Assert.assertTrue(locationTypeError.contains("Required"), "Issue in Location type");

		String locationNameError = driver.findElement(By.xpath("//mat-select[@formcontrolname='locationType']/following::mat-error[2]")).getText();

		Assert.assertTrue(locationNameError.contains("Required"), "Issue in Location name");

		String addressError = driver.findElement(By.xpath("//mat-select[@formcontrolname='locationType']/following::mat-error[3]")).getText();

		Assert.assertTrue(addressError.contains("Required"), "Issue in Address");

		String phoneNumberError = driver.findElement(By.xpath("//mat-select[@formcontrolname='locationType']/following::mat-error[4]")).getText();

		Assert.assertTrue(phoneNumberError.contains("Required"), "Issue in Phone number");

		boolean isButtonClickable = driver.findElement(ByAngular.buttonText("Create")).isEnabled();

		Assert.assertFalse(isButtonClickable, "Issue in Create button");

	}

}