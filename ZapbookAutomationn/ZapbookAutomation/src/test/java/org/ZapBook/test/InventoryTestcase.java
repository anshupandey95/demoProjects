package org.ZapBook.test;

import org.testng.annotations.Test;

import com.eva.vtiger.pages.functionality.support.contacts.Inventory;

public class InventoryTestcase extends BaseTestClass {

	@Test
	public void inventory_002() throws InterruptedException {
		Inventory ivn = new Inventory(webUtil);
		ivn.CreateNewProduct();

	}
}
