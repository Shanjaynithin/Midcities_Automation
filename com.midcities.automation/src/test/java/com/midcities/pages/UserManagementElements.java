package com.midcities.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.paulhammant.ngwebdriver.ByAngular;

public class UserManagementElements extends BaseClass {

	WebDriver driver;

	static String firstName = excel.getStringCellData("Admin_Features", 2, 0);
	static String lastName = excel.getStringCellData("Admin_Features", 2, 1);
	static String email = excel.getStringCellData("Admin_Features", 2, 2);

	public UserManagementElements(WebDriver driver) {

		this.driver = driver;
	}

	public void newUser_Positive() throws InterruptedException {

		// Navigating to user management //

		Thread.sleep(2000);

		WebElement leftNav = driver.findElement(By.xpath("*//mat-nav-list/mat-list-item[2]"));

		leftNav.click();

		driver.findElement(By.cssSelector("a[href='#/admin/user']")).click();

		// Creating new user //

		Thread.sleep(1000);

		driver.findElement(ByAngular.buttonText("Create New")).click();

		driver.findElement(By.id("mat-input-5")).sendKeys(firstName);

		driver.findElement(By.id("mat-input-6")).sendKeys(lastName);

		driver.findElement(By.id("mat-input-7")).sendKeys(email);

		driver.findElement(By.cssSelector("mat-select[name='role']")).click();

		driver.findElement(By.id("mat-option-8")).click();

		driver.findElement(ByAngular.buttonText("Send Activation Email")).click();

		// Delete the created user//

		Thread.sleep(3000);

		driver.findElement(By.id("mat-input-4")).sendKeys(firstName);

		Thread.sleep(1000);

		driver.findElement(ByAngular.buttonText("search")).click();

		Thread.sleep(1000);

		driver.findElement(By.cssSelector("button[class*='mat-red']")).click();

		Thread.sleep(1000);

		driver.findElement(ByAngular.buttonText("Delete")).click();

		driver.findElement(ByAngular.buttonText("close")).click();

	}

	public void newUser_Negative() throws AWTException, InterruptedException {

		Robot robot = new Robot();

		Thread.sleep(2000);

		WebElement leftNav = driver.findElement(By.xpath("*//mat-nav-list/mat-list-item[2]"));

		leftNav.click();

		Thread.sleep(1000);

		driver.findElement(By.cssSelector("a[href='#/admin/user']")).click();

		Thread.sleep(2000);

		driver.findElement(ByAngular.buttonText("Create New")).click();

		// For visiting each field, so that error message will be displayed //

		for (int i = 0; i <= 5; i++) {

			robot.keyPress(KeyEvent.VK_TAB);

			Thread.sleep(1000);
		}

		// Checking if error message is displayed under all the mandatory fields //

		String firstNameError = driver.findElement(By.cssSelector("mat-error[id='mat-error-3']")).getText();

		Assert.assertTrue(firstNameError.contains("required"), "Issue in first name");

		String lastNameError = driver.findElement(By.cssSelector("mat-error[id='mat-error-5']")).getText();

		Assert.assertTrue(lastNameError.contains("required"), "Issue in last name");

		String emailError = driver.findElement(By.cssSelector("mat-error[id='mat-error-7']")).getText();

		Assert.assertTrue(emailError.contains("required"), "Issue in email");

		String roleError = driver.findElement(By.cssSelector("mat-error[id='mat-error-9']")).getText();

		Assert.assertTrue(roleError.contains("required"), "Issue in role");

		String permissionError = driver.findElement(By.cssSelector("mat-error[id='mat-error-11']")).getText();

		Assert.assertTrue(permissionError.contains("required"), "Issue in permission");

		// Checking whether the Send Activation Email button is clickable

		boolean isButtonClickable = driver.findElement(ByAngular.buttonText("Send Activation Email")).isEnabled();

		Assert.assertFalse(isButtonClickable, "Issue in button");
	}

}
