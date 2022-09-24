package webpageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.webdrivermanager.BrowserUtils;

public class LoginPage extends BrowserUtils {

    @FindBy(partialLinkText = "Create")
    public WebElement clickCreateAccount;
WebDriver driver;
    public LoginPage(){
        //BaseTest baseTest=new BaseTest();
        //setup();
        driver=getDriver();

        driver.get("https://magento.softwaretestingboard.com/");
        PageFactory.initElements(driver,this);

        //baseTest.openUrl();
    }


public void clickCreateAccount(){
    try {
        Thread.sleep(4000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    clickCreateAccount.click();
}


}
