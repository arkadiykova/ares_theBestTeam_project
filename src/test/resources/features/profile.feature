@B30G7-148 @arkadii2
Feature: As a user I should be able to check or change profile info

	
		Background:Users with "user" and "employee" roles are logged in
		  Given user or employee logs in as "user300"
		    

	@B30G7-150
		Scenario: Test Case 1 - Verify Full Name and Username Synchronization
		    When the user navigates to the Profile module
		    And changes the full name
		    Then the full name and username should be synchronized	


	@B30G7-151
		Scenario: Test Case 2 - Update Email
		    When the user navigates to the Profile module
		    And updates the email address
		    Then the email address should be updated	


	@B30G7-152
		Scenario: Test Case 3 - Change Language
		    When the user navigates to the Profile module
		    And changes the preferred language
		    Then the language should be updated	


	@B30G7-153
		Scenario: Test Case 4 - Check Persistent Data
		    When the user logs out and logs in again
		    And goes to the Profile module
		    Then the profile information should persist across sessions



