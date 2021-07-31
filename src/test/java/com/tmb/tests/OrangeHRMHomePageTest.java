package com.tmb.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tmb.annotations.FrameworkAnnotations;
import com.tmb.pages.OrangeHRMHomePage;
import com.tmb.pages.OrangeHRMLoginPage;
import com.tmb.reports.ExtentReport;
import com.tmb.utils.DataProviderUtils;

public class OrangeHRMHomePageTest extends BaseTest {
	@FrameworkAnnotations(author = { "Abhishek" }, category = { "System" })
	@Test(dataProvider="getData",dataProviderClass=DataProviderUtils.class)
	public void validateHomePageDashBoardTest(Map<String, String>data) throws Exception {
		

		OrangeHRMLoginPage lgnPage = new OrangeHRMLoginPage();
		boolean homePageDashboard = lgnPage.enterUserName(data.get("username")).enterPassword(data.get("password")).clickLoginButton()
				.validateHomePageDashBoard();
		Assert.assertEquals(homePageDashboard, true);
		OrangeHRMHomePage homePage = new OrangeHRMHomePage();
		homePage.clickWelcome().clickLogout();
		

	}

}
