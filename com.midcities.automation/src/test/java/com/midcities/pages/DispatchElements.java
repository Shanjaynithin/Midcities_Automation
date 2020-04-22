package com.midcities.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.paulhammant.ngwebdriver.ByAngular;

public class DispatchElements {

	WebDriver driver;

	public DispatchElements(WebDriver driver) {

		this.driver = driver;
	}

	public void dispatch_legs() throws InterruptedException {

		Thread.sleep(3000);

		// Navigating to Dispatch screen
		driver.findElement(By.xpath("//a[@href='#/dispatch']")).click();

		Thread.sleep(3000);

		driver.findElement(ByAngular.buttonText("close")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath(
				"/html/body/app-root/app-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-dispatch/mat-card[1]/mat-card-content/div/mat-table/mat-row[1]/mat-cell[2]/a"))
				.click();

		Thread.sleep(3000);

		driver.findElement(By.xpath(
				"/html/body/app-root/app-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-leg/mat-card[2]/mat-card-content/div/mat-table/mat-row[1]/mat-cell[6]/button"))
				.click();

		driver.findElement(ByAngular.buttonText("Assigned")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"mat-radio-1\"]")).click();

		driver.findElement(ByAngular.buttonText("Assign")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath(
				"/html/body/app-root/app-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-leg/mat-card[2]/mat-card-content/div/mat-table/mat-row[1]/mat-cell[6]/button"))
				.click();

		driver.findElement(ByAngular.buttonText("Picked Up")).click();

		Thread.sleep(2000);

		driver.findElement(ByAngular.buttonText("Yes")).click();

		Thread.sleep(2000);

		driver.findElement(ByAngular.buttonText("Cancel")).click();

		driver.findElement(By.xpath(
				"/html/body/app-root/app-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-leg/mat-card[2]/mat-card-content/div/mat-table/mat-row[2]/mat-cell[6]/button"))
				.click();

		driver.findElement(ByAngular.buttonText("Delivered")).click();

		Thread.sleep(2000);

		driver.findElement(ByAngular.buttonText("Yes")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath(
				"/html/body/app-root/app-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-leg/mat-card[2]/mat-card-content/div/mat-table/mat-row[3]/mat-cell[6]/button"))
				.click();

		driver.findElement(ByAngular.buttonText("Picked Up")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath(
				"/html/body/app-root/app-layout/div/mat-sidenav-container/mat-sidenav-content/div/app-leg/mat-card[2]/mat-card-content/div/mat-table/mat-row[3]/mat-cell[6]/button"))
				.click();

		driver.findElement(ByAngular.buttonText("Delivered")).click();

		Thread.sleep(2000);

		driver.findElement(ByAngular.buttonText("Yes, immediately")).click();

		Thread.sleep(5000);
	}

}
