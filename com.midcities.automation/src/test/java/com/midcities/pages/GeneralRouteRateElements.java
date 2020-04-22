package com.midcities.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.paulhammant.ngwebdriver.ByAngular;

public class GeneralRouteRateElements extends BaseClass {

	WebDriver driver;

	static String pickup = excel.getStringCellData("Rate_Management", 6, 0);
	static String delivery = excel.getStringCellData("Rate_Management", 6, 1);
	static String orderType = excel.getStringCellData("Rate_Management", 6, 2);
	static String rate = excel.getStringCellData("Rate_Management", 6, 3);

	public GeneralRouteRateElements(WebDriver driver) {

		this.driver = driver;
	}

	public void generalRouteRate_Positive() throws InterruptedException {

		// Navigating to General Route rate section //
		Thread.sleep(2000);

		WebElement rateLeftNav = driver
				.findElement(By.xpath("//*[@id=\"sidebar-panel\"]/div/div[1]/div/div/mat-nav-list/mat-list-item[3]"));

		rateLeftNav.click();

		driver.findElement(By.cssSelector("a[href='#/rate/route']")).click();

		Thread.sleep(2000);

		// Clicking on the Create New Equipment button //
		driver.findElement(ByAngular.buttonText("Create New")).click();

		// Passing pickup address
		driver.findElement(By.id("mat-input-9")).sendKeys(pickup);

		driver.findElement(By.xpath("//mat-option/span/span[text()='" + pickup + "']")).click();

		// Passing delivery address
		driver.findElement(By.id("mat-input-11")).sendKeys(delivery);

		driver.findElement(By.xpath("//mat-option/span/span[text()='" + delivery + "']")).click();

		// Selecting Order Type
		driver.findElement(By.cssSelector("mat-select[formcontrolname='order_type']")).click();

		driver.findElement(By.xpath("//mat-option/span[text()='" + orderType + "']")).click();

		// Passing rate
		driver.findElement(By.cssSelector("input[formcontrolname='rate']")).sendKeys(rate);

		// Clicking on create button
		driver.findElement(ByAngular.buttonText("Create")).click();

	}

	public void generalRouteRate_Negative() throws AWTException, InterruptedException {

		Robot robot = new Robot();
		
		// Navigating to General Route rate section //
		Thread.sleep(2000);

		WebElement rateLeftNav = driver
				.findElement(By.xpath("//*[@id=\"sidebar-panel\"]/div/div[1]/div/div/mat-nav-list/mat-list-item[3]"));

		rateLeftNav.click();

		driver.findElement(By.cssSelector("a[href='#/rate/route']")).click();

		Thread.sleep(2000);

		// Clicking on the Create New General Route rate button
		driver.findElement(ByAngular.buttonText("Create New")).click();

		// For visiting each field, so that error message will be displayed //
		for (int i = 0; i <= 10; i++) {

			robot.keyPress(KeyEvent.VK_TAB);

			Thread.sleep(1000);
		}
		
		// Checking if error message is displayed under all the mandatory fields
		String pickupNameError = driver
				.findElement(By.xpath("//input[@id='mat-input-9']/following::mat-error[1]"))
				.getText();
		
		Assert.assertTrue(pickupNameError.contains("Required"), "Issue in pickup name");
		
		String pickupAddressError = driver
				.findElement(By.xpath("//input[@id='mat-input-9']/following::mat-error[2]"))
				.getText();
		
		Assert.assertTrue(pickupAddressError.contains("Required"), "Issue in pickup address");
		
		String deliveryNameError = driver
				.findElement(By.xpath("//input[@id='mat-input-9']/following::mat-error[3]"))
				.getText();
		
		Assert.assertTrue(deliveryNameError.contains("Required"), "Issue in delivery name");
		
		String deliveryAdressError = driver
				.findElement(By.xpath("//input[@id='mat-input-9']/following::mat-error[4]"))
				.getText();
		
		Assert.assertTrue(deliveryAdressError.contains("Required"), "Issue in delivery address");
		
		String orderTypeError = driver
				.findElement(By.xpath("//input[@id='mat-input-9']/following::mat-error[5]"))
				.getText();
		
		Assert.assertTrue(orderTypeError.contains("Required"), "Issue in order type");
		
		String rateError = driver
				.findElement(By.xpath("//input[@id='mat-input-9']/following::mat-error[6]"))
				.getText();
		
		Assert.assertTrue(rateError.contains("Required"), "Issue in rate");
		
		boolean isButtonClickable = driver.findElement(ByAngular.buttonText("Create")).isEnabled();

		Assert.assertFalse(isButtonClickable, "Issue in Create button");

	}

}
