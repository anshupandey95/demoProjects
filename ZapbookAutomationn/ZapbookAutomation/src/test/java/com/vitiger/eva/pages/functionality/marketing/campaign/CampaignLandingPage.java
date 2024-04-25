package com.vitiger.eva.pages.functionality.marketing.campaign;


import org.openqa.selenium.support.PageFactory;
import com.eva.vtiger.pages.or.marketing.campaign.OrCampaignLandingPage;
import com.org.zapbook.genericCode.WebDriverUtil;

public class CampaignLandingPage extends OrCampaignLandingPage {

	private WebDriverUtil webUtil;

	public CampaignLandingPage(WebDriverUtil webUtil) {
		this.webUtil = webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);
	}

	public CreateCampaignLandingPage clickCampaignButton() {
		webUtil.usingWebElementclickMethod(campaignBt, "Campaign Button Click");
		return new CreateCampaignLandingPage(webUtil);
	}
}
