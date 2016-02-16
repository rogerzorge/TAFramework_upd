package by.epam.taframework.core.factorymethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.File;
import java.io.IOException;

/**
 * Created by Yahor_Faliazhynski on 2/16/2016.
 */
public class ChromeDriverCreator extends WebDriverCreator {

    public static final String PATH_TO_CHROMEDRIVER = "d:\\chromedriver_win32\\chromedriver.exe";

    @Override
    public WebDriver factoryMethod() {
        ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(
                new File(PATH_TO_CHROMEDRIVER)).build();
        try {
            service.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver = new ChromeDriver(service);
        return driver;
    }

}
