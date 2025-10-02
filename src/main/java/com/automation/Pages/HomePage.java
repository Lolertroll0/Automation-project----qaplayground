package com.automation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import resources.BaseTest;

public class HomePage extends BaseTest{
    
    /// POM Locators and Methods of home page
    public HomePage (WebDriver driver) {
        super(driver);
    }

    private final By webTitle = By.xpath("/html/body/nav/div[1]");
    private final By loginButton = By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[4]/a");
    private final By userDisplayed = By.xpath("/html/body/header/div/div/div/div[2]/div/ul/li[10]/a/b");

    public String getHomeTitle () {
        return findElement(webTitle).getText();
    }

    public void goToLoginPage () {
        waitForClickable(loginButton, 3).click();
    }

    public String getDisplayedUser () {
        return findElement(userDisplayed).getText();
    }
}
