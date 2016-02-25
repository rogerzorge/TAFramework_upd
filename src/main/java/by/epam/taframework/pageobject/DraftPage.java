package by.epam.taframework.pageobject;

import by.epam.taframework.utils.EventLogSwitcher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Yahor local on 1/17/2016.
 */
public class DraftPage extends BasePage {

    @FindBy(css = "span.ts")
    private WebElement draftMailLink;

    public DraftPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getDraftTitle() {
        return draftMailLink.getText();
    }

    public DraftItemPage goToDraftItemPage() {
        draftMailLink.click();
        EventLogSwitcher.eventLogger("warn", "Go to Draft page");
        return PageFactory.initElements(driver, DraftItemPage.class);
    }

}
