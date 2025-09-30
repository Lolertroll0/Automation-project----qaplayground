package resources;

import com.automation.Pages.RegistrationFormPage;

import org.openqa.selenium.WebDriver;

public class TestDataFactory {
 
    // Helper 
    public static RegistrationFormPage registrationData(ConfigReader config, WebDriver driver) {
        return new RegistrationFormPage(
            driver,
            config.getProperty("user"),
            config.getProperty("lastname"),
            config.getProperty("address"),
            config.getProperty("state"),
            config.getProperty("city"),
            config.getProperty("zipcode"),
            config.getProperty("phone"),
            config.getProperty("password")
        );
    }
}
