package com.eva.vtiger.pages.functionality.support.contacts;

import org.openqa.selenium.support.PageFactory;
import com.eva.vitger.pages.or.support.contacts.OrSupport_ContactsLandingPage;
import com.org.zapbook.genericCode.WebDriverUtil;

public class Support_ContactsLandingPage extends OrSupport_ContactsLandingPage {

	private WebDriverUtil util;

	public Support_ContactsLandingPage(WebDriverUtil util) {
		this.util = util;
		PageFactory.initElements(util.getDriver(), this);

	}

	public void clickOnMassEdit() {
		util.usingWebElementclickMethod(massEditBt, "Mass Edit");
	}

	public void clickOnCheckBox() {
util.usingWebElementclickMethod(checkBoxBt, "Select All Check Box");
	}
}
