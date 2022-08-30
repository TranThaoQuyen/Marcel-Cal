package steps.createKYC;

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
public class CreateKYB extends BaseSteps{
    private LoginPage loginPage;
    DashboardPage dashboardPage;

    @Before("@CreateKYB")
    public void setup() {
        this.loginPage = new LoginPage();
        this.dashboardPage = new DashboardPage();
    }

    @Given("logged in")
    public void openPage() {
        this.loginPage.open();
    }

    @Given("user create KYB with {string} and {string} and {string} and {string} and {string}  and {string} and {string} as credentials")
    public void createKYB(String companyName, String registerNumber, String placeOfCommercialRegister, String companyShareCapital, String companyPlace, String companyAddress, String companyPostalCode) throws InterruptedException {
        this.loginPage.login("kirk+uuser04@equanimity.sg", "123456789");
        Thread.sleep(2000);
        this.dashboardPage.createKYB(companyName, registerNumber, placeOfCommercialRegister, companyShareCapital, companyPlace, companyAddress, companyPostalCode);
    }

    @Then("show Thank you for your Submission")
    public void isThankYouHeader() {
        WebElement thankYouHeader = this.dashboardPage.getSubmissionHeader();

        Assert.assertEquals(thankYouHeader.getText(),"Thank you for your Submission");
    }
}