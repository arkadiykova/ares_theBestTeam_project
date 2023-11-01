@B30G7-129
Feature: Default

	
	@B30G7-124
	Scenario: Verify user can create new list of card/task under any board
		Given user is on deck module
			When user clicks on newly created board name
			And user is prompted to enter new list name
			When user types new list task name and clicks Enter key on the keyboard
			Then user sees the newly created list inside the board	

	
	@B30G7-125
	Scenario: Verify user can create new list of card/task under any board
		Given user is inside the boards
			When user clicks on plus button on top right corner 
			Then user is prompted to enter new list name
			And user types new list  name and clicks Enter key on the keyboard
			Then user sees the newly created list inside the board	

	
	@B30G7-126
	Scenario: verify user can add a new card/task on any list on the current board
		Given user is inside the board
			When user clicks on plus button
			And user is prompted to enter new card name
			When user types new card name and clicks on Enter key on the keyboard
			Then user sees the newly created card inside the list	

	
	@B30G7-128
	Scenario: Verify user can assign any card_task to himself/herself by using the three dots on the related card
		Given user is inside the lists
		When user clicks on three dots cards’ drop down menu 
		Then user clicks on Assign to me option
		And user sees his or her username on the related card