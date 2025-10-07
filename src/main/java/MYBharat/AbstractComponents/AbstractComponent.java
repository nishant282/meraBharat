package MYBharat.AbstractComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {

    protected WebDriver driver;  // WebDriver instance for interacting with the browser
    private Properties properties;  // Properties object to store configuration data

    /**
     * Constructor to initialize WebDriver and load properties.
     * 
     * @param driver WebDriver instance used for browser interaction.
     */
    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
        // Define the path to the properties file
        String propertiesFilePath = System.getProperty("user.dir") + "//src//main//java//MYBharat//resources//GlobalData.properties";
        // Load properties from the file
        properties = loadProperties(propertiesFilePath);
    }

    /**
     * Loads properties from the specified file path.
     * 
     * @param filePath The path to the properties file.
     * @return A Properties object containing the loaded properties.
     */
    private Properties loadProperties(String filePath) {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(filePath)) {
            properties.load(fis);
        } catch (IOException ex) {
            System.err.println("Error loading properties file: " + ex.getMessage());
            ex.printStackTrace();
        }
        return properties;
    }

    /**
     * Gets the property value for the given key.
     * 
     * @param key The key of the property.
     * @return The value of the property.
     */
    protected String getProperty(String key) {
        return properties.getProperty(key);
    }

    // Waits for an OTP field to have exactly 6 digits
    public void waitForOTP() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
        final WebElement otpField = driver.findElement(By.xpath("//input[@id='otp']"));
        ExpectedCondition<Boolean> otpFieldHas6Digits = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return otpField.getAttribute("value").length() == 6;
            }
        };
        wait.until(otpFieldHas6Digits);
    }

    // Scrolls the page by the specified percentage
    public void scrollPage(int scrollpercent) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + scrollpercent + ")");
    }

    /**
     * Generates a random string of specified length using alphanumeric characters.
     * 
     * @return A random string.
     */
    protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // Length of the random string
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();
    }

    /**
     * Generates a random 10-digit number as a string.
     * 
     * @return A 10-digit number string.
     */
    public static String get10DigitNumber() {
        Random random = new Random();
        StringBuilder mobileNumber = new StringBuilder("9"); // Start with '9'

        // Generate the remaining 9 digits
        for (int i = 1; i < 10; i++) {
            int digit = random.nextInt(10); // Generate a random digit (0-9)
            mobileNumber.append(digit);
        }

        return mobileNumber.toString(); // Return the complete 10-digit number
    }

    /**
     * Waits for the specified WebElement to be visible.
     * 
     * @param findBy WebElement to wait for visibility.
     */
    public void waitForWebElementToVisible(WebElement findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }

    /**
     * Waits for the specified WebElement to be clickable.
     * 
     * @param findBy WebElement to wait for clickability.
     */
    public void waitForWebElementToClickable(WebElement findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.elementToBeClickable(findBy));
    }
    
    
    /**
     * Waits for the specified WebElement to be Visible.
     * 
     * @param locator WebElement to wait for Visible.
     */
    public void waitForWebElementToVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click(); // Click the element once it is visible
    }

    
    
    

    /**
     * Deletes all files in the specified folder.
     * 
     * @param folderPath The path to the folder to clean.
     */
    public void cleanFolder(String folderPath) {
        File folder = new File(folderPath);
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    file.delete();
                    System.out.println("Deleted file: " + file.getName());
                }
            }
            System.out.println("Folder cleaned successfully.");
        } else {
            System.out.println("Folder does not exist or is not a directory.");
        }
    }

    /**
     * Clears browser cache by clearing local storage, session storage, and reloading the page.
     */
    public void clearBrowserCache() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.localStorage.clear();");
        jsExecutor.executeScript("window.sessionStorage.clear();");
        jsExecutor.executeScript("window.location.reload();");
    }

    /**
     * Writes data to an Excel sheet.
     * 
     * @param data The data to write.
     * @param workbook The workbook to write to.
     * @param excelFilePath The path to the Excel file.
     */
    public void writeToExcel(String data, Workbook workbook, String excelFilePath) {
        Sheet sheet = workbook.getSheet("Data");
        if (sheet == null) {
            sheet = workbook.createSheet("Data");
        }
        int rowNum = sheet.getLastRowNum() + 1;
        Row row = sheet.createRow(rowNum);
        Cell cell = row.createCell(0);
        cell.setCellValue(data);
        try (FileOutputStream fileOut = new FileOutputStream(excelFilePath)) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns a Select object for interacting with dropdown elements.
     * 
     * @param dropdownElement The WebElement representing the dropdown.
     * @return A Select object.
     */
    public static Select select(WebElement dropdownElement) {
        return new Select(dropdownElement);
    }
}
