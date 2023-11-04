package com.symund.step_definitions;


import com.symund.pages.Deck_Page;
import com.symund.pages.LoginPage;
import com.symund.utilities.BrowserUtils;
import com.symund.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Deck_module_Step_defs {

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(40));;
    LoginPage loginPage=new LoginPage();

    Deck_Page deckPage = new Deck_Page();

    @Given("user is logged in as a {string}")
    public void user_is_logged_in_as_a(String string) {

     loginPage.login(string);

    }

    @Then("user navigates to Deck module")
    public void user_navigates_to_deck_module() {
        BrowserUtils.hover(deckPage.deckModule);


    }
    @Given("user clicks on Deck module")
    public void user_clicks_on_deck_module() {
     deckPage.deckModule.click();

    }
        @And("clicks on burgerMenu")
    public void clicksOnBurgerMenu() {

            deckPage.burgerMenu.click();
            BrowserUtils.waitFor(20);
      //  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='app-navigation-toggle']")));



    }
    @When("user clicks on Add board plus sign")
    public void user_clicks_on_add_board_plus_sign() {


       // wait.until(ExpectedConditions.elementToBeClickable(deckPage.addBoardPlusSign));
        BrowserUtils.waitFor(25);
        deckPage.addBoardPlusSign.click();

    }
    @Then("user types board name in the input box and clicks Enter key on the keyboard")
    public void user_types_board_name_in_the_input_box_and_clicks_enter_key_on_the_keyboard() {

        //wait.until(ExpectedConditions.visibilityOf(deckPage.boardNameInputBox));
        BrowserUtils.waitFor(20);
        deckPage.boardNameInputBox.sendKeys("New Board" + Keys.ENTER);

    }


    @Then("user sees the newly created board on the left side under ALl Boards")
    public void user_sees_the_newly_created_board_on_the_left_side_under_a_ll_boards() {


        wait.until(ExpectedConditions.visibilityOf(deckPage.newlyCreatedBoardName));
        BrowserUtils.waitFor(20);
        Assert.assertTrue(deckPage.newlyCreatedBoardName.isDisplayed());

    }

   // @Given("user is inside the Deck module")
   // public void user_is_inside_the_deck_module() {


   // }
    @When("user clicks on newly created board name")
    public void user_clicks_on_newly_created_board_name() {
      deckPage.newlyCreatedBoardName.click();

    }
    @When("user clicks on Add List plus button on top right")
    public void user_clicks_on_add_list_plus_button_on_top_right() {

        deckPage.topPlusSignForList.click();
    }
    @When("user types new list name in the input box and clicks Enter key on the keyboard")
    public void user_types_new_list_name_in_the_input_box_and_clicks_enter_key_on_the_keyboard() {
    deckPage.inputListName.sendKeys("New List");

    }
    @Then("user sees the newly created list inside the board")
    public void user_sees_the_newly_created_list_inside_the_board() {
        Assert.assertTrue(deckPage.newlyCreatedList.isDisplayed());


    }
    @Given("user is inside the board")
    public void user_is_inside_the_board() {

     Assert.assertTrue(deckPage.addBoardPlusSign.isDisplayed());

    }
    @When("user clicks on Add Card plus button")
    public void user_clicks_on_add_card_plus_button() {
    deckPage.cardPlusButton.click();

    }
    @When("user types new card name and clicks on Enter key on the keyboard")
    public void user_types_new_card_name_and_clicks_on_enter_key_on_the_keyboard() {
 deckPage.cardNameBox.sendKeys("New Card");

    }
    @Then("user sees the newly created card inside the list")
    public void user_sees_the_newly_created_card_inside_the_list() {
  Assert.assertTrue(deckPage.newlyCreatedCardName.isDisplayed());

    }

    @Given("user clicks on three dots cards’ drop down menu on the card")
    public void user_clicks_on_three_dots_cards_drop_down_menu_on_the_card() {

          deckPage.card3DotsOption.click();
    }
    @Then("user clicks on Assign to me option")
    public void user_clicks_on_assign_to_me_option() {

          deckPage.assignToMeButton.click();
    }
    @Then("user should see his or her profile icon on the card")
    public void user_should_see_his_or_her_profile_icon_on_the_card() {

       Assert.assertTrue(deckPage.userAvatar.isDisplayed());
    }


}


