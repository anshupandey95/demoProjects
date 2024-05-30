package WOSPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Utility.WebUtil;

public class changepasswordModule {
WebUtil ut;
	
	public changepasswordModule(WebUtil ut) {
		this.ut = ut;
		PageFactory.initElements(ut.getDriver(), this);
	}
	
	
	@FindBy(xpath = "//ion-button[@class='btn-primary m-0 ios button button-block button-solid ion-activatable ion-focusable hydrated']")
    WebElement changePasswordButton;
	
	@FindBy(xpath = "//input[@placeholder='Enter Old Password']")
	WebElement oldPasswordfield;
	
	@FindBy(xpath = "//input[@placeholder='Enter New Password']")
	WebElement newpasswordfield;
	@FindBy(xpath = "//input[@placeholder='Enter Confirm Password']")
	WebElement confirmpassword;
	@FindBy(xpath = "//ion-button[text()='Save']")
	WebElement ChangepasswordSaveButton;
	
	@FindBy(xpath = "//p[text()='Password updated successfully!']")
	WebElement savePasswordText;
	
	@FindBy(xpath = "//div[text()='Old password did not match!']")
	WebElement wrongoldpasswordText;
	
	public void clickChangepasswordbt() {
		ut.click(changePasswordButton, "ChangePasswordButton");
	}
	
	public void inputOldpass(String pass) {
		ut.sendkeysNormal(oldPasswordfield, pass, "OldPasswordField");
	}
	
	public void inputNewPassword() {
		ut.sendkeysNormal(newpasswordfield, "sR123456", "NewPasswordfield");
	}
	public void inputConfirmPassword() 
	{
		ut.sendkeysNormal(confirmpassword, "sR123456", "ConfirmPasswordField");
	
	}
	
	public void SaveChangepassword() {
		ut.click(ChangepasswordSaveButton, "ChangePasswordSaveBT");
	}
	
	
	public void VerifyPaswordText() {
		String actualtext = savePasswordText.getText();
		String Expected = "Password updated successfully!";
		if((actualtext.equals(Expected))) {
			System.out.println("password suscessfully changed");
			ut.getExtentTest().log(Status.INFO, MarkupHelper.createLabel("Password suscessfully changed", ExtentColor.LIME));
			
		} else {
			System.out.println("pasword change fails");
			
		}
	
	}
	
	public void Verifyoldpassword() {
		String actualtext = wrongoldpasswordText.getText();
		String Expected = "Old password did not match!";
		if((actualtext.equals(Expected))) {
			System.out.println("wrong old password warning displayed");
			ut.getExtentTest().log(Status.INFO, MarkupHelper.createLabel("Wrong old password warning displayed", ExtentColor.LIME));
			
		} else {
			System.out.println("pasword change fails");
			
		}
	
	}
	
	
	
}
