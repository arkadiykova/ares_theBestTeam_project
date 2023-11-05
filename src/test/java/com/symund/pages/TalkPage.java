package com.symund.pages;

import com.symund.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TalkPage {

    public TalkPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@class='toggle has-tooltip']")
    public WebElement plusButton;

    @FindBy(xpath = "(//input[@type='text'])[3]")
    public WebElement conversationName;

    @FindBy(xpath = "//label[@for='checkbox']")
    public WebElement AllowGuestToJoinViaLinkCheckbox;

    @FindBy(xpath = "//div[@class='navigation']/button")
    public WebElement AddParticipantsButton;

    @FindBy(xpath = "//div[@class='participants-search-results scrollable']//ul/li[1]")
    public WebElement aPerson;

    @FindBy(xpath = "//button[@class='navigation__button navigation__button-right primary']")
    public WebElement createConversationButton;

    @FindBy(xpath = "//button[@class='navigation__button navigation__button-right primary']")
    public WebElement closeButton;

    @FindBy(xpath = "(//span[@class='acli__content__line-one__title'])[1]")
    public WebElement verification;






}
