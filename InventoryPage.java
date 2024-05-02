package com.org.pages;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.webutility.Generics;

public class InventoryPage {
	

	Generics util;

	public InventoryPage(Generics util) {
		this.util = util;
		PageFactory.initElements(util.getDriver(), this);
	}
	
	
	@FindBy(xpath = "//li[text()=' Inventory ']")
	WebElement InventoryTab;
	
	
	@FindBy(xpath = "(//input[@placeholder='Enter here'])[1]")
	WebElement ProductNameDetail;
	
	
	@FindBy(xpath = "(//input[@placeholder='Enter here'])[2]")
	WebElement SKU;
	
	@FindBy(xpath = "(//input[@placeholder='Enter here'])[3]")
	WebElement bBrand;
	
	@FindBy(xpath = "(//input[@placeholder='Enter here'])[4]")
	WebElement supplier;
	
	@FindBy(xpath = "(//ion-select[@placeholder='Select'])[1]")
	WebElement SizeTap;
	
	@FindBy(xpath = "//ion-label[text()=' childs large ']")
	WebElement SizeSelect;

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@FindBy(xpath = "//ion-button[@class='btn-blue-icon ios button button-solid ion-activatable ion-focusable hydrated']")
WebElement AddProduct;
	
	
	
	
	@FindBy(xpath = "//img[@class='product cursor-cls']")
	WebElement photoBT;
	
	
	
	
	
	
	public void InventoryTabClick() {
		util.usingclick(InventoryTab);
		
	}
	
	
	
	public void NewProductClickBT() {
		util.usingclick(AddProduct);
	}
	
	
	public void photoareaClick() {
		util.usingclick(photoBT);
	}
	
	public void PhotoUpload() throws AWTException, InterruptedException {
		
		
		Thread.sleep(3000);
		util.ActionPhotoUpload("C:\\Users\\Dell\\Downloads\\sample");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
