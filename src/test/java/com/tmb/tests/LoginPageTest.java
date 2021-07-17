package com.tmb.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tmb.pages.OrangeHRMLoginPage;

public final class LoginPageTest extends BaseTest {

	private LoginPageTest() {

	}

	@Test
	public void loginLogoutTest() {
		OrangeHRMLoginPage lgnPage = new OrangeHRMLoginPage();
	boolean loginPanel=	lgnPage.enterUserName("Admin").
		enterPassword("admin123").
		doClick().clickWelcome()
		.clickLogout()
		.validatelogInPanelHeading();
	Assert.assertEquals(loginPanel, true);
		
		

	}


}