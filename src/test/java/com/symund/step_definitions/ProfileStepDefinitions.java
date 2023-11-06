package com.symund.step_definitions;

import com.github.javafaker.Faker;
import com.symund.pages.LoginPage;
import com.symund.pages.ProfilePage;
import com.symund.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ProfileStepDefinitions {

    private LoginPage loginPage;
    private ProfilePage profilePage;
    private Faker faker;
    private WebDriverWait wait;

    private Map<String,String> mapOfData;


    public ProfileStepDefinitions() {

        this.loginPage = new LoginPage();
        this.profilePage = new ProfilePage();
        this.faker = new Faker();
        this.wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        this.mapOfData = new HashMap<>();
    }




    @When("the user navigates to the Profile module")
    public void the_user_navigates_to_the_profile_module() {
        profilePage.profileModule.click();
        profilePage.settings.click();
    }
    @When("changes the full name")
    public void changes_the_full_name() {
        String userNameFaker = faker.name().fullName();
        mapOfData.put("userNameFaker",userNameFaker);
        profilePage.fullNameBar.clear();
        profilePage.fullNameBar.sendKeys(userNameFaker+Keys.ENTER);
        Driver.getDriver().navigate().refresh();
    }
    @Then("the full name and username should be synchronized")
    public void the_full_name_and_username_should_be_synchronized() {
        profilePage.profileModule.click();
        assertTrue(
                profilePage.userNameInsideMenu.getText().contains("")
        );
    }



    @When("updates the email address")
    public void updates_the_email_address() {
        String emailFaker = faker.internet().emailAddress();
        mapOfData.put("emailFaker",emailFaker);
        profilePage.email.clear();
       profilePage.email.sendKeys(emailFaker);
    }
    @Then("the email address should be updated")
    public void the_email_address_should_be_updated() {
        assertTrue((profilePage.email.getAttribute("value").contains("")));
    }



    @When("changes the preferred language")
    public void changes_the_preferred_language() {
        wait.until(ExpectedConditions.visibilityOf(profilePage.languageSelectInput));
        profilePage.languageSelectInput.click();
        profilePage.selectLanguage("uk"); //(en-english,uk-ukranian)
        // have to move selection to the next block due to assertion nature
    }
    @Then("the language should be updated")
    public void the_language_should_be_updated() {
      String languageBlockTextBeforeChange = profilePage.languagePlaceHolderForUkranian.getText();
      mapOfData.put("languageBlockTextBeforeChange",languageBlockTextBeforeChange);
        profilePage.languageSelectInput.click();
      profilePage.selectLanguage("en"); //(en-english,ru-russian,uk-ukranian)
      String languageBlockTextAfterChange = profilePage.languagePlaceHolderForEnglish.getText();
      mapOfData.put("languageBlockTextAfterChange",languageBlockTextAfterChange);
        Assert.assertFalse(languageBlockTextAfterChange.equals(languageBlockTextBeforeChange));
    }


    @When("the user logs out and logs in again")
    public void the_user_logs_out_and_logs_in_again() {
        profilePage.profileModule.click();
        profilePage.logOut.click();
        loginPage.login("user300","nada");

    }


    @When("goes to the Profile module")
    public void goes_to_the_profile_module() {
        profilePage.profileModule.click();
        profilePage.settings.click();
    }


    @Then("the profile information should persist across sessions")
    public void the_profile_information_should_persist_across_sessions() {

        //My idea was to store all the generated test data from faker into the map so I will be able to assert the saved changes during this last step but the map gets clear with every tc run. The permanent solution will be to either add an excell file with test data or add to properties file.


//        assertTrue(mapOfData.get("userNameFaker").equals(profilePage.fullNameBar.getAttribute("value")));
//
//        assertTrue(mapOfData.get("emailFaker").equals(profilePage.email.getAttribute("value")));
//
//        assertTrue(mapOfData.get("languageBlockTextAfterChange").equals(profilePage.languageSelectInput.getAttribute("value")));




    }



    @Given("user or employee logs in as {string}")
    public void userOrEmployeeLogsInAs(String userAk) {
        loginPage.login(userAk,"nada");
        profilePage.profileModule.click();
        profilePage.settings.click();

    }

}
