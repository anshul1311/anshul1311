package webpageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.logger.Log;
import utils.waitutils.WaitUtils;
import utils.webdrivermanager.BrowserUtils;

import java.time.Duration;

public class LoginPage extends BrowserUtils {
    String url;
    @FindBy(partialLinkText = "Create")
    public WebElement clickCreateAccount;
    WebDriver driver;
    WaitUtils waitUtils;

    public LoginPage(String url) {
        Log.info("Inside  method in class " + this.getClass().getName());
        Log.info("url is "+url);
        this.url = url;
        driver = getDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        waitUtils = new WaitUtils(driver);

        //baseTest.openUrl();
    }


    public void clickCreateAccount() {
        waitUtils.waitForElementTobeClickable(clickCreateAccount);
        clickCreateAccount.click();
    }

public boolean isLoginPageDisplayed(){
       return driver.getTitle().contains("Home Page - Magento eCommerce");
}
}
