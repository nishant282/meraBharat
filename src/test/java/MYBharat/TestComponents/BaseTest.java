package MYBharat.TestComponents;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import MYBharat.pageobjects.LandingPage;
import MYBharat.AbstractComponents.AbstractComponent;

public class BaseTest extends AbstractComponent {

    protected WebDriver driver;  // WebDriver instance for browser interaction
    protected LandingPage landingPage;  // LandingPage instance for page-specific actions

    /**
     * Constructor to initialize WebDriver and load properties from parent class.
     * 
     * @param driver WebDriver instance used for browser interaction.
     */
    public BaseTest(WebDriver driver) {
        super(driver);  // Initialize properties from AbstractComponent
        this.driver = driver;
    }

   

	/**
     * Initializes the WebDriver based on the browser specified in the properties file.
     * 
     * @return WebDriver instance configured for the specified browser.
     * @throws IOException If there is an issue loading the properties file.
     */
    public WebDriver initializeDriver() throws IOException {
        // Retrieve the browser name from properties
        String browserName = getProperty("browser");

        // Initialize WebDriver based on the browser specified
        switch (browserName.toLowerCase()) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browserName);
        }

        // Configure WebDriver timeouts and window settings
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        return driver;
    }

    /**
     * Captures a screenshot of the current browser window.
     * 
     * @param testCaseName The name of the test case for naming the screenshot file.
     * @return The file path of the saved screenshot.
     * @throws IOException If there is an issue saving the screenshot file.
     */
    public String getScreenshot(String testCaseName) throws IOException {
        TakesScreenshot scr = (TakesScreenshot) driver;
        File source = scr.getScreenshotAs(OutputType.FILE);
        // Define the path for saving the screenshot
        String screenshotPath = System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
        FileUtils.copyFile(source, new File(screenshotPath));
        return screenshotPath;
    }

    /**
     * Sets up the test environment before each test method.
     * 
     * @return LandingPage instance to interact with the application.
     * @throws IOException If there is an issue initializing the driver.
     */
    @BeforeMethod(alwaysRun = true)
    public LandingPage launchApplication() throws IOException {
        driver = initializeDriver();  // Initialize WebDriver
        landingPage = new LandingPage(driver);  // Initialize LandingPage
        landingPage.goTo();  // Navigate to the application
        return landingPage;
    }

    /**
     * Cleans up the test environment after each test method.
     * Closes the browser and releases resources.
     */
 // Flag to determine whether to close the browser after tests
      private boolean shouldCloseBrowser = false;

    @AfterMethod(alwaysRun = false) // This method runs after each test method if it passes
    public void tearDown() {
        // Check if the browser should be closed and if the driver is not null
        if (shouldCloseBrowser && driver != null) {
            driver.quit();  // Close the browser if the flag is true
        }
    }
}
