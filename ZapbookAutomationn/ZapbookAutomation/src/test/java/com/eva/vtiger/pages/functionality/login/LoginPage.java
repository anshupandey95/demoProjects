package com.eva.vtiger.pages.functionality.login;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

import com.eva.vtiger.pages.functionality.myhomepage.home.HomePage;
import com.eva.vtiger.pages.or.login.LoginOR;
import com.org.zapbook.genericCode.WebDriverUtil;

public class LoginPage extends LoginOR {

	private WebDriverUtil WebUtil;

	public LoginPage(WebDriverUtil WebUtil) {
		this.WebUtil = WebUtil;
		PageFactory.initElements(WebUtil.getDriver(), this);
	}

//	public HomePage validLogin(Map<String, String> rowDataList) {
//		String usernameData = rowDataList.get("Username");
//		String passwordData = rowDataList.get("Password");
//		WebUtil.usingWebElementSendKeys(getUserNameEd(), usernameData, "username");
//		WebUtil.usingWebElementSendKeys(getUserPasswordEd(), passwordData, "userpassword");
//		WebUtil.usingWebElementclickMethod(getSigninBt(), "SignIn Button");
//		return new HomePage(WebUtil);
//	}

	public HomePage validLogin() {
		WebUtil.usingWebElementSendKeys(getUserNameEd(), WebUtil.getConfiValue("username"), "username");
		WebUtil.usingWebElementSendKeys(getUserPasswordEd(), WebUtil.getConfiValue("password"), "userpassword");
		WebUtil.usingWebElementclickMethod(Sign_IN, "SignIn Button");
		return new HomePage(WebUtil);
	}

	public HomePage invalidLogin() {
		WebUtil.usingWebElementSendKeys(getUserNameEd(), WebUtil.getConfiValue("invalidusername"), "username");
		WebUtil.usingWebElementSendKeys(getUserPasswordEd(), WebUtil.getConfiValue("invalidpass"), "userpassword");
		WebUtil.usingWebElementclickMethod(getSigninBt(), "SignIn Button");
		return new HomePage(WebUtil);
	}

}