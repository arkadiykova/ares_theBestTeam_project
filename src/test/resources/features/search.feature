@hailey @B30G7-117
Feature: Search Functionalities, Dashboard Icons

  Background: User is logged in
    Given user is logged in as a "user"

  @B30G7-117
  Scenario: The user searches for a readMe file
    Given the user is on the dashboard page
    When the user presses on search icon
    And the user types file name in the search box
    Then the user should be redirected to a new page and see the file
    Then the user should see the "Details" of the file