package com.midcities.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.midcities.utility.BrowserConfig;
import com.midcities.utility.ConfigDataProvider;
import com.midcities.utility.ExcelDataProvider;
import com.midcities.utility.Helper;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports reports;
	public ExtentTest logger;

	@BeforeSuite
	public void setupSuite() {
		
		//This is base class

		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();

		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(
				System.getProperty("user.dir") + "/Reports/Midcities_" + Helper.getCurrentDateTime() + ".html"));
		reports = new ExtentReports();
		reports.attachReporter(extent);

	}

	@BeforeClass
	public void startUp() {

		driver = BrowserConfig.startApplication(driver, config.getBrowser(), config.getUrl());

	}

	@AfterClass
	public void finish() {

		// BrowserConfig.quitBrowser(driver);

	}

	@AfterMethod
	public void screenshotHandler(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {

			// Helper.captureScreenshot(driver,result.getName());

				logger.fail("Test failed", MediaEntityBuilder
						.createScreenCaptureFromPath(Helper.captureScreenshot(driver, result.getName())).build());
			
		} else if (result.getStatus() == ITestResult.SUCCESS) {

				logger.pass("Test passed", MediaEntityBuilder
						.createScreenCaptureFromPath(Helper.captureScreenshot(driver, result.getName())).build());
		} 

		reports.flush();
	}

}
