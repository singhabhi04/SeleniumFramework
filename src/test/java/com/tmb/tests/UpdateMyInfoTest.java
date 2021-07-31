package com.tmb.tests;

import java.util.Map;

import org.testng.annotations.Test;

import com.tmb.annotations.FrameworkAnnotations;
import com.tmb.pages.OrangeHRMLoginPage;
import com.tmb.utils.DataProviderUtils;

public  class UpdateMyInfoTest extends BaseTest {
	@FrameworkAnnotations(author = { "Abhishek" }, category = { "System" })
	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void validateUpdateMyInfoTest(Map<String, String> data) throws Exception 
	{
		OrangeHRMLoginPage lgnPage = new OrangeHRMLoginPage();
		lgnPage.enterUserName(data.get("username")).enterPassword(data.get("password")).clickLoginButton()
		.clickOnMyInfoMenu().clickOnEditBtn().enterFirstName(data.get("firstname")).
		enterLastName(data.get("lastname")).enterEmpId(data.get("empid")).selectGenederRadioBtn().selectNationalityDropdown(data.get("dropdownvalue")).clickOnEditBtn();
	}
}
