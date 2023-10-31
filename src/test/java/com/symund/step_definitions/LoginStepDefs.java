package com.symund.step_definitions;

import com.symund.pages.LoginPage;
import com.symund.utilities.ConfigurationReader;
import com.symund.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;


public class LoginStepDefs {
    private LoginPage loginPage;
    private WebDriverWait wait;

    public LoginStepDefs() {
        this.loginPage = new LoginPage();
        this.wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        wait.until(ExpectedConditions.titleContains("Symund"));
        assertTrue(Driver.getDriver().getTitle().contains("Symund"));
    }

    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String userType) {
        //based on input enter that user information
        loginPage.login(userType);
    }

    @Then("they should have access to user-specific features")
    public void they_should_have_access_to_user_specific_features() {
        wait.until(ExpectedConditions.titleContains("QA"));
       assertTrue(Driver.getDriver().getTitle().contains("QA"));
    }

    @Then("they should have access to employee-specific features")
    public void they_should_have_access_to_employee_specific_features() {
        wait.until(ExpectedConditions.titleContains("QA"));
        assertTrue(Driver.getDriver().getTitle().contains("QA"));
    }



}