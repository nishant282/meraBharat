package MYBharat.pageobjects.Register;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import MYBharat.AbstractComponents.AbstractComponent;
import MYBharat.AbstractComponents.Reusable_PartnerRegistration;

public class Register_NGO extends Reusable_PartnerRegistration {

	WebDriver driver;

	

	public Register_NGO(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@id='partner_type']")
	WebElement PleaseSelectOrganization;

	@FindBy(xpath="//input[@id='ngo_org_name']") 
	WebElement name;

	@FindBy(xpath="(//textarea[@id='addressnew'])[1]")
	WebElement address;

	@FindBy(xpath = "(//select[@id='state_id'])[1]")
	WebElement SelectState;

	@FindBy(xpath = "//div[@class='col']//select[@id='city_id']")
	WebElement SelectDistrict;

	

	@FindBy(xpath = "(//input[@id='zip'])[1]")
	WebElement pincode;

	@FindBy(xpath = "//button[@id='first-step']")
	WebElement next;

	@FindBy(xpath = "//input[@id='user_phone']")
	WebElement mobileNumber;

	@FindBy(xpath = "(//textarea[@id='addressnew'])[2]")
	WebElement contactAddress;

	@FindBy(xpath = "//div[@id='tnc']//input[@id='flexCheckDefault']")
	WebElement flexCheckDefault;

	@FindBy(xpath = "(//div[@class='col-md-12 col-sm-12 d-grid gap-2'])[2]")
	WebElement submit;

	@FindBy(xpath="//p[@class='f-right-onboard']") 
	WebElement skip;

	@Override
	public String getSaltString() {
		String email = super.getSaltString() + "@yopmail.com";
		return email;

	}

	@Override
	public void registration(String email) throws InterruptedException {

		super.registration(email);
		waitForWebElementToVisible(PleaseSelectOrganization);
		Select org = AbstractComponent.select(PleaseSelectOrganization);
		org.selectByVisibleText("NGO");
		name.sendKeys("Rotary club Modinagar");
		address.sendKeys("Modinagar");
		Select state = AbstractComponent.select(SelectState);
		state.selectByVisibleText("UTTAR PRADESH");
		Select district = AbstractComponent.select(SelectDistrict);
		district.selectByVisibleText("GHAZIABAD");
		

		pincode.sendKeys("201204");
		next.click();

		String number = AbstractComponent.get10DigitNumber();
		mobileNumber.sendKeys(number);
		contactAddress.sendKeys("Modinagar");
		flexCheckDefault.click();

		submit.click();
		skip.click();
	}

}
