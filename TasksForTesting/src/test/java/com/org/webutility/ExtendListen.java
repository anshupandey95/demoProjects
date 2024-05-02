package com.org.webutility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendListen implements ITestListener {
	
	 public ExtentReports rport;
	public ExtentSparkReporter html;
	 public ExtentTest test;
	 
	public void configReport() {
		
		String time = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportName = "ZapBookTesting" +time + ".html";
		html = new ExtentSparkReporter("./Reportsss/" + reportName);
		rport = new ExtentReports();
		rport.attachReporter(html);
		//configuration to change look and feel of report
				html.config().setDocumentTitle("Extent Listener Report Demo");
				html.config().setReportName("This is my First Report");
				html.config().setTheme(Theme.DARK);
				
			
	}
	
	
	
	public void onTestStart(ITestResult result) {
		configReport();
		System.out.println("Test has been started"+ result.getName());
	    // not implemented
	  }
	  public void onTestSuccess(ITestResult result) {
		  
		  System.out.println("Test is suscess");
		  

			test = rport.createTest(result.getName());
			test.log(Status.PASS, MarkupHelper.createLabel("BaseTeST passed  " + result.getName() ,ExtentColor.GREEN));
	    // not implemented
	  }

	  /**
	   * Invoked each time a test fails.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#FAILURE
	   */
	  public void onTestFailure(ITestResult Result) {
		  System.out.println("Name of test method failed:" + Result.getName() );  		
			test = rport.createTest(Result.getName());//create entry in html report
			test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is: " + Result.getName() ,ExtentColor.RED));
		  
		  
		  
		 // test.log(Status.FAIL, MarkupHelper.createLabel(" faileddddddd " + result.getName() ,ExtentColor.GREEN));
		  
	    	  }
	  
	  
	  public void onFinish(ITestContext context) {
		  rport.flush();
		  
		  System.out.println("methord finished");
	  }
	  
		    

	 
	
	
	
	

}
