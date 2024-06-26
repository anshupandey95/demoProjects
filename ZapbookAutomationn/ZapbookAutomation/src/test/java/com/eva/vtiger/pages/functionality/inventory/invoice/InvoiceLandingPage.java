package com.eva.vtiger.pages.functionality.inventory.invoice;

import org.openqa.selenium.support.PageFactory;
import org.zapbook.genericCode.WebDriverUtil;

import com.eva.vtiger.pages.or.inventory.invoice.OrInvoiceLandingPage;

public class InvoiceLandingPage extends OrInvoiceLandingPage {
	
	private WebDriverUtil webUtil;
	
	public InvoiceLandingPage(WebDriverUtil webUtil){
		this.webUtil=webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);
	}
	
	public CreateInvoiceLandingPage clickOnInvoiceButton() {
		webUtil.usingWebElementclickMethod(clickInvoiceCreateBt, " Click on Invoice create button");
		return new CreateInvoiceLandingPage(webUtil);
	}
}
