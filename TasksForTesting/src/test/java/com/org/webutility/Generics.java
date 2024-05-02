package com.org.webutility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Generics {
	public WebDriver driver;
	public Generics util;

	// public static ExtentReports rport;

	// public static ExtentTest test;

	public WebDriver getDriver() {
		return driver;
	}
	
	
//	public void extentReport() {
//		DateFormat df = new SimpleDateFormat("mm-dd-yyyy-hh-mm-ss");
//		String timestamp = df.format(new Date());
//		ExtentSparkReporter html = new ExtentSparkReporter("ExtentReport" + timestamp + ".html");
//		rport = new ExtentReports();
//		rport.attachReporter(html);
//
//	}

//	public ExtentTest getExtentTest() {
//		return test;
//
//	}

//	public void flushingg() {
//		rport.flush();
//	}

//	public void genrateReport(String fileNameOfExtendeport) {
//		String time = Dateformate();
//		ExtentSparkReporter sperobj = new ExtentSparkReporter("Automation\\" + fileNameOfExtendeport + time + ".html");
//		rport = new ExtentReports();
//		rport.attachReporter(sperobj);
//	}

	public String Dateformate() {
		DateFormat date = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss");
		return date.format(new Date());

	}

	public void browserLaunch(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			// test.log(Status.INFO, "browser launched");
			// test.log(Status.INFO, "browser is launched successfully");
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();

		}
		// test.log(Status.INFO, MarkupHelper.createLabel(browser, ExtentColor.ORANGE));
	}

	public void javascriptClick(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);

	}

	public void javascriptsendKeys(WebElement ele, String entertext) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

	}

	public void shadowextract(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

	}

	public void openurl(String URL) {
		driver.get(URL);
	}

	public void actionClick(WebElement ele) {
		Actions ac = new Actions(driver);
		ac.click(ele).build().perform();

	}

	public void dragAndDrop(WebElement elementForDrag, int xOff, int yOff) {
		try {
			new Actions(driver).dragAndDropBy(elementForDrag, xOff, yOff).build().perform();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {

		}

	}

	public void implicitWait(int time) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));

	}

	public void maximize() {
		try {
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {

		}

	}

	public void enableElement(WebElement ele) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('disabled');", ele);
	}

	public void usingsendkeys(WebElement we, String value) {
		we.sendKeys(value);

	}

	public void usingclick(WebElement we) {
		we.click();
	}

	public WebElement ScrollToUserAndClick(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'auto', block: 'center', inline: 'center' });", ele);
		//js.executeAsyncScript("arguments[0].scrollIntoView({behaviour: 'auto, block:'center,inline: 'center'});", ele);
		return ele;
	}

	public void actionToUserAndClick(WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();

	}

	public WebElement newdating() throws InterruptedException {
		// This Element is inside single shadow DOM.
		String cssSelectorForHost1 = "#datetime";
		Thread.sleep(1000);
		SearchContext shadow = driver.findElement(By.cssSelector("#datetime")).getShadowRoot();
		Thread.sleep(1000);
		WebElement eleee = shadow.findElement(By.cssSelector("button[aria-label='Tuesday, April 2']"));
		eleee.click();
		return eleee;
	}

	public WebElement nextdate() throws InterruptedException {

		String cssSelectorForHost1 = "#datetime";
		String cssSelectorForHost2 = " div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > ion-buttons:nth-child(1) > ion-button:nth-child(2)";
		Thread.sleep(1000);
		SearchContext shadow0 = driver.findElement(By.cssSelector("#datetime")).getShadowRoot();
		Thread.sleep(1000);
		SearchContext shadow1 = shadow0.findElement(By.cssSelector(
				" div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > ion-buttons:nth-child(1) > ion-button:nth-child(2)"))
				.getShadowRoot();
		Thread.sleep(1000);
		WebElement ede = shadow1.findElement(By.cssSelector(".button-inner"));
		return ede;
	}

	public void newtab() {

		org.openqa.selenium.JavascriptExecutor j = (org.openqa.selenium.JavascriptExecutor) util.getDriver();
		// j.executeScript("window.open();");
		j.executeScript("window.open(); ");

	}

	public void webdriverwaiting(WebElement ele, int timein) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timein));
		wait.until(ExpectedConditions.visibilityOf(ele));

	}

	public void actionupload(String filepath) throws AWTException {

		StringSelection s = new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
	}

	public void javascriptscrollnormal(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);

	}

	public WebElement clickslider() throws InterruptedException {

		String cssSelectorForHost1 = "#ion-r-1";
		Thread.sleep(1000);
		SearchContext shadow = driver.findElement(By.cssSelector("#ion-r-1")).getShadowRoot();
		Thread.sleep(1000);
		WebElement al = shadow.findElement(
				By.cssSelector(".range-knob-handle.range-knob-a.ion-activatable.ion-focusable.range-knob-min"));

		return al;

	}
	
	
	
	
	public WebElement nextbuttonsc() throws InterruptedException {
		String cssSelectorForHost1 = "#datetime";
		String cssSelectorForHost2 = " div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > ion-buttons:nth-child(1) > ion-button:nth-child(2)";
		Thread.sleep(1000);
		SearchContext shadow0 = driver.findElement(By.cssSelector("#datetime")).getShadowRoot();
		Thread.sleep(1000);
		SearchContext shadow1 = shadow0.findElement(By.cssSelector(" div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > ion-buttons:nth-child(1) > ion-button:nth-child(2)")).getShadowRoot();
		Thread.sleep(1000);
		
		 WebElement ee =   shadow1.findElement(By.cssSelector(".button-native"));
		 return ee;
	}
	
	
	
	public WebElement Five() throws InterruptedException {
		
		
		
		
		
		
		
		//This Element is inside single shadow DOM.
		String cssSelectorForHost1 = "#datetime";
		Thread.sleep(1000);
		SearchContext shadow = driver.findElement(By.cssSelector("#datetime")).getShadowRoot();
		Thread.sleep(1000);
		WebElement fivedate=  shadow.findElement(By.cssSelector(" div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > button:nth-child(11) > div:nth-child(1)"));
		return fivedate;
//		String cssSelectorForHost1 = "#datetime";
//		Thread.sleep(1000);
//		SearchContext shadow = driver.findElement(By.cssSelector("#datetime")).getShadowRoot();
//		Thread.sleep(1000);
//		 WebElement fivedate =   shadow.findElement(By.cssSelector(".calendar-day.calendar-day-active"));
//		 return fivedate;
	}
	
	
	public WebElement fulldates() throws InterruptedException {
		
		String cssSelectorForHost1 = "#datetime";
		Thread.sleep(1000);
		SearchContext shadow = driver.findElement(By.cssSelector("#datetime")).getShadowRoot();
		Thread.sleep(1000);
		WebElement eleee  = shadow.findElement(By.cssSelector(" div:nth-child(1) > div:nth-child(2) > div:nth-child(2)"));
		return eleee;
	}
}


