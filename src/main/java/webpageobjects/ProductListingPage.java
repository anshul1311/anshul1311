package webpageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utils.waitutils.WaitUtils;

public class ProductListingPage {
    WebDriver driver;
    WaitUtils waitUtils;
    @FindBy(xpath = "//li[@class='item product product-item']")
    public WebElement btnClickCard;
    public ProductListingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUtils=new WaitUtils(driver);
    }

    public void clickAddToCart(){
        waitUtils.waitForElementTobeClickable(btnClickCard);
        btnClickCard.click();
    }
}
