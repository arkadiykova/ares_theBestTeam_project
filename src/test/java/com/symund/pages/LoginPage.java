package com.symund.pages;


import com.symund.utilities.ConfigurationReader;
import com.symund.utilities.Driver;
import static org.junit.Assert.assertTrue; //used static keyword to not have to call assertTrue method throw Assert
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class LoginPage {

    private WebDriverWait wait;  // Declaring global variable private as it a good practice, and it will only be used in this class, same with ConfigurationReader. Later initialized inside the constructor
    private ConfigurationReader configurationReader;





    public LoginPage(){ // to initialize global variables: wait and configreader
        PageFactory.initElements(Driver.getDriver(), this);
        this.wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(10));
        this.configurationReader = new ConfigurationReader();


    }

    @FindBy(xpath = "//input[@id='user']")
    public WebElement userNameBar;



    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordBar;

    @FindBy(xpath = "//input[@id='submit-form']")
    public WebElement submit;


    //method replaces the userType for either "user" or "employee" to login as such
    public void login(String userType) {

        String username = configurationReader.getProperty(userType + "_username");
        String password = configurationReader.getProperty(userType + "_password");

        userNameBar.sendKeys(username);
        passwordBar.sendKeys(password);
        submit.click();
        wait.until(ExpectedConditions.titleContains("Dashboard"));
        assertTrue(Driver.getDriver().getTitle().contains("Dashboard"));

    }




}
