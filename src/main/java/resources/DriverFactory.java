package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import resources.enums.BrowserType;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver getDriver(BrowserType browser) {
        if (driver != null) {
            return driver;
        } else {
            driver = intializeWebDriver(browser);
            return driver;
        }
    }
    
    private static WebDriver intializeWebDriver(BrowserType browser) {
        switch (browser) {
            case CHROME -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
        
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                //chromeOptions.addArguments("--headless=new");

                return new ChromeDriver(chromeOptions);
            }

            case FIREFOX -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
        
                firefoxOptions.addArguments("--no-sandbox");
                firefoxOptions.addArguments("--disable-dev-shm-usage");
                firefoxOptions.addArguments("--headless=new");

                return new FirefoxDriver(firefoxOptions);
            }

            case EDGE -> {
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                
                edgeOptions.addArguments("--no-sandbox");
                edgeOptions.addArguments("--disable-dev-shm-usage");
                edgeOptions.addArguments("--headless=new");

                return new EdgeDriver(edgeOptions);
            }
                
            default -> throw new IllegalArgumentException("Browser not supported");
        }     
    }

    public static void tearDown (){
        if (driver != null) {
            driver.quit();
            driver = null;
        } else {
            System.out.println("Driver is already null.");
        }
    }
}
