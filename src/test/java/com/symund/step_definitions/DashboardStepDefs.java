package com.symund.step_definitions;

import com.symund.pages.*;
import com.symund.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class DashboardStepDefs {
    private WebDriverWait wait;
    DashboardPage dashboardPage;
    FilesPage filesPage;


    public DashboardStepDefs() {
        this.wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        this.dashboardPage = new DashboardPage();
        this.filesPage = new FilesPage();
    }

    @Given("the user is on files page")
    public void theUserIsOnFilesPage() {
        filesPage.getAllFiles();
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

