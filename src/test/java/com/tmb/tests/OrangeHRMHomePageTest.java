package com.tmb.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

		WebElement welcomeIcon = DriverManager.getDriver().findElement(By.id("welcome"));
		welcomeIcon.click();
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10);
		By logOutLink = By.xpath("//a[text()='Logout']");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(logOutLink));
		DriverManager.getDriver().findElement(logOutLink).click();
		

	}

}
