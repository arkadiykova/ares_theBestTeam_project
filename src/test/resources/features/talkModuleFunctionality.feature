Feature: Talk Module Functionality

  User Story :
  As a user, I should be able to create a new conversation, add participant, start and leave call under the Talk module


  Background: user is already logged in
    Given the user logged in as "user"
    And user navigates to “Talk” module

  @mark
  Scenario: Create a new conversation
    Given user clicks a plus button
    And user enters name for the conversation
    And user enables Allow guests join via link
    And user clicks Add participants button
    And user selects A person
    And user clicks a create conversation button
    When user clicks close button
    Then user can see newly created conversation in the list