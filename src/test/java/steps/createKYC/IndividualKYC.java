package steps.createKYC;

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
public class IndividualKYC extends BaseSteps{
    private LoginPage loginPage;
    DashboardPage dashboardPage;

    @Before("@CreateKYCIndividual")
    public void setup() {
        this.loginPage = new LoginPage();
        this.dashboardPage = new DashboardPage();
    }

    @Given("user logged in")
    public void openPage() {
        this.loginPage.open();
    }

    @Given("user create KYC with {string} and {string} and {string} and {string} and {string} and {string} as credentials")
    public void enterCredential(String identificationNum, String dateOfBirth, String placeOfBirth, String residentialAddress, String city, String postalCode) throws InterruptedException {
        this.loginPage.login("kirk+uuser01@equanimity.sg", "123456789");
        Thread.sleep(2000);
        this.dashboardPage.createKYCIndividual(identificationNum, dateOfBirth, placeOfBirth,residentialAddress, city,postalCode);
    }

    @Then("show submission header")
    public void isShowIdentityHeader() {
        WebElement identityHeader = this.dashboardPage.getIdentityHeaderHeader();

        Assert.assertEquals(identityHeader.getText(),"Please verify your identity.");
    }
}
