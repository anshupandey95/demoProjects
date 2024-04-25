package com.eva.vtiger.pages.functionality.inventory.invoice;

import org.openqa.selenium.support.PageFactory;

import com.org.zapbook.genericCode.WebDriverUtil;

public class AccountsLandingPage {

	private WebDriverUtil webUtil;

	public AccountsLandingPage(WebDriverUtil webUtil) {
		this.webUtil = webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);
	}
	
}
