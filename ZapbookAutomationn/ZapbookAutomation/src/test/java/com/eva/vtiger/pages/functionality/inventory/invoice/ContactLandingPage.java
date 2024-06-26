package com.eva.vtiger.pages.functionality.inventory.invoice;

import org.openqa.selenium.support.PageFactory;
import com.org.zapbook.genericCode.WebDriverUtil;

import com.eva.vtiger.pages.or.inventory.invoice.OrContactLandingPage;

public class ContactLandingPage extends OrContactLandingPage {

	private WebDriverUtil webUtil;

	public ContactLandingPage(WebDriverUtil webUtil) {
		this.webUtil = webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);
	}

	public void clickOnAnyNameOfNameFilter() {
		webUtil.usingWebElementclickMethod(clickYadavRamanBt, "Yadav Raman");
	}
}
