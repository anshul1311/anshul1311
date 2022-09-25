package utils.webdrivermanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.logger.Log;

public class BrowserUtils {
    @Getter
    @Setter
    WebDriver driver;

    public BrowserUtils() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        if(System.getProperty("headlessRun").equals("Y")) {
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("disable-gpu");
            Log.info("Running in headless mode");
        }else{
            Log.info("Running in non headless mode");
        }
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();


    }
}
