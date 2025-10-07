package MYBharat.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MYBharat.AbstractComponents.AbstractComponent;

public class Login_errorMessage extends AbstractComponent {

	WebDriver driver;

	public Login_errorMessage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//span[@class='lang_yuva_register_login_link fontchange']") 
	WebElement signIn;
	
	
	@FindBy(xpath="//input[@id='mybharat']") 
	WebElement enterMobileNumberOrEmail;

	
	@FindBy(xpath="//input[@id='terms_mobile']") 
	WebElement iConsentToTermsOfUse;
	
	@FindBy(css=".d-grid.gap-2") 
	WebElement signin;
	
	@FindBy(xpath="//button[contains(text(),'Sign')]") 
	WebElement sign;

	@FindBy(xpath = "//small[normalize-space()='Please enter valid OTP.']")
	WebElement errorMessage;

	public void AsPartnerUsingPhoneOrEmail(String numberoremail) {
		signIn.click();
		enterMobileNumberOrEmail.sendKeys(numberoremail);
		iConsentToTermsOfUse.click();
		signin.click();
		waitForOTP();
		sign.click();
	}

	
	
	    public String getErrorMessage() {
		return errorMessage.getText();

	}

}
