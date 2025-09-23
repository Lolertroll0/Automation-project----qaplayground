
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.Pages.HomePage;

import resources.ConfigReader;
import resources.DriverFactory;
import static resources.enums.BrowserType.*;

public class HomeTest {
    private WebDriver driver;
    private ConfigReader config;
    private HomePage search;
    
    @BeforeTest
    public void setUp() {

        // Actuators initialization
        config = new ConfigReader();
        driver = DriverFactory.getDriver(FIREFOX);
        search = new HomePage(driver);

        // Navigate to the URL from config
        driver.get(config.getProperty("baseURL"));
    }    
    @Test
    public void checkLogo() {        
        // Assertion to verify the page title
        Assert.assertEquals(search.getTitle(), "QA Playground");
    }
    @AfterTest
    public void tearDown() {
        DriverFactory.tearDown();
    }
}
