package com.automation.Pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import resources.BaseTest;

public class SignUpPage extends BaseTest{

    /// POM Locators and Methods of home page
    public SignUpPage (WebDriver driver) { 
        super(driver);      
    }
    
    private final By loginButton =  By.xpath ("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    private final By nameField =    By.xpath ("//form[@action=\"/signup\"]//input[@placeholder=\"Name\"]");
    private final By emailField =   By.xpath ("//form[@action=\"/signup\"]//input[@name=\"email\"]");  
    private final By submitButton = By.xpath ("//form[@action=\"/signup\"]//button[@data-qa=\"signup-button\"]");

    public void clicOnLoginButton () throws NoSuchElementException{      
        waitForVisibility(loginButton, 10).click();
    }

    public void enterParameter (String user, String email) throws NoSuchElementException{       

        sendKeys(user, nameField);
        sendKeys(email, emailField);
        
        findElement(submitButton).click();
    }
}
