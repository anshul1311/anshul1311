package webpageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.logger.Log;
import utils.waitutils.WaitUtils;

public class PaymentPage {

    @FindBy(xpath = "//button[@title='Place Order']")
    public WebElement btnPlaceOrder;
    WebDriver driver;
    WaitUtils waitUtils;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUtils = new WaitUtils(driver);
    }

    public void clickPlaceOrder() {
        Log.info("Inside Method clickPlaceOrder: " + this.getClass().getName());
        btnPlaceOrder.click();
        waitUtils.waitForElementTobeInvisible(btnPlaceOrder);
    }

}
