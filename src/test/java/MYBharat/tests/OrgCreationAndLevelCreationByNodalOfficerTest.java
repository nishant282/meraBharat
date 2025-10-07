package MYBharat.tests;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import MYBharat.TestComponents.BaseTest;
import MYBharat.TestComponents.Retry;
import MYBharat.pageobjects.LevelCreationByNodalOfficerAndAddSubUser;
import MYBharat.pageobjects.Login_errorMessage;
import MYBharat.pageobjects.PoliceOrgCreation;

public class OrgCreationAndLevelCreationByNodalOfficerTest extends BaseTest {

    // Default constructor
    public OrgCreationAndLevelCreationByNodalOfficerTest() {
        super(null); // Call the super constructor with null or remove if using default BaseTest setup
    }

    @Test(dataProvider = "orgCreationData", priority = 1, enabled = true)
    public void policeOrganisationCreation(String SuperAdmin, String nodalOfficerNumber, String nodalofficeremail) throws InterruptedException, IOException {
        // Use the login object from BaseTest
        Login_errorMessage login = new Login_errorMessage(driver);
        login.AsPartnerUsingPhoneOrEmail(SuperAdmin);
        
        PoliceOrgCreation org = new PoliceOrgCreation(driver);
        org.OrgCreation(nodalOfficerNumber, nodalofficeremail);
    }

    @Test(dataProvider = "levelCreationData", priority = 2, enabled = true, retryAnalyzer = Retry.class)
    public void levelCreation(String nodalOfficeremail, String subUser) {
        // Use the login object from BaseTest
        Login_errorMessage login = new Login_errorMessage(driver);
        login.AsPartnerUsingPhoneOrEmail(nodalOfficeremail);
        
        LevelCreationByNodalOfficerAndAddSubUser levelCre = new LevelCreationByNodalOfficerAndAddSubUser(driver);
        levelCre.levelCreation();
        levelCre.addSubUser(subUser);
    }

    @DataProvider
    public Object[][] orgCreationData() {
        return new Object[][] {
            {"nishant90001@yopmail.com", "9056789456", "nishant3334@yopmail.com"}
        };
    }

    @DataProvider
    public Object[][] levelCreationData() {
        return new Object[][] {
            {"nishant3334@yopmail.com", "7217537114"}
        };
    }
}
