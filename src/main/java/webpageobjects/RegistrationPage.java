package webpageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import responsedto.Root;

import java.util.HashMap;

public class RegistrationPage {

    WebDriver driver;
    Root root;

    @FindBy(id="firstname")
    public WebElement txtFirstName;
    @FindBy(id="lastname")
    public WebElement txtLastName;
    @FindBy(id="email_address")
    public WebElement txtemail;
    @FindBy(id="password")
    public WebElement txtPassword;
    @FindBy(id="password-confirmation")
    public WebElement txtPasswordCnfrmtion;
    @FindBy(xpath = "//button[@title='Create an Account']")
    public WebElement btnCreate;

    public RegistrationPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void enterRegistrationDetails(String firstName,String lastName,String email,String password){
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

}
