package com.symund.step_definitions;

import com.symund.pages.FilesPage;
import com.symund.utilities.BrowserUtils;
import com.symund.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeletedFiles_StepDefinitions {

    FilesPage page = new FilesPage();
    Actions actions = new Actions(Driver.getDriver());



    //Scenario1
    @Given(": user navigates to “File” module")
    public void user_navigates_to_file_module() {
        BrowserUtils.selectModule("files").click();



    }

    @Given(": user navigates to “Deleted files” module")
    public void user_navigates_to_deleted_files_module() {

        FilesPage.selectTab("deleted").click();

    }

    @When(": user clicks sort by Modified")
    public void user_clicks_sort_by_modified() {

        actions.moveToElement(page.sortByDeleted).click().perform();

    }

    @Then(": user should be able to see deleted files by modified date in acceding order and vice versa")
    public void user_should_be_able_to_see_deleted_files_by_modified_date_in_acceding_order_and_vice_versa() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy hh:mm a");

        boolean isAccedingOrder = false;




        List<WebElement> dateOfCreation = Driver.getDriver().findElements(By.xpath("(//table[@id='filestable'])[12]//td[@class='date']//span"));

        List<String> dateTimeSorted = new ArrayList<>();

        List<String> dateTimeDefault = new ArrayList<>();

        for (WebElement eachElement : dateOfCreation) {

            dateTimeSorted.add(eachElement.getAttribute("data-original-title"));

            dateTimeDefault.add(eachElement.getAttribute("data-original-title"));
        }

        Collections.sort(dateTimeSorted);

        System.out.println(dateTimeSorted);

        if(!(dateTimeSorted.equals(dateTimeDefault))){
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
        }

    }


    //Scenario2

    @Given(": user clicks to to three dots icon for Test folder")
    public void user_clicks_to_to_three_dots_icon_for_test_folder() {

        WebElement rowToRemove = Driver.getDriver().findElement(By.xpath("//tr[@data-id='91656']"));

        if(rowToRemove.isDisplayed()){
            Driver.getDriver().findElement(By.xpath("//tr[@data-id='91656']//span//a[2]")).click();
        }

    }

    @Given(": user clicks to Delete permanently icon")
    public void user_clicks_to_delete_permanently_icon() {

        Driver.getDriver().findElement(By.xpath("(//tr[@data-id='91656']//div)[3]//span[.='Delete permanently']")).click();

    }
    @Then(": user should be able to see removed folder")
    public void user_should_be_able_to_see_removed_folder() {

        boolean rowExist = FilesPage.isElementPresent(Driver.getDriver(), By.xpath("//tr[@data-id='91656']"));

        if(!rowExist){
            Assert.assertTrue(true);
        }

    }

        //Scenario3

    @Given(": user click to restore button for the any files from Deleted Files Tab")
    public void user_click_to_restore_button_for_the_any_files_from_deleted_files_tab() {
        WebElement rowToRestore = Driver.getDriver().findElement(By.xpath("//tr[@data-id='91476']"));

        if(rowToRestore.isDisplayed()){
            Driver.getDriver().findElement(By.xpath("//tr[@data-id='91476']//a[@data-action='Restore']")).click();
        }
    }

    @When(": user navigates to All Files Tab")
    public void user_navigates_to_all_files_tab() {
        FilesPage.selectTab("all files").click();
    }
    @Then(": should be able to see Text2_Sharif files is visible in All Files Tab")
    public void should_be_able_to_see_text2_sharif_files_is_visible_in_all_files_tab() {

        boolean rowExist = FilesPage.isElementPresent(Driver.getDriver(),By.xpath("//tr[@data-id='91476']"));

        if(rowExist){
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
        }

    }








}


















