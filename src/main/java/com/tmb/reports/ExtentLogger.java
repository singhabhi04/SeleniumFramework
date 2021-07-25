package com.tmb.reports;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.tmb.driver.DriverManager;
import com.tmb.enums.ConfigProperties;
import com.tmb.utils.ReadPropertyFile;

public final class ExtentLogger {
	private ExtentLogger() {

	}
	
	public static void pass(String message) {
		ExtentReportManager.getExtentTest().pass(message);
	}
	
	public static void fail(String message) {
		ExtentReportManager.getExtentTest().fail(message);
	}
	
	public static void skip(String message) {
		ExtentReportManager.getExtentTest().skip(message);
	}

	public static void pass(String message,boolean isScreenShotNeeded) throws Exception {
		if(ReadPropertyFile.getValue(ConfigProperties.PASSEDSTEPSSCREENSHOT).equalsIgnoreCase("Yes")){
			ExtentReportManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
		}
		else {
			pass(message);
		}
	
	}
	public static void fail(String message,boolean isScreenShotNeeded) throws Exception {
		if(ReadPropertyFile.getValue(ConfigProperties.FAILEDSTEPSSCREENSHOT).equalsIgnoreCase("Yes")){
			ExtentReportManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
		}
		else {
			fail(message);
		}
	}
	public static String getBase64Image() {
		return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
		
	}
	
}
