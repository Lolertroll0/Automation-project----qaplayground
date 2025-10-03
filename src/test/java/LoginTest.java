import java.util.NoSuchElementException;

import static resources.enums.BrowserType.*;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.automation.Pages.LoginPage;
import com.automation.Pages.HomePage;

import resources.*;


public class LoginTest extends BaseTest {

    private WebDriver driver;
    private ConfigReader config;
    private LoginPage login;
    private HomePage home;

    public LoginTest(WebDriver driver) {
        super(driver);
    }

    @BeforeTest
    public void setUp() {

        // Actuators initialization
        config = new ConfigReader();
        driver = DriverFactory.getDriver(CHROME);
        login = TestDataFactory.loginData(config, driver);
        home = new HomePage(driver);
        // Navigate to the URL from config
        driver.get(config.getProperty("homeurl"));
        login.isDocumentReady();
        home.goToLoginPage();
    } 

    @Test (description="try to login successfully")
    public void successfulLogin (){
        try {
            Assert.assertTrue(login.getCurrentURL().contains("https://www.automationexercise.com/login"));
            login.fillForm();
            login.sendForm();
            Assert.assertTrue(home.getDisplayedUser().toLowerCase()
                                .contains(config.getProperty("user").toLowerCase()));

        } catch (NoSuchElementException ex){
            System.err.println("Element was not found " + ex);
            throw ex;
        } catch (AssertionError ex){
            System.err.println("An Assersion Failed during Runtime " + ex);
            throw ex;
        } 
    }
}
