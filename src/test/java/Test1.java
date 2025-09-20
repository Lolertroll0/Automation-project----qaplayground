import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.resources.DriverFactory;

public class Test1 {
    private WebDriver driver;

@Test
    public void openGoogle() {
        DriverFactory factory = new DriverFactory();
        driver = factory.driverSetup();
        driver.get("https://www.google.com");
        assert driver.getTitle().contains("Google");
        Assert.assertTrue(driver.getTitle().contains("Google"), "Title does not contain 'Google'");
   }
}
