package webpageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.logger.Log;
import utils.waitutils.WaitUtils;

public class ProductListingPage {
    @FindBy(xpath = "//li[@class='item product product-item']")
    public WebElement btnClickCard;
    WebDriver driver;
    WaitUtils waitUtils;

    public ProductListingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUtils = new WaitUtils(driver);
    }

    public void clickAddToCart() {
        Log.info("Inside AddToCart method in class " + this.getClass().getName());
        waitUtils.waitForElementTobeClickable(btnClickCard);
        btnClickCard.click();
    }
}
