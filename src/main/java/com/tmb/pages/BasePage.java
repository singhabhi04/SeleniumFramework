package com.tmb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.constants.FrameworkConstants;
import com.tmb.driver.DriverManager;

public class BasePage {

	protected void doSendKeys(By by, String value) {
		doClear(by);
		DriverManager.getDriver().findElement(by).sendKeys(value);
	}

	private void doClear(By by) {
		DriverManager.getDriver().findElement(by).clear();
	}

	protected void doClick(By by) {
		explicitWaitForVisibilityOfElementToBeLocated(by);
		DriverManager.getDriver().findElement(by).click();
	}

	private void explicitWaitForVisibilityOfElementToBeLocated(By by) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwaittime());
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
	}

	protected boolean validateElementIsDisplayed(By by) {
		return DriverManager.getDriver().findElement(by).isDisplayed();

	}

}