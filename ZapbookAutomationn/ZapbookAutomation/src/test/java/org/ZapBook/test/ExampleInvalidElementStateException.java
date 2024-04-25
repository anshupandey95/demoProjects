package org.ZapBook.test;



	
	import org.openqa.selenium.By;
	import org.openqa.selenium.InvalidElementStateException;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class ExampleInvalidElementStateException {
	    public static void main(String[] args) {
	        System.setProperty("webdriver.chrome.driver", "");

	        WebDriver driver = new ChromeDriver();
	        driver.get("https://example.com");

	        try {
	            WebElement element = driver.findElement(By.id("someElementId"));
	            // Trying to click on the element
	            element.click();
	        } catch (InvalidElementStateException e) {
	            System.out.println("InvalidElementStateException: " + e.getMessage());
	            // Handle the exception as needed
	        } finally {
	            driver.quit();
	        }
	    }
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	