package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.enums.WaitStrategy;

public final class OrangeHRMMyInfoPage extends BasePage{
	
	
	private final By editBtn = By.id("btnSave");
	private final By firstNameTxtBox = By.id("personal_txtEmpFirstName");
	private final By lastNameTxtBox = By.id("personal_txtEmpLastName");
	private final By empIdTxtBox = By.id("personal_txtEmployeeId");
	private final By genderRadioBtn = By.id("personal_optGender_1");
	private final By nationalityDropDown = By.xpath("//select[@id='personal_cmbNation']");
	
	
	public OrangeHRMMyInfoPage clickOnEditBtn() {
		doClick(editBtn, WaitStrategy.CLICKABLE, "Edit button");
		return this;
	}
	
	public OrangeHRMMyInfoPage enterFirstName(String firstName) {
		doSendKeys(firstNameTxtBox, firstName, WaitStrategy.PRESENCE, "FirstName text box");
		return this;
	}
	public OrangeHRMMyInfoPage enterLastName(String lastName) {
		doSendKeys(lastNameTxtBox, lastName, WaitStrategy.PRESENCE, "LastName text box");
		return this;
	}
	
	public OrangeHRMMyInfoPage enterEmpId(String empId) {
		doSendKeys(empIdTxtBox, empId, WaitStrategy.PRESENCE, "Emp Id text box");
		return this;
	}
	public OrangeHRMMyInfoPage selectGenederRadioBtn() {
		doClick(genderRadioBtn, WaitStrategy.VISIBLE, "Gender Radio button");
		return this;
	}
	public OrangeHRMMyInfoPage selectNationalityDropdown(String dropdownValue) {
		selectValueFromDropDown(nationalityDropDown, dropdownValue);
		return this;
		
	}
	
	
	

}
