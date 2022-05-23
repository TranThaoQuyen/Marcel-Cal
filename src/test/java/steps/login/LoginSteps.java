package steps.login;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageobjects.LoginPage;
import pageobjects.ProfilesPage;
import steps.BaseSteps;

@RunWith(Cucumber.class)
public class LoginSteps extends BaseSteps {
    private LoginPage loginPage;
    ProfilesPage profilesPage;

    @Before
    public void setup() {
        this.initializeDriver();
        this.loginPage = new LoginPage(this.driver);
        this.profilesPage = new ProfilesPage(this.driver);
    }

    @Given("user is on login page")
    public void openPage() {
        this.loginPage.open();
    }

    @Given("user logins with {string} and {string} as credentials")
    public void enterCredential(String email, String password) {
        this.loginPage.login(email, password);
    }

    @Then("user is on profiles page")
    public void isOnProfilesPage() {
        WebElement profileHeader = this.profilesPage.getHeaderElement();

        Assert.assertTrue(profileHeader.isDisplayed());
    }

    @Then("user see error message")
    public void checkErrorMessage() {
        WebElement errorElement = loginPage.getErrorAlert();
        Assert.assertEquals(errorElement.getText(), "Invalid email or password.");
    }

    @After
    public void close() {
        this.loginPage.close();
    }
}
