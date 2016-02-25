package by.epam.taframework.pageobject;

import by.epam.taframework.utils.EventLogSwitcher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Yahor local on 1/17/2016.
 */
public class SentPage extends BasePage {

    @FindBy(css = "span.ts")
    private WebElement sentMailLink;

    @FindBy(linkText = "Sign out")
    private WebElement logoutLink;

    public SentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getSentTitle() {
        return sentMailLink.getText();
    }

    public SignInPage clickLogoutLink() {
        logoutLink.click();
        EventLogSwitcher.eventLogger("info", "Logout from Gmail");
        return PageFactory.initElements(driver, SignInPage.class);
    }

}
