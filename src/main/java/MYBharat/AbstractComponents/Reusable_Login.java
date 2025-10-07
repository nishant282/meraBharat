package MYBharat.AbstractComponents;


import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;


public class Reusable_Login {

	WebDriver driver;

	public Reusable_Login(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath="//span[@class='lang_yuva_register_login_link fontchange']") 
	WebElement signIn;
	
	@FindBy(xpath="//input[@id='mybharat']") 
	WebElement enterMobileNumberOrEmail;
	
	@FindBy(xpath="//input[@id='terms_mobile']") 
	WebElement iConsentToTermsOfUse;
	
	@FindBy(xpath="(//button[normalize-space()='Sign In'])[1]")
	WebElement signin;
	
	@FindBy(xpath = "//iframe[@id='ifmail']")
	WebElement Iframe;

	@FindBy(xpath = "(//p[contains(text(),'Your one-time password (OTP) for updating e-mail i')])[1]")
	WebElement Password;

	@FindBy(xpath = "//button[contains(text(),'Sign')]")
	WebElement sign;

	@FindBy(xpath = "//input[@id='login']")
	WebElement enterYourInboxHere;

	@FindBy(xpath = "(//i[@class='material-icons-outlined f36'])[1]")
	WebElement next;

	@FindBy(xpath = "//input[@id='otp']")
	WebElement enterOTP;
	
	//login
	
	public void login(String email) throws InterruptedException {
		clearbrowsercache();
		// Click on "signIn" button
		signIn.click();

		// Enter email in the mobile number or email field
		enterMobileNumberOrEmail.sendKeys(email);

		// Click on "I consent to terms" checkbox
		iConsentToTermsOfUse.click();

		// Click on "Sign In" button
		signin.click();

		// Switch to new browser tab
		driver.switchTo().newWindow(WindowType.TAB);

		// Open yopmail.com in the new tab
		driver.get("https://yopmail.com/");

		// Enter email in the inbox field
		enterYourInboxHere.clear();
		enterYourInboxHere.sendKeys(email);

		// Click on "Next" button
		next.click();

		// Switch to iframe
		driver.switchTo().frame(Iframe);

		// Extract password from the webpage
		String Pass = Password.getText().split(". This")[0].trim().split("is")[1].trim();
		

		// Close the new tab
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(1)).close();
		driver.switchTo().window(tab.get(0));

		// Enter OTP
		enterOTP.sendKeys(Pass);

		// Click on "Sign In" button
		sign.click();
	}
	
	
	 public void clearbrowsercache() {

		   JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	        jsExecutor.executeScript("window.localStorage.clear();");
	        jsExecutor.executeScript("window.sessionStorage.clear();");
	        jsExecutor.executeScript("window.location.reload();");

	}
	
	
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   

	
}
