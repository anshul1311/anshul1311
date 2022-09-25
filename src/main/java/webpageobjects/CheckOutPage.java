package webpageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.logger.Log;
import utils.waitutils.WaitUtils;

public class CheckOutPage {

    @FindBy(name = "company")
    public WebElement txtCompany;
    @FindBy(name = "street[0]")
    public WebElement txtStreet;
    @FindBy(name = "city")
    public WebElement txtCity;
    @FindBy(name = "region_id")
    public WebElement selectState;
    @FindBy(name = "region")
    public WebElement txtState;
    @FindBy(name = "postcode")
    public WebElement txtPinCode;
    @FindBy(name = "country_id")
    public WebElement selectCountry;
    @FindBy(name = "telephone")
    public WebElement txtPhone;
    @FindBy(xpath = "//button[@data-role='opc-continue']")
    public WebElement btnNext;
    @FindBy(xpath = "//input[@checked='true']")
    public WebElement selectRadio;
    @FindBy(xpath = "//tbody/tr")
    public WebElement shippingMethodOption;
    WebDriver driver;
    WaitUtils waitUtils;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUtils = new WaitUtils(driver);
    }

    public void fillAddressDetails(String street, String pinCode, String state, String country, String phone, String city) {
        Log.info("Inside fillAddressDetails Method");
        waitUtils.waitForElementTobeClickable(txtCompany);
        Log.info("Enter Company");
        txtCompany.sendKeys("test");
        waitUtils.waitForElementTobeClickable(selectCountry);
        Select select = new Select(selectCountry);
        Log.info("Select Country");
        select.selectByVisibleText(country);
        waitUtils.waitForElementTobeClickable(txtStreet);
        Log.info("Enter Street "+street);
        txtStreet.sendKeys(street);
        waitUtils.waitForElementTobeClickable(txtPinCode);
        Log.info("Enter Pincode "+pinCode);
        txtPinCode.sendKeys(pinCode);
        if (selectState.getText().contains("Please select a region")) {
            Select selectState1 = new Select(selectState);
            selectState1.selectByVisibleText(state);
        } else {
            waitUtils.waitForElementTobeDisplayed(txtState);
            Log.info("Enter State "+state);
            txtState.sendKeys(state);
        }
        waitUtils.waitForElementTobeClickable(txtPhone);
        txtPhone.sendKeys(phone);
        waitUtils.waitForElementTobeClickable(txtCity);
        txtCity.sendKeys(city);
        try {
            waitUtils.waitForElementTobeClickable(selectRadio);
            selectRadio.click();
        } catch (Exception e) {
            shippingMethodOption.click();
        }
        waitUtils.waitForElementTobeClickable(btnNext);
        btnNext.click();

    }

}
