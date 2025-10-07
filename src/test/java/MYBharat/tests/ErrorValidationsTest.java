package MYBharat.tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import MYBharat.TestComponents.BaseTest;
import MYBharat.pageobjects.Login_errorMessage;

public class ErrorValidationsTest extends BaseTest {

    // Default constructor
    public ErrorValidationsTest() {
        super(null); // Call the super constructor with null or remove if using default BaseTest setup
    }

    @Test
    public void OTPErrorValidation() throws IOException {
        // Use the login object from BaseTest
        Login_errorMessage partnerLogin = new Login_errorMessage(driver);
        partnerLogin.AsPartnerUsingPhoneOrEmail("7777777777"); // Partner phone number
        
        // Assert that the error message is as expected
        Assert.assertEquals(partnerLogin.getErrorMessage(), "Please enter valid OTP.");
    }
}
