package com.tmb.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.tmb.driver.DriverFactory;
import com.tmb.driver.DriverManager;

public final class LoginPageTest extends BaseTest {

	private LoginPageTest() {

	}

	@Test
	public void loginTest() {

		DriverManager.getDriver().findElement(By.id("txtUsername")).sendKeys("Admin");
		DriverManager.getDriver().findElement(By.id("txtPassword")).sendKeys("admin123", Keys.ENTER);

	}


}