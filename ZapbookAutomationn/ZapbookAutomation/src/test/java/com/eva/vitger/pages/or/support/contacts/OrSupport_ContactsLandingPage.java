package com.eva.vitger.pages.or.support.contacts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrSupport_ContactsLandingPage {

	@FindBy(xpath = "//td[text()='Filters :']//parent::tr//parent::tbody//parent::table//parent::td//preceding-sibling::td//input[@value='Mass Edit']")
	protected WebElement massEditBt;

	@FindBy(name = "selectall")
	protected WebElement checkBoxBt;

	 
}
