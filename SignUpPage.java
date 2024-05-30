package WOSPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Utility.WebUtil;

public class SignUpPage {
	WebUtil ut;
	
	public  SignUpPage(WebUtil ut) {
		this.ut = ut;
		PageFactory.initElements(ut.getDriver(), this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement signUpBt;
	@FindBy(xpath = "//input[@placeholder='Enter First Name']")
	WebElement firstname;
	@FindBy(xpath = "//input[@placeholder='Enter Last Name']")
	WebElement lastname;
	
	@FindBy(xpath = "//input[@placeholder='Enter Phone Number']")
	WebElement PhoneNo;
	
	@FindBy(xpath = "//input[@placeholder='Enter Email Address']")
	WebElement EmailId;
	
	@FindBy(xpath = "//input[@placeholder='Enter Password']")
	WebElement passwordField;
	
	@FindBy(xpath = "//input[@placeholder='Enter Confirm Password']")
	WebElement confirmPasword;
	
	@FindBy(xpath = "//span[text()='Enter valid phone number']")
	WebElement invalidtext;
	@FindBy(xpath = "//span[text()='Enter valid email address']")
	WebElement invalidEmailText;
	
	
	
	
	
	
	
	
	@FindBy(xpath = "//ion-label[text()='Assets']")
	WebElement assettab;
	
	@FindBy(xpath = "//ion-button[contains(text(),' New Asset ')]")
	WebElement NewAsserts;
	
	
	
	
	@FindBy(xpath = "//ion-button[contains(text(),'Sign Up')]")
	WebElement SignUpsubmitBT;
	
	
	public void clickSignup() {
		ut.click(signUpBt, "Signupbutton");
	}
	public void InputFirstName(String nameFirst) {
		ut.sendkeysNormal(firstname, nameFirst, "FirstNmaefield");
		
	}
	
	public void InputLastName(String last) {
		ut.sendkeysNormal(lastname, last, "LastNmaefield");
		
	}
	
	public void phoneInput(String phone) {
		ut.sendkeysNormal(PhoneNo, phone, "phoneNoField");
		
	}
	
	public void phonenumberverication() {
		Boolean Digits = invalidtext.isDisplayed();
		if(Digits == true) {
			ut.getExtentTest().log(Status.INFO, MarkupHelper.createLabel("Invalid Phone No Warning Displayed", ExtentColor.ORANGE));
			System.out.println("invalid number text verified");
		} else {
			System.out.println("Invalid phone number pop up not apperared");
		}
		
	}
	
	public void InputEmail(String email) {
		ut.sendkeysNormal(EmailId, email, "emailIdField");
		
	}
	
	public void InvalidEmailVerify() {
		Boolean email = invalidtext.isDisplayed();
		if(email == true) {
			ut.getExtentTest().log(Status.INFO, MarkupHelper.createLabel("Invalid Email Warning Displayed", ExtentColor.ORANGE));
			
			System.out.println("invalid email warning  Displayed");
		} else {
			System.out.println("Invalid EmailId Warning pop up not Displayed");
		}
		
	}
	
	public void passwordInput(String pass) {
		ut.sendkeysNormal(passwordField, pass, "passwordfield");
		
	}
	
	public void confirmPasswordInput(String confirm) {
		ut.sendkeysNormal(confirmPasword, confirm, "passwordfield");
		
	}
	public void submitSignup() {
		ut.click(SignUpsubmitBT, "submitButton");
	}
	 
	
	
	public void CheckSignUPBtEnable() {
		Boolean Sign  = SignUpsubmitBT.isEnabled();
		
		if(Sign == true) {
			ut.getExtentTest().log(Status.INFO, MarkupHelper.createLabel("Verification failed", ExtentColor.ORANGE));
			
		} else {
			ut.getExtentTest().log(Status.INFO, MarkupHelper.createLabel("Verification Passed ", ExtentColor.ORANGE));
			
		}
		
	}
	
	
	
	
	public void AssetClick() {
		assettab.click();
	}
	
	public void newAssert() {
		NewAsserts.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
