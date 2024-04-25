package com.eva.vtiger.pages.or.myhomepage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.org.zapbook.genericCode.WebDriverUtil;

import com.evs.vtiger.functionality.reusablecodepage.ReusableCommanCodevtigerDependentBasePage;

public class OrValidateHomepahe extends ReusableCommanCodevtigerDependentBasePage {

	public OrValidateHomepahe(WebDriverUtil webUtil) {
		super(webUtil);
	}

	@FindBy(xpath = "//a[text()='Raman']")
	protected WebElement ramanClick;

	 
}
