package TestRunner;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Utility.WebUtil;
import WOSPages.LoginPage;

public class BaseTest {
	public WebUtil ut ;
	public ExtentTest test;
	public WebDriver driver;
	public ExtentReports report;
	public LoginPage l;
	
	

	@BeforeTest
	public void getExtendreport() throws InterruptedException {
		ut = new WebUtil();

		ut.extentReport();

		System.out.println("beforeTest");
		
		


	}

	@BeforeClass
	public void initDriver() throws InterruptedException {
	
		System.out.println("Beforeclass");
	
	}

	@BeforeMethod
	public void Stratfromlogin(Method m) throws InterruptedException {
		
		
		
		

		int i = 0;
		System.out.println(++i);
		String st = m.getName();
		ut.testCaseId(st);
		
		l = new LoginPage(ut);
		
		System.out.println("BeforeMethod");
        ut.openBroswer("chrome");
        ut.maximize("Browser maximized");
        ut.implicitWait(10);
        ut.openURl("https://app.workover.betaplanets.com/#/login");
        ut.implicitWait(10);

        
        l = new LoginPage(ut);
        l.withoutlogUser();
        Thread.sleep(2000);
        l.withouLogsetpass();
        l.withouLogclicksubmitsignin();

		

	}

	@AfterMethod
	public void logout(ITestResult i) throws IOException {
		int status = i.getStatus();
		if (status == ITestResult.FAILURE) {
			ut.getExtentTest().log(Status.FAIL, MarkupHelper.createLabel("The Test Case Failed", ExtentColor.RED));
			ut.SnapShot("MyShots");

		}

		ut.flush();
	}
	
	
	 
	
	
	
	
	
	
	
	
	
}
