package resources;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {
    private WebDriver driver;
    @Override
    public void onTestFailure (ITestResult result) {
        
        try {
            Object testInstance = result.getInstance();
            driver = (WebDriver) testInstance.getClass().getMethod("getDriver").invoke(testInstance);        
        } catch (Exception ex){
            System.err.println("Error trying to retrive WebDriver from Instance: " + ex.getMessage());
        }      
        // ScreenShot capture
        ScreenshotHandler.capture(driver, "exception-error_");
    }
}
