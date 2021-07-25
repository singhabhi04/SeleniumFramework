package com.tmb.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tmb.pages.OrangeHRMHomePage;
import com.tmb.pages.OrangeHRMLoginPage;
import com.tmb.reports.ExtentReport;

public class OrangeHRMHomePageTest extends BaseTest {

	@Test
	public void validateDashBoard() {
		

		OrangeHRMLoginPage lgnPage = new OrangeHRMLoginPage();
		boolean homePageDashboard = lgnPage.enterUserName("Admin").enterPassword("admin123").clickLoginButton()
				.validateHomePageDashBoard();
		Assert.assertEquals(homePageDashboard, true);
		OrangeHRMHomePage homePage = new OrangeHRMHomePage();
		homePage.clickWelcome().clickLogout();
		

	}

}
