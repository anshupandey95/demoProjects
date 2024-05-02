package com.org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.webutility.Generics;


public class newBookingPage {
	
	
	Generics util;
	
	public newBookingPage(Generics util) {
		this.util = util;
		PageFactory.initElements(util.getDriver(), this);
	}
	
	
	
	
	@FindBy(css = ".range-knob-handle.range-knob-a.ion-activatable.ion-focusable.range-knob-min")
	WebElement jaiho;
	
	
	
	
	
	
	@FindBy(xpath = "(//ion-select[@placeholder='Select'])[1]")
	WebElement location;
	@FindBy(xpath = "//ion-label[text()=' Millvale ']")
	WebElement locSelect;

	@FindBy(xpath = "(//ion-select[@placeholder='Select'])[2]")
	WebElement experience;
	@FindBy(xpath = "//ion-label[text()='Large Event']")
	WebElement exselect;
	@FindBy(xpath = "//input[@min='2024-05-02']")
	WebElement date;
	@FindBy(xpath = "//ion-select[@aria-label='Select time']")
	WebElement time;

	@FindBy(xpath = "//ion-radio[@role='radio']")
	WebElement selecttime;

	@FindBy(xpath = "(//ion-select[@placeholder='Select'])[3]")
	WebElement saleorigin;

	@FindBy(xpath = "(//ion-radio[@role='radio'])[2]")
	WebElement originselect;
	
	
	//ion-label[text()='Phone call']

	@FindBy(xpath = "//ion-button[@type='button']")
	WebElement continuee;

	@FindBy(xpath = "//ion-range[@id='ion-r-1']")
	private WebElement slider;
	
	@FindBy(xpath = "//ion-button[@class='ios button button-round button-solid ion-activatable ion-focusable hydrated']")
	private WebElement continueee;
	
	
	@FindBy(xpath = "//ion-range[@class='ios in-item hydrated ng-dirty ng-valid ng-touched ion-dirty ion-valid ion-touched']")
	WebElement locarea;
	
	//ion-button[text()=' Continue']
	
	public void clickLocation() {
		location.click();
	}

	public void selectLocation() {
		util.actionClick(locSelect);
	}

	public void experie() {
		experience.click();
	}

	public void expeSelect() {
		util.actionClick(exselect);
	}

	public void Slider() {
		
		util.actionClick(jaiho);
		util.dragAndDrop(jaiho, 1200, 0);
//		util.actionClick(slider);
		//util.dragAndDrop(slider, 2, 5, "s");
	}
	
	
	public Point sliderLocandAll() {
		Point xyLoc = slider.getLocation();
		return xyLoc;
		
		
		
		
	}
	public WebElement cc() throws InterruptedException {
		WebElement em = util.clickslider();
		return em;
		
	}
	
	
	
	
	
	public void sliii() throws InterruptedException {
		
		WebElement elee = util.clickslider();
		util.dragAndDrop(elee, 5, 5);
		
		
		
	}
	
	public void slidertest() {
		
		
		Actions ac = new Actions(util.getDriver());
		ac.dragAndDropBy(slider, 1200, 0).build().perform();
		
	}
	
	public Point locareaaa() {
		
		Point loctiareas = locarea.getLocation();
		return loctiareas;
	}

	public void datee() throws InterruptedException {
		
		//date.click();
    //util.usingsendkeys(date,  "02-05-2024");
	}
	
	public Dimension DateLoc() {
		Dimension Chaudayi = date.getSize();
		
		
		return Chaudayi;
	}
	
	public Point XY() {
		Point XYLoc = date.getLocation();
		return XYLoc;
	}

	public void timeclick() throws InterruptedException {
		Thread.sleep(5000);
		time.click();
	}

	public void timeselectt() throws InterruptedException {
		Thread.sleep(4000);
		selecttime.click();
	}

	public void origin() {
		saleorigin.click();
	}

	public void originselect() {
		originselect.click();
	}

	public void conti() throws InterruptedException {
		Thread.sleep(2000);
		util.actionClick(continuee);
	}
	
	
	public void continueeTonextPage() {
		util.usingclick(continueee);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
