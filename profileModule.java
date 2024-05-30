package WOSPages;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Utility.WebUtil;

public class profileModule {
	
WebUtil ut;
	
	public  profileModule(WebUtil ut) {
		this.ut = ut;
		PageFactory.initElements(ut.getDriver(), this);
	}
	
	
	
	
	@FindBy(xpath = "//ion-button[@routerlink='/profile']")
	WebElement profileButton;
	
	
	@FindBy(xpath = "//ion-button[normalize-space()='Edit Profile']")
	WebElement EditProfileButton;
	
	
	@FindBy(xpath = "//ion-col[@class='ion-text-center ios hydrated']//img")
	WebElement profilepic;
	
	
	@FindBy(xpath = "//input[@placeholder='Enter Address']")
	WebElement addressTextfield;
	
	@FindBy(xpath = "//textarea[@placeholder='Add About']")
	WebElement TextAreaField;
	
	@FindBy(xpath = "//ion-button[contains(text(),'Save')]")
	WebElement SaveButton;
	
	@FindBy(xpath = "//p[contains(text(),'Profile updated successfully!')]")
	WebElement suscessText;
	
	public void clickprofile() {
		ut.click(profileButton, "profiletabButton");
	}
	
	public void normaleditclickscroll() {
		ut.javaScrollToElement(EditProfileButton, "EditprofileButton");
	}
	
	public void clickeditjavawithnormalxpath() {
		ut.javascriptClick(EditProfileButton, "Editprofilebutton");
	}
	

	
	
	
	
	public void UploadProfilePic() throws AWTException, InterruptedException {
		ut.click(profilepic, "ProfileButton");
		Thread.sleep(3000);
		ut.actionupload("C:\\Users\\Dell\\Downloads\\daniel-craig-4", "ProfileUpload");
	}
	
	public void scrollToSaveButton() {
		ut.javaScrollToElement(SaveButton, "SaveButton");
	}
	
	public void InputAddress() {
		ut.sendkeysNormal(addressTextfield, "500 New Jersey Avenue, WashingtonDC ", "AddressField");
		
	}
	
	public void AboutUs() {
		ut.sendkeysNormal(TextAreaField, "Hello I am James and I am here for something meaningful and purpose oriented", "TextAreafield");
	}
	
	public void Saveclick() {
		ut.actionClick(SaveButton, "SaveButton");
	}
	
	
	public void profileupdatevERIFY() {
		String suscesstext = suscessText.getText();
		System.out.println(suscesstext);
		String ExpectedText = "Profile updated successfully!";
		
		if(suscesstext.equals(ExpectedText)) {
			System.out.println("Suscess msg veridied");
			ut.getExtentTest().log(Status.INFO, MarkupHelper.createLabel("Profile update Suscess msg verified", ExtentColor.LIME));
		} else {
			System.out.println("suscess update fails");
			ut.getExtentTest().log(Status.INFO, MarkupHelper.createLabel("update profile suscess msg failed", ExtentColor.RED));
			
		} 
		
	}
	


}
