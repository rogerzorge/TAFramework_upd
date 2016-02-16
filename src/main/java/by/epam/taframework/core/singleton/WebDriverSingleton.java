package by.epam.taframework.core.singleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
            switch (browserType) {
                case "Firefox":
                    driver = new FirefoxDriver();
                    break;
                case "Chrome":
                    System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
                    driver = new ChromeDriver();
                    break;
                default:
                    driver = new FirefoxDriver(); //default web driver
                    System.out.println("Firefox web driver was used as a default web driver! Type 'Chrome' as getInstance() method attribute to launch tests in Google Chrome browser!");
                    break;
            }
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
