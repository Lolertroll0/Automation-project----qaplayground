import org.openqa.selenium.WebDriver;

import com.automation.resources.DriverFactory;

public class Test {
    private WebDriver driver;

    public void openGoogle() {
        DriverFactory factory = new DriverFactory();
        driver = factory.driverSetup();
        driver.get("https://www.google.com");
   }
}
