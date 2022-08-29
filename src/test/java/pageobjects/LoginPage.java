package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {

    @FindBy(how = How.CSS, using = "input[type='email']")
    private WebElement emailField;

    @FindBy(how = How.CSS, using = "input[type='password']")
    private WebElement passwordField;

    @FindBy(how = How.CSS, using = "button[type='button'].button.entry__button")
    private WebElement signInBtn;

    private static final String PAGE_URL = "/login";

    public LoginPage() {
        super();
        this.pageUrl = PAGE_URL;
    }

    public void login(String email, String password) {
        this.emailField.sendKeys(email);
        this.passwordField.sendKeys(password);
        this.signInBtn.click();
    }
}
