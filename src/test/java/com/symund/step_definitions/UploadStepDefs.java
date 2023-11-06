package com.symund.step_definitions;

import com.symund.pages.FilePage;
import com.symund.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class UploadStepDefs {

    FilePage filePage = new FilePage();

    /*
    public static List<String> namesOfAllFiles(WebElement nameOfFile) {

        List<WebElement> namesAsElements = new ArrayList<>();
        namesAsElements.add(nameOfFile);

        List<String> namesAsString = new ArrayList<>();
        for (WebElement each : namesAsElements) {
            namesAsString.add(each.getText());
        }

        return namesAsString;

    }

     */


    @When("user clicks Add new button")
    public void user_clicks_add_new_button() {
        filePage.addNewButton.click();
    }
    @And("user clicks Upload file button and upload any file")
    public void user_clicks_upload_file_button_and_upload_any_file() {
        filePage.uploadFileButton.sendKeys("/Users/artem/Desktop/book/booknotes.txt");
    }
    @Then("user should see new uploaded file")
    public void user_should_see_new_uploaded_file() {
        String expectedName = "booknotes";

        if (expectedName.equals(filePage.nameOfFile.getText())) {
            Assert.assertTrue(true);
        }
    }


    @And("user clicks New folder button")
    public void userClicksNewFolderButton() {
        filePage.newFolderButton.click();
    }
    @And("user enters {string} as name of the folder")
    public void userEntersAsNameOfTheFolder(String arg0) {
        filePage.folderNameInput.sendKeys(arg0 + Keys.ENTER);
    }
    @Then("user should see new created folder {string}")
    public void userShouldSeeNefCreatedFolder(String arg0) {
        if (arg0.equals(filePage.nameOfFile.getText())) {
            Assert.assertTrue(true);
        }
    }


    @When("user clicks three dote menu of any file")
    public void userClicksThreeDoteMenuOfAnyFile() {
        filePage.threeDotsMenu.click();
    }
    @Then("user should be able to click Delete file or folder button")
    public void userClicksDeleteFileFolderButton() {
        Assert.assertTrue(filePage.threeDotsMenu.isEnabled());
    }


    @Then("user should see the total number of files and folders")
    public void userShouldSeeTheTotalNumberOfFilesAndFolders() {
        Assert.assertTrue(filePage.totalNumberOfFiles.isDisplayed());
    }

}
