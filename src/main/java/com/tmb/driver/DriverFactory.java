package com.tmb.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import com.tmb.constants.FrameworkConstants;

public class DriverFactory {
	
	public static WebDriver driver;
	 public static void initDriver() {
		 if(Objects.isNull(driver)) {
			 System.setProperty("webdriver.chrome.driver",FrameworkConstants.getChromedriverpath());
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://opensource-demo.orangehrmlive.com/");
		 }
		 
	 }
	 public static void quitDriver() {
		 if(Objects.nonNull(driver)) {
			 driver.quit();
			 driver=null;
		 }
		
	 }

}
