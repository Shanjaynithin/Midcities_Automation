package com.midcities.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.paulhammant.ngwebdriver.ByAngular;

public class InvoiceManagementElements extends BaseClass {

	WebDriver driver;

	public InvoiceManagementElements(WebDriver driver) {

		this.driver = driver;
	}

	public void invoice_testcase() throws InterruptedException {

		// Navigating to Chassis section //
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[@href='#/invoice']")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath(
				"/html/body/app-root/app-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-invoice/mat-card/mat-card-content/div/mat-table/mat-row[1]/mat-cell[1]/a"))
				.click();
		
		Thread.sleep(2000);

		driver.findElement(By.xpath(
				"/html/body/app-root/app-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-invoice-to-generated/mat-card/mat-card-content/div/mat-table/mat-row/mat-cell[2]/a"))
				.click();
		
		Thread.sleep(2000);
		
		driver.findElement(ByAngular.buttonText("Generate invoice")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(ByAngular.buttonText("Cancel")).click();

	}

}
