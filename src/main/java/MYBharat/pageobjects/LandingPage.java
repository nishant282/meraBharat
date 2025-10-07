package MYBharat.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import MYBharat.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

    private WebDriver driver;

    /**
     * Constructor to initialize WebDriver and PageFactory.
     * 
     * @param driver WebDriver instance used for browser interaction.
     */
    public LandingPage(WebDriver driver) {
        super(driver);  // Initialize properties from the AbstractComponent
        this.driver = driver;
        PageFactory.initElements(driver, this);  // Initialize WebElements in this class
    }

    /**
     * Navigates to the URL specified in the properties file under the key "environment".
     */
    public void goTo() {
        String webUrl = getProperty("environment");  // Retrieve URL from properties
        driver.get(webUrl);  // Navigate to the URL
    }
}
