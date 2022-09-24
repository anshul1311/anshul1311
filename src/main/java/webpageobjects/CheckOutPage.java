package webpageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.waitutils.WaitUtils;

public class CheckOutPage {

    WebDriver driver;
    WaitUtils waitUtils;
    @FindBy(name = "company")
    public WebElement txtCompany;
    @FindBy(name = "street[0]")
    public WebElement txtStreet;
    @FindBy(name = "city")
    public WebElement txtCity;
    @FindBy(name = "region_id")
    public WebElement selectState;
    @FindBy(name="region")
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


    public void fillAddressDetails(String street, String pinCode, String state, String country, String phone,String city) {
        waitUtils.waitForElementTobeClickable(txtCompany);
        txtCompany.sendKeys("test");
        waitUtils.waitForElementTobeClickable(selectCountry);
        Select select = new Select(selectCountry);
        select.selectByVisibleText(country);
        waitUtils.waitForElementTobeClickable(txtStreet);
        txtStreet.sendKeys(street);
        waitUtils.waitForElementTobeClickable(txtPinCode);
        txtPinCode.sendKeys(pinCode);
        if(selectState.getText().contains("Please select a region")) {
            Select selectState1 = new Select(selectState);
            selectState1.selectByVisibleText(state);
        }else{
            waitUtils.waitForElementTobeDisplayed(txtState);
            txtState.sendKeys(state);
        }
        waitUtils.waitForElementTobeClickable(txtPhone);
        txtPhone.sendKeys(phone);
        waitUtils.waitForElementTobeClickable(txtCity);
        txtCity.sendKeys(city);
        waitUtils.waitForElementTobeClickable(selectRadio);
        selectRadio.click();
        waitUtils.waitForElementTobeClickable(btnNext);
        btnNext.click();

    }

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUtils = new WaitUtils(driver);
    }

}
