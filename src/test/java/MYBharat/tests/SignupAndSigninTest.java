package MYBharat.tests;

import java.io.IOException;
import org.testng.annotations.Test;
import MYBharat.TestComponents.BaseTest;

import MYBharat.pageobjects.Logout.Logout_Partner;
import MYBharat.pageobjects.Logout.Logout_Youth;
import MYBharat.pageobjects.Register.Register_NGO;
import MYBharat.pageobjects.Register.Register_NSSProgramOfficer;
import MYBharat.pageobjects.Register.Register_GovtPartner;
import MYBharat.pageobjects.Register.Register_Youth;
import MYBharat.pageobjects.Register.Register_Youthclub;
import MYBharat.pageobjects.logins.Login_Partner;
import MYBharat.pageobjects.logins.Login_Youth;

public class SignupAndSigninTest extends BaseTest {

    // Constructor should call the super constructor with null or default values
    public SignupAndSigninTest() {
        super(null); // Or call super() with a suitable WebDriver instance if necessary
    }

    @Test(enabled = true, priority = 1)
    public void youth_SignUp_Logout_Signin() throws IOException, InterruptedException {
        // Use the landingPage object from BaseTest
        landingPage.goTo();
        Register_Youth registerYouth = new Register_Youth(driver);
        registerYouth.register_verifyOTPandGoToRegistration();
        registerYouth.register();
        registerYouth.registerPopUp();
        registerYouth.registrationCertificateDownload();

        Login_Youth loginyouth = new Login_Youth(driver);
        String email = loginyouth.getemail();

        Logout_Youth logout = new Logout_Youth(driver);
        logout.logout_youth();
        System.out.println("Youth email is " + email);
        Login_Youth loginyouth1 = new Login_Youth(driver);
        loginyouth1.clearbrowsercache();
        loginyouth1.login(email);
    }

    @Test(enabled = true, priority = 2)
    public void youthClub_SignUp_Logout_Signin() throws IOException, InterruptedException {
        // Use the landingPage object from BaseTest
        landingPage.goTo();
        Register_Youthclub registerYouthClub = new Register_Youthclub(driver);
        String email = registerYouthClub.getSaltString();
        registerYouthClub.registration(email);

        Logout_Partner logout = new Logout_Partner(driver);
        logout.logout();
        Login_Partner Login = new Login_Partner(driver);
        System.out.println("Youth club email is " + email);
        Login.login(email);
    }

    @Test(enabled = true, priority = 3)
    public void NGO_SignUp_Logout_Signin() throws IOException, InterruptedException {
        // Use the landingPage object from BaseTest
        landingPage.goTo();
        Register_NGO registerNGO = new Register_NGO(driver);
        String email = registerNGO.getSaltString();
        registerNGO.registration(email);

        Logout_Partner logout = new Logout_Partner(driver);
        logout.logout();
        Login_Partner Login = new Login_Partner(driver);
        System.out.println("NGO email is " + email);
        Login.login(email);
    }

    @Test(enabled = true, priority = 4)
    public void Partner_Signup_Logout_Signin() throws IOException, InterruptedException {
        // Use the landingPage object from BaseTest
        landingPage.goTo();
        Register_GovtPartner registerPartner = new Register_GovtPartner(driver);
        String email = registerPartner.getSaltString();
        registerPartner.registration(email);

        Logout_Partner logout = new Logout_Partner(driver);
        logout.logout();
        Login_Partner Login = new Login_Partner(driver);
        System.out.println("Partner email is " + email);
        Login.login(email);
    }

    @Test(enabled = true, priority = 5)
    public void NSSProgramOfficer_Signup_Logout_Signin() throws IOException, InterruptedException {
        // Use the landingPage object from BaseTest
        landingPage.goTo();
        Register_NSSProgramOfficer registerNSSPO = new Register_NSSProgramOfficer(driver);
        String email = registerNSSPO.getSaltString();
        registerNSSPO.registration(email);

        Logout_Partner logout = new Logout_Partner(driver);
        logout.logout();
        Login_Partner Login = new Login_Partner(driver);
        System.out.println("NSSPO email is " + email);
        Login.login(email);
        
        
    }
    
    
    @Test(enabled = true, priority = 5)
    public void NSSProgramOfficer_Signup_Logout_Signin55() throws IOException, InterruptedException {
        // Use the landingPage object from BaseTest
        landingPage.goTo();
        Register_NSSProgramOfficer registerNSSPO = new Register_NSSProgramOfficer(driver);
        String email = registerNSSPO.getSaltString();
        registerNSSPO.registration(email);

        Logout_Partner logout = new Logout_Partner(driver);
        logout.logout();
        Login_Partner Login = new Login_Partner(driver);
        System.out.println("NSSPO email is " + email);
        Login.login(email);
    }
    
    
    
    @Test(enabled = true, priority = 5)
    public void NSSProgramOfficer_Signup_Logout_Signin56() throws IOException, InterruptedException {
        // Use the landingPage object from BaseTest
        landingPage.goTo();
        Register_NSSProgramOfficer registerNSSPO = new Register_NSSProgramOfficer(driver);
        String email = registerNSSPO.getSaltString();
        registerNSSPO.registration(email);

        Logout_Partner logout = new Logout_Partner(driver);
        logout.logout();
        Login_Partner Login = new Login_Partner(driver);
        System.out.println("NSSPO email is " + email);
        Login.login(email);
    }
    
    
    
    @Test(enabled = true, priority = 5)
    public void NSSProgramOfficer_Signup_Logout_Signin57() throws IOException, InterruptedException {
        // Use the landingPage object from BaseTest
        landingPage.goTo();
        Register_NSSProgramOfficer registerNSSPO = new Register_NSSProgramOfficer(driver);
        String email = registerNSSPO.getSaltString();
        registerNSSPO.registration(email);

        Logout_Partner logout = new Logout_Partner(driver);
        logout.logout();
        Login_Partner Login = new Login_Partner(driver);
        System.out.println("NSSPO email is " + email);
        Login.login(email);
    }
}
