package com.eva.vtiger.pages.functionality.marketing.leads;

import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.pages.or.marketing.leeds.OrLeadsListMappingLandingPage;
import com.org.zapbook.genericCode.WebDriverUtil;

public class LeadsListMappingLandingPage extends OrLeadsListMappingLandingPage {

	private WebDriverUtil WebUtil;

	public LeadsListMappingLandingPage(WebDriverUtil WebUtil) {
		this.WebUtil = WebUtil;
		PageFactory.initElements(WebUtil.getDriver(), this);

	}

	public void basicInformation() {
		WebUtil.SelectByVisibleText(clickcompanyDD, "Company", "Company *");
		WebUtil.SelectByVisibleText(clickLastNameDD, "Last Name", "Last Name *");
		WebUtil.SelectByVisibleText(clickFirstNameDD, "First Name", "First Name");

	}

	public MappingResultsLandingPage clickOnImportNowButton() {
		basicInformation();
		WebUtil.usingWebElementclickMethod(clickImportNowButton, "Import Now Button");
		return new MappingResultsLandingPage(WebUtil);
	}

	public MappingResultsLandingPage cancelButton() {
		basicInformation();
		WebUtil.usingWebElementclickMethod(clickCancelButton, "Cancel Button");
		return new MappingResultsLandingPage(WebUtil);
	}

}
