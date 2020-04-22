package com.midcities.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.paulhammant.ngwebdriver.ByAngular;

public class DriverRateElements extends BaseClass {

	WebDriver driver;

	static String legType = excel.getStringCellData("Rate_Management", 2, 0);
	static String driverType = excel.getStringCellData("Rate_Management", 2, 1);
	static String ratePerMile = excel.getStringCellData("Rate_Management", 2, 2);
	
	public DriverRateElements(WebDriver driver) {

		this.driver = driver;
	}

	public void driverRate_Positive() throws InterruptedException {

		// Navigating to General Route rate section //
		Thread.sleep(2000);

		WebElement rateLeftNav = driver
				.findElement(By.xpath("//*[@id=\"sidebar-panel\"]/div/div[1]/div/div/mat-nav-list/mat-list-item[3]"));

		rateLeftNav.click();

		driver.findElement(By.cssSelector("a[href='#/rate/driverrates']")).click();

		Thread.sleep(2000);

		// Clicking on the Create New Equipment button //
		driver.findElement(ByAngular.buttonText("Create New")).click();

		// Selecting Leg Type
		driver.findElement(By.name("leg_type_id")).click();

		driver.findElement(By.xpath("//mat-option/span[text()='" + legType + "']")).click();

		// Selecting Driver Type
		String drivers = driverType + " ";

		driver.findElement(By.name("driver_type_id")).click();

		driver.findElement(By.xpath("//mat-option/span[text()='" + drivers + "']")).click();

		// Passing Rate per mile
		driver.findElement(By.name("rate_per_mile")).sendKeys(ratePerMile);

		// Clicking on Save button
		driver.findElement(ByAngular.buttonText("Create")).click();
	}

	public void driverRate_negative() throws InterruptedException, AWTException {
		
		Robot robot = new Robot();

		// Navigating to General Route rate section //
		Thread.sleep(2000);

		WebElement rateLeftNav = driver
				.findElement(By.xpath("//*[@id=\"sidebar-panel\"]/div/div[1]/div/div/mat-nav-list/mat-list-item[3]"));

		rateLeftNav.click();

		driver.findElement(By.cssSelector("a[href='#/rate/route']")).click();

		Thread.sleep(2000);

		// Clicking on the Add driver rate button //
		driver.findElement(ByAngular.buttonText("Create New")).click();

		// For visiting each field, so that error message will be displayed //
		for (int i = 0; i <= 4; i++) {

			robot.keyPress(KeyEvent.VK_TAB);

			Thread.sleep(1000);
		}
		
		// Checking if error message is displayed under all the mandatory fields
		String LegTypeError = driver
				.findElement(By.xpath("//mat-select[@name='leg_type_id']/following::mat-error[2]"))
				.getText();
		
		Assert.assertTrue(LegTypeError.contains("required"), "Issue in Leg type");
		
		String DriverTypeError = driver
				.findElement(By.xpath("//mat-select[@name='leg_type_id']/following::mat-error[4]"))
				.getText();
		
		Assert.assertTrue(DriverTypeError.contains("required"), "Issue in Driver type");
		
		String RateError = driver
				.findElement(By.xpath("//mat-select[@name='leg_type_id']/following::mat-error[6]"))
				.getText();
		
		Assert.assertTrue(RateError.contains("required"), "Issue in Rate Per Mile");
		
		boolean isButtonClickable = driver.findElement(ByAngular.buttonText("Create")).isEnabled();

		Assert.assertFalse(isButtonClickable, "Issue in Create button");

	}

}
