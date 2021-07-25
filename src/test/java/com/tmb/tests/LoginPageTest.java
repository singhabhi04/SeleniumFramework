package com.tmb.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tmb.pages.OrangeHRMLoginPage;
import com.tmb.reports.ExtentReport;

public final class LoginPageTest extends BaseTest {

	private LoginPageTest() {

	}

	@Test
	public void loginLogoutTest() throws Exception  {
		
		OrangeHRMLoginPage lgnPage = new OrangeHRMLoginPage();
		boolean loginPanel = lgnPage.enterUserName("Admin").enterPassword("admin123").clickLoginButton().clickWelcome()
				.clickLogout().validatelogInPanelHeading();
		Assert.assertEquals(loginPanel, true);

	}

}