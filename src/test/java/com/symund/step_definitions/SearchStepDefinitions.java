package com.symund.step_definitions;

import com.symund.pages.DashboardPage;
import com.symund.pages.FilesPage;
import com.symund.pages.LoginPage;
import com.symund.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SearchStepDefinitions {

    FilesPage filesPage;
    DashboardPage dashboardPage;
    private WebDriverWait wait;
    private String fileName;

    public SearchStepDefinitions() {
        this.dashboardPage = new DashboardPage();
        this.filesPage = new FilesPage();
        this.fileName = "ReadMe.md";
        this.wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));

    }

    @Given("the user is on the dashboard page")
    public void theUserIsOnTheDashboardPage() {
        wait.until(ExpectedConditions.titleContains("Dashboard"));
        assertTrue(Driver.getDriver().getTitle().contains("Dashboard"));
    }

    @And("the user types file name in the search box")
    public void theUserTypesFileNameInTheSearchBox() {
        dashboardPage.getSearchButton().click();
        dashboardPage.getSearchBox().sendKeys(fileName);
        wait.until(ExpectedConditions.visibilityOf( dashboardPage.getSearchResult().get(0)));
        dashboardPage.getSearchBox().sendKeys(Keys.ENTER);
    }

    @When("the user presses on search icon")
    public void theUserPressesOnSearchIcon() {
        dashboardPage.getSearchButton();

    }

    @Then("the user should be redirected to a new page and see the file")
    public void theUserShouldBeRedirectedToANewPageAndSeeTheFile() {
        wait.until(ExpectedConditions.visibilityOf(filesPage.getAllFiles()));
        assertTrue(filesPage.getAllFiles().isDisplayed());
    }


}
