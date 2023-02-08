package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Arrays;

public class BasePage {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if(driver.get()==null) {

            ChromeOptions option = new ChromeOptions();
//            option.addArguments("--headless");
            option.setAcceptInsecureCerts(true);

//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            capabilities.setCapability("chrome.switches", Arrays.asList("--ignore-certificate-errors"));
//            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver(option));
        }
        return driver.get();
    }

    protected void open(String url) {
        Selenide.open(url);
    }

    public static void quitDriver() {
        driver.get().quit();
        driver.remove();
    }

    public BasePage() {
        WebDriverRunner.setWebDriver(getDriver());
        Configuration.timeout = 3000;
        Configuration.pageLoadTimeout = 6000;
    }
}
