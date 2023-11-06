@DeckFunctionality
Feature: DECK MODULE FUNCTIONALITY
	Background: User is logged in
	Given user is logged in as a "user"
	Then user navigates to Deck module

	@B30G7-123
	Scenario: Verify user can create new board
		Given user clicks on Deck module
		And clicks on burgerMenu
		When user clicks on Add board plus sign
		Then user types board name in the input box and clicks Enter key on the keyboard
		And user sees the newly created board on the left side under ALl Boards



	@B30G7-124
	Scenario: Verify user can create new list of card/task under any board
		Given user clicks on Deck module
		When user clicks on newly created board name
		And user clicks on Add List plus button on top right
		And user types new list name in the input box and clicks Enter key on the keyboard
		Then user sees the newly created list inside the board



	@B30G7-126
	Scenario: verify user can add a new card/task on any list on the current board
		Given user is inside the board
		When user clicks on Add Card plus button
		And user types new card name and clicks on Enter key on the keyboard
		Then user sees the newly created card inside the list


	@B30G7-128
	Scenario: Verify user can assign any card/task to himself/herself by using the three dots on the related card
		Given user is inside the board
		Given user clicks on three dots cards’ drop down menu on the card
		Then user clicks on Assign to me option
		And user should see his or her profile icon on the card
