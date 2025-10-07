package MYBharat.AbstractComponents;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Reusable_PartnerRegistration extends AbstractComponent {

	WebDriver driver;

	public Reusable_PartnerRegistration(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath = "//span[@class='lang_register fontchange']")
	WebElement getStarted;

	@FindBy(xpath = "(//a[@class='dropdown-item border-bottom'])[2]")
	WebElement partner;

	@FindBy(xpath = "//span[@id='skiptmc']")
	WebElement register;

	@FindBy(xpath = "//input[@id='mybharat']")
	WebElement enterMobileNumberOrEmail;

	@FindBy(xpath = "//input[@id='terms_mobile']")
	WebElement iConsentToTermsOfUse;

	@FindBy(css = ".d-grid.gap-2")
	WebElement signIn;

	@FindBy(xpath = "//iframe[@id='ifmail']")
	WebElement Iframe;

	@FindBy(xpath = "(//p[contains(text(),'Your one-time password (OTP) for updating e-mail i')])[1]")
	WebElement Password;

	@FindBy(xpath = "//button[contains(text(),'Sign')]")
	WebElement sign;

	@FindBy(xpath = "//input[@id='login']")
	WebElement enterYourInboxHere;

	@FindBy(xpath = "(//i[@class='material-icons-outlined f36'])[1]")
	WebElement next;

	@FindBy(xpath = "//input[@id='otp']")
	WebElement enterOTP;

	@FindBy(xpath = "//input[@id='fullname']")
	WebElement fullName;

	@FindBy(xpath = "//input[@id='dd']")
	WebElement dd;

	@FindBy(xpath = "//input[@id='mm']")
	WebElement mm;

	@FindBy(xpath = "//input[@id='yy']")
	WebElement yyyy;

	@FindBy(xpath = "//select[@id='types']")
	WebElement selectGender;

	@FindBy(xpath = "//select[@id='state_address']")
	WebElement SelectState;

	@FindBy(xpath = "//select[@id='district_address']")
	WebElement SelectDistrict;

	@FindBy(xpath = "//input[@id='restype_rural']")
	WebElement rural;

	@FindBy(xpath = "//select[@id='block_address']")
	WebElement SelectBlock;

	@FindBy(xpath = "//input[@id='pincode']")
	WebElement pincode;

	@FindBy(xpath="//input[@id='terms']") 
	WebElement iConsentToTerms;

	@FindBy(css = ".d-grid.gap-2")
	WebElement submit;

	// signup

	public void registration(String email) throws InterruptedException {
		clearbrowsercache();
		// Click on "Get Started" button
		getStarted.click();
		partner.click();
		register.click();
		// Enter email in the mobile number or email field
		enterMobileNumberOrEmail.sendKeys(email);

		// Click on "I consent to terms" checkbox
		iConsentToTermsOfUse.click();

		// Click on "Sign In" button
		signIn.click();

		// Switch to new browser tab
		driver.switchTo().newWindow(WindowType.TAB);

		// Open yopmail.com in the new tab
		driver.get("https://yopmail.com/");

		// Enter email in the inbox field
		enterYourInboxHere.clear();
		enterYourInboxHere.sendKeys(email);

		// Click on "Next" button
		next.click();

		// Switch to iframe
		driver.switchTo().frame(Iframe);

		// Extract password from the webpage
		String Pass = Password.getText().split(". This")[0].trim().split("is")[1].trim();
		

		// Close the new tab
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(1)).close();
		driver.switchTo().window(tab.get(0));

		// Enter OTP
		enterOTP.sendKeys(Pass);

		// Click on "Sign In" button
		sign.click();

		waitForWebElementToVisible(fullName);
		// Fill full name
		fullName.sendKeys("Nishant Sharma");

		// Fill date of birth
		dd.sendKeys("11");
		mm.sendKeys("03");
		yyyy.sendKeys("1990");

		// Select gender
		Select selectgender = new Select(selectGender);
		selectgender.selectByVisibleText("Male");

		// Select state
		Select selectState = new Select(SelectState);
		selectState.selectByVisibleText("PUNJAB");

		// Select district
		waitForWebElementToClickable(SelectDistrict);
		Select selectDistrict = new Select(SelectDistrict);
		selectDistrict.selectByVisibleText("FARIDKOT");

		// Select rural
		rural.click();

		// Select block
		waitForWebElementToClickable(SelectBlock);
		Select selectBlock = new Select(SelectBlock);
		selectBlock.selectByIndex(2);

		// Fill pincode
		pincode.sendKeys("201204");

		// Click on "I consent to terms of use" checkbox
		iConsentToTerms.click();

		// Click on "Submit" button
		submit.click();
	}

	public void clearbrowsercache() {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.localStorage.clear();");
		jsExecutor.executeScript("window.sessionStorage.clear();");
		jsExecutor.executeScript("window.location.reload();");

	}

}
