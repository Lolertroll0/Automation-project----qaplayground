package com.automation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import resources.BaseTest;

public class RegistrationFormPage extends BaseTest {

    private final String firstName;
    private final String lastname;
    private final String address;
    private final String state;
    private final String city;
    private final String zipcode;
    private final String phone;
    private final String password;

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
    
    private final By misterCheck      = By.xpath("//input[@id=\"id_gender1\"]");
    private final By passwordField    = By.id("password");
    private final By firstNameField   = By.id("first_name");
    private final By lastNameField    = By.id("last_name");
    private final By addressField     = By.id("address1");
    private final By stateField       = By.id("state");
    private final By cityField        = By.id("city");
    private final By zipCodeField     = By.id("zipcode");
    private final By phoneField       = By.id("mobile_number");
    private final By submitButton     = By.xpath("//form [@action = \"/signup\"] //button [@data-qa = \"create-account\"]");
    
    private final By daysDropdown     = By.id("days");
    private final By monthsDropdown   = By.id("months");
    private final By yearsDropdown    = By.id("years");
    private final By countryDropdown  = By.id("country");
    
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


