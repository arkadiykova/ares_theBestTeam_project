package com.symund.pages;

import com.symund.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import java.awt.*;
import java.util.ArrayList;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class FilesPage {

    public FilesPage() {
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

















    public static WebElement selectTab(String tabName) {
        WebElement header;
        try {
            header = Driver.getDriver().findElement(By.xpath("//*[contains(@class, 'with-icon')]"));
        } catch (NoSuchElementException e) {
            return null; // Return null if the module is not found.
        }

        List<WebElement> tabs = header.findElements(By.tagName("a"));
        for (WebElement eachTab : tabs) {
            if (eachTab.getText().contains(tabName.substring(0, 1).toUpperCase())) { // will change the 1st letter of the tabName to UpperCase
                return eachTab; // Return the first displayed module.
            }
        }

        return null; // Return null if no displayed modules are found.
    }

    public static boolean isElementPresent(WebDriver driver, By by) {
        try {
            Driver.getDriver().findElement(by);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }





    @FindBy(xpath = "//a[.='Deleted']")
    public WebElement sortByDeleted;




}
