import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.resources.ConfigReader;
import com.automation.resources.DriverFactory;

public class Test1   {
    private WebDriver driver;
    private ConfigReader config;
@BeforeMethod
    public void driverSetup() {
        config = new ConfigReader();
        driver = DriverFactory.setup();
        driver.get(config.getProperty("baseurl"));
    }
@Test
    public void openGoogle() {
        assert driver.getTitle().contains("Playground for the QA automation engineers");
        Assert.assertTrue(driver.getTitle().contains("Playground"), "Title does not contain 'Playground'");
   }
@AfterTest (enabled=false)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
