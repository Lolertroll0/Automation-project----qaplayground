package com.automation.resources;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
    private static WebDriver driver;

    public WebDriver getDriver(WebDriver driver) {
        if (driver != null) {
            return driver;
        } else {
            WebDriverManager.chromedriver().setup();
            
            return this.driver;
        }
    }
    public static WebDriver setup() {
        ChromeOptions options = new ChromeOptions();
        
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        // options.addArguments("--headless=new");

        driver = new ChromeDriver(options);
        return driver;
    }
}
