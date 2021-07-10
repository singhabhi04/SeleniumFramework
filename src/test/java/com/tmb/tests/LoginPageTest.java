package com.tmb.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.tmb.driver.DriverFactory;

public final class LoginPageTest extends BaseTest{
	
	private LoginPageTest() {
		
	}


	@Test
	public void loginTest() {


		DriverFactory.driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		DriverFactory.driver.findElement(By.id("txtPassword")).sendKeys("admin123",Keys.ENTER);

	}

	@Test
	public void validateLoginPageTitle() {


		System.out.println(DriverFactory.driver.getTitle());


}
}