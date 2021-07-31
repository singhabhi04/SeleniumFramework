package com.tmb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;
import com.tmb.reports.ExtentLogger;
import com.tmb.reports.ExtentReport;
import com.tmb.reports.ExtentReportManager;

public final class OrangeHRMHomePage extends BasePage {

	private final By linkWelcome = By.id("welcome");
	By logoutLink = By.xpath("//a[text()='Logout']");
	By dashBoardSection = By.xpath("//h1[text()='Dashboard']");
	private final By myInfoMenu = By.xpath("//a[@id='menu_pim_viewMyDetails']");

	public OrangeHRMHomePage clickWelcome()  {

		doClick(linkWelcome, WaitStrategy.VISIBLE," Welcome Link");
		
		return this;
	}

	public OrangeHRMLoginPage clickLogout() {
		doClick(logoutLink, WaitStrategy.VISIBLE,"Logout link");
		
		return new OrangeHRMLoginPage();
	}

	public boolean validateHomePageDashBoard() throws Exception {
		
		
		return validateElementIsDisplayed(dashBoardSection);

	}
	public OrangeHRMMyInfoPage clickOnMyInfoMenu() {
		doClick(myInfoMenu, WaitStrategy.VISIBLE,"My Info menu");
		return new OrangeHRMMyInfoPage();
	}

}
