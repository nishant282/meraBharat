package MYBharat.pageobjects.Register;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import MYBharat.AbstractComponents.AbstractComponent;
import MYBharat.AbstractComponents.Reusable_PartnerRegistration;

public class Register_GovtPartner extends Reusable_PartnerRegistration {

	WebDriver driver;

	public Register_GovtPartner
	(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//select[@id='partner_type']") 
	WebElement PleaseSelectOrg;
	
	@FindBy(xpath="//select[@id='org_name']") 
	WebElement OrganisationName;
	
	@FindBy(xpath="//select[@id='designation']") 
	WebElement PleaseSelectDesignation;
	
	@FindBy(xpath="(//select[@id='1_division'])[1]") 
	WebElement SelectDivision;
	
	@FindBy(xpath="//button[@id='first-step']") 
	WebElement next;

	@FindBy(xpath="//input[@id='user_phone']") 
	WebElement mobileNumber;
	
	@FindBy(xpath="(//select[@id='state_id'])[2]") 
	WebElement SelectState;
	
	@FindBy(xpath="(//select[@id='city_id'])[2]") 
	WebElement SelectDistrict;
	
	@FindBy(xpath="(//input[@id='zip'])[2]") 
	WebElement pincode;
	
	@FindBy(xpath="(//textarea[@id='addressnew'])[2]") 
	WebElement address;
	
	@FindBy(xpath="//div[@id='tnc']//input[@id='flexCheckDefault']") 
	WebElement flexCheckDefault;
	
	@FindBy(xpath="(//div[@class='col-md-12 col-sm-12 d-grid gap-2'])[2]") 
	WebElement submit;
	
	@FindBy(xpath="//p[@class='f-right-onboard']") 
	WebElement skip;

	String number = AbstractComponent.get10DigitNumber();
	
	@Override
	public String getSaltString() {
		String email = super.getSaltString() + "@yopmail.com";
		return email;

	}

	@Override
	public void registration(String email) throws InterruptedException {

		super.registration(email);
		waitForWebElementToVisible(PleaseSelectOrg);
		Select org = AbstractComponent.select(PleaseSelectOrg);
		org.selectByVisibleText("Government Organisation");
		Select orgname = AbstractComponent.select(OrganisationName);
		orgname.selectByVisibleText("Mdnr Partner (only for Testing)");
		Select designation = AbstractComponent.select(PleaseSelectDesignation);
		designation.selectByVisibleText("NATIONAL POLICE");
		Select division = AbstractComponent.select(SelectDivision);
		division.selectByVisibleText("INDIA");
		next.click();
		waitForWebElementToVisible(mobileNumber);
		mobileNumber.sendKeys(number);
		
		Select state = AbstractComponent.select(SelectState);
		state.selectByVisibleText("UTTAR PRADESH");
		
		Select district = AbstractComponent.select(SelectDistrict);
		district.selectByVisibleText("GHAZIABAD");
		pincode.sendKeys("201204");
		address.sendKeys("Modinagar");
		flexCheckDefault.click();
		submit.click();
		skip.click();
	}

}
