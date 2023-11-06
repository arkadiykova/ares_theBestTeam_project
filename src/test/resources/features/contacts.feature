@arkadii @B30G7-146
Feature: Contact Group Functionality under Contacts module

	Background: User is logged in
		Given user is logged in as a "user"

	@B30G7-144
	Scenario: Contacts module end-to-end. Create group->create contact->add property to the contact.
		Given the user is on the landing page
		    When the user navigates to the Contacts module
		    And the user creates a new group
		    And the user names the new group
		    And the user clicks on New Contact
		    And the user fills out the new contact form
		    And the user adds a new property of anniversary
		    Then the new group is created successfully
		    And the new contact is added to the group
		    And the "Anniversary" property is set for the new contact