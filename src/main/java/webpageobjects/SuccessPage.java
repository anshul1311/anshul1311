package webpageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.waitutils.WaitUtils;

public class SuccessPage {
    WebDriver driver;
    WaitUtils waitUtils;

    public SuccessPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitUtils=new WaitUtils(driver);

    }
    @FindBy(xpath = "//span[@data-ui-id='page-title-wrapper']")
    public WebElement txtSuccessMessage;
    @FindBy(xpath = "//div[@class='checkout-success']/p[1]")
    public WebElement txtOrderNumberMessage;


    public String validateSuccessMessage(){
        waitUtils.waitForElementTobeClickable(txtSuccessMessage);
        String message=txtSuccessMessage.getText();
        return message;
    }
}
