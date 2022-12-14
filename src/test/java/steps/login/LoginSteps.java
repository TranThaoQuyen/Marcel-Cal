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
import pageobjects.DashboardPage;
import steps.BaseSteps;

@RunWith(Cucumber.class)
public class LoginSteps extends BaseSteps {
    private LoginPage loginPage;
    DashboardPage dashboardPage;

    @Before("@Login")
    public void setup() {
        this.loginPage = new LoginPage();
        this.dashboardPage = new DashboardPage();
    }

    @Given("user is on login page")
    public void openPage() {
        this.loginPage.open();
    }

    @Given("user logins with {string} and {string} as credentials")
    public void enterCredential(String email, String password) throws InterruptedException {
        this.loginPage.login(email, password);
        Thread.sleep(7000);
    }

    @Then("user is on dashboard page")
    public void isOnDashboardPage() {
        WebElement profileHeader = this.dashboardPage.getHeaderElement();

        Assert.assertTrue(profileHeader.isDisplayed());
    }

    @After
    public void close() {
        this.driver.close();
    }
}
