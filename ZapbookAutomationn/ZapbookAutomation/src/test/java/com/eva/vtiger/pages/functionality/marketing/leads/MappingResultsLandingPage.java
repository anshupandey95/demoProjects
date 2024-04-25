package com.eva.vtiger.pages.functionality.marketing.leads;

import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.pages.or.marketing.leeds.OrMappingResultsLandingPage;
import com.org.zapbook.genericCode.WebDriverUtil;

public class MappingResultsLandingPage extends OrMappingResultsLandingPage {

	private WebDriverUtil WebUtil;

	public MappingResultsLandingPage(WebDriverUtil WebUtil) {
		this.WebUtil = WebUtil;
		PageFactory.initElements(WebUtil.getDriver(), this);

	}
	public  void clickOnFinishedButton() {
		WebUtil.usingWebElementclickMethod(clickFinishedBt, "Finished");
	}
}
