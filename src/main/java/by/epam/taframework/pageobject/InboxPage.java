package by.epam.taframework.pageobject;

import by.epam.taframework.core.singleton.WebDriverSingleton;
import by.epam.taframework.utils.EventLogSwitcher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Yahor local on 1/17/2016.
 */
public class InboxPage extends BasePage {

    public static final String HTML_GMAIL_URL = "https://mail.google.com/mail/?ui=html&zy=h";

    @FindBy(linkText = "Compose Mail")
    private WebElement composeButton;

    @FindBy(linkText = "Sent Mail")
    private WebElement sentLink;

    public InboxPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getComposeLabel() {
        return composeButton.getText();
    }

    public ComposePage goToComposePage() {
        composeButton.click();
        EventLogSwitcher.eventLogger("warn", "Go to Compose page");
        return PageFactory.initElements(driver, ComposePage.class);
    }

    public void goToHTMLGmailPage() {
        driver.get(HTML_GMAIL_URL);
        EventLogSwitcher.eventLogger("warn", "Go to HTML Gmail page");
    }

    public SentPage goToSentPage() {
        sentLink.click();
        EventLogSwitcher.eventLogger("warn", "Go to Sent page");
        return PageFactory.initElements(driver, SentPage.class);
    }

}
