package com.eva.vtiger.pages.functionality.myhomepage.home;

import org.openqa.selenium.support.PageFactory;

import com.eva.vtiger.pages.or.myhomepage.OrValidateHomepahe;
import com.org.zapbook.genericCode.WebDriverUtil;

public class ValidationHomePage extends OrValidateHomepahe {

	private WebDriverUtil webUtil;

	public ValidationHomePage(WebDriverUtil webUtil) {
		super(webUtil);
		this.webUtil = webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);

	}
	public void validateFirstName() {
		webUtil.validateText(ramanClick, "Raman", "Raman ");

	}
}
