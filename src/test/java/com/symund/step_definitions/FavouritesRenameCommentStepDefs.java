package com.symund.step_definitions;

import com.symund.pages.FavoritesRenameCommentPage;
import com.symund.pages.FilesPage;
import com.symund.pages.LoginPage;
import com.symund.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertTrue;


public class FavouritesRenameCommentStepDefs {

    private WebDriverWait wait;
    private LoginPage loginPage;
    private FilesPage filesPage;
    private FavoritesRenameCommentPage favoritesRenameCommentPage;


    public FavouritesRenameCommentStepDefs() {
        this.wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        this.favoritesRenameCommentPage = new FavoritesRenameCommentPage();
        this.loginPage = new LoginPage();
        this.filesPage = new FilesPage();
    }


    @Given("the user navigates to {string} module")
    public void the_user_navigates_to_module(String Files) {
        favoritesRenameCommentPage.filesModule.click();
        assertTrue(Driver.getDriver().getTitle().contains("Files"));
    }

    //Scenario 1
    //@B30G7-154

    @When("the user clicks on three dots menu of any file")
    public void theUserClicksOnThreeDotsMenuOfAnyFile() {
        favoritesRenameCommentPage.addThreeDotMenu.click();
    }

    @And("the user hovers to and clicks {string} option")
    public void theUserHoversToAndClicksOption(String option) {
        favoritesRenameCommentPage.clickMenuOption(favoritesRenameCommentPage.addRemoveFavorites);
        System.out.println("Tested file successfully added to favorites");
    }

    @And("the user navigates to {string} tab")
    public void theUserNavigatesToTab(String Favorites) {
        FilesPage.selectTab("Favorites").click();
    }


    @And("the newly added file should be seen in {string} tab folder")
    public void theNewlyAddedFileShouldBeSeenInTabFolder(String fileName) {
        favoritesRenameCommentPage.isFilePresentInFavorites();
    }

    @Then("the user clicks on three dots menu of the newly added to favorites file")
    public void theUserClicksOnThreeDotsMenuOfTheNewlyAddedToFavoritesFile() {
        favoritesRenameCommentPage.removeThreeDotMenu.click();
    }


    @Then("the user clicks {string} option")
    public void theUserClicksOption(String option) {
        favoritesRenameCommentPage.clickMenuOption(favoritesRenameCommentPage.addRemoveFavorites);
        System.out.println("Tested file successfully removed from favorites");
    }


    //Scenario 2
//@B30G7-155
    @And("the user hovers to and clicks Rename option")
    public void theUserHoversToAndClicksRenameOption() {
        favoritesRenameCommentPage.clickMenuOption(favoritesRenameCommentPage.renameFile);
    }

    @And ("the user can rename the file")
    public void the_user_can_rename_the_file() {
        // Perform the renaming of the file using keyboard input
        String newFileName = "Renamed"; // Change this to the desired new name
        favoritesRenameCommentPage.renameFileUsingKeyboard(newFileName);
    }


@And ("the file is renamed successfully")
public void the_file_is_renamed_successfully() {
    String expectedNewFileName = "Renamed"; // Replace with the expected new file name
    try {
        Thread.sleep(3000); // Sleep for 3 seconds
    } catch (InterruptedException e) {
        // Handle the exception, if needed
    }
    String actualFileName = favoritesRenameCommentPage.testedFile.getText();

    // Use an assertion to compare the actual and expected file names
    Assert.assertEquals("Tested file successfully renamed", expectedNewFileName, actualFileName);

    // Print a statement if the file is successfully renamed
    Assert.assertTrue("The file has been successfully renamed.", actualFileName.equals(expectedNewFileName));
    System.out.println("The file has been successfully renamed");
}

    @Then("the user returns the original name to the file")
    public void theUserReturnsTheOriginalNameToTheFile() {

        String newFileName = "US0012"; // Change this to the original name
        favoritesRenameCommentPage.renameFileUsingKeyboard(newFileName);
    }
    @And("the file is renamed back successfully")
    public void theFileIsRenamedBackSuccessfully() {
        String expectedNewFileName = "US0012"; // Replace with the original file name
        try {
            Thread.sleep(3000); // Sleep for 3 seconds
        } catch (InterruptedException e) {
            // Handle the exception, if needed
        }
        String actualFileName = favoritesRenameCommentPage.testedFile.getText();

        // Use an assertion to compare the actual and expected file names
        Assert.assertEquals("Tested file successfully renamed", expectedNewFileName, actualFileName);

        // Print a statement if the file is successfully renamed
        Assert.assertTrue("The file has been successfully renamed.", actualFileName.equals(expectedNewFileName));
        System.out.println("The file has been successfully renamed back");
    }

    //Scenario 3
    //@B30G7-156


    @And("the user hovers to and clicks Details option")
    public void theUserHoversToAndClicksOption() {
        favoritesRenameCommentPage.clickMenuOption(favoritesRenameCommentPage.detailsOption);
    }
    @When("the user clicks {string} from menu opened right side")
    public void the_user_clicks_from_menu_opened_right_side(String option) {
        favoritesRenameCommentPage.commentsOption.click();
    }

    @When("the user adds comment to the file")
    public void the_user_adds_comment_to_the_file() {
        // Click on the commentPlaceholder element to give it focus
        favoritesRenameCommentPage.commentPlaceholder.click();

        // Send keys (comment) followed by an Enter key press
        favoritesRenameCommentPage.commentPlaceholder.sendKeys("Comment added" + Keys.ENTER);
    }

    @Then("the comment is successfully added")
    public void the_comment_is_successfully_added() {
        String expectedComment = "Comment added";

        String actualComment = favoritesRenameCommentPage.commentPlaceholder.getText();
        Assert.assertEquals("The comment is successfully added", expectedComment, actualComment);
        System.out.println("The comment is successfully added");
    }



}


