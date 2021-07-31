package com.tmb.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tmb.constants.FrameworkConstants;
import com.tmb.enums.ConfigProperties;

public  final class ExtentReport {
	private ExtentReport() {
		
	}
	private static ExtentReports extent;
	
	public static void initReports() throws Exception {
		if(Objects.isNull(extent)) {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
		extent.attachReporter(spark);
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("Orange HRM Reports");
		spark.config().setReportName("Orange HRM Test Execution  Reports");
		spark.config().setTheme(Theme.STANDARD);
		}
	}
	public static void createTest(String testCaseName) {
	ExtentTest	test =extent.createTest(testCaseName);
	ExtentReportManager.setDriver(test);
		
	}
	public static void flushReports() throws IOException {
		if(Objects.nonNull(extent)) {
			extent.flush();
		}
	
		try {
			Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void addAuthors(String[] authors) {
		for(String temp:authors) {
			ExtentReportManager.getExtentTest().assignAuthor(temp);
		}
	}
	
	public static void addCategory(String[] category) {
		for(String temp:category) {
			ExtentReportManager.getExtentTest().assignCategory(temp);
		}
	}

}
