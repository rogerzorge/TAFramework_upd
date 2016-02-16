package by.epam.emailtest.test;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Yahor local on 1/18/2016.
 */
public class EmailPOTest extends BasePOTest {

    @Test(testName = "Login", description = "Gmail Account logIN test")
    public void accountLoginTest() {
        inboxPage = signInPage.setEmail(user01.getLogin())
                                .goToPasswPage()
                                .setPasswd(user01.getPassw())
                                .goToInboxPage();
        inboxPage.goToHTMLGmailPage();
        assertEquals(inboxPage.getComposeLabel(), "Compose Mail", "Wasn't login (asserted elements are not equal)");
    }

    @Test(testName = "Compose", description = "A new email compose and save as draft test", priority = 1)
    public void emailComposeTest() {
        composePage = inboxPage.goToComposePage()
//                                .setTo("ivan.mailtest@mail.ru")
                                .setToActions(email01.getToField())  //new PO method that emulates keyboards key send through Actions class API
                                .setSubject(email01.getSubjectField())
                                .setBody(email01.getBodyField())
//                                .saveDraft();
                                .saveDraftActions();    //new PO method that emulates LMC through Actions class API
        assertEquals(composePage.getDraftSavedLabel(), "Your message has been saved.", "Draft not saved (asserted elements are not equal)");
    }

    @Test(testName = "inDraft", description = "An email can be found in Draft test", priority = 2)
    public void presentInDraftTest() {
        draftPage = composePage.goToDraftPage();
        assertEquals(draftPage.getDraftTitle(), "Test subject " + randomNum + " gmail - Test body " + randomNum + " test", "No saved draft mail in Draft (asserted elements are not equal)");
    }

    @Test(testName = "fieldsCheck", description = "Saved as draft email fields(To, Subject, Body) verification", priority = 3)
    public void draftEmailFieldsTest() {
        draftItemPage = draftPage.goToDraftItemPage();
        assertEquals(draftItemPage.getTo(), email01.getToField(), "To is incorrect (asserted elements are not equal)");
        assertEquals(draftItemPage.getSubject(), email01.getSubjectField(), "Subject is incorrect (asserted elements are not equal)");
        assertEquals(draftItemPage.getBody(), email01.getBodyField(), "Body is incorrect (asserted elements are not equal)");
    }

    @Test(testName = "Send", description = "Send email and check that it's present in Sent", priority = 4)
    public void emailSendTest() {
//        draftItemPage.clickSendButton();
        draftItemPage.clickSendButtonJs();  //new PO method that realizes JS Executor based clicker
        sentPage = inboxPage.goToSentPage();
        assertEquals(sentPage.getSentTitle(), "Test subject " + randomNum + " gmail - Test body " + randomNum + " test", "Mail wasn't sent (asserted elements are not equal)");
    }

    @Test(testName = "Logout", description = "Gmail Account logOUT test", priority = 5)
    public void accountLogoutTest() {
        sentPage.clickLogoutLink();
        assertEquals(signInPage.getHeaderTitle(), "Sign in to continue to Gmail", "Wasn't logout (asserted elements are not equal)");
    }

}