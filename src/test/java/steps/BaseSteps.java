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
    private Properties config;
    protected WebDriver driver;

    protected WebDriver initializeDriver() {

        this.config = Config.getConfig();

        String browser = config.getProperty("app.browser");

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                this.driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                this.driver = new FirefoxDriver();
                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
                this.driver = new SafariDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                this.driver = new EdgeDriver();
                break;
        }

        this.driver.manage().timeouts().implicitlyWait(Duration.ofMillis(Long.parseLong(config.getProperty("app.timeout"))));

        return this.driver;
    }
}
