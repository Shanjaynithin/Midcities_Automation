package com.midcities.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.paulhammant.ngwebdriver.ByAngular;

public class EquipmentManagementElements extends BaseClass {

	WebDriver driver;

	static String equipmentType = excel.getStringCellData("Admin_features", 22, 0);
	static String name = excel.getStringCellData("Admin_features", 22, 1);
	static String make = excel.getStringCellData("Admin_features", 22, 2);
	static String model = excel.getStringCellData("Admin_features", 22, 3);
	static String year = excel.getStringCellData("Admin_features", 22, 4);
	static String VIN = excel.getStringCellData("Admin_features", 22, 5);
	static String license = excel.getStringCellData("Admin_features", 22, 6);
	static String licenseState = excel.getStringCellData("Admin_features", 22, 7);
	static String licenseExpiry = excel.getStringCellData("Admin_features", 22, 8);
	static String location = excel.getStringCellData("Admin_features", 22, 9);
	static String remarks = excel.getStringCellData("Admin_features", 22, 10);

	public EquipmentManagementElements(WebDriver driver) {

		this.driver = driver;
	}

	public void equipment_positive() throws InterruptedException {

		// Navigating to Equipment section //
		Thread.sleep(2000);

		WebElement leftNav = driver.findElement(By.xpath("*//mat-nav-list/mat-list-item[2]"));

		leftNav.click();

		driver.findElement(By.cssSelector("a[href='#/admin/equipment']")).click();

		Thread.sleep(2000);

		// Clicking on the Create New Equipment button //
		driver.findElement(ByAngular.buttonText("Create New")).click();

		// Passing Equipment values //

		// Selecting Equipment Type
		driver.findElement(By.cssSelector("mat-select[formcontrolname='equipmentType']")).click();

		String equipment = " " + equipmentType + " ";

		driver.findElement(By.xpath("//mat-option/span[text()='" + equipment + "']")).click();

		// Passing Equipment name
		driver.findElement(By.cssSelector("input[formcontrolname='equipmentName']")).sendKeys(name);

		// Passing Make name
		driver.findElement(By.cssSelector("input[formcontrolname='makeName']")).sendKeys(make);

		// Passing Model name
		driver.findElement(By.cssSelector("input[formcontrolname='modelName']")).sendKeys(model);

		// Passing Year
		driver.findElement(By.cssSelector("mat-select[formcontrolname='chosenYear']")).click();

		driver.findElement(By.xpath("//mat-option/span[text()='" + year + "']")).click();

		// Passing Model name
		driver.findElement(By.cssSelector("input[formcontrolname='VIN']")).sendKeys(VIN);

		// Passing License number
		driver.findElement(By.cssSelector("input[formcontrolname='license']")).sendKeys(license);

		// Passing License State
		driver.findElement(By.cssSelector("input[formcontrolname='licenseState']")).sendKeys(licenseState);

		// Passing License Expiry
		driver.findElement(By.cssSelector("input[formcontrolname='licenseExpiry']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(
				"//*[@id=\"owl-dt-picker-0\"]/div[2]/owl-date-time-calendar/div[2]/owl-date-time-month-view/table/tbody/tr[5]/td[5]"))
				.click();
		//*[@id="owl-dt-picker-0"]/div[2]/owl-date-time-calendar/div[2]/owl-date-time-month-view/table/tbody/tr[5]/td[5]/span
		
		Thread.sleep(2000);
		
		// Selecting location
		String loc = " " + location + " ";

		driver.findElement(By.cssSelector("mat-select[formcontrolname='location']")).click();

		driver.findElement(By.xpath("//mat-option/span[text()='" + loc + "']")).click();

		// Passing remarks
		driver.findElement(By.cssSelector("input[formcontrolname='remarks']")).sendKeys(remarks);

		// Clicking on Save button
		driver.findElement(ByAngular.buttonText("Create")).click();

	}

	public void equipment_negative() throws AWTException, InterruptedException {

		Robot robot = new Robot();

		// Navigating to equipment section //
		Thread.sleep(2000);

		WebElement leftNav = driver.findElement(By.xpath("*//mat-nav-list/mat-list-item[2]"));

		leftNav.click();

		driver.findElement(By.cssSelector("a[href='#/admin/equipment']")).click();

		Thread.sleep(2000);

		// Clicking on the Create New equipment button //
		driver.findElement(ByAngular.buttonText("Create New")).click();

		// For visiting each field, so that error message will be displayed //
		for (int i = 0; i <= 12; i++) {

			robot.keyPress(KeyEvent.VK_TAB);

			Thread.sleep(1000);
		}

		// Checking if error message is displayed under all the mandatory fields
		String EquipmentTypeError = driver
				.findElement(By.xpath("//mat-select[@formcontrolname='equipmentType']/following::mat-error[1]"))
				.getText();

		Assert.assertTrue(EquipmentTypeError.contains("Required"), "Issue in Equipment type");

		String EquipmentNameError = driver
				.findElement(By.xpath("//mat-select[@formcontrolname='equipmentType']/following::mat-error[2]"))
				.getText();

		Assert.assertTrue(EquipmentNameError.contains("Required"), "Issue in Equipment name");

		String EquipmentMakeError = driver
				.findElement(By.xpath("//mat-select[@formcontrolname='equipmentType']/following::mat-error[3]"))
				.getText();

		Assert.assertTrue(EquipmentMakeError.contains("Required"), "Issue in Equipment Make");

		String modelError = driver
				.findElement(By.xpath("//mat-select[@formcontrolname='equipmentType']/following::mat-error[4]"))
				.getText();

		Assert.assertTrue(modelError.contains("Required"), "Issue in Model");

		String yearError = driver
				.findElement(By.xpath("//mat-select[@formcontrolname='equipmentType']/following::mat-error[5]"))
				.getText();

		Assert.assertTrue(yearError.contains("Required"), "Issue in Year");

		String VINError = driver
				.findElement(By.xpath("//mat-select[@formcontrolname='equipmentType']/following::mat-error[6]"))
				.getText();

		Assert.assertTrue(VINError.contains("Required"), "Issue in VIN");

		String licenseError = driver
				.findElement(By.xpath("//mat-select[@formcontrolname='equipmentType']/following::mat-error[7]"))
				.getText();

		Assert.assertTrue(licenseError.contains("Required"), "Issue in license");

		String licenseStateError = driver
				.findElement(By.xpath("//mat-select[@formcontrolname='equipmentType']/following::mat-error[8]"))
				.getText();

		Assert.assertTrue(licenseStateError.contains("Required"), "Issue in license state");

		String licenseExpiryError = driver
				.findElement(By.xpath("//mat-select[@formcontrolname='equipmentType']/following::mat-error[9]"))
				.getText();

		Assert.assertTrue(licenseExpiryError.contains("Required"), "Issue in license expiry");

		String locationError = driver
				.findElement(By.xpath("//mat-select[@formcontrolname='equipmentType']/following::mat-error[10]"))
				.getText();

		Assert.assertTrue(locationError.contains("Required"), "Issue in location");

		String remarksError = driver
				.findElement(By.xpath("//mat-select[@formcontrolname='equipmentType']/following::mat-error[11]"))
				.getText();

		Assert.assertTrue(remarksError.contains("Required"), "Issue in remarks");

		boolean isButtonClickable = driver.findElement(ByAngular.buttonText("Create")).isEnabled();

		Assert.assertFalse(isButtonClickable, "Issue in Create button");

	}

}
