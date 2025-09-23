package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseTest {
    private WebDriver driver;

    public BaseTest(WebDriver driver) {
        this.driver = driver;
    }

    
    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }
}
