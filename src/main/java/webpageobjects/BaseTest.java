package webpageobjects;

import io.cucumber.java.Before;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import utils.webdrivermanager.BrowserUtils;
@Getter
@Setter
public class BaseTest {
    WebDriver driver;
    BrowserUtils browserUtils;
    public void setup(){
        browserUtils=new BrowserUtils();
        //driver=browserUtils.setup();
        driver.get("https://magento.softwaretestingboard.com/");
    }

}
