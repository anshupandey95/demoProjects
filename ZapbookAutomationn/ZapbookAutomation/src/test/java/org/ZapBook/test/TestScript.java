package org.ZapBook.test;

import java.util.Map;

import org.testng.annotations.Test;
import com.eva.vtiger.listner.IRetryFailedTestCase;
import com.eva.vtiger.listner.ItestListnerTestcase;
import com.eva.vtiger.pages.functionality.inventory.invoice.CreateInvoiceLandingPage;
import com.eva.vtiger.pages.functionality.inventory.invoice.InvoiceDetailPage;
import com.eva.vtiger.pages.functionality.inventory.invoice.InvoiceLandingPage;

import com.eva.vtiger.pages.functionality.marketing.leads.ImportLeadSelectCSVFileLandingPage;
import com.eva.vtiger.pages.functionality.marketing.leads.LeadsCreatePage;
import com.eva.vtiger.pages.functionality.marketing.leads.LeadsDetailLandingPage;
import com.eva.vtiger.pages.functionality.marketing.leads.LeadsLandingPage;
import com.eva.vtiger.pages.functionality.marketing.leads.LeadsListMappingLandingPage;
import com.eva.vtiger.pages.functionality.marketing.leads.MappingResultsLandingPage;
import com.vitiger.eva.pages.functionality.marketing.campaign.CampaignDetailLandingPage;
import com.vitiger.eva.pages.functionality.marketing.campaign.CampaignLandingPage;
import com.vitiger.eva.pages.functionality.marketing.campaign.CreateCampaignLandingPage;
public class TestScript extends BaseTestClass {
	private Map<String, String> mapRowData;
	private CampaignDetailLandingPage cDLP;
	@Test(dataProvider = "getValue")
	public void verifyCreateInvoice(Object objMapData) {
		webUtil.setImplicitlyWait(4);
		mapRowData = (Map<String, String>) objMapData;
		InvoiceLandingPage iNLP = hmp.goToInventoryLandingPage();
		CreateInvoiceLandingPage cILP = iNLP.clickOnInvoiceButton();
		InvoiceDetailPage iDP = cILP.saveButton(mapRowData);
		String ExpectedError = mapRowData.get("ExpextedErrorMessage ");
		String scenarioResut = mapRowData.get("Scenario");
		if (scenarioResut.equalsIgnoreCase("Invalid")) {
			webUtil.validatePopUpText(ExpectedError);
			webUtil.HandleAlertAccept();
		} else {
			webUtil.validateText(iDP.getSubject(), mapRowData.get("Subject"), "Kirana Store");
			webUtil.validateText(iDP.getCustomerNo(), mapRowData.get("CustomerNo"), "330");
			webUtil.validateText(iDP.getBillingAddress(), mapRowData.get("Bill_street"), "Mahboobpur");
		}
	}

	@Test(groups= {"Sanity"},dataProvider = "getValue")
	public void verifyCreateCampaign(Object objMapData) {
		mapRowData = (Map<String, String>) objMapData;
		CampaignLandingPage clp = hmp.gotoMarketingCampaignsLandingPage();
		CreateCampaignLandingPage cCLP = clp.clickCampaignButton();
		cDLP = cCLP.saveButton(mapRowData);
		String expectedMessage = mapRowData.get("ExpextedErrorMessage");
		String scenario = mapRowData.get("Scenario");
		if (scenario.equalsIgnoreCase("Invalid")) {
			webUtil.validatePopUpText(expectedMessage);
			webUtil.HandleAlertAccept();
		} else {
			webUtil.validateText(cDLP.getCampaignName(), mapRowData.get("CampaignName"), "Rahul");
			webUtil.validateText(cDLP.validateTargetAudience(), mapRowData.get("TargetAudience"), "Robot 2.0");
		}

	}

}
