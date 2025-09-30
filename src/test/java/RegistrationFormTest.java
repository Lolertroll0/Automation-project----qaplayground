import static resources.enums.BrowserType.*;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.Pages.HomePage;
import com.automation.Pages.RegistrationFormPage;
import com.automation.Pages.SignUpPage;
import resources.*;

import resources.*;


public class RegistrationFormTest {

    private WebDriver driver;
    private ConfigReader config;
    private SignUpPage signUp;
    private RegistrationFormPage registrator;
    
    @BeforeTest
    public void setUp() {

        // Actuators initialization
        config = new ConfigReader();
        driver = DriverFactory.getDriver(CHROME);
        registrator = TestDataFactory.registrationData(config, driver);
        signUp = new SignUpPage (driver);

        // Navigate to the URL from config

        driver.get(config.getProperty("homeurl"));
    }    
    @Test 
    public void registerNewUser () {        
        try {
            signUp.clicOnLoginButton();
            Assert.assertEquals(driver.getCurrentUrl(), "https://www.automationexercise.com/login");
            Assert.assertEquals(signUp.isDocumentReady(), true);

            signUp.enterParameter(config.getProperty("user"), config.getProperty("email"));
            Assert.assertEquals(driver.getCurrentUrl(), "https://www.automationexercise.com/signup");

            registrator.fillForm();
            registrator.fillDropdown(config.getProperty("day"),
                                     config.getProperty("month"),
                                     config.getProperty("year"),
                                     config.getProperty("country"));

            registrator.submitForm();

            Assert.assertEquals(driver.getCurrentUrl(), "https://www.automationexercise.com/account_created");
            registrator.isSuccessful();

        } catch (org.openqa.selenium.NoSuchElementException ex){
            System.out.println("Element was not found: " + ex);
        } catch (AssertionError ex) {
            System.out.println("An Assersion failed during runtime: " + ex);
        }
        
    }
    @AfterTest
    public void tearDown() {
        DriverFactory.tearDown();
    }
}
