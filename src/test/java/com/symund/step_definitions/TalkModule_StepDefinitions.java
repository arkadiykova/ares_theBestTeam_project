package com.symund.step_definitions;

import com.symund.pages.FilesPage;
import com.symund.pages.TalkPage;
import com.symund.utilities.BrowserUtils;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class TalkModule_StepDefinitions {

TalkPage talkPage = new TalkPage();
    @Given("user navigates to “Talk” module")
    public void user_navigates_to_talk_module() {
        BrowserUtils.selectModule("spreed").click();
    }
    @Given("user clicks a plus button")
    public void user_clicks_a_plus_button() {
        talkPage.plusButton.click();
    }
    @Given("user enters name for the conversation")
    public void user_enters_name_for_the_conversation() {
        talkPage.conversationName.sendKeys("Dialogue 1");
    }
    @Given("user enables Allow guests join via link")
    public void user_enables_allow_guests_join_via_link() {
        talkPage.AllowGuestToJoinViaLinkCheckbox.click();
    }
    @Given("user clicks Add participants button")
    public void user_clicks_add_participants_button() {
        talkPage.AddParticipantsButton.click();
    }
    @Given("user selects A person")
    public void user_selects_a_person() {
        talkPage.aPerson.click();
    }
    @Given("user clicks a create conversation button")
    public void user_clicks_a_create_conversation_button() {
        talkPage.createConversationButton.click();
    }
    @When("user clicks close button")
    public void user_clicks_close_button() {
        talkPage.closeButton.click();
    }
    @Then("user can see newly created conversation in the list")
    public void user_can_see_newly_created_conversation_in_the_list() {
        String actualNameOfANewConversation = talkPage.verification.getText();
        String expectedNameOfANewConversation = "Dialogue 1";
        Assert.assertEquals(actualNameOfANewConversation , expectedNameOfANewConversation);
    }
}
