package MYBharat.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import MYBharat.AbstractComponents.AbstractComponent;

public class LevelCreationByNodalOfficerAndAddSubUser extends AbstractComponent {

	WebDriver driver;

	public LevelCreationByNodalOfficerAndAddSubUser(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@title='Organizational Settings']")
	WebElement organizationalSettings;
	
	
	@FindBy(css="#division_name_1") 
	WebElement majorDivision;

	@FindBy(css="#designation_1") 
	WebElement designation1;

	@FindBy(css="#division_name_2") 
	WebElement subDivision;

	@FindBy(css="#designation_2") 
	WebElement designation2;

	@FindBy(css="#division_name_3") 
	WebElement microDivision;

	@FindBy(css="#designation_3") 
	WebElement designation3;
	
	@FindBy(xpath="//button[@id='btnsumbit']") 
	WebElement save;
	
	@FindBy(xpath="//a[@href='/organization/division?hierarchy_id=NzEz']")
	WebElement addEditLevel1;
	
	@FindBy(xpath="//button[@id='div_add']") 
	WebElement addDivision1;
	
	
	
	@FindBy(name="label_name") 
	WebElement nameOfMajorDivision1;
	
	@FindBy(xpath="//input[@placeholder='Email']") 
	WebElement email1;
	
	@FindBy(xpath="//input[@placeholder='Mobile Number']") 
	WebElement mobileNumber1;
	
	@FindBy(xpath="//button[normalize-space()='Save']") 
	WebElement save1;
	
	
	
	@FindBy(xpath="//img[@alt='Image']")
	WebElement image1;
			
	@FindBy(xpath="(//a[@type='button'][contains(text(),'Add')])[2]")
	WebElement addEditLevel2;
	
	
	
	@FindBy(xpath="//button[@id='div_add']") 
	WebElement addDivision2;
	
	
	
	@FindBy(xpath="//select[@name='parent_id']") 
	WebElement selectMajorDivision;
	
	
	@FindBy(xpath="//input[@placeholder='Name of Micro Division']") 
	WebElement nameOfMicroDivision;
	
	@FindBy(xpath="//input[@name='email']") 
	WebElement email2;
	
	@FindBy(xpath="//input[@name='mobile_number']") 
	WebElement mobileNumber2;
	
	
	@FindBy(xpath="//button[normalize-space()='Save']")
	WebElement save2;
	
	@FindBy(xpath="//img[@alt='Image']") 
	WebElement image2;
	
	@FindBy(xpath="//tbody/tr[3]/td[4]/a[1]") 
	WebElement addEditLevel3;
	
	@FindBy(xpath="//button[@id='div_add']") 
	WebElement addDivision3;
	
	@FindBy(xpath="//select[@name='parent_id']") 
	WebElement selectSubDivision;
	
	@FindBy(xpath="//input[@placeholder='Name of Minor Division']") 
	WebElement nameOfMinorDivision;
	
	@FindBy(xpath="//input[@name='email']") 
	WebElement email3;
	
	@FindBy(xpath="//input[@name='mobile_number']") 
	WebElement mobileNumber3;
	
	
	@FindBy(xpath="//button[normalize-space()='Save']") 
	WebElement save3;
	
	@FindBy(xpath="//img[@alt='Image']") 
	WebElement image3;
	
	
	
	
	@FindBy(xpath="//a[@title='Add Sub User']") 
	WebElement userManagement;
	
	@FindBy(xpath="//a[@title='User Management']") 
	WebElement userManagement1;
	
	@FindBy(xpath="//input[@id='user_phone']") 
	WebElement enterMobileNoOfUser;
	
	@FindBy(xpath="//button[@id='getUser']") 
	WebElement getUserDetailsFromDigiLock1;
	
	@FindBy(xpath="//input[@id='email_id']") 
	WebElement emailId;
	
	@FindBy(xpath="//button[normalize-space()='Add user']")
	WebElement addUser;
	
	
	public void levelCreation() {
		organizationalSettings.click();
		majorDivision.sendKeys("District");
		designation1.sendKeys("SSP");
		subDivision.sendKeys("Block");
		designation2.sendKeys("DSP");
		microDivision.sendKeys("City");
		designation3.sendKeys("SI");
		save.click();
		//addEditLevel1.click();
		addDivision1.click();
		nameOfMajorDivision1.sendKeys("Ghaziabad");
		email1.sendKeys("nishant.iete01@gmail.com");
		mobileNumber1.sendKeys("7778889990");
		save1.click();
		image1.click();
		addEditLevel2.click();
		addDivision2.click();
		Select selectMajorDiv = new Select(selectMajorDivision);
		selectMajorDiv.selectByVisibleText("Ghaziabad");
		nameOfMicroDivision.sendKeys("Modinagar");
		email2.sendKeys("nishant.iete02@gmail.com");
		mobileNumber2.sendKeys("7778889991");
		save2.click();
		image2.click();
		addEditLevel3.click();
		addDivision3.click();
		Select selectSubDiv = new Select(selectSubDivision);
		selectSubDiv.selectByVisibleText("Modinagar");
		nameOfMinorDivision.sendKeys("Bhojpur");
		email3.sendKeys("nishant.iete02@gmail.com");
		mobileNumber3.sendKeys("7778889991");
		save3.click();
		image3.click();
		
		
	}

	public void addSubUser(String num1) {
		
		try {
			userManagement.click();	
		} catch (Exception e) {
			userManagement1.click();
		}
		
		enterMobileNoOfUser.sendKeys(num1);
		getUserDetailsFromDigiLock1.click();
		emailId.sendKeys("test1234@gmail.com");
		addUser.click();
		
	}
	   

	   
	
}
