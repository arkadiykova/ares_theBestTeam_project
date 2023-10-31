package com.symund.pages;

import com.symund.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class FilesPage {

    public FilesPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


}
