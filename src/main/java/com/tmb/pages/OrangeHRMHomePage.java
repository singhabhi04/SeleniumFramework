package com.tmb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;

public final class OrangeHRMHomePage extends BasePage{
	
	private final By linkWelcome = By.id("welcome");
	By logoutLink = By.xpath("//a[text()='Logout']");
	
	public OrangeHRMHomePage clickWelcome() {
		
		doClick(linkWelcome,WaitStrategy.VISIBLE);
		return this;
	}
	public OrangeHRMLoginPage clickLogout() {
	doClick(logoutLink,WaitStrategy.VISIBLE);
		return new OrangeHRMLoginPage();
	}

}
