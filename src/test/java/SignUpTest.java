//Enums
import static resources.enums.BrowserType.*;

// Expections
import java.util.NoSuchElementException;

// Libraries
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

// Local Imports
import com.automation.Pages.SignUpPage;
import resources.ConfigReader;
import resources.DriverFactory;

public class SignUpTest {
    private WebDriver driver;
    private ConfigReader config;
    private SignUpPage signUp;
    
    @BeforeTest
    public void setUp() {

        // Actuators initialization
        config = new ConfigReader();
        driver = DriverFactory.getDriver(CHROME);
        signUp = new SignUpPage(driver);

        // Navigate to the URL from config
        driver.get(config.getProperty("homeurl"));
        signUp.isDocumentReady();
    }    
   
    @Test (description="Just checking if we reach signUp form URL from Home URL")
    public void newUserNameAndPassword () {
        try {
            signUp.clicOnLoginButton();
            Assert.assertEquals(driver.getCurrentUrl(), "https://www.automationexercise.com/login");
            Assert.assertEquals(signUp.isDocumentReady(), true);

            signUp.enterParameter(config.getProperty("user"), config.getProperty("email"));
            Assert.assertTrue(driver.getCurrentUrl().equals("https://www.automationexercise.com/signup"));

        } catch (org.openqa.selenium.NoSuchElementException ex){
            System.err.println("Element was not found " + ex);
            throw ex;
        } catch (AssertionError ex) {
            System.err.println("An Assersion failed during runtime: " + ex);
            throw ex;
        }
    }

    @AfterTest
    public void tearDown() {    
        DriverFactory.tearDown();
    }
}
