package pageobjects;

import helpers.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DashboardPage extends BasePage {

    @FindBy(how = How.CSS, using = ".page__title.h3")
    private WebElement pageHeader;

    @FindBy(how = How.XPATH, using = "//a[@href ='/docs/configuration']")
    private WebElement KYCBtn;

    @FindBy(how = How.CSS, using = ".packages__group div:first-child .button.packages__button")
    private WebElement signUpKYCIndividual;

    @FindBy(how = How.CSS, using = ".packages__group div:nth-of-type(2) .button.packages__button")
    private WebElement signUpKYCCompany;

    @FindBy(how = How.CSS, using = "input[value='usd']")
    private WebElement radioBtnUSD;

    @FindBy(how = How.CSS, using = "input[value='usdc']")
    private WebElement radioBtnUSDC;

    @FindBy(how = How.CSS, using = ".button.settings__button")
    private WebElement nextBtn;

    @FindBy(how = How.CSS, using = "input[type='text'].field__input")
    private WebElement identificationNum;

    @FindBy(how = How.CSS, using = "input[id='date-picker-dialog']")
    private WebElement dateOfBirth;

    @FindBy(how = How.CSS, using = "input[type='text'].field__input")
    private WebElement placeOfBirth;

    @FindBy(how = How.CSS, using = "div.MuiSelect-root.MuiSelect-select.MuiSelect-selectMenu.MuiSelect-outlined.MuiInputBase-input.MuiOutlinedInput-input")
    private WebElement nationality;

    @FindBy(how = How.CSS, using = ".//*[@role='listbox']/li")
    private WebElement listBoxNationality;

    @FindBy(how = How.CSS, using = "div.MuiSelect-root.MuiSelect-select.MuiSelect-selectMenu.MuiSelect-outlined.MuiInputBase-input.MuiOutlinedInput-input")
    private WebElement countryOfResidential;

    @FindBy(how = How.CSS, using = ".//*[@role='listbox']/li")
    private WebElement listBoxCountryOfResidential;

    @FindBy(how = How.CSS, using = "input[type='text'].field__input")
    private WebElement residentialAddress;

    @FindBy(how = How.CSS, using = "input[type='text'].field__input")
    private WebElement city;

    @FindBy(how = How.CSS, using = "input[type='text'].field__input")
    private WebElement postalCode;

    @FindBy(how = How.CSS, using = "button[type='button']")
    private WebElement submitBtn;

    private static final String PAGE_URL = "";

    public DashboardPage() {
        super();
        this.pageUrl = PAGE_URL;
    }

    public WebElement getHeaderElement() {
        return this.pageHeader;
    }

    public void createKYCIndividual(String identificationNum, String dateOfBirth, String placeOfBirth, String residentialAddress, String city, String postalCode ) {
        new WebDriverWait(this.driver, Duration.ofMillis(Long.parseLong(Config.getConfig().getProperty("app.timeout"))))
                .until(ExpectedConditions.visibilityOf(this.pageHeader));
        driver.get("https://dev-kyc.cryptoadvisory.li/application");
        new WebDriverWait(this.driver, Duration.ofMillis(Long.parseLong(Config.getConfig().getProperty("app.timeout"))))
                .until(ExpectedConditions.visibilityOf(this.signUpKYCIndividual));
        this.signUpKYCIndividual.click();
        this.radioBtnUSD.click();
        this.nextBtn.click();
        new WebDriverWait(this.driver, Duration.ofMillis(Long.parseLong(Config.getConfig().getProperty("app.timeout"))))
                .until(ExpectedConditions.visibilityOf(this.identificationNum));
        this.identificationNum.sendKeys();
        this.dateOfBirth.sendKeys();
        this.placeOfBirth.sendKeys();
        this.nationality.click();
        List<WebElement> listOfNationality = driver.findElements(By.xpath(".//*[@role='listbox']/li"));
        for (WebElement webElement: listOfNationality) {
            if (webElement.getText().trim().equals("Afghanistan")){
                webElement.click();
                break;
            }
        }
        this.countryOfResidential.click();
        List<WebElement> listOfCountry = driver.findElements(By.xpath(".//*[@role='listbox']/li"));
        for (WebElement webElement: listOfCountry) {
            if (webElement.getText().trim().equals("Afghanistan")){
                webElement.click();
                break;
            }
        }
        this.residentialAddress.sendKeys();
        this.city.sendKeys();
        this.postalCode.sendKeys();
        this.submitBtn.click();
    }
}
