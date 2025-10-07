package MYBharat.pageobjects.Logout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MYBharat.AbstractComponents.AbstractComponent;

public class Logout_Youth extends AbstractComponent {

	WebDriver driver;

	public Logout_Youth(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//ion-avatar[@class='md hydrated']//img[@alt='Profile Pic']") 
	WebElement welcome;
	
	@FindBy(xpath="//ion-label[@class='sc-ion-label-ios-h sc-ion-label-ios-s ios hydrated'][normalize-space()='Logout']") 
	WebElement logOut;

	public void logout_youth() {
		
		welcome.click();
		logOut.click();
		
	}
	
	
	
	   

}
