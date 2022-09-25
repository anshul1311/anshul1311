package webpageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.logger.Log;
import utils.waitutils.WaitUtils;

public class HomePage {
    @FindBy(id = "search")
    public WebElement txtSearch;
    @FindBy(xpath = "//button[@title='Search']")
    public WebElement btnSearch;
    WebDriver driver;
    WaitUtils waitUtils;

    public HomePage(WebDriver driver) {
        Log.info("Inside HomePage Constructor");
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUtils = new WaitUtils(driver);
    }

    public void searchClothes(String str) {
        Log.info("Inside searchClothes method in class " + this.getClass().getName());
        waitUtils.waitForElementTobeClickable(txtSearch);
        txtSearch.sendKeys("jacket");
        waitUtils.waitForElementTobeClickable(btnSearch);
        btnSearch.click();
    }


}
