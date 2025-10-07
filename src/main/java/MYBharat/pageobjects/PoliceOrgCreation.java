package MYBharat.pageobjects;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;



import MYBharat.AbstractComponents.AbstractComponent;

public class PoliceOrgCreation extends AbstractComponent {

	WebDriver driver;

	public PoliceOrgCreation(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='Organizations']")
	WebElement organizations;

	@FindBy(xpath = "//a[@class='btn btn-primary f-right btn-default']")
	WebElement addOrganization;

	@FindBy(xpath="//label[@id='customButton']//img") 
	WebElement banner;

	@FindBy(css = "label[id='customButton1'] img")
	WebElement picUpload;

	@FindBy(xpath = "//img[@id='editOrgNameButton']")
	WebElement editOrgName;

	@FindBy(xpath = "//input[@id='ediOrgNameText']")
	WebElement enterOrganizationName;

	@FindBy(xpath = "//img[@id='editAbbreviationButton']")
	WebElement Abbreviation;

	@FindBy(xpath = "//input[@id='editAbbreviationNameField']")
	WebElement enterAbbreviat;

	@FindBy(css = "#exampleFormControlTextarea1")
	WebElement about;

	@FindBy(xpath = "//a[normalize-space()='Basic Info']")
	WebElement basicInfo;

	@FindBy(css = "#abbreviation2")
	WebElement Abbre;

	@FindBy(xpath = "//input[@id='bharat_handle']")
	WebElement Handle;

	@FindBy(xpath = "//select[@id='org_category']")
	WebElement selectOrganizationCategory;

	@FindBy(xpath = "//select[@id='subcategory']")
	WebElement SelectSubcategory;

	@FindBy(css = "#checkbox0")
	WebElement experientialLearning;

	@FindBy(css = "#checkbox1")
	WebElement volunteer;

	@FindBy(css = "#s2id_autogen1")
	WebElement Specialization;

	@FindBy(xpath = "//input[@id='address']")
	WebElement address;

	@FindBy(xpath = "//input[@id='landmark']")
	WebElement landmark;

	@FindBy(xpath = "//select[@id='orgstate_id']")
	WebElement state;

	@FindBy(xpath = "//select[@id='orgdistrict_id']")
	WebElement district;

	@FindBy(xpath = "//input[@id='org_area_urban']")
	WebElement orgLocType;

	@FindBy(xpath = "//input[@id='org_pincode']")
	WebElement pincode;

	@FindBy(xpath = "//input[@id='town_city']")
	WebElement townCity;

	@FindBy(xpath = "//input[@id='nodel_name']")
	WebElement name;

	@FindBy(xpath = "//input[@id='nodel_mobile']")
	WebElement mobile;

	@FindBy(xpath = "//input[@id='nodel_email']")
	WebElement email;

	@FindBy(xpath = "//input[@id='nodel_designation']")
	WebElement designation;

	@FindBy(xpath = "//select[@id='nodel_gender']")
	WebElement selectGender;

	@FindBy(xpath = "//button[@type='submit']//img")
	WebElement submit;

	@SuppressWarnings("deprecation")
	public void OrgCreation(String nodalno, String nodalemail) throws  InterruptedException, IOException {
		organizations.click();
		addOrganization.click();

		banner.click();
		Runtime.getRuntime().exec("C:\\Users\\nisha\\Desktop\\fileupload1.exe");


		
		editOrgName.click();
		enterOrganizationName.sendKeys("Modinagar Gram Panchayat");
		Abbreviation.click();
		enterAbbreviat.sendKeys("Modinagar GP");
		about.sendKeys("Modinagar is a town and a municipal board in Ghaziabad district .");
		basicInfo.click();
		Abbre.sendKeys("Mdnr");
		Handle.sendKeys("MyModinagar");
		Select selectOrgType = new Select(selectOrganizationCategory);
		selectOrgType.selectByVisibleText("Government");
		Select selectsubCategory = new Select(SelectSubcategory);
		selectsubCategory.selectByVisibleText("Police");
		experientialLearning.click();
		volunteer.click();

		scrollPage(500);

		Specialization.click();
		Specialization.sendKeys("Health" + Keys.ENTER + "Road safety" + Keys.ENTER);

		address.sendKeys("satya nagar");
		landmark.sendKeys("near tower");
		Select selectstate = new Select(state);
		selectstate.selectByVisibleText("Delhi");
		Select selectdistrict = new Select(district);
		selectdistrict.selectByVisibleText("NEW DELHI");
		name.sendKeys("Nishant sharma");
		mobile.sendKeys(nodalno);
		email.sendKeys(nodalemail);
		designation.sendKeys("Nodal");
		Select selectgender = new Select(selectGender);
		selectgender.selectByVisibleText("Male");
		submit.click();
	}

}


