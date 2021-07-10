package com.tmb.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.tmb.driver.DriverFactory;

public class BaseTest {
	
	protected BaseTest() {
		
	}
	
	@BeforeMethod
	public void setUp() {
		DriverFactory.initDriver();
	}

	@AfterMethod
	public void tearDown() {
		DriverFactory.quitDriver();
	}
}
