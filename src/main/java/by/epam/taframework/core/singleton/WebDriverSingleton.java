package by.epam.taframework.core.singleton;

import by.epam.taframework.core.factorymethod.WebDriverSwitcher;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Yahor local on 2/13/2016.
 */
public class WebDriverSingleton {

    private static WebDriver driver;
    private static final String CHROME_DRIVER_PATH = "d:\\chromedriver_win32\\chromedriver.exe ";

    private WebDriverSingleton() {}

    public static WebDriver getInstance(String browserType) {
        if (null == driver) {
            driver = new WebDriverSwitcher().driverSwitcher(browserType);
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }

    public static WebElement explicitWait(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
        WebElement element = wait.until(ExpectedConditions.visibilityOf(webElement));
        return element;
    }

}
