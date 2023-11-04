package com.symund.pages;

import com.symund.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Deck_Page {
    public Deck_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[@class='app-navigation-toggle']")
    public WebElement burgerMenu;

    @FindBy(xpath = "//a[@aria-label='Deck']")
    public WebElement deckModule;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement boardNameInputBox;

    @FindBy(xpath = "//div[@class='app-navigation-entry__icon-bullet']")
    public WebElement boardName;

    @FindBy(xpath = "//span[@title='New Board']")
    public WebElement newlyCreatedBoardName;

    @FindBy(xpath = "//span[@title='Add board']")
    public WebElement addBoardPlusSign;

    @FindBy(xpath = "//button[@rel='noreferrer noopener']")
    public WebElement topPlusSignForList;

    @FindBy(xpath = "//span[@title='All boards']")
    public WebElement allBoardsButton;
    @FindBy(xpath = "//input[@type='text']")
    public WebElement newlyCreatedList;

    @FindBy(id = "new-stack-input-main")
    public WebElement inputListName;

    @FindBy(xpath = "(//input[@type='submit'])[2]")
    public WebElement listArrowSign;

    @FindBy(xpath = "(//button[@class='action-item action-item--single icon-add undefined undefined has-tooltip'])[2]")
    public WebElement cardPlusButton;

    @FindBy(id = "new-stack-input-main")
    public WebElement cardNameBox;

    @FindBy(xpath = "//div[@class='card-upper']")
    public WebElement newlyCreatedCardName;

    @FindBy(xpath = "(//input[@type='submit'])[2]")
    public WebElement cardBoxArrowSign;

    @FindBy(xpath = "(//button[@aria-label='Actions'])[2]")
    public WebElement card3DotsOption;

    @FindBy(xpath = "//span[.='Assign to me']")
    public WebElement assignToMeButton;

    @FindBy(xpath = "//div[@class='avatarlist--inline']")
    public WebElement userAvatar;


}
