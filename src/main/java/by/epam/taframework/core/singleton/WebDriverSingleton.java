package by.epam.taframework.core.singleton;

import by.epam.taframework.core.factorymethod.WebDriverSwitcher;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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

    public static void highlightElement(WebElement element, String screenshotName) {
        String bg = element.getCssValue("backgroundColor");
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '" + "yellow" + "'", element);
        takeScreenshot(screenshotName);
        sleep(2000);
        js.executeScript("arguments[0].style.backgroundColor = '" + bg + "'", element);
    }

    public static String takeScreenshot(String screenshotName) {
        String path;
        String timeStamp;
        try {
            File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            path = "./target/screenshots/" + screenshotName + timeStamp + ".png";
            FileUtils.copyFile(source, new File(path));
        } catch (IOException e) {
            path = "Failed to capture screenshot: " + e.getMessage();
        }
        return path;
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
