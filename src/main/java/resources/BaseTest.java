package resources;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    private WebDriver driver;

    public BaseTest(WebDriver driver) {
        this.driver = driver;
    }

    
    public WebElement findElement (By locator) {
        return driver.findElement(locator);
    }

    public Boolean isDocumentReady () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            return wait.until(webDriver -> 
                ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState")
                .toString().equals("complete") 
                );
        } catch (TimeoutException e) {
            return false;
        }
    }

    public WebElement waitForVisibility (By locator, int seconds) throws NoSuchElementException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    public void sendKeys (String text, By target) throws NoSuchElementException{
        driver.findElement(target).sendKeys(text);
    }
}
