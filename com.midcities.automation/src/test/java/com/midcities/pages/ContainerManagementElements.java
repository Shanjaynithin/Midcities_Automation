package com.midcities.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.paulhammant.ngwebdriver.ByAngular;

public class ContainerManagementElements extends BaseClass {

	WebDriver driver;
	static Robot robot;

	static String containerName = excel.getStringCellData("Admin_features", 18, 0);
	static String LocationName = excel.getStringCellData("Admin_features", 18, 1);
	static String email = excel.getStringCellData("Admin_features", 18, 2);
	static String phoneNumber = excel.getStringCellData("Admin_features", 18, 3);
	static String PCR = excel.getStringCellData("Admin_features", 18, 4);
	static String hireDehireLocation = excel.getStringCellData("Admin_features", 18, 5);

	public ContainerManagementElements(WebDriver driver) {

		this.driver = driver;
	}

	public void container_positive() throws InterruptedException {

		// Navigating to container section //
		Thread.sleep(2000);

		WebElement leftNav = driver.findElement(By.xpath("*//mat-nav-list/mat-list-item[2]"));

		leftNav.click();

		driver.findElement(By.cssSelector("a[href='#/admin/container']")).click();

		Thread.sleep(2000);

		// Clicking on the Create New Container button //
		driver.findElement(ByAngular.buttonText("Create New")).click();

		// Passing Container values //

		// Passing Container name
		driver.findElement(By.cssSelector("input[formcontrolname='containerName']")).sendKeys(containerName);

		// Passing location
		driver.findElement(By.xpath("//app-midcities-name-autocomplete[@label='Location Name']//input"))
				.sendKeys(LocationName);

		// Selecting location
		driver.findElement(By.xpath("//mat-option/span/span[text()='" + LocationName + "']")).click();

		// Passing email
		driver.findElement(By.cssSelector("input[formcontrolname='email']")).sendKeys(email);

		// Passing phone number
		driver.findElement(By.cssSelector("input[formcontrolname='phoneNumber']")).sendKeys(phoneNumber);

		// Opening Preferred Chassis Rental drop-down
		driver.findElement(By.cssSelector("mat-select[formcontrolname='preferredChassisRental']")).click();

		// Selecting a Chassis Rental option
		driver.findElement(By.xpath("//span[@class='mat-option-text'][text()='" + PCR + "']")).click();
		
		Thread.sleep(2000);

		// Passing Hire/Dehire location
		//driver.findElement(By.xpath("//div[@class='cdk-overlay-backdrop cdk-overlay-transparent-backdrop cdk-overlay-backdrop-showing']")).click();

		driver.findElement(By.xpath("//app-midcities-name-autocomplete[@label='Hire/Dehire Name']//input"))
				.sendKeys(hireDehireLocation);
	
		// Selecting Hire/Dehire location
		driver.findElement(By.xpath("//mat-option/span/span[text()='" + hireDehireLocation + "']")).click();

		// Clicking on Save button
		driver.findElement(ByAngular.buttonText("Create")).click();

		// Searching for Container name
		driver.findElement(By.name("container_name")).sendKeys(containerName);

		Thread.sleep(1000);

		driver.findElement(ByAngular.buttonText("search")).click();

		Thread.sleep(1000);

		// Clicking delete button
		driver.findElement(By.cssSelector("button[class*='mat-red']")).click();

		Thread.sleep(1000);

		driver.findElement(ByAngular.buttonText("Delete")).click();

		driver.findElement(ByAngular.buttonText("close")).click();
	}

	public void container_negative() throws AWTException, InterruptedException {

		robot = new Robot();

		// Navigating to Container section //
		Thread.sleep(2000);

		WebElement leftNav = driver.findElement(By.xpath("*//mat-nav-list/mat-list-item[2]"));

		leftNav.click();

		driver.findElement(By.cssSelector("a[href='#/admin/container']")).click();

		Thread.sleep(2000);

		// Clicking on the Create New Container button //
		driver.findElement(ByAngular.buttonText("Create New")).click();

		// For visiting each field, so that error message will be displayed //
		for (int i = 0; i <= 15; i++) {

			robot.keyPress(KeyEvent.VK_TAB);

			Thread.sleep(1000);
		}

		// Checking if error message is displayed under all the mandatory fields //

		String containerNameError = driver
				.findElement(By.xpath("//input[@formcontrolname='containerName']/following::mat-error[1]")).getText();

		Assert.assertTrue(containerNameError.contains("Required"), "Issue in Container name");

		String locationNameError = driver
				.findElement(By.xpath("//input[@formcontrolname='containerName']/following::mat-error[2]")).getText();

		Assert.assertTrue(locationNameError.contains("Required"), "Issue in Location name");

		String addressError = driver
				.findElement(By.xpath("//input[@formcontrolname='containerName']/following::mat-error[3]")).getText();

		Assert.assertTrue(addressError.contains("Required"), "Issue in Address");

		String emailError = driver
				.findElement(By.xpath("//input[@formcontrolname='containerName']/following::mat-error[5]")).getText();

		Assert.assertTrue(emailError.contains("Required"), "Issue in Email");

		String phoneNumberError = driver
				.findElement(By.xpath("//input[@formcontrolname='containerName']/following::mat-error[7]")).getText();

		Assert.assertTrue(phoneNumberError.contains("Required"), "Issue in Phone number");

		String chassisError = driver
				.findElement(By.xpath("//input[@formcontrolname='containerName']/following::mat-error[8]")).getText();

		Assert.assertTrue(chassisError.contains("Required"), "Issue in PCR");

		String hireDehireNameError = driver
				.findElement(By.xpath("//input[@formcontrolname='containerName']/following::mat-error[9]")).getText();

		Assert.assertTrue(hireDehireNameError.contains("Required"), "Issue in Hire/Dehire Name");

		String hireDehireAddressError = driver
				.findElement(By.xpath("//input[@formcontrolname='containerName']/following::mat-error[10]")).getText();

		Assert.assertTrue(hireDehireAddressError.contains("Required"), "Issue in Hire/Dehire Address");

		boolean isButtonClickable = driver.findElement(ByAngular.buttonText("Create")).isEnabled();

		Assert.assertFalse(isButtonClickable, "Issue in Create button");

	}

}
