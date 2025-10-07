package MYBharat.pageobjects.logins;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import MYBharat.AbstractComponents.Reusable_Login;

public class Login_Youth extends Reusable_Login {

	WebDriver driver;

	public Login_Youth(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//p[normalize-space()='Welcome']") 
	WebElement welcome;

	@FindBy(xpath="//div[contains(@class,'header navbar navbar-inverse')]//li[2]//a[1]")
	WebElement publicProfile;

	@FindBy(xpath="(//span[@id='emailid'])[1]")
	WebElement emailid;

	public String getemail() {
		welcome.click();
		publicProfile.click();
		String email = emailid.getText();
		System.out.println(email);
		return email;
	}

	
	public void clearbrowsercache() {
		super.clearbrowsercache();
	}
	
	
	@Override
	public void login(String email) throws InterruptedException {
		super.login(email);
	}

	
	
	
	
}
