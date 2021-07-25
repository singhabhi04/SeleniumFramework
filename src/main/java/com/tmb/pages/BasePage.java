package com.tmb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.constants.FrameworkConstants;
import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;
import com.tmb.factories.ExplicitWaitFactory;
import com.tmb.reports.ExtentLogger;

public class BasePage {

	protected void doSendKeys(By by, String value, WaitStrategy  strategy,String webElementName) {
		doClear(by);
		ExplicitWaitFactory.performExplicitWait(strategy, by).sendKeys(value);
		ExtentLogger.pass(value +" is entered sucessfully in " +webElementName);
	
	}

	private void doClear(By by) {
		DriverManager.getDriver().findElement(by).clear();
	}

	protected void doClick(By by, WaitStrategy  strategy,String webElementName) {
		ExplicitWaitFactory.performExplicitWait(strategy, by).click();
		ExtentLogger.pass(webElementName+  " is clicked");
	
	}

	
	protected boolean validateElementIsDisplayed(By by) {
		return DriverManager.getDriver().findElement(by).isDisplayed();

	}

}