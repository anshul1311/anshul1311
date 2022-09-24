package webpageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.waitutils.WaitUtils;

public class HomePage {
    WebDriver driver;
    WaitUtils waitUtils;

    @FindBy(id= "search")
    public WebElement txtSearch;
    @FindBy(xpath = "//button[@title='Search']")
    public WebElement btnSearch;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUtils=new WaitUtils(driver);
    }

    public void searchClothes(String str){
        waitUtils.waitForElementTobeClickable(txtSearch);
        txtSearch.sendKeys("jacket");
        waitUtils.waitForElementTobeClickable(btnSearch);
        btnSearch.click();
    }


}
