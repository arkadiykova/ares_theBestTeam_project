package com.symund.step_definitions;

import com.symund.pages.LoginPage;
import com.symund.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;


public class LoginStepDefs {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {

    }

    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String userType) {
        //based on input enter that user information
        String username = null;
        String password = null;

        if (userType.equalsIgnoreCase("user")) {
            username = ConfigurationReader.getProperty("user_username");
            password = ConfigurationReader.getProperty("user_password");
            new LoginPage().loginUser(username, password);

        } else if (userType.equalsIgnoreCase("employee")) {
            username = ConfigurationReader.getProperty("employee_username");
            password = ConfigurationReader.getProperty("employee_password");
            new LoginPage().loginEmployee(username, password);
        }
    }


}