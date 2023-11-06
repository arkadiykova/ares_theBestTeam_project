@B30G7-157
Feature: User should be able to add a file to favorites, rename any file and give some comments on any file

  Background: User is is on the login page
    Given the user logged in as "user"
    Then they should have access to user-specific features
    Given the user navigates to "Files" module

  @B30G7-154

  Scenario: User can add any file to favorites from its own three dots menu
    When the user clicks on three dots menu of any file
    And the user hovers to and clicks "Add to favourites" option
    And the user navigates to "Favorites" tab
    And the newly added file should be seen in "Favorites" tab folder
    Then the user clicks on three dots menu of the newly added to favorites file
    And the user clicks "Removes from favourites" option


  @B30G7-155
  Scenario: User can rename any file
    When the user clicks on three dots menu of any file
    And the user hovers to and clicks Rename option
    And the user can rename the file
    And the file is renamed successfully
    When the user clicks on three dots menu of any file
    And the user hovers to and clicks Rename option
    Then the user returns the original name to the file
    And the file is renamed back successfully


  @B30G7-156
  Scenario: User can put some comments on any file from the file details menu opened right side
    When the user clicks on three dots menu of any file
    And the user hovers to and clicks Details option
    And the user clicks "Comments" from menu opened right side
    And the user adds comment to the file
    Then the comment is successfully added