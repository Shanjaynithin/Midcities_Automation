package com.midcities.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.paulhammant.ngwebdriver.ByAngular;

public class OrderManagementElements extends BaseClass {

	WebDriver driver;

	static String orderType = excel.getStringCellData("Order_Management", 2, 0);
	static String customerName = excel.getStringCellData("Order_Management", 2, 1);
	static String customerRefNo = excel.getStringCellData("Order_Management", 2, 2);
	static String pickupName = excel.getStringCellData("Order_Management", 5, 0);
	static String deliverName = excel.getStringCellData("Order_Management", 5, 1);
	// static String pickupDate = excel.getStringCellData("Order_Management", 6, 0);
	// static String deliveryDate = excel.getStringCellData("Order_Management",
	// 6,0);
	static String containerNo = excel.getStringCellData("Order_Management", 8, 0);
	static String size = excel.getStringCellData("Order_Management", 8, 1);
	static String weight = excel.getStringCellData("Order_Management", 8, 2);
	static String containerType = excel.getStringCellData("Order_Management", 8, 3);
	static String containerOwner = excel.getStringCellData("Order_Management", 8, 4);
	static String chassisName = excel.getStringCellData("Order_Management", 8, 5);
	static String hireLocation = excel.getStringCellData("Order_Management", 8, 6);
	static String orderNotes = excel.getStringCellData("Order_Management", 11, 0);

	public OrderManagementElements(WebDriver driver) {

		this.driver = driver;
	}

	public void order_Positive() throws InterruptedException {

		Thread.sleep(3000);

		// Navigating to order screen
		driver.findElement(By.xpath("//a[@href='#/order']")).click();

		Thread.sleep(3000);

		// Clicking on the Create Order button //
		driver.findElement(ByAngular.buttonText("Create New Order")).click();

		// Selecting Order Type
		driver.findElement(By.cssSelector("mat-select[formcontrolname='order_type']")).click();

		driver.findElement(By.xpath("//mat-option/span[text()='" + orderType + "']")).click();

		// Selecting customer name
		driver.findElement(By.cssSelector("input[formcontrolname='customer_name']")).sendKeys(customerName);

		driver.findElement(By.xpath("//mat-option/span/span[text()='" + customerName + "']")).click();

		// Passing customer reference number
		driver.findElement(By.cssSelector("input[formcontrolname='customer_reference']")).sendKeys(customerRefNo);

		// Passing pickup address
		driver.findElement(By.id("mat-input-9")).sendKeys(pickupName);

		driver.findElement(By.xpath("//mat-option/span/span[text()='" + pickupName + "']")).click();

		// Passing pickup date and time
		driver.findElement(By.cssSelector("input[formcontrolname='est_pickup_time']")).click();
		
		Thread.sleep(2000);

		driver.findElement(By.xpath(
				"//*[@id=\"owl-dt-picker-0\"]/div[2]/owl-date-time-calendar/div[2]/owl-date-time-month-view/table/tbody/tr[5]/td[3]/span"))
				.click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"owl-dt-picker-0\"]/div[2]/div[2]/button[2]")).click();

		// Passing delivery address
		driver.findElement(By.id("mat-input-11")).sendKeys(deliverName);

		driver.findElement(By.xpath("//mat-option/span/span[text()='" + deliverName + "']")).click();

		// Passing delivery date and time
		driver.findElement(By.cssSelector("input[formcontrolname='est_delivery_time']")).click();
		
		Thread.sleep(3000);

		driver.findElement(By.xpath(
				"//*[@id=\"owl-dt-picker-1\"]/div[2]/owl-date-time-calendar/div[2]/owl-date-time-month-view/table/tbody/tr[5]/td[4]/span"))
				.click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"owl-dt-picker-1\"]/div[2]/div[2]/button[2]")).click();
		
		Thread.sleep(1000);

		// Passing container reference number
		driver.findElement(By.cssSelector("input[formcontrolname='containernumber']")).sendKeys(containerNo);

		// Selecting size
		String sizeNumber = " " + size;

		driver.findElement(By.cssSelector("mat-select[formcontrolname='containersize']")).click();

		driver.findElement(By.xpath("//mat-option/span[text()='" + sizeNumber + "']")).click();

		// Passing weight
		driver.findElement(By.cssSelector("input[formcontrolname='weights']")).sendKeys(weight);

		// Selecting Container Type
		String containerTypes = " " + containerType + " ";

		driver.findElement(By.cssSelector("mat-select[formcontrolname='containertype']")).click();

		driver.findElement(By.xpath("//mat-option/span[text()='" + containerTypes + "']")).click();

		// Passing container owner
		driver.findElement(By.cssSelector("input[formcontrolname='containername']")).sendKeys(containerOwner);

		driver.findElement(By.xpath("//mat-option/span/span[text()='" + containerOwner + "']")).click();

		// Selecting Chassis name
		String chassis = chassisName + " ";

		driver.findElement(By.cssSelector("mat-select[formcontrolname='chassisname']")).click();

		driver.findElement(By.xpath("//mat-option/span[text()='" + chassis + "']")).click();

		// Selecting Hire/Dehire location
		String location = " " + hireLocation;

		driver.findElement(By.cssSelector("mat-select[formcontrolname='hire_name']")).click();

		driver.findElement(By.xpath("//mat-option/span[text()='" + location + "']")).click();

		// Passing notes
		driver.findElement(By.cssSelector("textarea[formcontrolname='order_notes']")).sendKeys(orderNotes);

		// Clicking on create button
		driver.findElement(ByAngular.buttonText("Save & Dispatch")).click();

	}

	public void order_Negative() throws AWTException, InterruptedException {

		Robot robot = new Robot();

		// Navigating to General Route rate section //
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[@href='#/order']")).click();

		Thread.sleep(2000);

		// Clicking on the Create Order button //
		driver.findElement(ByAngular.buttonText(" Create New Order ")).click();
		
		Thread.sleep(2000);
		
		// Clicking on order type
		driver.findElement(By.cssSelector("mat-select[formcontrolname='order_type']")).click();

		// For visiting each field, so that error message will be displayed //
		for (int i = 0; i <= 28; i++) {

			robot.keyPress(KeyEvent.VK_TAB);

			Thread.sleep(1000);
		}
		
		// Checking if error message is displayed under all the mandatory fields
		String orderTypeError = driver
				.findElement(By.xpath("//mat-select[@formcontrolname='order_type']/following::mat-error[1]"))
				.getText();
		
		Assert.assertTrue(orderTypeError.contains("Required"), "Issue in order type");
		
		String customerNameError = driver
				.findElement(By.xpath("//mat-select[@formcontrolname='order_type']/following::mat-error[2]"))
				.getText();
		
		Assert.assertTrue(customerNameError.contains("Required"), "Issue in customer name");
		
		String customerRefError = driver
				.findElement(By.xpath("//mat-select[@formcontrolname='order_type']/following::mat-error[4]"))
				.getText();
		
		Assert.assertTrue(customerRefError.contains("Required"), "Issue in customer reference number");
		
		String pickupNameError = driver
				.findElement(By.xpath("//mat-select[@formcontrolname='order_type']/following::mat-error[7]"))
				.getText();
		
		Assert.assertTrue(pickupNameError.contains("Required"), "Issue in Pickup name");
		
		String pickupAddressError = driver
				.findElement(By.xpath("//mat-select[@formcontrolname='order_type']/following::mat-error[8]"))
				.getText();
		
		Assert.assertTrue(pickupAddressError.contains("Required"), "Issue in Pickup address");
		
		String pickupDateError = driver
				.findElement(By.xpath("//mat-select[@formcontrolname='order_type']/following::mat-error[9]"))
				.getText();
		
		Assert.assertTrue(pickupDateError.contains("Required"), "Issue in Pickup date and time");
		
		String deliveryNameError = driver
				.findElement(By.xpath("//mat-select[@formcontrolname='order_type']/following::mat-error[10]"))
				.getText();
		
		Assert.assertTrue(deliveryNameError.contains("Required"), "Issue in Delivery name");
		
		String deliveryAddressError = driver
				.findElement(By.xpath("//mat-select[@formcontrolname='order_type']/following::mat-error[11]"))
				.getText();
		
		Assert.assertTrue(deliveryAddressError.contains("Required"), "Issue in Delivery address");
		
		String deliveryDateError = driver
				.findElement(By.xpath("//mat-select[@formcontrolname='order_type']/following::mat-error[12]"))
				.getText();
		
		Assert.assertTrue(deliveryDateError.contains("Required"), "Issue in Delivery date and time");
		
		String sizeError = driver
				.findElement(By.xpath("//mat-select[@formcontrolname='order_type']/following::mat-error[13]"))
				.getText();
		
		Assert.assertTrue(sizeError.contains("Required"), "Issue in size");
		
		String weightError = driver
				.findElement(By.xpath("//mat-select[@formcontrolname='order_type']/following::mat-error[14]"))
				.getText();
		
		Assert.assertTrue(weightError.contains("Required"), "Issue in weight");
		
		String containerTypeError = driver
				.findElement(By.xpath("//mat-select[@formcontrolname='order_type']/following::mat-error[15]"))
				.getText();
		
		Assert.assertTrue(containerTypeError.contains("Required"), "Issue in container type");
		
		String containerOwnerError = driver
				.findElement(By.xpath("//mat-select[@formcontrolname='order_type']/following::mat-error[17]"))
				.getText();
		
		Assert.assertTrue(containerOwnerError.contains("Required"), "Issue in container owner");
		
		boolean isButtonClickable = driver.findElement(ByAngular.buttonText("Save & Dispatch")).isEnabled();

		Assert.assertFalse(isButtonClickable, "Issue in Create button");

	}

}
