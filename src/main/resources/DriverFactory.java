import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            return driver;
        }
    }
}
