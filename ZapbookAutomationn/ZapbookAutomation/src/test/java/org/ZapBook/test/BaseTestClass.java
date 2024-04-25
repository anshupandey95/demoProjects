package org.ZapBook.test;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.eva.vtiger.pages.functionality.login.LoginPage;
import com.eva.vtiger.pages.functionality.myhomepage.home.HomePage;
import com.org.zapbook.genericCode.WebDriverUtil;

public class BaseTestClass {

	protected com.org.zapbook.genericCode.WebDriverUtil webUtil;
	protected HomePage hmp;
	protected List<Map<String, String>> listTestdata;
	protected Object[][] dataTwoDArr;

	@BeforeTest(alwaysRun = true)
	public void generateExtentReport() {
		webUtil = new WebDriverUtil();
		webUtil.extentReport();
	}

	@AfterTest(alwaysRun = true)
	public void flushed() {

	}

	@BeforeClass(alwaysRun = true)
	public void launchBrowser() {
		webUtil.testCaseId("browser Launched");
		webUtil.launchBrower(webUtil.getConfiValue("browser"));
		webUtil.hitUrl(webUtil.getConfiValue("url"));
		webUtil.maximizeWindow();
	}

	@AfterClass(alwaysRun = true)
	public void closeTheBrowser() {
		// webUtil.close();
	}

//	@DataProvider
//	public Object[][] getValue(Method m) {
//		String st = m.getName();
//		listTestdata = ExcelDataUtil.getAllDataFromExcel("ExcelData\\ReadData.xlsx", st);
//		Object[][] dataTwoDArr = new Object[listTestdata.size()][1];
//		for (int i = 0; i < listTestdata.size(); i++) {
//			Object objmap = listTestdata.get(i);
//			dataTwoDArr[i][0] = objmap;
//
//		}
//		return dataTwoDArr;
//	}
//
	@BeforeMethod(alwaysRun = true)
	public void startFromLogin(Method m) throws InterruptedException {
		int i = 0;
		System.out.println(++i);

		String st = m.getName();
		webUtil.testCaseId(st);
		LoginPage loginObj = new LoginPage(webUtil);
		hmp = loginObj.validLogin();

	}

	@AfterMethod(alwaysRun = true)
	public void logout(ITestResult i) {
		int status = i.getStatus();
		if (status == ITestResult.FAILURE) {
			webUtil.SnapShot("ScreenShot");
		}
		//hmp.signOut();
		webUtil.flushed();

	}

}
