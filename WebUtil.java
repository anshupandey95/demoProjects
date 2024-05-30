package Utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

public class WebUtil {

	public ExtentTest test;
	public WebDriver driver;
	public ExtentReports report;

	public WebDriver getDriver() {

		return driver;

	}

	public String dateFormate() {
		DateFormat df = new SimpleDateFormat("dd_MMM+yyyy_HH_mm_ss_z");
		return df.format(new Date());
	}

	public ExtentTest getExtentTest() {
		return test;
	}

	public void extentReport() {

		DateFormat df = new SimpleDateFormat("mm-dd-yyyy-hh-mm-ss");
		String timeStam = df.format(new Date());
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("ExtentReport" + timeStam + ".html");

		htmlReport.config().setReportName("WoS WorkOver Solutions Test Report");
		report = new ExtentReports();

		report.attachReporter(htmlReport);

	}

	public void usingsendkeys(WebElement we, String value, String logdetai) {
		we.sendKeys(value);
		test.log(Status.INFO, logdetai + "Keys sending Done Suscessfully ");

	}

	public void actionupload(String filepath, String elementvalue) throws AWTException {

		StringSelection s = new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		test.log(Status.INFO,
				MarkupHelper.createLabel(elementvalue + "Picture uploaded suscessfully", ExtentColor.BLUE));

	}

	public void openBroswer(String browser) {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				ChromeOptions options = new ChromeOptions();

				options.addArguments("--disable-notifications");

				driver = new ChromeDriver(options);
				// driver = new ChromeDriver();

			}

			else if (browser.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();

//				test.log(Status.INFO,
//						MarkupHelper.createLabel(browser + "browser launched succesfully", ExtentColor.INDIGO));

			}
		}

		catch (Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "browser did not launch");
		}

	}

	public void openURl(String URL) {
		driver.get(URL);

		// test.log(Status.INFO, "url launched");

	}

	public void close() {
		driver.close();
		try {
			test.log(Status.INFO, "Browser closed  successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void maximize(String AnyVal) {
		try {
			driver.manage().window().maximize();
			// stest.log(Status.INFO, "window maximize successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void flush() {
		report.flush();
	}

	public void click(WebElement we, String elementName) {
		if (we.isEnabled()) {
			we.click();
			test.log(Status.INFO, MarkupHelper.createLabel(elementName + "Clicked Suscessfully", ExtentColor.PINK));

		} else {
			test.log(Status.FAIL, elementName + "not  click sucessfully");
		}
	}

	public void Status(String Verification) {
		test.log(Status.FAIL, MarkupHelper.createLabel(Verification, ExtentColor.RED));
	}

	public void StatusPass(String Verificationpass) {
		test.log(Status.FAIL, MarkupHelper.createLabel(Verificationpass, ExtentColor.GREEN));
	}

	public void mouseOver(WebElement we, String elementName) {

		Actions ac = new Actions(driver);
		if (we.isDisplayed())
			if (we.isEnabled()) {
				ac.moveToElement(we).build().perform();
				test.log(Status.INFO, elementName + "MouseOver Successfully");
			} else {
				test.log(Status.FAIL, elementName + "not mouseOver");
			}
	}

	public void actionMoveToElement(WebElement we) {

		Actions act = new Actions(driver);
		if (we.isDisplayed())
			if (we.isEnabled()) {
				act.moveToElement(we).perform();
			}
	}

	public void actionClick(WebElement we, String LogDetail) {
		try {
			new Actions(driver).click(we).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
		test.log(Status.INFO,
				MarkupHelper.createLabel(LogDetail + "Clicked suscessfully using action", ExtentColor.PINK));

	}

	public void actionSendkey(WebElement we, String elementName, String LogDetail) {
		Actions actions = new Actions(driver);

		actions.sendKeys(we, elementName).build().perform();
		test.log(Status.INFO, MarkupHelper.createLabel(LogDetail + "Keys sent suscessfully", ExtentColor.YELLOW));

	}

	public void actionDoubleClick(WebElement we, String elementName) {

		Actions act = new Actions(driver);
		if (we.isDisplayed() == true)
			if (we.isEnabled() == true) {
				act.moveToElement(we).doubleClick().build().perform();
				test.log(Status.INFO, "by action double click is successfully");
			} else {
				test.log(Status.FAIL, "by action double click is not  successfully");
			}
	}

	public void actionRightClick(WebElement we, String elementName) {

		Actions act = new Actions(driver);
		if (we.isDisplayed() == true)
			if (we.isEnabled() == true) {
				act.moveToElement(we).contextClick().build().perform();
			} else {
				test.log(Status.INFO, "by action right click is successfully");
			}
		else {
			test.log(Status.FAIL, "by action right click is not  successfully");

		}
	}

	public void dragAnddrop(String elementName, WebElement we1, WebElement we2) {

		Actions act = new Actions(driver);
		if (we1.isDisplayed() == true)
			if (we1.isEnabled() == true) {
				act.dragAndDrop(we1, we2).contextClick().build().perform();
				test.log(Status.INFO, "by action drag and drop is successfully");
			} else {
				test.log(Status.FAIL, "by action drag and drop is  not successfully");
			}
	}

	public void sendkeysNormal(WebElement we, String values, String lodetai) {
		we.clear();

		we.sendKeys(values);
		// test.log(Status.INFO, elementName + "clicked suscessfully");
		test.log(Status.INFO,
				MarkupHelper.createLabel(lodetai + "Keys sent suscessfully with normal click", ExtentColor.ORANGE));
	}

	public void implicitWait(int time) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		} catch (Exception e) {

		}

	}

	public void javaScriptSendKeys(WebElement we, String inputValue) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		we.clear();
		jse.executeScript("arguments[0].value='" + inputValue + "", we);
		System.out.println("value is Inputed successfully");

	}

	public void javascriptClick(WebElement ele, String Logdetai) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);
		test.log(Status.INFO,
				MarkupHelper.createLabel(Logdetai + "Clicked suscessfully using javascript", ExtentColor.PINK));

	}

	public void explicityWait(WebElement we, int timeInsecond) {
		if (we.isDisplayed() && we.isEnabled()) {
			WebDriverWait explicitwait = new WebDriverWait(driver, Duration.ofSeconds(timeInsecond));
			explicitwait.until(ExpectedConditions.visibilityOf(we));
			test.log(Status.INFO, "sendkey successfully");
		}
	}

	public void refreshWindow() {
		driver.navigate().refresh();
		test.log(Status.INFO, "refreshed and product verified");
	}

	public void dragAndDrop(WebElement elementForDrag, int xOff, int yOff) {
		try {
			new Actions(driver).dragAndDropBy(elementForDrag, xOff, yOff).build().perform();
			test.log(Status.INFO, "item Dragged Done ");
		} catch (Exception e) {
			e.printStackTrace();

		} finally {

		}

	}

	public void createTestCase(String teatCaseName) {
		test = report.createTest(teatCaseName);
	}

	public void actionScroll(WebElement element, String elementName) {
		try {
			new Actions(driver).scrollToElement(element).build().perform();
			test.log(Status.INFO, "page scroll to the" + elementName + " successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void scrollDownToPAge() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void javaScrollToElement(WebElement element, String scrollButtonlog) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
			test.log(Status.INFO,
					MarkupHelper.createLabel("Scrolling Achieved upto" + scrollButtonlog, ExtentColor.BROWN));

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void testCaseId(String testCaseName) {
		test = report.createTest(testCaseName);
		test.log(Status.INFO, MarkupHelper.createLabel(testCaseName + "generate successfully", ExtentColor.GREEN));
	}

	public void capturedScreen(String trestname) throws IOException {
		TakesScreenshot screening = ((TakesScreenshot) driver);
		File src = screening.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "//ScreenShots//" + trestname + ".png");
		FileUtils.copyFile(src, dest);

	}

	public ExtentTest SnapShot(String fileName) {
		TakesScreenshot tscreen = (TakesScreenshot) driver;
		File files = tscreen.getScreenshotAs(OutputType.FILE);

		File file = new File(fileName + "SnapShot.png");
		try {
			Files.copy(files, file);
			test.log(Status.INFO,
					MarkupHelper.createLabel("Takes ScreenShot is performed succesfully ", ExtentColor.GREY));
		} catch (IOException e) {
			test.log(Status.INFO,
					MarkupHelper.createLabel("Takes ScreenShot isn't performed succesfully ", ExtentColor.RED));
			e.printStackTrace();
		}
		return test.addScreenCaptureFromPath(file.getAbsolutePath());
	}

	public void clickWhenEnabled(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		if (ele.isEnabled()) {
			ele.click();
		} else {
			throw new RuntimeException("Element is not enabled.");
		}

	}

	public Set<String> GetWindowHandles() {
		return driver.getWindowHandles();
	}

	public void scrollDownjava() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	// Function to scroll up the page
	public static void scrollUp(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0)");
	}

	public void JavaRefresh() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		// Refresh the page using JavaScript
		jsExecutor.executeScript("history.go(0)");
	}

	public String generateEmailId() {
		return (RandomStringUtils.randomAlphabetic(5));
	}

	public void acceptalert() {
		// driver.switchTo().alert().dismiss();
		Alert alert = driver.switchTo().alert();
		alert.dismiss();

	}

	public void ActionDismissAlert() {
		Actions ac = new Actions(driver);
		// ac.sendKeys(Keys.ESCAPE).build().perform();
		ac.sendKeys("\ue00c").perform();
	}

	public void javaDismiss() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("return document.dispatchEvent(new KeyboardEvent('keydown', {key: 'Escape'}));");

	}
	// driver.execute_script("return document.dispatchEvent(new
	// KeyboardEvent('keydown', {key: 'Escape'}));")

///////////////////////////////////////////////////////////////////////////////////

	public WebElement editBt() throws InterruptedException {

		// This Element is inside single shadow DOM.
		String cssSelectorForHost1 = "body > app-root:nth-child(1) > ion-app:nth-child(1) > ion-split-pane:nth-child(1) > ion-router-outlet:nth-child(2) > app-profile:nth-child(2) > ion-content:nth-child(2) > div:nth-child(1) > ion-grid:nth-child(2) > ion-row:nth-child(1) > ion-col:nth-child(1) > ion-row:nth-child(1) > ion-col:nth-child(1) > ion-card:nth-child(1) > ion-card-content:nth-child(1) > ion-button:nth-child(9)";
		Thread.sleep(1000);
		SearchContext shadow = driver.findElement(By.cssSelector(
				"body > app-root:nth-child(1) > ion-app:nth-child(1) > ion-split-pane:nth-child(1) > ion-router-outlet:nth-child(2) > app-profile:nth-child(2) > ion-content:nth-child(2) > div:nth-child(1) > ion-grid:nth-child(2) > ion-row:nth-child(1) > ion-col:nth-child(1) > ion-row:nth-child(1) > ion-col:nth-child(1) > ion-card:nth-child(1) > ion-card-content:nth-child(1) > ion-button:nth-child(9)"))
				.getShadowRoot();
		Thread.sleep(1000);
		WebElement ele = shadow.findElement(By.cssSelector(".button-inner"));
		return ele;

	}
	public int gettextwidth(WebElement ele, String texxt) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        return ((Number) js.executeScript(
                "var span = document.createElement('span');" +
                "span.textContent = arguments[0];" +
                "span.style.visibility = 'hidden';" +
                "span.style.whiteSpace = 'nowrap';" +
                "document.body.appendChild(span);" +
                "var width = span.offsetWidth;" +
                "document.body.removeChild(span);" +
                "return width;", texxt)).intValue();
	}

	
        
        
}


