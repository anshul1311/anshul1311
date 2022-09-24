package webpageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.waitutils.WaitUtils;

public class PaymentPage {

    WebDriver driver;
    WaitUtils waitUtils;

    @FindBy(xpath = "//button[@title='Place Order']")
    public WebElement btnPlaceOrder;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUtils = new WaitUtils(driver);
    }

    public void clickPlaceOrder(){
        waitUtils.waitForElementTobeDisplayed(btnPlaceOrder);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        btnPlaceOrder.click();
    }

}
