package webpageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.waitutils.WaitUtils;

public class ProductDetailsPage {

    WebDriver driver;
    WaitUtils waitUtils;

    @FindBy(xpath = "//div[@option-tooltip-value='XS']")
    public WebElement btnSelectSize;
    @FindBy(xpath = "//div[@option-label='Gray']")
    public WebElement btnSelectColor;
    @FindBy(xpath = "//button[@title='Add to Cart']")
    public WebElement btnAddToCart;
    @FindBy(xpath = "//span[@class='counter qty']")
    public WebElement btnAddCartIcon;
    @FindBy(id ="top-cart-btn-checkout")
    public WebElement btnProceed;
    @FindBy(xpath = "//div[@class='block-content']")
    public WebElement cardValue;
    @FindBy(xpath = "//a[contains(@data-bind,'product_name')]")
    public WebElement addReview;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUtils = new WaitUtils(driver);
    }

    public void selectSize() {
        waitUtils.waitForElementTobeClickable(btnSelectSize);
        btnSelectSize.click();
    }

    public void selectColor() {
        waitUtils.waitForElementTobeClickable(btnSelectColor);
        btnSelectColor.click();
    }

    public void addToCart() {
        selectSize();
        selectColor();
        waitUtils.waitForElementTobeClickable(btnAddToCart);
        btnAddToCart.click();
        waitUtils.waitForElementTobeClickable(btnAddCartIcon);
        btnAddCartIcon.click();
        waitUtils.waitForElementTobeDisplayed(cardValue);
        waitUtils.waitForElementTobeClickable(btnProceed);
        waitUtils.waitForElementTobeClickable(addReview);
        if(btnProceed.isEnabled()==true) {
            btnProceed.click();
        }

    }
}
