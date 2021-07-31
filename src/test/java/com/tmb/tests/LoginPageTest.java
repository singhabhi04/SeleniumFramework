package com.tmb.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tmb.annotations.FrameworkAnnotations;
import com.tmb.pages.OrangeHRMLoginPage;
import com.tmb.reports.ExtentReport;
import com.tmb.utils.DataProviderUtils;

public final class LoginPageTest extends BaseTest {

	private LoginPageTest() {

	}
	@FrameworkAnnotations(author = { "Abhishek" }, category = { "Regression" })
	@Test(dataProvider="getData",dataProviderClass=DataProviderUtils.class)
	public void loginLogoutTest(Map<String, String>data) throws Exception  {
		
		OrangeHRMLoginPage lgnPage = new OrangeHRMLoginPage();
		boolean loginPanel = lgnPage.enterUserName(data.get("username")).enterPassword(data.get("password")).clickLoginButton().clickWelcome()
				.clickLogout().validatelogInPanelHeading();
		Assert.assertEquals(loginPanel, true);

	}

}