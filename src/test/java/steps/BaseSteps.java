package steps;

import helpers.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.Properties;

public class BaseSteps {
    protected static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            Properties config = Config.getConfig();
            String browser = config.getProperty("app.browser");

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(Long.parseLong(config.getProperty("app.timeout"))));
        }
        return driver;
    }

    public static void quit(){
        driver.quit();
        driver = null;
    }
}
