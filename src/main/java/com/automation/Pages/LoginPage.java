package com.automation.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import resources.BaseTest;
public class LoginPage extends BaseTest{
    
    private final String email, password;

    public LoginPage (WebDriver driver, String email, String password) {
        super(driver);
        this.email = email;
        this.password = password;
    }

    private final By emailField     = By.xpath("//form[@action=\"/login\"]//input[@data-qa=\"login-email\"]");
    private final By passwordField  = By.xpath("//form[@action=\"/login\"]//input[@data-qa=\"login-password\"]");
    private final By loginButton    = By.xpath("//form[@action=\"/login\"]//button");
    
    public void fillForm () {
        sendKeys(email, emailField);
        sendKeys(password, passwordField);
    }
    
    public void sendForm () {
        waitForClickable(loginButton, 3).click();
    }
}
