package com.tmb.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tmb.driver.DriverFactory;
import com.tmb.driver.DriverManager;

public class OrangeHRMHomePageTest extends BaseTest {

	@Test
	public void validateDashBoard() {
		DriverManager.getDriver().findElement(By.id("txtUsername")).sendKeys("Admin");
		DriverManager.getDriver().findElement(By.id("txtPassword")).sendKeys("admin123", Keys.ENTER);
		boolean dashBoardSection = DriverManager.getDriver().findElement(By.xpath("//h1[text()='Dashboard']"))
				.isDisplayed();
		if (dashBoardSection) {
			System.out.println("DashBoard Section is Displayed");
			Assert.assertEquals(dashBoardSection, true);
		} else {
			Assert.assertEquals(dashBoardSection, true);
		}

	}

}
