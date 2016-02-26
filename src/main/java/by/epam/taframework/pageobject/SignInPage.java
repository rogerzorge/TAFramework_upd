package by.epam.taframework.pageobject;

import java.lang.String;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;


/**
 * Created by Yahor local on 1/17/2016.
 */
public class SignInPage extends BasePage {

    public static final String GMAIL_URL = "http://gmail.com";

    @FindBy(id = "Email")
    private WebElement emailTextbox;

    @FindBy(id = "next")
    private WebElement nextButton;

    @FindBy(id = "Passwd")
    private WebElement passwdTextbox;

    @FindBy(id = "signIn")
    private WebElement signinButton;

    @FindBy(css = "h2.hidden-small")
    private WebElement headerTitle;

    public SignInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public SignInPage setEmail(String emailValue) {
        emailTextbox.sendKeys(emailValue);
        getLogger().info("Email was set");
        return this;
    }

    public SignInPage goToPasswPage() {
        nextButton.click();
        getLogger().info("Go to Password page");
        return this;
    }

    public SignInPage setPasswd(String passwdValue) {
        passwdTextbox.sendKeys(passwdValue);
        getLogger().info("Password was set");
        return this;
    }

    public InboxPage goToInboxPage() {
//        WebDriverSingleton.explicitWait(signinButton).click();
        signinButton.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getLogger().warn("Go to Inbox page");
        return PageFactory.initElements(driver, InboxPage.class);
    }

    public String getHeaderTitle() {
        return headerTitle.getText();
    }

}
