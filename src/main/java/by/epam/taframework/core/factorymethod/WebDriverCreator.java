package by.epam.taframework.core.factorymethod;

import org.openqa.selenium.WebDriver;

/**
 * Created by Yahor_Faliazhynski on 2/16/2016.
 */
public abstract class WebDriverCreator {

    protected WebDriver driver;

    public abstract WebDriver factoryMethod();

}
