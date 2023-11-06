package com.symund.step_definitions;

import com.symund.pages.BasePage;
import com.symund.pages.DashboardPage;
import com.symund.pages.FilesPage;
import com.symund.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertTrue;

public class DashboardStepDefs {
    DashboardPage dashboardPage;
    FilesPage filesPage;

    BasePage basePage;

    @Given("the user is on files page")
    public void theUserIsOnFilesPage() {

    }

    @When("the user presses on app icon")
    public void theUserPressesOnAppIcon() {
        dashboardPage.getDashIcon();

    }

    @Then("the user will be returned to the Dashboard")
    public void theUserWillBeReturnedToTheDashboard() {
        assertTrue(Driver.getDriver().getTitle().contains("Dashboard"));
    }
}

