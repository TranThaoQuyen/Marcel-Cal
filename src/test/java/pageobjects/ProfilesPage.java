package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProfilesPage extends BasePage {
    private static final String PAGE_URL = "/profiles";

    @FindBy(how = How.ID, using = "profile-page")
    private WebElement header;

    public ProfilesPage(WebDriver webDriver) {
        super(webDriver);
        this.pageUrl = PAGE_URL;
    }

    public WebElement getHeaderElement() {
        return this.header;
    }
}
