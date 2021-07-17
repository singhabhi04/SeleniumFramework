package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.driver.DriverManager;

public final class OrangeHRMLoginPage {
	
	private final By textBoxUserName = By.id("txtUsername");
	private final By textBoxPassword = By.id("txtPassword");
	private final By loginBtn = By.id("btnLogin");
	private final By logInPanelHeading = By.id("logInPanelHeading");
	
	
	 public OrangeHRMLoginPage enterUserName(String userName) {
		 DriverManager.getDriver().findElement(textBoxUserName).clear();
		 DriverManager.getDriver().findElement(textBoxUserName).sendKeys(userName);
		 return this;
		 
	 }
	 public OrangeHRMLoginPage enterPassword(String password) {
		 DriverManager.getDriver().findElement(textBoxPassword).clear();
		 DriverManager.getDriver().findElement(textBoxPassword).sendKeys(password);
		 return this;
		 
	 }
	 public OrangeHRMHomePage doClick() {
		 DriverManager.getDriver().findElement(loginBtn).click();
		 return  new OrangeHRMHomePage();
	 }
	 public boolean validatelogInPanelHeading() {
	return	 DriverManager.getDriver().findElement(logInPanelHeading).isDisplayed();
	
	 }

}
