package com.midcities.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.paulhammant.ngwebdriver.ByAngular;

public class AccessorialChargesElements extends BaseClass {

	WebDriver driver;

	static String accessorialName = excel.getStringCellData("Rate_Management", 10, 0);
	static String intervalValue = excel.getStringCellData("Rate_Management", 10, 1);
	static String interval = excel.getStringCellData("Rate_Management", 10, 2);
	static String description = excel.getStringCellData("Rate_Management", 10, 3);
	static String rate = excel.getStringCellData("Rate_Management", 10, 4);

	public AccessorialChargesElements(WebDriver driver) {

		this.driver = driver;
	}

	public void accessorialCharges_Positive() throws InterruptedException {

		// Navigating to General Route rate section //
		Thread.sleep(2000);

		WebElement rateLeftNav = driver
				.findElement(By.xpath("//*[@id=\"sidebar-panel\"]/div/div[1]/div/div/mat-nav-list/mat-list-item[3]"));

		rateLeftNav.click();

		driver.findElement(By.cssSelector("a[href='#/rate/accessorial']")).click();

		Thread.sleep(2000);

		// Clicking on the Create New Equipment button //
		driver.findElement(ByAngular.buttonText("Create New")).click();

		// Passing accessorial name
		driver.findElement(
				By.xpath("//mat-radio-button//div[@class='mat-radio-label-content'][text()='New Accessorial Charge']"))
				.click();

		driver.findElement(By.name("accessories_name")).sendKeys(accessorialName);

		// Passing interval value
		driver.findElement(By.name("accessories_value")).sendKeys(intervalValue);

		// Selecting interval
		driver.findElement(By.name("accessories_interval")).click();
		
		Thread.sleep(1000);

		driver.findElement(By.xpath("//mat-option/span[text()='" + interval + "']")).click();

		// Passing description
		driver.findElement(By.name("description")).sendKeys(description);

		// Passing rate
		driver.findElement(By.name("rate")).sendKeys(rate);

		// Clicking on create button
		driver.findElement(ByAngular.buttonText("Create")).click();

	}

	public void accessorialCharges_Negative() throws InterruptedException, AWTException {

		Robot robot = new Robot();

		// Navigating to General Route rate section //
		Thread.sleep(2000);

		WebElement rateLeftNav = driver
				.findElement(By.xpath("//*[@id=\"sidebar-panel\"]/div/div[1]/div/div/mat-nav-list/mat-list-item[3]"));

		rateLeftNav.click();

		driver.findElement(By.cssSelector("a[href='#/rate/accessorial']")).click();

		Thread.sleep(2000);

		// Clicking on the Create New Equipment button //
		driver.findElement(ByAngular.buttonText("Create New")).click();

		// For visiting each field, so that error message will be displayed //
		for (int i = 0; i <= 7; i++) {

			robot.keyPress(KeyEvent.VK_TAB);

			Thread.sleep(1000);
		}
		
		// Checking if error message is displayed under all the mandatory fields
		String AccessoriesNameError = driver
				.findElement(By.xpath("//mat-select[@name='accessories_name']/following::mat-error[2]"))
				.getText();
		
		Assert.assertTrue(AccessoriesNameError.contains("required"), "Issue in Accessories name");
		
		String intervalValueError = driver
				.findElement(By.xpath("//mat-select[@name='accessories_name']/following::mat-error[3]"))
				.getText();
		
		Assert.assertTrue(intervalValueError.contains("required"), "Issue in Interval value");
		
		String intervalError = driver
				.findElement(By.xpath("//mat-select[@name='accessories_name']/following::mat-error[5]"))
				.getText();
		
		Assert.assertTrue(intervalError.contains("required"), "Issue in Interval");
		
		String descError = driver
				.findElement(By.xpath("//mat-select[@name='accessories_name']/following::mat-error[7]"))
				.getText();
		
		Assert.assertTrue(descError.contains("required"), "Issue in description");
		
		String rateError = driver
				.findElement(By.xpath("//mat-select[@name='accessories_name']/following::mat-error[8]"))
				.getText();
		
		Assert.assertTrue(rateError.contains("required"), "Issue in rate");
		
		boolean isButtonClickable = driver.findElement(ByAngular.buttonText("Create")).isEnabled();

		Assert.assertFalse(isButtonClickable, "Issue in Create button");
		

	}

}
