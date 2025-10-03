package resources;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotHandler {
    public static void capture (WebDriver driver, String fileName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            File destination = new File("screenshots/" + fileName + "_" + TimeStamp.getCurrentTime() + ".png");
            FileUtils.copyFile(source, destination);
            System.out.println("Screenshot taken: " + destination.getAbsolutePath());
        } catch (IOException ex){
            System.err.println("Failed to capture Screenshot: " + ex.getMessage());
        }
    }
}
