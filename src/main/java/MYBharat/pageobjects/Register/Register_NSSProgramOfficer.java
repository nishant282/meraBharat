package MYBharat.pageobjects.Register;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import MYBharat.AbstractComponents.AbstractComponent;
import MYBharat.AbstractComponents.Reusable_PartnerRegistration;

public class Register_NSSProgramOfficer extends Reusable_PartnerRegistration {

	WebDriver driver;

	public Register_NSSProgramOfficer
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
	WebElement Designation;
	
	@FindBy(xpath="(//select[@id='1_division'])[1]") 
	WebElement Central_Regional_Directorate;
	
	@FindBy(xpath="(//select[@id='2_division'])[1]") 
	WebElement StateWise_Regional_Dirctorate;
	
	@FindBy(xpath="//div[@id='s2id_3_division']") 
	WebElement college;

	@FindBy(xpath="//body") 
	WebElement SearchCollege;
	
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
		orgname.selectByVisibleText("National Service Scheme (NSS)");
		Select designation = AbstractComponent.select(Designation);
		designation.selectByVisibleText("NSS COORDINATOR COLLEGE");
		Select Regional_Directorate = AbstractComponent.select(Central_Regional_Directorate);
		Regional_Directorate.selectByVisibleText("CENTRAL");
		Select StateWise_Regional = AbstractComponent.select(StateWise_Regional_Dirctorate);
		StateWise_Regional.selectByVisibleText("MADHYA PRADESH");
		college.click();
		waitForWebElementToClickable(SearchCollege);
		
		
		
		SearchCollege.sendKeys("T" + Keys.ENTER);
	
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
