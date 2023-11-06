package com.symund.pages;

import com.symund.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class FavoritesRenameCommentPage {


    public FavoritesRenameCommentPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    //locators for the tested file

    //
    //@FindBy(xpath = "//a[normalize-space(.)='Files'][1]")
    @FindBy(xpath = "(//a[@aria-label='Files'])[1]")
    public WebElement filesModule;


    @FindBy(xpath = "//tr[@data-id='91965']//a[@data-action='menu']")
    public WebElement addThreeDotMenu;

    @FindBy(xpath = "( //tr[@data-id='91965']//a[@data-action='menu'])[2]")
    public WebElement removeThreeDotMenu;
    @FindBy(xpath = "//tr[@data-id='91965']//a[@data-action='Favorite']")
    public WebElement addRemoveFavorites;

    @FindBy(xpath = "//tr[@data-id='91965']//a[@data-action='Rename']")
    public WebElement renameFile;

    @FindBy(xpath = "//tr[@data-id='91965']//a[@data-action='Details']")
    public WebElement detailsOption;

    @FindBy(xpath = "//a[@id='comments']")
    public WebElement commentsOption;

    @FindBy(xpath = "//div[@role='textbox']")
    public WebElement commentPlaceholder;


    public void clickMenuOption(WebElement addRemoveFavorites) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(addRemoveFavorites).perform();
        addRemoveFavorites.click();

    }

    @FindBy(xpath = "//tr[@data-id='91965']//span[@class='innernametext']")
    public WebElement testedFile;


    public void isFilePresentInFavorites() {
        try {
            // Verify the presence of the testedFile element
            Assert.assertTrue("The tested file is present in the Favorite tab folder.", testedFile.isEnabled());
            System.out.println("Tested file is present in Favorites");
        } catch (NoSuchElementException e) {
            Assert.fail("The tested file is not present in the Favorite tab folder.");
            System.out.println("Tested file is NOT present in Favorites");
        }
    }

//    @FindBy(xpath = "//input[@name='file-name']")
//    public WebElement renameInput;

    public void renameFileUsingKeyboard(String newFileName) {
        // If the renaming input is visible, send the new file name and press "Enter"
        WebElement activeInputField = Driver.getDriver().switchTo().activeElement();
        activeInputField.sendKeys(newFileName);
        activeInputField.sendKeys(Keys.ENTER);

    }

    public String getFileName() {
        // Return the text of the testedFile element (the current file name)
        return testedFile.getText();
    }


}
