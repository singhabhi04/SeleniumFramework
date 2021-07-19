package com.tmb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.constants.FrameworkConstants;
import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;
import com.tmb.factories.ExplicitWaitFactory;

public class BasePage {

	protected void doSendKeys(By by, String value, WaitStrategy  strategy) {
		doClear(by);
		ExplicitWaitFactory.performExplicitWait(strategy, by).sendKeys(value);
	
	}

	private void doClear(By by) {
		DriverManager.getDriver().findElement(by).clear();
	}

	protected void doClick(By by, WaitStrategy  strategy) {
		ExplicitWaitFactory.performExplicitWait(strategy, by).click();;
	
	}

	private void explicitWaitForVisibilityOfElementToBeLocated(By by) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwaittime());
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	private void explicitWaitForElementTobeClickable(By by) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwaittime());
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}
	protected boolean validateElementIsDisplayed(By by) {
		return DriverManager.getDriver().findElement(by).isDisplayed();

	}

}