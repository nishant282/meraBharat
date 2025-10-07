package MYBharat.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import MYBharat.AbstractComponents.AbstractComponent;

public class YouthELOVerificationByPartnerAndAssignTask extends AbstractComponent {

	WebDriver driver;

	public YouthELOVerificationByPartnerAndAssignTask(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//a[@title='Experiential Learning']") 
	WebElement experientialLearning;
	
	@FindBy(xpath="//div[@id='live']//a[contains(text(),'Ghaziabad - Experiential Le')]") 
	WebElement Experiential;
	
	@FindBy(xpath="//a[@class='btn btn_new btn-sm']") 
	WebElement approve;

	@FindBy(xpath="//a[@href='#Approved']") 
	WebElement approved1;
	
	@FindBy(xpath="//a[@id='assign_approve']") 
	WebElement assign;
	
	@FindBy(xpath="//a[normalize-space()='Yes']") 
	WebElement yes;
	
	@FindBy(xpath="//input[@placeholder='Task Title']") 
	WebElement taskTitle;
	
	@FindBy(xpath="//select[@name='task") 
	WebElement taskType;
	
	@FindBy(xpath="//input[@placeholder='weightage percentage']") 
	WebElement weightagePercentage;
	
	
	@FindBy(xpath="//input[@placeholder='Start Date']") 
	WebElement startDate;
	
	@FindBy(xpath="//input[@placeholder='End Date']") 
	WebElement endDate;
	
	@FindBy(xpath="//textarea[@id='comment']")
	WebElement taskDescription;
	
	@FindBy(xpath="//input[@name='files") 
	WebElement files;
	
	@FindBy(xpath="//input[@id='save_task']")
	WebElement submitBtn;
	
	public void ELOVerification() {
		experientialLearning.click();
		Experiential.click();
		approve.click();
		approved1.click();
		assign.click();
		yes.click();
		taskTitle.sendKeys("This is task title");
		
		Select selectTaskType = new Select(taskType);
		selectTaskType.selectByVisibleText("Field Based");
		
		weightagePercentage.sendKeys("100");
		
		startDate.click();
		
		// select start date
		while (!driver.findElement(By.className("datepicker-switch")).getText().contains("January 2024")) {
			driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][normalize-space()='»']"))
					.click();
		}

		driver.findElement(By.cssSelector("#interest_date_0")).click();
		int count = driver.findElements(By.className("day")).size();

		for (int i = 0; i < count; i++) {
			String text = driver.findElements(By.className("day")).get(i).getText();
			if (text.equalsIgnoreCase("2")) {
				driver.findElements(By.className("day")).get(i).click();
				break;
			}

		}

		
		endDate.click();
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
		
		taskDescription.sendKeys("This is Description");
		files.sendKeys("www.google.com");
		submitBtn.click();
		
	}

	
	   

}
