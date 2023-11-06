package com.symund.pages;

import com.symund.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


public class ProfilePage {


    public ProfilePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "settings")
    public WebElement profileModule;

    @FindBy(xpath = "//li[@data-id='settings']")
    public WebElement settings;

    @FindBy(xpath = "//li[@data-id='logout']")
    public WebElement logOut;


    @FindBy(id = "displayname")
    public WebElement fullNameBar;


    @FindBy(xpath = "//span[@class='user-status-menu-item__header']")
    public WebElement userNameInsideMenu;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "languageinput")
    public WebElement languageSelectInput;

    @FindBy (xpath = "//form[@id='language']//label[.='Language']")
    public WebElement languagePlaceHolderForEnglish;

    @FindBy (xpath = "//form[@id='language']//label[.='Мова']")
    public WebElement languagePlaceHolderForUkranian;

    public List<WebElement> getLanguageOptions() {
        return languageSelectInput.findElements(By.tagName("option"));
    }

    public void selectLanguage(String language) {
        List<WebElement> options = getLanguageOptions();

        for (WebElement option : options) {
            if (option.getAttribute("value").contains(language)) {
                option.click();
                break;
            }
        }
    }











}
