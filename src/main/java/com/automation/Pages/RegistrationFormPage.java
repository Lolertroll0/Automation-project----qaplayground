package com.automation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import resources.BaseTest;

public class RegistrationFormPage extends BaseTest {

    private String firstName;
    private String lastname;
    private String address;
    private String state;
    private String city;
    private String zipcode;
    private String phone;
    private String password;

    /// POM Locators and Methods of home page
    
    public RegistrationFormPage (WebDriver driver, String firstName, String lastname, String address, String state, String city, String zipcode, String phone, String password) {       
        super(driver);
        this.firstName = firstName;
        this.lastname = lastname;
        this.address = address;
        this.state = state;
        this.city = city;
        this.zipcode = zipcode;
        this.phone = phone;
        this.password = password;
    }
    
    private By misterCheck      = By.xpath("//input[@id=\"id_gender1\"]");
    private By passwordField    = By.id("password");
    private By firstNameField   = By.id("first_name");
    private By lastNameField    = By.id("last_name");
    private By addressField     = By.id("address1");
    private By stateField       = By.id("state");
    private By cityField        = By.id("city");
    private By zipCodeField     = By.id("zipcode");
    private By phoneField       = By.id("mobile_number");
    private By submitButton     = By.xpath("//form [@action = \"/signup\"] //button [@data-qa = \"create-account\"]");
    
    private By daysDropdown     = By.id("days");
    private By monthsDropdown   = By.id("months");
    private By yearsDropdown    = By.id("years");
    private By countryDropdown  = By.id("country");
    
    private By successfulRegistration = By.xpath("//h2[@data-qa=\"account-created\"]//b");
    
    public void fillForm () throws NoSuchElementException{

        findElement(misterCheck).click();

        sendKeys(password, passwordField);
        sendKeys(firstName, firstNameField);
        sendKeys(lastname, lastNameField);
        sendKeys(address, addressField);
        sendKeys(state, stateField);
        sendKeys(city, cityField);
        sendKeys(zipcode, zipCodeField);
        sendKeys(phone, phoneField);
    }

    public void submitForm () {
        waitForClickable(submitButton, 2).click();
    }

    public void fillDropdown (String day, String month, String year, String country) {

        Select selectDays   = new Select(findElement(daysDropdown));
        Select selectMonths = new Select(findElement(monthsDropdown));
        Select selectYears  = new Select(findElement(yearsDropdown));
        Select selectCountry= new Select(findElement(countryDropdown));

        selectDays.selectByValue(day);
        selectMonths.selectByVisibleText(month);
        selectYears.selectByValue(year);
        selectCountry.selectByValue(country);

    }

    public void isSuccessful () {
        Assert.assertTrue(getWebTitle().toLowerCase().contains("Created".toLowerCase()), "Text doesn't match");
    }
    

}


