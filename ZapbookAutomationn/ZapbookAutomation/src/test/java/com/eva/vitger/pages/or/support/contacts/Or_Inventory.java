package com.eva.vitger.pages.or.support.contacts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Or_Inventory {

	@FindBy(xpath = "//li[normalize-space()='Inventory']")
	protected WebElement inventry;

	@FindBy(xpath = "//ion-button[normalize-space()='New Product']")
	protected WebElement newproduct;

	@FindBy(xpath = "//input[@name='ion-input-3']")
	protected WebElement productname;

	@FindBy(xpath = "//input[@name='ion-input-4']")
	protected WebElement skuText;

	@FindBy(xpath = "//input[@name='ion-input-5']")
	protected WebElement brandln;

	@FindBy(xpath = "//input[@name='ion-input-6']")
	protected WebElement supplierLn;

	@FindBy(xpath = "//ion-select[@aria-haspopup='listbox'][4]")
	protected WebElement size_ln;

	@FindBy(xpath = "//ion-labessl[@id='ion-rb-0-lbl']")
	protected WebElement ChiledSmall_Ln;

	@FindBy(xpath = "//ion-select[@formcontrolname='category_id']")
	protected WebElement category_ln;

	@FindBy(xpath = "//ion-radio[@role='radio']")
	protected WebElement system_ln;

	@FindBy(xpath = "//ion-input[@formcontrolname='retail_price']")
	protected WebElement retail_price;

	@FindBy(xpath = "//ion-input[@formcontrolname='purchase_price']")
	protected WebElement purchase_price;

	@FindBy(xpath = "//ion-input[@formcontrolname='stock']")
	protected WebElement Stock_ln;

	@FindBy(xpath = "//input[@name='ion-input-24']")
	protected WebElement lowstock;

	@FindBy(xpath = "//textarea[@name='ion-textarea-3']")
	protected WebElement textbox;

	public WebElement getProductName() {
		return productname;
	}

	public WebElement getSKU() {
		return skuText;
	}

	public WebElement getBrand() {
		return brandln;

	}

	public WebElement getSupplier() {
		return supplierLn;
	}

	public WebElement getRetailprice() {
		return retail_price;
	}

}
