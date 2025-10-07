import static resources.enums.BrowserType.*;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.Pages.HomePage;

import resources.ConfigReader;
import resources.DriverFactory;

public class HomeTest {
    
    private WebDriver driver;
    private ConfigReader config;
    private HomePage homePage;
    
    @BeforeTest
    public void setUp() {

        // Actuators initialization
        config = new ConfigReader();
        driver = DriverFactory.getDriver(CHROME);
        homePage = new HomePage(driver);

        // Navigate to the URL from config
        driver.get(config.getProperty("homeurl"));
    }    
    @Test
    public void checkTitle () {        
        // Assertion to verify the page title
        Assert.assertEquals(homePage.getHomePageUrl(), "Automation Exercise");
    }
    @AfterTest
    public void tearDown() {
        DriverFactory.tearDown();
    }
}
