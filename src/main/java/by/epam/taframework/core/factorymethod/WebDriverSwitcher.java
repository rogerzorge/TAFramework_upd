package by.epam.taframework.core.factorymethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Yahor_Faliazhynski on 2/16/2016.
 */
public class WebDriverSwitcher {

    private WebDriver driver;
    private WebDriverCreator creator;

    public WebDriver driverSwitcher(String browserType) {

        switch (browserType) {
            case "Firefox":
            creator = new FirefoxDriverCreator();
            driver = creator.factoryMethod();
            break;
            case "Chrome":
            creator = new ChromeDriverCreator();
            driver = creator.factoryMethod();
            break;
            default:
            creator = new FirefoxDriverCreator(); //default web driver
            driver = creator.factoryMethod();
            System.out.println("Firefox web driver was used as a default web driver! Type 'Chrome' as driverSwitcher() method attribute to launch tests in Google Chrome browser!");
            break;
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    return driver;
    }

}
