package webpageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.logger.Log;
import utils.waitutils.WaitUtils;

/**
 * @author anshul ahuja
 */
public class SuccessPage {
    @FindBy(xpath = "//span[@data-ui-id='page-title-wrapper']")
    public WebElement txtSuccessMessage;
    @FindBy(xpath = "//div[@class='checkout-success']/p[1]")
    public WebElement txtOrderNumberMessage;
    WebDriver driver;
    WaitUtils waitUtils;
    public SuccessPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUtils = new WaitUtils(driver);
    }

    public String validateSuccessMessage() {
        waitUtils.waitForElementTobeClickable(txtSuccessMessage);
        String message = txtSuccessMessage.getText();
        Log.info("Success Message: " + message);
        return message;
    }

    public boolean isOrderNumberDisplayed() {
        waitUtils.waitForElementTobeClickable(txtOrderNumberMessage);
        String message = txtOrderNumberMessage.getText();
        Log.info("Order Number Message: " + message);
        if (message.contains("Your order number is"))
            return true;
        return false;
    }
}
