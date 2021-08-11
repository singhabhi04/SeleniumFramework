package com.tmb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.constants.FrameworkConstants;
import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;
import com.tmb.factories.ExplicitWaitFactory;
import com.tmb.reports.ExtentLogger;
import com.tmb.utils.DecodeUtils;

public class BasePage {

	protected void doSendKeys(By by, String value, WaitStrategy strategy, String webElementName,
			boolean isEncodingRequired) {
		doClear(by);
		ExplicitWaitFactory.performExplicitWait(strategy, by).sendKeys(value);
		if(isEncodingRequired) {
			ExtentLogger.pass(DecodeUtils.getEncodedString(value) + " is entered sucessfully in " + webElementName, true);
		}
		else {
			ExtentLogger.pass(value + " is entered sucessfully in " + webElementName, true);
		}

		
	}

	protected void doSendKeys(By by, String value, WaitStrategy strategy, String webElementName) {
		doClear(by);
		ExplicitWaitFactory.performExplicitWait(strategy, by).sendKeys(value);

		ExtentLogger.pass(value + " is entered sucessfully in " + webElementName, true);

	}

	private void doClear(By by) {
		DriverManager.getDriver().findElement(by).clear();
	}

	protected void doClick(By by, WaitStrategy strategy, String webElementName) {
		ExplicitWaitFactory.performExplicitWait(strategy, by).click();

		ExtentLogger.pass(webElementName + " is clicked", true);

	}

	protected boolean validateElementIsDisplayed(By by) {
		return DriverManager.getDriver().findElement(by).isDisplayed();

	}

	protected void selectValueFromDropDown(By by, String value) {
		doClick(by, WaitStrategy.CLICKABLE, "Nationality dropdown");
		Select sc = new Select(DriverManager.getDriver().findElement(by));
		sc.selectByVisibleText(value);

	}

}