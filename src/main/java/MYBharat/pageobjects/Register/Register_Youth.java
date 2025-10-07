package MYBharat.pageobjects.Register;

import java.io.File;
import java.util.ArrayList;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.github.javafaker.Faker; // Import Java Faker
import MYBharat.AbstractComponents.AbstractComponent;

public class Register_Youth extends AbstractComponent {

	WebDriver driver;
	Faker faker; // Declare Faker instance

	public Register_Youth(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		faker = new Faker(); // Initialize Faker
	}

	String email = getSaltString() + "@sharklasers.com";
	String mobilenum = get10DigitNumber();

	@FindBy(xpath = "//span[@class='lang_register fontchange']")
	WebElement getStarted;

	@FindBy(xpath = "//div[@role='group']//a[1]")
	WebElement youthApplicants_Volunteers_participants;

	@FindBy(xpath = "//button[@class='btn btn_login lang_yuva_register_as_youth_btn fontchange']")
	WebElement register;

	@FindBy(xpath = "//input[@id='mybharat']")
	WebElement enterMobileNumberOrEmail;

	@FindBy(xpath = "//input[@id='terms_mobile']")
	WebElement iConsentToTerms;

	@FindBy(css = ".d-grid.gap-2")
	WebElement signIn;

	@FindBy(xpath = "//p[contains(text(),'Your one-time password (OTP) for updating e-mail i')]")
	WebElement Password;

	@FindBy(xpath = "//button[contains(text(),'Sign')]")
	WebElement sign;

	@FindBy(xpath = "//a[@id='forget_button']")
	WebElement forgetMe;

	@FindBy(xpath = "//span[@id='inbox-id']//input[@type='text']")
	WebElement enterYourInboxHere;

	@FindBy(xpath = "//button[normalize-space()='Set']")
	WebElement set;

	@FindBy(xpath = "//td[normalize-space()='no-reply@mybharat.gov.in']")
	WebElement expandEmail;

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

	@FindBy(xpath = "//input[@id='restype_urban']")
	WebElement urban;

	@FindBy(xpath = "//select[@id='local_address']")
	WebElement selectLocalBody;

	@FindBy(xpath = "//input[@id='pincode']")
	WebElement pincode;

	@FindBy(xpath = "//input[@id='terms']")
	WebElement iConsentToTermsOfUse;

	@FindBy(css = ".d-grid.gap-2")
	WebElement submit;

	@FindBy(xpath = "//input[@id='txtmobile']")
	WebElement mobileNumber;

	@FindBy(xpath = "//input[@value='NCC']")
	WebElement yuvaType;

	@FindBy(xpath = "//select[@id='qualification_type']")
	WebElement selectQualification;

	@FindBy(xpath = "(//div[@id='s2id_mySelect'])")
	WebElement sports;

	@FindBy(xpath = "(//body)[1]")
	WebElement modalopen;

	@FindBy(xpath = "//input[@id='khel_participate']")
	WebElement khelParticipate;

	@FindBy(xpath = "//button[normalize-space()='Submit']")
	WebElement submitfeatures;

	@FindBy(css = "body > app-root:nth-child(1) > ion-app:nth-child(1) > ion-modal:nth-child(2) > app-view-image:nth-child(1) > ion-footer:nth-child(3) > ion-toolbar:nth-child(1) > ion-buttons:nth-child(1) > ion-button:nth-child(2)")
	WebElement ImageButton;

	public void register_verifyOTPandGoToRegistration() throws InterruptedException {
		// Click on "Get Started" button
		getStarted.click();

		// Click on "Youth Applicants, Volunteers, Participants" option
		youthApplicants_Volunteers_participants.click();

		// Click on "Register" button
		register.click();

		// Enter email in the mobile number or email field
		enterMobileNumberOrEmail.sendKeys(email);

		// Click on "I consent to terms" checkbox
		iConsentToTerms.click();

		// Click on "Sign In" button
		signIn.click();

		// Switch to new browser tab
		driver.switchTo().newWindow(WindowType.TAB);

		// Open dummy email in the new tab
		String dummyemailUrl = getProperty("dummyEmail");
		driver.get(dummyemailUrl);

		forgetMe.click();

		if (enterYourInboxHere.isDisplayed() && enterYourInboxHere.isEnabled()) {
			enterYourInboxHere.click();
		}

		// Enter email in the inbox field
		String[] parts = email.split("@");
		enterYourInboxHere.sendKeys(parts[0]);

		// Click on "Next" button
		set.click();

		// Switch to iframe
		expandEmail.click();

		// Extract password from the webpage
		String OTP = Password.getText().split(". This")[0].trim().split("is")[1].trim();
		System.out.println("Youth email is " + email);
		System.out.println("OTP is : " + OTP);

		// Close the new tab
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(1)).close();
		driver.switchTo().window(tab.get(0));

		// Enter OTP
		enterOTP.sendKeys(OTP);

		// Click on "Sign In" button
		sign.click();
	}

	// Method to fill registration details
	public void register() {
		// Fill full name with random name
		fullName.sendKeys(faker.name().fullName());

		// Fill date of birth with random values
		dd.sendKeys(String.valueOf(faker.number().numberBetween(1, 29))); // Day
		mm.sendKeys(String.valueOf(faker.number().numberBetween(1, 12))); // Month
		yyyy.sendKeys(String.valueOf(faker.number().numberBetween(1970, 2003))); // Year
		
		

		// Select gender
		waitForWebElementToClickable(selectGender);
		Select gender = AbstractComponent.select(selectGender);
		gender.selectByVisibleText(faker.options().option("Male", "Female", "Other")); // Random gender

		// Select state
		Select state = AbstractComponent.select(SelectState);
		int randomStateIndex = faker.number().numberBetween(1, 15); // Adjust based on the number of states
		state.selectByIndex(randomStateIndex); // Use random index for state selection

		// Select district by index
		waitForWebElementToClickable(SelectDistrict);
		Select district = AbstractComponent.select(SelectDistrict);
		int randomIndex = faker.number().numberBetween(1, 2); // Adjust based on the number of districts
		district.selectByIndex(randomIndex); // Use random index for district selection

		// Select block
		rural.click();
		waitForWebElementToClickable(SelectBlock);
		Select block = AbstractComponent.select(SelectBlock);

		// Automatically select a value from the block dropdown by index
		if (block.getOptions().size() > 1) { // Check if there are more than one option
			block.selectByIndex(1); // Select the first available option
		} else {
			// If no value found in block dropdown, select "urban"
			System.out.println("No values found in block dropdown. Selecting 'urban'.");
			// select urban
			urban.click();
			// Select local body dropdown
			waitForWebElementToClickable(selectLocalBody);
			Select localBodyDropdown = AbstractComponent.select(selectLocalBody);

			// Automatically select value from local body dropdown by index 1
			localBodyDropdown.selectByIndex(1);
		}

		// Fill pincode with random value (Assuming valid 6-digit number)
		pincode.sendKeys(String.valueOf(faker.number().numberBetween(100000, 999999)));

		// Click on "I consent to terms of use" checkbox
		iConsentToTermsOfUse.click();

		// Click on "Submit" button
		submit.click();
	}

	// fill registration popup details
	public void registerPopUp() {
		// Fill mobile number with random number
		mobileNumber.sendKeys(mobilenum);

		// Click on "Yuva" type
		yuvaType.click();

		// Select highest qualification
		Select highest_Qualification = AbstractComponent.select(selectQualification);
		highest_Qualification.selectByIndex(4); // Adjust as necessary

		waitForWebElementToVisible(sports);
		// Click on "Sports" checkbox
		sports.click();

		// Enter sports name in the modal with a random sport
		modalopen.sendKeys("Boxing" + Keys.ENTER);

		// Click on "Khel Participate" button
		khelParticipate.click();

		// Click on "Submit Features" button
		submitfeatures.click();
	}

	// Method to download registration certificate
	public void registrationCertificateDownload() throws InterruptedException {
		// Define the download directory path
		String downloadDirPath = "C:\\Users\\nisha\\eclipse-workspace\\MYBharat_completeFramework\\images";

		// Clean the folder before downloading
		cleanFolder(downloadDirPath);

		waitForWebElementToVisible(ImageButton);
		ImageButton.click();

		// Create a File object representing the download directory
		File downloadDir = new File(downloadDirPath);

		// Check if the folder exists
		if (downloadDir.exists() && downloadDir.isDirectory()) {
			// List all files in the folder
			File[] files = downloadDir.listFiles();

			// Print the list of files
			System.out.println("Files in folder: " + downloadDirPath);
			if (files != null) {
				for (File file : files) {
					System.out.println(file.getName());
				}
			}

			// Specify the file name to search for
			String fileName = "certificate";

			// Search for the file named "certificate"
			boolean found = false;
			if (files != null) {
				for (File file : files) {
					if (file.isFile() && file.getName().equals(fileName)) {
						System.out.println("File 'certificate' found in folder: " + downloadDirPath);
						found = true;
						break; // Exit the loop once the file is found
					}
				}
			}

			// If the file is not found
			if (!found) {
				System.out.println("File 'certificate' not found in folder: " + downloadDirPath);
			}
		} else {
			System.out.println("Folder does not exist or is not a directory: " + downloadDirPath);
		}

	}

}
