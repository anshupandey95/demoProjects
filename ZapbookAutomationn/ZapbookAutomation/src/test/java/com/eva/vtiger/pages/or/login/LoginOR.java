package com.eva.vtiger.pages.or.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Factory;

public class LoginOR {

	@FindBy(xpath = "//input[@placeholder='Enter email']")
	private WebElement SignIN_eamil;

	@FindBy(xpath = "//input[@placeholder='Enter password']")
	private WebElement User_Pass;

	@FindBy(xpath = "//ion-button['SIGN IN']")
	protected WebElement Sign_IN;

	@FindBy(xpath = "//ion-button[@class='hidden-mobile md button button-clear in-toolbar ion-activatable ion-focusable hydrated']//ion-icon[@name='log-out-outline']")
	private WebElement log;

	@FindBy(xpath = "//button[@class='alert-button ion-focusable ion-activatable sc-ion-alert-ios']")
	private WebElement logout;

	
    @FindBy(xpath = "//ion-buttons[@class='buttons-last-slot sc-ion-buttons-md-h sc-ion-buttons-md-s md hydrated']//ion-button[4]")
    private WebElement signIn_out;
    
    
    
	public WebElement getUserNameEd() {
		return SignIN_eamil;
	}

	public WebElement getUserPasswordEd() {
		return User_Pass;
	}

	public WebElement getSigninBt() {
		return Sign_IN;

	}
}
