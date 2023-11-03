package com.symund.pages;

import com.symund.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.util.ArrayList;
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











}
