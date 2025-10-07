package MYBharat.pageobjects.Logout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MYBharat.AbstractComponents.AbstractComponent;

public class Logout_Partner extends AbstractComponent {

	WebDriver driver;

	public Logout_Partner(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//p[normalize-space()='Welcome']")
	WebElement welcome;
	
	@FindBy(xpath="//a[@id='logout']")
	WebElement logOut;

	public void logout() {
		
		welcome.click();
		logOut.click();
		
	}
	
	
	
	   

}
