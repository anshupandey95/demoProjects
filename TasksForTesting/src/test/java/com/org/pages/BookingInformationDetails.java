package com.org.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.webutility.Generics;

public class BookingInformationDetails {
	Generics util;
	public BookingInformationDetails(Generics util) {
		this.util = util;
		PageFactory.initElements(util.getDriver(), this);
	}
	
	@FindBy(xpath  = "//ion-input[@formcontrolname='first_name']")
	protected WebElement firstname;

	@FindBy(xpath = "//ion-input[@formcontrolname='last_name']")
	protected WebElement lastname;

	@FindBy(xpath = "//ion-input[@formcontrolname='email']")
	protected WebElement emailBT;

	@FindBy(xpath = "//ion-input[@formcontrolname='phone']")
	protected WebElement phoneBT;

	@FindBy(xpath = "//ion-checkbox[@role='checkbox']")
	protected WebElement checkBox;

	@FindBy(xpath = "//div[@class='textarea-wrapper sc-ion-textarea-ios']")
	protected WebElement Note_Box;
	@FindBy(xpath = "//ion-textarea[@formcontrolname='notes']")
	protected WebElement notesssss;
	
	
	@FindBy(xpath = "(//ion-checkbox[@role='checkbox'])[3]")
	protected WebElement checkboxxxxxx;
	
	
	@FindBy(xpath = "//ion-button[contains(text(),' Pay Deposit')]")
	protected WebElement paydeposittt;
	
	
	@FindBy(xpath = "//ion-button[@class='reserve ios button button-round button-solid ion-activatable ion-focusable hydrated']")
	protected WebElement reserve;
	
	
	//ion-button[@class='reserve ios button button-round button-solid ion-activatable ion-focusable hydrated']
	//ion-textarea[@formcontrolname='notes']
	
	
	public void FirstName() {
		util.javascriptsendKeys(firstname, "Ayush");
	}
	
	
	public void Lastname() {
		util.javascriptsendKeys(lastname, "Fedric");
	}
	
	public void email() {
		util.javascriptsendKeys(emailBT, "fredric@gmail.com");;
	}
	
	
	public void notesssss() {
		util.javascriptsendKeys(notesssss, "He is a great player mind it");;
	}
	
	
	public void phonee() {
		util.javascriptsendKeys(phoneBT, "(345) 263-4561");
	}
	
	
	public void check() {
		util.actionClick(checkboxxxxxx);
		
	}
	public void reserve() {
		util.usingclick(reserve);
		
	}
	
	
	
//	public void sendnotes(String notes) {
//		ut.actionClick(Note_Box, notes);
//		ut.javascriptSendKeysMethord(Note_Box, notes);
//		
//		
//		
//	}
//	public void scrolltonotes() {
//		ut.javascriptScrollToSpecificElement(Note_Box);
//	}
	
	
	
	public void depos() {
	
		
		
		
		util.javascriptClick(paydeposittt);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
