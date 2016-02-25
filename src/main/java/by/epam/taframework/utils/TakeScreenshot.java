package by.epam.taframework.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Yahor_Faliazhynski on 2/25/2016.
 */
public class TakeScreenshot {

    public static String takeScreenshot(WebDriver driver, String screenshotName) {
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

}
