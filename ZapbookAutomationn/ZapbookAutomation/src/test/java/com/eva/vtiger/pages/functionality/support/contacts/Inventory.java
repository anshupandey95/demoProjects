package com.eva.vtiger.pages.functionality.support.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.eva.vitger.pages.or.support.contacts.Or_Inventory;
import com.org.zapbook.genericCode.WebDriverUtil;

public class Inventory extends Or_Inventory {
	private WebDriverUtil webUtil;

	public Inventory(WebDriverUtil webUtil) {
		this.webUtil = webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);

	}

	public void CreateNewProduct() throws InterruptedException {
		webUtil.waitForElementEnabled(inventry, 4000);
		webUtil.usingWebElementclickMethod(inventry, "inventorylist ");
		Thread.sleep(3000);
		webUtil.usingWebElementclickMethod(newproduct, "newProductButton");
		Thread.sleep(7000);
		webUtil.usingWebElementSendKeys(getProductName(), webUtil.getConfiValue("productname"), "ProductName");
		webUtil.usingWebElementSendKeys(getSKU(), webUtil.getConfiValue("SKU"), "skuText");
		webUtil.usingWebElementSendKeys(getBrand(), webUtil.getConfiValue("Brand"), "brandln");
		webUtil.usingWebElementSendKeys(getSupplier(), webUtil.getConfiValue("Supplier"), "supplierLn");
		webUtil.usingWebElementclickMethod(category_ln, "Category");
		Thread.sleep(3000);
		webUtil.usingWebElementclickMethod(system_ln, "systemln");

		webUtil.waitForElementVisibility(By.xpath("//ion-input[@formcontrolname='retail_price']"), 10);
		try {
			webUtil.waitForElementVisibility(By.xpath("//ion-input[@formcontrolname='retail_price']"), 10);

			Thread.sleep(3000);
			webUtil.usingWebElementSendKeys(retail_price, "465", "reatil");

			webUtil.usingWebElementclickMethod(purchase_price, "purchase");
			Thread.sleep(3000);
			webUtil.actionsSendkeysMethod(purchase_price, "500", "purchase");

			Thread.sleep(5000);
			webUtil.usingWebElementclickMethod(Stock_ln, "stock");
			webUtil.usingWebElementSendKeys(Stock_ln, "45", "stock");

		} catch (NoSuchWindowException e) {

		}
		webUtil.usingWebElementclickMethod(lowstock, "LowStock");
     webUtil.usingWebElementSendKeys(lowstock, "56", "LowStock");
		
		
		
		
		
		
		
		
		
		
		
//	util.usingWebElementSendKeys(firstNameEd, "bb"," n n");
//	util.usingWebElementSendKeys(lastNameEd, "v","v");
//	util.usingWebElementSendKeys(AccountNameEd, "396181993402"," Account_Name");
//	util.usingWebElementSendKeys(mobileEd, "6386993420"," Mobile");
//	util.usingWebElementSendKeys(leadsSourceDd, "Employee"," Employee");
//	util.usingWebElementSendKeys(emailEd, "by862473@gmail.com"," Email");
//	util.usingWebElementSendKeys(assistantEd, "QA Tester"," Assistant");

	}// ion-radio[@class='sc-ion-select-popover-ios ios in-item interactive
		// radio-checked hydrated']

	public void saveButtonclick() throws InterruptedException {
		CreateNewProduct();
		// util.usingWebElementclickMethod(saveClick, "Save Button");
	}

	public void cancelButtonclick() throws InterruptedException {
		CreateNewProduct();
		// util.usingWebElementclickMethod(cancelClick, "Cancel Button");
	}

}