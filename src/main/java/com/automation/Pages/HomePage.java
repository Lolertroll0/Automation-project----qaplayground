package com.automation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import resources.BaseTest;

public class HomePage extends BaseTest{
    
    /// POM Locators and Methods of home page
    public HomePage (WebDriver driver) {
        super(driver);
    }

    private By webTitle = By.xpath("/html/body/nav/div[1]");

}
