package com.symund.pages;

import com.symund.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FilePage {

    public FilePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//a[@class='button new']")
    public WebElement addNewButton;

    @FindBy (xpath = "//label[@for='file_upload_start']")
    public WebElement uploadFileButton;

    @FindBy (xpath = "//table[@class='list-container has-controls']//span[@class='innernametext']")
    public WebElement nameOfFile;

    @FindBy (xpath = "//a[@data-filetype='folder']")
    public WebElement newFolderButton;

    @FindBy (xpath = "//input[@id='view12-input-folder']")
    public WebElement folderNameInput;

    @FindBy (xpath = "//a[@class='action action-menu permanent']")
    public WebElement threeDotsMenu;

    @FindBy (xpath = "//a[@class='menuitem action action-delete permanent']")
    public WebElement deleteButton;

    @FindBy (xpath = "//span[@class='info']")
    public WebElement totalNumberOfFiles;

}
