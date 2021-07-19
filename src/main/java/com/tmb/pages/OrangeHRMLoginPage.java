package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.driver.DriverManager;

public final class OrangeHRMLoginPage extends BasePage {

	private final By textBoxUserName = By.id("txtUsername");
	private final By textBoxPassword = By.id("txtPassword");
	private final By loginBtn = By.id("btnLogin");
	private final By logInPanelHeading = By.id("logInPanelHeading");

	public OrangeHRMLoginPage enterUserName(String userName) {
		doSendKeys(textBoxUserName, userName);

		return this;

	}

	public OrangeHRMLoginPage enterPassword(String password) {
		doSendKeys(textBoxPassword, password);

		return this;

	}

	public OrangeHRMHomePage doClick() {
		doClick(loginBtn);
		return new OrangeHRMHomePage();
	}

	public boolean validatelogInPanelHeading() {
		return validateElementIsDisplayed(logInPanelHeading);
	}

}
