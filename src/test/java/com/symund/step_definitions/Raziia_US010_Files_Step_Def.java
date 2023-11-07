package com.symund.step_definitions;

import com.symund.pages.FilesPage;
import com.symund.pages.LoginPage;
import com.symund.utilities.BrowserUtils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;


import java.util.List;

public class Raziia_US010_Files_Step_Def {
    FilesPage filesPage = new FilesPage();
    LoginPage loginPage = new LoginPage();





    @When("user enter valid username and password")
    public void userEnterValidUsernameAndPassword() {
        loginPage.login("user");
    }

    @And("user click to login button")
    public void userClickToLoginButton() {
    }

    @Then("user should be directed to home page")
    public void userShouldBeDirectedToHomePage() {
    }

    @Given("User click Files button")
    public void user_click_files_button() {
        filesPage.FilesButton.click();
    }
    @When("User see  title is Files - Symund - QA")
    public void user_see_all_files_dashboard() {
        BrowserUtils.verifyTitle("Files - Symund - QA");
    }
    @Then("User click Names  arrow button")
    public void user_click_names_button() {
        filesPage.NameArrowButton.click();

    }
    @Then("User can see all Files sorted by name in alphabetical order")
    public void user_can_see_all_files_sorted_by_name_in_alphabetical_order() {


        List<String> nameOfFiles = new ArrayList<>();
        for (WebElement eachFiles : filesPage.notFavoriteFiles) {
            nameOfFiles.add(eachFiles.getAttribute("data-file"));
        }
        boolean sortedStatus = isSorted(nameOfFiles);

        if (sortedStatus) {
            Assert.assertTrue(true);
            System.out.println("The Files are sorted.");
        } else {
            Assert.assertTrue(false);
            System.out.println("The Files are not sorted.");
        }



        List<String> nameOfFavoriteFolders = new ArrayList<>();
        for(WebElement eachFavoriteFolder : filesPage.AllFavoriteFolders){
            nameOfFavoriteFolders.add(eachFavoriteFolder.getAttribute("data-file"));

        }
        boolean sortedStatus2 = isSorted(nameOfFavoriteFolders);

        if (sortedStatus2) {
            Assert.assertTrue(true);
            System.out.println("The Favorite folders are sorted.");
        } else {
            Assert.assertTrue(false);
            System.out.println("The Favorite folders are not sorted.");
        }
        List<String> nameOfFavoriteFiles = new ArrayList<>();
        for(WebElement eachFavoriteFiles : filesPage.AllFavoriteFiles){
            nameOfFavoriteFiles.add(eachFavoriteFiles.getAttribute("data-file"));
        }
        boolean sortedStatus3 = isSorted(nameOfFavoriteFiles);

        if (sortedStatus3) {
            Assert.assertTrue(true);
            System.out.println("The Favorite files are sorted.");
        } else {
            Assert.assertTrue(false);
            System.out.println("The Favorite files are not sorted.");
        }
        List<String> nameOfAllFilesFolder = new ArrayList<>();
        for(WebElement eachAllFilesFolder : filesPage.notFavoriteFolders){
            nameOfAllFilesFolder.add(eachAllFilesFolder.getAttribute("data-file"));
        }
        boolean sortedStatus4 = isSorted(nameOfAllFilesFolder);

        if (sortedStatus4) {
            Assert.assertTrue(true);
            System.out.println("The Folders are sorted.");
        } else {
            Assert.assertTrue(false);
            System.out.println("The Folders  are not sorted.");
        }


    }





    @Then("User click Size  button")
    public void userClickSizeButton() {
        filesPage.SizeButton.click();
    }

    @Then("User can see the list of Files sorted in order by size")
    public void userCanSeeTheListOfFilesInOrderBySize() {

            List<Integer> sizesOfFiles = new ArrayList<>();
            for (WebElement element : filesPage.notFavoriteFiles2) {
                // Assuming the size is represented as text and needs conversion to integer
                String sizeText = element.getAttribute("data-size").replaceAll("[^0-9]", ""); // Extract the numeric value
                int size = Integer.parseInt(sizeText);
                sizesOfFiles.add(size);
            }
        // Check if the sizes are sorted
            boolean sortedAscending = isAscendingSorted(sizesOfFiles);
            boolean sortedDescending = isDescendingSorted(sizesOfFiles);

            // Perform actions based on the sorted status
            if (sortedAscending) {
                Assert.assertTrue(true);
                System.out.println("Files are sorted by size in ascending order.");
            } else if (sortedDescending) {
                Assert.assertTrue(true);
                System.out.println("Files are sorted by size in descending order.");
            } else {
                Assert.assertTrue(false);
                System.out.println("Files are not sorted by size.");
            }

        List<Integer> sizesOfFavoriteFiles = new ArrayList<>();
        for (WebElement element : filesPage.FavoriteFiles2) {
            // Assuming the size is represented as text and needs conversion to integer
            String sizeText3 = element.getAttribute("data-size").replaceAll("[^0-9]", ""); // Extract the numeric value
            int size3 = Integer.parseInt(sizeText3);
            sizesOfFavoriteFiles.add(size3);
        }
        // Check if the sizes are sorted
        boolean sortedAscending3 = isAscendingSorted(sizesOfFavoriteFiles);
        boolean sortedDescending3 = isDescendingSorted(sizesOfFavoriteFiles);

        // Perform actions based on the sorted status
        if (sortedAscending3) {
            Assert.assertTrue(true);
            System.out.println("Favorite files are sorted by size in ascending order.");
        } else if (sortedDescending3) {
            Assert.assertTrue(true);
            System.out.println("Favorite files are sorted by size in descending order.");
        } else {
            Assert.assertTrue(false);
            System.out.println("Favorite files are not sorted by size.");
        }
    }

    @Then("User click Modified arrow button")
    public void userClickModifiedArrowButton() {
        filesPage.ModifiedButton.click();
    }

    @Then("User can see the list of Files sorted in order based on Modified dates")
    public void userCanSeeTheListOfFilesInOrderBasedOnModifiedDates() {

        List<LocalDate> datesOfFiles = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, uuuu HH:mm a");
        for (WebElement element : filesPage.notFavoriteFilesDate) {
            String dateString = element.getAttribute("data-original-title");
        try {
        LocalDate date = LocalDate.parse(dateString, formatter);
        //validDatesOfFiles.add(date);
         } catch (DateTimeParseException e){}
               // invalidDateStrings.add(dateString);
        }
        // Verify ascending order
        boolean ascendingOrder1 = isSortedAscendingDate(datesOfFiles);
        // Verify descending order
        boolean descendingOrder1 = isSortedDescendingDate(datesOfFiles);
        // Perform actions based on the sorted status
        if (ascendingOrder1) {
            Assert.assertTrue(true);
            System.out.println("Files are sorted by modified date in ascending order.");
        } else if (descendingOrder1) {
            Assert.assertTrue(true);
            System.out.println("Files are sorted by modified date in descending order.");
        } else {
            Assert.assertTrue(false);
            System.out.println("Files are not sorted by modified date.");
        }
        List<LocalDate> datesOfFavoriteFiles = new ArrayList<>();
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MMMM dd, uuuu HH:mm a");
        for (WebElement element : filesPage.FavoriteFilesDate) {
            String dateString = element.getAttribute("data-original-title");
            try {
                LocalDate date = LocalDate.parse(dateString, formatter2);
                //validDatesOfFiles.add(date);
            } catch (DateTimeParseException e){}
            // invalidDateStrings.add(dateString);
        }
        // Verify ascending order
        boolean ascendingOrder2 = isSortedAscendingDate(datesOfFavoriteFiles);
        // Verify descending order
        boolean descendingOrder2 = isSortedDescendingDate(datesOfFavoriteFiles);
        // Perform actions based on the sorted status
        if (ascendingOrder2) {
            Assert.assertTrue(true);
            System.out.println("Favorite Files are sorted by modified date in ascending order.");
        } else if (descendingOrder2) {
            Assert.assertTrue(true);
            System.out.println("Favorite Files are sorted by modified date in descending order.");
        } else {
            Assert.assertTrue(false);
            System.out.println("Favorite Files are not sorted by modified date.");
        }





    }

    @When("User click on Select all checkbox button")
    public void userClickOnSelectAllCheckboxButton() {
        filesPage.checkBox.click();
    }

    @And("User can see that all checkboxses checked")
    public void userCanSeeThatAllCheckboxsesChecked() {


        boolean allChecked = true;

        // Verify if all checkboxes are checked
        for (WebElement checkbox : filesPage.allCheckBoxes) {
            if (checkbox.isSelected()) {
                allChecked=true;
                break;
            }
        }

        // Perform actions based on the verification
        if (allChecked) {
            System.out.println("All checkboxes are checked.");
        } else {
            System.out.println("Not all checkboxes are checked.");
        }

    }

    @Then("User should see total value of folders and files")
    public void userShouldSeeTotalValueOfFoldersAndFiles() {

        String bodyText = filesPage.totalValueOfFoldersAndFiles.getText(); // Get the text within the <body> element

        String specificWords = "folders"; // Words you're checking for

        if (bodyText.contains(specificWords)) {
            System.out.println("The user see total value of folders and files");

        } else {
            System.out.println("The user see total value of folders and files" );

        }


    }
    public static boolean isSorted(List<String> list) {
        boolean ascending = true;
        boolean descending = true;

        for (int i = 1; i < list.size(); i++) {
            // Check for ascending order
            if (list.get(i - 1).compareTo(list.get(i)) > 0) {
                ascending = false;
            }
            // Check for descending order
            if (list.get(i - 1).compareTo(list.get(i)) < 0) {
                descending = false;
            }
        }

        // If either ascending or descending is true, the list is sorted
        return ascending || descending;
    }

    public static boolean isAscendingSorted(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) > list.get(i)) {
                return false;
            }
        }
        return true;
    }
    public static boolean isDescendingSorted(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) < list.get(i)) {
                return false;
            }
        }
        return true;
    }
    public static boolean isSortedAscendingDate(List<LocalDate> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).isAfter(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    // Method to check if a list of dates is sorted in descending order
    public static boolean isSortedDescendingDate(List<LocalDate> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).isBefore(list.get(i))) {
                return false;
            }
        }
        return true;


    }

}
