package webpageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.logger.Log;
import utils.waitutils.WaitUtils;

public class RegistrationPage {

    WebDriver driver;
    WaitUtils waitUtils;
    @FindBy(id = "firstname")
    public WebElement txtFirstName;
    @FindBy(id = "lastname")
    public WebElement txtLastName;
    @FindBy(id = "email_address")
    public WebElement txtemail;
    @FindBy(id = "password")
    public WebElement txtPassword;
    @FindBy(id = "password-confirmation")
    public WebElement txtPasswordCnfrmtion;
    @FindBy(xpath = "//button[@title='Create an Account']")
    public WebElement btnCreate;
    @FindBy(xpath = "//div[@data-ui-id='message-error']/div")
    public WebElement messageError;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUtils = new WaitUtils(driver);
    }

    public void enterRegistrationDetails(String firstName, String lastName, String email, String password) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        txtFirstName.sendKeys(firstName);
        txtLastName.sendKeys(lastName);
        txtemail.sendKeys(email);
        txtPassword.sendKeys(password);
        txtPasswordCnfrmtion.sendKeys(password);
        btnCreate.click();
    }

    public boolean isUserExist() {
        try {
            waitUtils.waitForElementToBePresentInDom(messageError);
            if (messageError.isDisplayed() == true) {
                Log.info("Account already exists");
                return true;
            }
        } catch (Exception e) {
            Log.info("Account is not already present");
        }
        return false;
    }
    public boolean isRegistrationPageDisplayed() {
        return driver.getTitle().contains("Create New Customer Account");
    }
}
