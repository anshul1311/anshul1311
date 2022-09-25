package webpageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.logger.Log;
import utils.waitutils.WaitUtils;

public class CommonElements {

    @FindBy(xpath = "//img[contains(@src,'loader')]")
    public WebElement imgLoader;
    WebDriver driver;
    WaitUtils waitUtils;

    public CommonElements(WebDriver driver) {
        Log.info("Inside Common Elements Constructor");
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUtils = new WaitUtils(driver);
    }

    public void waitForLoaderToDisappear() {
        waitUtils.waitForElementTobeInvisible(imgLoader);
    }

}
