package com.symund.pages;

import com.symund.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Deck_Page {
    public Deck_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(linkText = "/index.php/apps/deck/")
    public WebElement deckModule;

    @FindBy(xpath = "//span[@title='All boards']")
    public WebElement allBoardsButton;


    @FindBy(id = "new-stack-input-main")
    public WebElement inputListName;

    @FindBy(xpath = "(//input[@type='submit'])[2]")
    public WebElement listArrowSign;

    @FindBy(xpath = "(//button[@class='action-item action-item--single icon-add undefined undefined has-tooltip'])[2]")
    public WebElement cardPlusButton;

    @FindBy(id = "new-stack-input-main")
    public WebElement cardNameBox;

    @FindBy(xpath = "(//input[@type='submit'])[2]")
    public WebElement cardBoxArrowSign;

    @FindBy(xpath = "(//button[@aria-label='Actions'])[2]")
    public WebElement card3DotsOption;

    @FindBy(xpath = "//span[.='Assign to me']")
    public WebElement assignToMeButton;
}
