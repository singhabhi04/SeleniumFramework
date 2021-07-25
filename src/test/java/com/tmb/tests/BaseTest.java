package com.tmb.tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.tmb.driver.DriverFactory;
import com.tmb.reports.ExtentReport;

public class BaseTest {

	protected BaseTest() {

	}

	@BeforeMethod
	protected void setUp() throws Exception {
		DriverFactory.initDriver();
	}

	@AfterMethod
	protected void tearDown() {
		DriverFactory.quitDriver();
	}
}
