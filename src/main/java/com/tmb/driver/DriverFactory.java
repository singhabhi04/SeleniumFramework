package com.tmb.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.tmb.constants.FrameworkConstants;
import com.tmb.enums.ConfigProperties;
import com.tmb.utils.ReadPropertyFile;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author Abhishek Singh
 *07-Aug-2021
 */
public final class DriverFactory {

	private DriverFactory() {

	}

	private static WebDriver driver;

	public static void initDriver() {
		if (Objects.isNull(DriverManager.getDriver())) {
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromedriverpath());
			driver = new ChromeDriver();
			DriverManager.setDriver(driver);
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().get(ReadPropertyFile.getValue(ConfigProperties.URL));
		}

	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unLoad();
		}

	}

}
