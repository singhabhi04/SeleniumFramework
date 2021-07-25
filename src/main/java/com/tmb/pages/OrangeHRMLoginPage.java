package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;
import com.tmb.reports.ExtentLogger;
import com.tmb.reports.ExtentReport;
import com.tmb.reports.ExtentReportManager;

public final class OrangeHRMLoginPage extends BasePage {

	private final By textBoxUserName = By.id("txtUsername");
	private final By textBoxPassword = By.id("txtPassword");
	private final By loginBtn = By.id("btnLogin");
	private final By logInPanelHeading = By.id("logInPanelHeading");

	public OrangeHRMLoginPage enterUserName(String userName) throws Exception {
		doSendKeys(textBoxUserName, userName, WaitStrategy.VISIBLE, "Username");

		return this;

	}

	public OrangeHRMLoginPage enterPassword(String password)  {
		doSendKeys(textBoxPassword, password, WaitStrategy.VISIBLE, "Password");

		return this;

	}

	public OrangeHRMHomePage clickLoginButton() throws Exception {
		doClick(loginBtn, WaitStrategy.VISIBLE, "Login button");

		return new OrangeHRMHomePage();
	}

	public boolean validatelogInPanelHeading() {
		ExtentLogger.pass("Login Panel Heading is validated");
		return validateElementIsDisplayed(logInPanelHeading);

	}

}
