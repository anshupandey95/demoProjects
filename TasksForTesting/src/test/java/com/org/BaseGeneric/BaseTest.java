package com.org.BaseGeneric;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.org.pages.LoginPage;
import com.org.webutility.Generics;

//@Listeners(com.org.webutility.ExtendListen.class)
public class BaseTest {

	public Generics util;

	public WebDriver driver;

	@BeforeClass
	public void Setup() throws InterruptedException {
		util = new Generics();

		util.browserLaunch("chrome");

		util.openurl("https://app.zap.betaplanets.com");
		util.maximize();
		util.implicitWait(10);

		Thread.sleep(2000);

		LoginPage Log = new LoginPage(util);
		Log.Logname();
		Thread.sleep(2000);
		Log.logpass();
		// util.enableElement(null);
		Thread.sleep(1000);
		Log.submit();

	}

//	@BeforeTest
//	public void ReportAssign() {
//		util = new Generics();
//		util.extentReport();
//	}

//	@BeforeMethod
//	public void startFromLogin(Method m) {
//		int i =0;
//		System.out.println(++i);
//		String st = m.getName();
//		util.testCaseID(st);
//		
//	}
//
//	@AfterTest
//	public void reportFlush() {
//
//		util.flushingg();
//	}

}
