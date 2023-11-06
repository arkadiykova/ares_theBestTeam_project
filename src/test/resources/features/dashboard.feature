@hailey @B30G7-117
Feature: Search Functionalities, Dashboard Icons

  Background: User is logged in
    Given user is logged in as a "user"

  @B30G7-117
  Scenario: The user returns to Dashboard with App Icon
    Given the user is on files page
    When the user presses on app icon
    Then the user will be returned to the Dashboard