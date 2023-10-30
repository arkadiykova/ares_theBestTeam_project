package com.symund.pages;

import com.symund.utilities.ConfigurationReader;
import com.symund.utilities.Driver;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage {

    private WebDriverWait wait;


    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
        this.wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//input[@id='user']")
    public WebElement userName;



    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@id='submit-form']")
    public WebElement submit;


    public void loginUser(String user_userNameStr, String user_passwordStr) {

        userName.sendKeys(ConfigurationReader.getProperty("user_username"));
        password.sendKeys(ConfigurationReader.getProperty("user_password"));
        submit.click();
        wait.until(ExpectedConditions.titleContains("Dashboard"));
        assertTrue(Driver.getDriver().getTitle().contains("Dashboard"));
    }

    public void loginEmployee(String employee_userNameStr, String employee_passwordStr) {

        userName.sendKeys(ConfigurationReader.getProperty("employee_username"));
        password.sendKeys(ConfigurationReader.getProperty("employee_password"));
        submit.click();
        wait.until(ExpectedConditions.titleContains("Dashboard"));
        assertTrue(Driver.getDriver().getTitle().contains("Dashboard"));
    }




}
