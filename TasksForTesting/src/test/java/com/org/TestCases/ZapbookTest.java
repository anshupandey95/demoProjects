package com.org.TestCases;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.org.BaseGeneric.BaseTest;
import com.org.pages.LoginPage;
import com.org.pages.ScheduleVerifypage;
import com.org.pages.newBookingPage;

public class ZapbookTest extends BaseTest {

	@Test
	public void Zapbook() throws InterruptedException {

		LoginPage log = new LoginPage(util);
		Thread.sleep(5000);

		log.bookingbuttonClick();

		newBookingPage N = new newBookingPage(util);
		// N.newtab();

		Thread.sleep(4000);

		Dimension a = N.DateLoc();
		System.out.println(a);

		Point b = N.XY();
		System.out.println(b);

		Thread.sleep(2000);
		N.datee();
		Thread.sleep(2000);

	}

	 @Test
	public void scheduleTest() throws InterruptedException {
		util.implicitWait(10);

		ScheduleVerifypage verify = new ScheduleVerifypage(util);
		Thread.sleep(3000);
		verify.schrdulebutton();
		System.out.println("aaaaaaaaaaaaa");
		Thread.sleep(5000);
		verify.dateoptionsclick();
		System.out.println("bbbbbbbbbbbbb");

		Thread.sleep(4000);
		verify.schedulenextdateclickshadow();
		System.out.println("cccccccc");

		Thread.sleep(4000);
		verify.fivedateclick();
		System.out.println("ddddddddd");
		String actualTextSchedule = verify.schedulText();
		System.out.println(actualTextSchedule);

		String expectedTextSchedule = "mmm nnn";

		if (actualTextSchedule.contains(expectedTextSchedule)) {
			Assert.assertTrue(true);
			System.out.println("Matched Booking Verified");

		} else {
			System.out.println("Booking not Verified");
			Assert.assertTrue(false);
		}

	}

}
