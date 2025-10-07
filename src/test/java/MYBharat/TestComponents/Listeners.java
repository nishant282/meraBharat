package MYBharat.TestComponents;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import MYBharat.resources.ExtentReporterNG;

/**
 * Listeners class to handle TestNG events and integrate with ExtentReports.
 */
public class Listeners extends BaseTest implements ITestListener {

    private ExtentTest test;  // ExtentTest instance for reporting
    private ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();  // Thread-safe ExtentTest instance
    private ExtentReports extent = ExtentReporterNG.getReportObject();  // ExtentReports instance

    // No-argument constructor
    public Listeners() {
        super(null); // Call the parent constructor; no need to pass driver
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Create a new test in ExtentReports
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);  // Store the test instance in ThreadLocal
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Log test success in ExtentReports
        extentTest.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Log test failure and capture screenshot
        extentTest.get().fail(result.getThrowable());

        // Retrieve WebDriver instance from the test context
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        if (driver != null) {
            String filePath = null;
            try {
                // Capture screenshot and add it to ExtentReports
                filePath = getScreenshot(result.getMethod().getMethodName());
                extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("WebDriver instance not found in the test context.");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Log test skipped status (optional implementation)
        extentTest.get().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Handle partial successes if needed (optional implementation)
        extentTest.get().log(Status.WARNING, "Test failed but within success percentage");
    }

    @Override
    public void onStart(ITestContext context) {
        // Called before the start of any test methods (optional implementation)
    }

    @Override
    public void onFinish(ITestContext context) {
        // Flush ExtentReports to write all data to the report
        extent.flush();
    }
}
