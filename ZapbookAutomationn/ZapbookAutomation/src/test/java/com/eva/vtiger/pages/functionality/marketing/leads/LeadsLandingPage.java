package com.eva.vtiger.pages.functionality.marketing.leads;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.pages.or.marketing.leeds.OrLeadsLandingPage;
import com.evs.vtiger.functionality.reusablecodepage.ReusableCommanCodevtigerDependentBasePage;
import com.org.zapbook.genericCode.WebDriverUtil;

public class LeadsLandingPage extends OrLeadsLandingPage {
	private WebDriverUtil WebUtil;

	public LeadsLandingPage(WebDriverUtil WebUtil) {
		super(WebUtil);
		this.WebUtil = WebUtil;
		PageFactory.initElements(WebUtil.getDriver(), this);

	}

	public LeadsCreatePage clickCreateAccountButton(String elementName) {
		WebUtil.usingWebElementclickMethod(clickCreateBT, elementName);
		return new LeadsCreatePage(WebUtil);
	}

	public ImportLeadSelectCSVFileLandingPage clickOnImportLead(String elementName) {
		WebUtil.usingWebElementclickMethod(clickImportLead, elementName);
		return new ImportLeadSelectCSVFileLandingPage(WebUtil);

	}
}
