package MYBharat.pageobjects.logins;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;


import MYBharat.AbstractComponents.Reusable_Login;

public class Login_Partner extends Reusable_Login {

	WebDriver driver;

	public Login_Partner(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	

	
	@Override
	public void login(String email) throws InterruptedException {
		super.login(email);
	}

	
	
	
	
}
