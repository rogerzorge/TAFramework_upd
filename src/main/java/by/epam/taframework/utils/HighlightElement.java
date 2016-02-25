package by.epam.taframework.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Yahor_Faliazhynski on 2/25/2016.
 */
public class HighlightElement {

    public static void highlightElement(WebDriver driver, WebElement element, String screenshotName) {
        String bg = element.getCssValue("backgroundColor");
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '" + "yellow" + "'", element);
        TakeScreenshot.takeScreenshot(driver, screenshotName);
        sleep(2000);
        js.executeScript("arguments[0].style.backgroundColor = '" + bg + "'", element);
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
