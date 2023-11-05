package com.symund.pages;

import com.symund.utilities.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class FilesPage {

    public FilesPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath ="//a[@aria-label='Files']")
    public WebElement FilesButton;
    @FindBy(linkText = "Name")
    public WebElement NameArrowButton;

    @FindBy(xpath = "//tr[@data-type='dir' and @data-favorite='true']")
    public List<WebElement> AllFavoriteFolders;
    @FindBy(xpath = "//tr[@data-type='file' and @data-favorite='true']")
    public List<WebElement> AllFavoriteFiles;

@FindBy(xpath = "//tr[@data-type='dir' and not(contains(@data-favorite, 'true'))]")
public List<WebElement> notFavoriteFolders;
@FindBy (xpath = "//tr[@data-type='file' and not(contains(@data-favorite, 'true'))]")
public List<WebElement> notFavoriteFiles;
@FindBy(xpath = "//a[@data-sort='size']")
public WebElement SizeButton;
@FindBy(xpath = "//a[@data-sort='mtime']")
public WebElement ModifiedButton;
@FindBy(xpath = "//tr[@data-favorite='true']")
public List<WebElement> FavoriteFiles2;
@FindBy(xpath = "//span[.='Not favorited']/../../../../../..")
public List<WebElement> notFavoriteFiles2;


@FindBy(xpath="//tr[@data-type='file' and not(contains(@data-favorite, 'true'))]/td[4]/span")
public List<WebElement> notFavoriteFilesDate;


@FindBy(xpath = "//tr[@data-favorite='true']/td[4]/span")
    public List<WebElement> FavoriteFilesDate;
@FindBy(xpath = "//label[@for='select_all_files']")
public WebElement checkBox;
@FindBy(xpath = "//td[@class='selection']")
public List<WebElement> allCheckBoxes;
@FindBy(xpath = "//table[@id='filestable']//a//span")
public WebElement totalValueOfFoldersAndFiles;


















}
