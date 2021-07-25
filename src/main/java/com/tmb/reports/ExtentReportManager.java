package com.tmb.reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentReportManager {
	
	private ExtentReportManager() {
		
	}
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	 static ExtentTest getExtentTest() {
		return extentTest.get();
	}

	 static void setDriver(ExtentTest test) {
		extentTest.set(test);
	}

	 static void unLoad() {
		extentTest.remove();
	}

}
