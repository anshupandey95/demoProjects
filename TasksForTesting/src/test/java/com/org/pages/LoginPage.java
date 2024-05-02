package com.org.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.webutility.Generics;

public class LoginPage {

	Generics util;

	public LoginPage(Generics util) {
		this.util = util;
		PageFactory.initElements(util.getDriver(), this);
	}

	@FindBy(xpath = "(//input[@class='native-input sc-ion-input-ios'])[1]")
	WebElement logName;
	@FindBy(xpath = "(//input[@class='native-input sc-ion-input-ios'])[2]")
	WebElement logpassword;

	@FindBy(xpath = "//ion-button[@type='submit']")
	WebElement sub;

	@FindBy(xpath = "//ion-button[@class='btn-blue-icon ios button button-solid ion-activatable ion-focusable hydrated']")
	WebElement bookButton;

	public void Logname() {
		util.usingsendkeys(logName, "user2@knoxweb.com");

	}

	public void logpass() {
		util.usingsendkeys(logpassword, "sR@123456");

	}

	public void submit() {
		// util.enableElement(sub);

		util.javascriptClick(sub);
		// ut.javascriptClickMethord(sub);

		// ion-button[@type='submit']
	}

	public void bookingbuttonClick() {

		bookButton.click();
		// ut.javascriptClickMethord(sub);

		// ion-button[@type='submit']
	}

}
