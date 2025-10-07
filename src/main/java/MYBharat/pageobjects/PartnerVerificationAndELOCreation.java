package MYBharat.pageobjects;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;




import MYBharat.AbstractComponents.AbstractComponent;

public class PartnerVerificationAndELOCreation extends AbstractComponent {

	WebDriver driver;

	public PartnerVerificationAndELOCreation(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='Organization Users']")
	WebElement organizationUsers;

	@FindBy(xpath = "//tr[@class='odd']//span[@class='badge badge-success status'][normalize-space()='Approve']")
	WebElement approve1;

	@FindBy(xpath = "//a[@id='yes']")
	WebElement approvalYes;

	@FindBy(xpath = "//span[@class='title'][normalize-space()='Experiential Learning']")
	WebElement experientialLearning;

	@FindBy(xpath = "//button[normalize-space()='Add Experiential Learning']")
	WebElement addExperientialLearning;

	@FindBy(xpath = "//select[@id='credit_hour']")
	WebElement selectDuration;

	@FindBy(xpath = "//select[@id='thana_list']")
	WebElement selectDistrict;

	@FindBy(xpath = "//input[@id='vacancies']")
	WebElement noOfVacancies;

	@FindBy(css = "#interest_date_0")
	WebElement startdate;

	@FindBy(css = "#interest_end_date_0")
	WebElement endDate;

	@FindBy(xpath = "//select[@id='internship_status']")
	WebElement selectMode;

	@FindBy(css = "#s2id_autogen2")
	WebElement s2idAutogen2;

	@FindBy(xpath = "//textarea[@name='short_desc']")
	WebElement shortDesc;

	@FindBy(xpath = "//select[@id='eligibility_criteria']")
	WebElement selectEligibilityCriteria;

	@FindBy(xpath = "//input[@id='show_interest_date']")
	WebElement showInterestDate;

	@FindBy(css="#img_path1") 
	WebElement browse;

	@FindBy(xpath = "//button[@id='submit']")
	WebElement preview;

	@FindBy(xpath = "(//a[normalize-space()='Publish'])[1]")
	WebElement publish;

	public void partnerVerificationByNodalOfficer() {
		organizationUsers.click();
		approve1.click();
		approvalYes.click();
	}

	public void ELOCreation() {
		experientialLearning.click();
		addExperientialLearning.click();

		Select duration = new Select(selectDuration);
		duration.selectByVisibleText("120");

		Select location = new Select(selectDistrict);
		location.selectByIndex(1);

		noOfVacancies.sendKeys("2");

		startdate.click();
		// select start date
		while (!driver.findElement(By.className("datepicker-switch")).getText().contains("January 2024")) {
			driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][normalize-space()='»']"))
					.click();
		}

		driver.findElement(By.cssSelector("#interest_date_0")).click();
		int count = driver.findElements(By.className("day")).size();

		for (int i = 0; i < count; i++) {
			String text = driver.findElements(By.className("day")).get(i).getText();
			if (text.equalsIgnoreCase("1")) {
				driver.findElements(By.className("day")).get(i).click();
				break;
			}

		}

		endDate.click();

		// select end date
		while (!driver.findElement(By.className("datepicker-switch")).getText().contains("January 2024")) {
			driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][normalize-space()='»']"))
					.click();
		}

		// Grab common attribute//Put into list and iterate
		int count1 = driver.findElements(By.className("day")).size();

		for (int i = 0; i < count1; i++) {
			String text = driver.findElements(By.className("day")).get(i).getText();
			if (text.equalsIgnoreCase("30")) {
				driver.findElements(By.className("day")).get(i).click();
				break;
			}

		}

		Select mode = new Select(selectMode);
		mode.selectByVisibleText("Continuous");

		s2idAutogen2.sendKeys("Human Resource");
		Actions action1 = new Actions(driver);
		action1.keyDown(Keys.ENTER).build().perform();

		shortDesc.sendKeys("As a Software Development Intern, you will work closely with our engineering team, contributing to real-world projects that will be deployed to thousands of users. This is a unique opportunity to apply your classroom knowledge, learn from experienced developers, and gain valuable industry experience.");

		Select eligiblityCriteria = new Select(selectEligibilityCriteria);
		eligiblityCriteria.selectByVisibleText("Graduation");

		showInterestDate.click();

		// Interest shown date
		while (!driver.findElement(By.className("datepicker-switch")).getText().contains("December 2023")) {
			driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][normalize-space()='»']"))
					.click();
		}

		// Grab common attribute//Put into list and iterate
		int count2 = driver.findElements(By.className("day")).size();

		for (int i = 0; i < count2; i++) {
			String text = driver.findElements(By.className("day")).get(i).getText();
			if (text.equalsIgnoreCase("1")) {
				driver.findElements(By.className("day")).get(i).click();
				break;
			}

		}
		
		
		
		browse.sendKeys(System.getProperty("user.dir")+"//images//1.jpeg");
		preview.click();
		publish.click();
	}

}
