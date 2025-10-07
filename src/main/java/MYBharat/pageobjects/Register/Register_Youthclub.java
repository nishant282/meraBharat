package MYBharat.pageobjects.Register;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import MYBharat.AbstractComponents.AbstractComponent;
import MYBharat.AbstractComponents.Reusable_PartnerRegistration;

public class Register_Youthclub extends Reusable_PartnerRegistration {

	WebDriver driver;

	public Register_Youthclub(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@id='partner_type']")
	WebElement PleaseSelectOrganization;

	@FindBy(xpath = "//input[@id='youth_clb_name']")
	WebElement nameOfYouthClub;

	@FindBy(xpath = "(//textarea[@id='addressnew'])[1]")
	WebElement address;

	@FindBy(xpath = "(//select[@id='state_id'])[1]")
	WebElement SelectState;

	@FindBy(xpath = "//div[@class='col']//select[@id='city_id']")
	WebElement SelectDistrict;

	@FindBy(xpath = "//input[@id='get_block_list']")
	WebElement getBlockList;

	@FindBy(xpath = "(//select[@id='block'])[1]")
	WebElement SelectBlock;

	@FindBy(xpath = "//select[@id='panchayat']")
	WebElement SelectPanchayat;

	@FindBy(xpath = "//select[@id='village']")
	WebElement SelectVillage;

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
		String email = super.getSaltString() + "@mailto.plus";
		return email;

	}

	@Override
	public void registration(String email) throws InterruptedException {

		super.registration(email);
		waitForWebElementToVisible(PleaseSelectOrganization);
		Select org = AbstractComponent.select(PleaseSelectOrganization);
		org.selectByVisibleText("Youth Club");
		nameOfYouthClub.sendKeys("Rotary club Modinagar");
		address.sendKeys("Modinagar");
		Select state = AbstractComponent.select(SelectState);
		state.selectByVisibleText("UTTAR PRADESH");
		Select district = AbstractComponent.select(SelectDistrict);
		district.selectByVisibleText("GHAZIABAD");
		getBlockList.click();

		waitForWebElementToVisible(SelectBlock);

		Select block = AbstractComponent.select(SelectBlock);
		block.selectByVisibleText("Muradnagar");
		Select panchayat = AbstractComponent.select(SelectPanchayat);
		panchayat.selectByVisibleText("Abupur");
		Select village = AbstractComponent.select(SelectVillage);
		village.selectByVisibleText("Abupur");
		scrollPage(50);

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
