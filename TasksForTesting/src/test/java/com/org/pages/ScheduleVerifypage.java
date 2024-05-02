package com.org.pages;

import java.util.List;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.org.webutility.Generics;

public class ScheduleVerifypage {
	Generics util;

	public ScheduleVerifypage(Generics util) {
		this.util = util;
		PageFactory.initElements(util.getDriver(), this);

	}

	@FindBy(xpath = "//ion-datetime-button[@datetime='datetime']")
	WebElement scheduleDateClick;
	

	@FindBy(xpath = "//li[text()=' Schedule ']")
	WebElement schedulenav;
	
	@FindBy(xpath = "//ion-datetime-button[@class='custom-date-picker ion-color ion-color-primary ios hydrated']")
	WebElement dateoptions;
	@FindBy(xpath = "//a[@class='fc-event fc-event-draggable fc-event-resizable fc-event-start fc-event-end fc-event-future fc-timeline-event fc-h-event']")
	WebElement schedulesThatareBooke;
	

	public void schrdulebutton() {
		util.javascriptClick(schedulenav);
	}

	public void schedulenextdateclickshadow() throws InterruptedException {
		WebElement aa = util.nextbuttonsc();
		aa.click();
		

	}
	
	public void dateoptionsclick() {
		dateoptions.click();
		
	}
	
	public void fivedateclick() throws InterruptedException {
		WebElement ee = util.Five();
		
		util.javascriptClick(ee);
	}
	
	
	public String schedulText() {
		String scheduleDetailsText = schedulesThatareBooke.getText();
		return scheduleDetailsText;
	}
	
	public void fullll() throws InterruptedException {
		
		
		
		
	}
	

	/////////////////////////////////////// ayush//////////////////////

//
//	@FindBy(xpath = "//ion-datetime-button[@class='custom-date-picker ion-color ion-color-primary ios hydrated']")
//	WebElement date;
//	
//	
//	
//	@FindBy(css =  "button[aria-label='Sunday, April 7']")
//	WebElement assign_2;
//	
//	
//	
//	@FindBy(css = "#datetime")
//	WebElement dateAssign;
//	
//	@FindBy(xpath = "//div[@class='fc-event-main']")
//	WebElement slideToUser;

//
//	public void date() {
//		util.usingclick(date);
//
//	}
////	public void shadow(WebElement we, WebElement we) {
////		
////	}
//	
//	public void DateSelect() throws InterruptedException {
//		
//		 WebElement ele = util.newdating();
//		 ele.click();
////		Thread.sleep(1000);
////		SearchContext shadow = dateAssign.getShadowRoot();
////		Thread.sleep(1000);
////		WebElement  ele = shadow.findElement(By.cssSelector("button[aria-label='Sunday, April 7']"));
////		util.javascriptClick(ele);
//		
//	}
//	
//	public void user() {
//		
//		util.actionToUserAndClick(slideToUser);
////		 WebElement ele = util.ScrollToUserAndClick(slideToUser);
////		 ele.click();
//	}
//	
//	
//	public void nextingdating() throws InterruptedException {
//		WebElement ele = util.nextdate();
//		ele.click();
//	}
//	

}
