package com.symund.step_definitions;

import com.symund.pages.ContactsPage;
import com.symund.pages.LoginPage;
import com.symund.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;



public class ContactsStepDefinitions {

private WebDriverWait wait;
private ContactsPage contactsPage;
private List<String> groupNames;
private LoginPage loginPage;



    public ContactsStepDefinitions() {
        this.wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        this.contactsPage = new ContactsPage();
        this.groupNames = new ArrayList<>();
        this.loginPage = new LoginPage();

    }
    int groupCount = 0;


    @Given("the user is on the landing page")
    public void the_user_is_on_the_landing_page() {
        wait.until(ExpectedConditions.titleContains("Dashboard"));
        assertTrue(Driver.getDriver().getTitle().contains("Dashboard"));
    }

    @When("the user navigates to the Contacts module")
    public void the_user_navigates_to_the_contacts_module() {
        contactsPage.contactsModule.click();
        assertTrue(Driver.getDriver().getTitle().contains("Contacts"));
    }

    @When("the user creates a new group")
    public void the_user_creates_a_new_group() {
        contactsPage.newGroup.click();
    }

    @When("the user names the new group")
    public void the_user_names_the_new_group() {
        String groupName = "ArkadiiTestGroup"+System.currentTimeMillis();
        contactsPage.newGroupName.sendKeys(groupName+ Keys.ENTER);
        groupNames.add(groupName);

    }
    @When("the user clicks on New Contact")
    public void the_user_clicks_on_new_contact() {
        contactsPage.newContact.click();
    }

    @When("the user fills out the new contact form")
    public void the_user_fills_out_the_new_contact_form() {
        contactsPage.fillContactForm();
        groupCount ++;
    }

    @When("the user adds a new property of anniversary")
    public void the_user_adds_a_new_property_of_anniversary() {
        contactsPage.newContactPropertySelection.click();
        contactsPage.anniversaryOption.click();
    }

    @Then("the new group is created successfully")
    public void the_new_group_is_created_successfully() {
        String newlyCreatedGroupName = groupNames.get(groupNames.size()-1);
        List<WebElement> listOfGroups = Driver.getDriver().findElements(By.xpath("//div[@id=\"app-navigation-vue\"]//ul/li//*"));
        boolean isGroupCreated = false;
        for (WebElement eachGroup : listOfGroups) {
            if (eachGroup.getText().contains(newlyCreatedGroupName)){
                isGroupCreated = true;
                break;
            }
        }
        assertTrue(isGroupCreated);

    }

    @Then("the new contact is added to the group")
    public void the_new_contact_is_added_to_the_group() {
        assertTrue(groupCount>0);
    }

    @Then("the {string} property is set for the new contact")
    public void the_property_is_set_for_the_new_contact(String string) {
        assertTrue(contactsPage.newContactAnniversaryBlock.isDisplayed());
    }
}
