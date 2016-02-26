package by.epam.taframework.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Math.abs;

/**
 * Created by Yahor local on 1/17/2016.
 */
public class ComposePage extends BasePage {

    @FindBy(id = "to")
    private WebElement toTextbox;

    @FindBy(name = "subject")
    private WebElement subjectTextbox;

    @FindBy(name = "body")
    private WebElement bodyTextbox;

    @FindBy(xpath = "//input[@type='submit' and @value='Save Draft']")
    private WebElement saveDraftButton;

    @FindBy(xpath = "//a[@href='?&s=d']")
    private WebElement draftLink;

    @FindBy(xpath = "//td[@bgcolor='#FAD163' and @role='alert']/b")
    private WebElement draftSavedLabel;

    public ComposePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public WebElement getSaveDraftButton() {
        return this.saveDraftButton;
    }

    public ComposePage setTo(String to) {
        toTextbox.clear();
        toTextbox.sendKeys(to);
        getLogger().info("Set 'To' field");
        return this;
    }

    public ComposePage setSubject(String subject) {
        subjectTextbox.clear();
        subjectTextbox.sendKeys(subject);
        getLogger().info("Set 'Subject' field");
        return this;
    }

    public ComposePage setBody(String body) {
        bodyTextbox.clear();
        bodyTextbox.sendKeys(body);
        getLogger().info("Set 'Body' field");
        return this;
    }

    public ComposePage saveDraft() {
        saveDraftButton.click();
        getLogger().info("Save draft email");
        return this;
    }

    public DraftPage goToDraftPage() {
        draftLink.click();
        getLogger().warn("Go to Draft page");
        return PageFactory.initElements(driver, DraftPage.class);
    }

    public String getDraftSavedLabel() {
        return draftSavedLabel.getText();
    }

    public ComposePage saveDraftActions() {
        Actions builder = new Actions(driver);
        Action saveDraft = builder.click(saveDraftButton).build();
        saveDraft.perform();
        getLogger().info("Save draft email via Actions class");
        return this;
    }

    public ComposePage setToActions(String to) {
        Actions builder = new Actions(driver);
        Action setAndSave = builder.sendKeys(toTextbox, to).build();
        setAndSave.perform();
        getLogger().info("Set 'To' field via Actions class");
        return this;
    }

}
