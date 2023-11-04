
Feature: Deleted Files Tab Functionality

  User story:

  As a user, I should be able to see all deleted files and delete/restore them permanently under the Deleted Files tab.

  Background: user is already logged in
    Given the user logged in as "user"
    And : user navigates to “File” module
    Then : user navigates to “Deleted files” module

  @SH
  Scenario: As as user, I should be able to sort deleted files by modified date

    Given : user clicks sort by Modified
    Then : user should be able to see deleted files by modified date in acceding order and vice versa

  @SH
  Scenario: As a user, I can delete any deleted file permanently

    Given : user clicks to to three dots icon for Test folder
    And : user clicks to Delete permanently icon
    Then : user should be able to see removed folder

  @SH
  Scenario: Restore deleted file functionality

    Given : user click to restore button for the any files from Deleted Files Tab
    When : user navigates to All Files Tab
    Then : should be able to see Text2_Sharif files is visible in All Files Tab

