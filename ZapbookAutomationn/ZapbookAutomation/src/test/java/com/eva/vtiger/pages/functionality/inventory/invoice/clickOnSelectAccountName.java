package com.eva.vtiger.pages.functionality.inventory.invoice;

import org.openqa.selenium.support.PageFactory;
import com.org.zapbook.genericCode.WebDriverUtil;

import com.eva.vtiger.pages.or.inventory.invoice.OrClickOnSelectAccountName;

public class clickOnSelectAccountName extends OrClickOnSelectAccountName {

	private WebDriverUtil webUtil;

	public clickOnSelectAccountName(WebDriverUtil webUtil) {
		this.webUtil = webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);

	}

	public void accountNameselectBt() {
		webUtil.usingWebElementclickMethod(accountNameSelect, "Account Name Select Button");

	}

}
