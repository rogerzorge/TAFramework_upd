package by.epam.emailtest.test;

import by.epam.taframework.businessobject.Account;
import by.epam.taframework.businessobject.Message;
import by.epam.taframework.core.singleton.WebDriverSingleton;
import by.epam.taframework.pageobject.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static java.lang.Math.abs;
import static java.lang.Math.random;
import static org.testng.Assert.fail;

/**
 * Created by Yahor_Faliazhynski on 1/12/2016.
 */
public class BasePOTest {

    protected WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();
    protected int randomNum;

    protected SignInPage signInPage;
    protected InboxPage inboxPage;
    protected ComposePage composePage;
    protected DraftPage draftPage;
    protected DraftItemPage draftItemPage;
    protected SentPage sentPage;
    protected Account user01;
    protected Message email01;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.out.println("Class start!");
        randomNum = (int)abs(random() * 1000000);
        System.out.println("Current random number is: " + randomNum);
        driver = WebDriverSingleton.getInstance("Chrome"); // Type attribute here: 'Firefox', 'Chrome' or any other String - default browser will be used (FF)
        driver.manage().window().maximize();
        signInPage = new SignInPage(driver);
        driver.get(SignInPage.GMAIL_URL);
        signInPage.getLogger().warn("Load base URL");

        user01 = new Account("ivan.mailfortest", "Zaq1!Xsw2@");
        email01 = new Message("ivan.mailtest@mail.ru", "Test subject " + randomNum + " gmail", "Test body " + randomNum + " test");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        System.out.println("Class finish!");
        WebDriverSingleton.closeDriver();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}