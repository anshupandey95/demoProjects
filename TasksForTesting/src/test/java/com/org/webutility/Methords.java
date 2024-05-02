package com.org.webutility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Methords {
	public WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
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
	
	
	
	
	public void browserLaunch(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			// test.log(Status.INFO, "browser launched");
			// test.log(Status.INFO, "browser is launched successfully");
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();

		}
		
	}
	
	
	
	public void javascriptClick(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);

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
	
	
	public WebElement ScrollToUserAndClick(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'auto', block: 'center', inline: 'center' });", ele);
		//js.executeAsyncScript("arguments[0].scrollIntoView({behaviour: 'auto, block:'center,inline: 'center'});", ele);
		return ele;
	}
	
	
	
	public void actionToUserAndClick(WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();

	}Actions action = new Actions(util.getDriver());
	
	action.moveToElement(date, 900, 0).click().build().perform();
	//Thread.sleep(3000);
	
	
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
	
	
	public void actionSendkey(WebElement we, String elementName, String textBoxValue) {
		try {
			new Actions(driver).sendKeys(we).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

	}
	
	
	
	public void actionScrollPage(WebElement we, String elementName) {
		Actions act = new Actions(driver);
		if (we.isDisplayed() == true) {
			if (we.isEnabled() == true) {
				act.scrollToElement(we).build().perform();
				
			} else {
				
			}
		}

	}
	
	
	 public void javascriptScrollToSpecificElement(WebElement element) {
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
	 }
	 
	 
	 
	 public  void javascriptSendKeysMethord( WebElement element, String text) {
	        // Cast WebDriver to JavascriptExecutor
	        JavascriptExecutor js = (JavascriptExecutor) driver;

	        // Execute JavaScript code to set the value of the element
	        js.executeScript("arguments[0].value = arguments[1];", element, text);
	    }
	 
	 
	 
	 public  void javascriptrefreshPageMethord() {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        // Execute JavaScript code to refresh the page
	        js.executeScript("location.reload();");
	    }
	
	
	
	


}
