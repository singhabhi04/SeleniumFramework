package com.tmb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.driver.DriverManager;

public final class OrangeHRMHomePage {
	
	private final By linkWelcome = By.id("welcome");
	By logoutLink = By.xpath("//a[text()='Logout']");
	
	public OrangeHRMHomePage clickWelcome() {
		
		DriverManager.getDriver().findElement(linkWelcome).click();
		return this;
	}
	public OrangeHRMLoginPage clickLogout() {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(logoutLink));
		DriverManager.getDriver().findElement(logoutLink).click();
		return new OrangeHRMLoginPage();
	}

}
