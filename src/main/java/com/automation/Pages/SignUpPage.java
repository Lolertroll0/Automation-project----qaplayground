package com.automation.Pages;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.BaseTest;

public class SignUpPage extends BaseTest{

    private WebDriver driver;
    private WebElement iloginButton;

    /// POM Locators and Methods of home page
    public SignUpPage (WebDriver driver) { 
        super(driver);
        this.driver = driver;
    }
    
    private By loginButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    private By nameField = By.xpath ("//form[@action=\"/singup\"]//input[@name=\"name\"]");
    private By emailField = By.xpath ("//form[@action=\"/singup\"]//input[@name=\"email\"]");  
    private By submitButton = By.linkText("Signup");

    public void clicOnLoginButton () throws NoSuchElementException{      
        waitForVisibility(loginButton, 10).click();
    }

    public void enterParameter (String user, String email) throws NoSuchElementException{       

        sendKeys(user, nameField);
        sendKeys(email, emailField);
        
        findElement(submitButton).click();
    }
}
