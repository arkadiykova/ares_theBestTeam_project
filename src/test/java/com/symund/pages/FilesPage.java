package com.symund.pages;

import com.symund.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilesPage {

    public FilesPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public static WebElement selectTab(String tabName) {
        WebElement header;
        try {
            header = Driver.getDriver().findElement(By.xpath("//*[contains(@class, 'with-icon')]"));
        } catch (NoSuchElementException e) {
            return null; // Return null if the module is not found.
        }


        List<WebElement> tabs = header.findElements(By.tagName("a"));
        for (WebElement eachTab : tabs) {
            if (eachTab.getText().contains(tabName.substring(0,1).toUpperCase())){ // will change the 1st letter of the tabName to UpperCase
                return eachTab; // Return the first displayed module.
            }
        }

        return null; // Return null if no displayed modules are found.
    }


}
