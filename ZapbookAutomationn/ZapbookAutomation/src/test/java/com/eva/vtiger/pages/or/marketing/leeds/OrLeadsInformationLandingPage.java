package com.eva.vtiger.pages.or.marketing.leeds;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.org.zapbook.genericCode.WebDriverUtil;

public class OrLeadsInformationLandingPage {


	@FindBy(xpath = "//td[@class='dvtSelectedCell']")
	protected WebElement LeadInformationtxt;

	@FindBy(xpath = "//span[@id='dtlview_Company']")
	protected WebElement ExpertViewAutomation;

	 
}
