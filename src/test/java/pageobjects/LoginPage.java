package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {

    @FindBy(how = How.ID, using = "user-email-login")
    private WebElement emailField;

    @FindBy(how = How.ID, using = "user-password-login")
    private WebElement passwordField;

    @FindBy(how = How.XPATH, using = "//*[@id=\"prepare-signin-form\"]/div[1]/button")
    private WebElement loginButton;

    @FindBy(how = How.CSS, using = ".alert-danger p")
    private WebElement alertContent;

    private static final String PAGE_URL = "/users/sign_in";

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        this.pageUrl = PAGE_URL;
    }

    public WebElement getErrorAlert() {
        return alertContent;
    }

    public void login(String email, String password) {
        this.emailField.sendKeys(email);
        this.passwordField.sendKeys(password);
        this.loginButton.click();
    }
}
