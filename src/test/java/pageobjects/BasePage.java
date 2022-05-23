package pageobjects;

import helpers.Config;
import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BasePage {
    protected String pageUrl;
    protected WebDriver driver;
    private Properties config;

    public BasePage() {}
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.config = Config.getConfig();
        PageFactory.initElements(this.driver, this);
    }

    protected String getAbsolutePath(String path) {
        return this.config.getProperty("app.baseURL") + path;
    }

    public void open() {
        this.driver.get(getAbsolutePath(pageUrl));
    }

    public Boolean isOnPage(String path) {
        return this.driver.getCurrentUrl().equals(getAbsolutePath(path));
    }

    public void close() {
        this.driver.close();
    }
}
