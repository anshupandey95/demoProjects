package org.ZapBook.test;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.zapbook.genericCode.WebDriverUtil;

import com.aventstack.extentreports.ExtentReports;
import com.eva.vtiger.listner.IRetryFailedTestCase;
import com.eva.vtiger.pages.functionality.marketing.leads.ImportLeadSelectCSVFileLandingPage;
import com.eva.vtiger.pages.functionality.marketing.leads.LeadsCreatePage;
import com.eva.vtiger.pages.functionality.marketing.leads.LeadsDetailLandingPage;
import com.eva.vtiger.pages.functionality.marketing.leads.LeadsLandingPage;
import com.eva.vtiger.pages.functionality.marketing.leads.LeadsListMappingLandingPage;
import com.eva.vtiger.pages.functionality.marketing.leads.MappingResultsLandingPage;

public class TextCase_VtigerAutomate2 extends BaseTestClass{
	private Map<String, String> mapRowData;

	
	@Test(groups= {"Regression"},dataProvider = "getValue")
	public void verifyCreateLead(Object objMapData) {
		mapRowData = (Map<String, String>) objMapData;
		LeadsLandingPage lLp = hmp.goToMarketingLandingPage();
		LeadsCreatePage leadsCreate = lLp.clickCreateAccountButton("Click Button");
//		for (int i = 0; i < listTestdata.size(); i++) {
//			mapRowData = ExcelDataUtil.totalListData.get(i);
		LeadsDetailLandingPage lILP = leadsCreate.saveLeads(mapRowData);
		String expectedErrorMessage = mapRowData.get("ErrorMessage");
		String scenario = mapRowData.get("ScenarioType");
		if (scenario.equalsIgnoreCase("Invalid")) {
			webUtil.validatePopUpText(expectedErrorMessage);
			webUtil.HandleAlertAccept();
		} else {
			lILP.validateLeadsDetailInfo();
		}
	}

@Test(retryAnalyzer = IRetryFailedTestCase.class)
	public void verifyImportLead() {
//		System.out.println(10/0);
		LeadsLandingPage lLP = hmp.goToMarketingLandingPage();
		ImportLeadSelectCSVFileLandingPage iLFLP = lLP.clickOnImportLead("Import Lead");
		LeadsListMappingLandingPage lLMLP = iLFLP.clickOnNextButton();
		MappingResultsLandingPage mRLP = lLMLP.clickOnImportNowButton();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mRLP.clickOnFinishedButton();
	}

}