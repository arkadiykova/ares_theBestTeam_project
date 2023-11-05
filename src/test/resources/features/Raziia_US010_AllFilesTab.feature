@B30G7-137
Feature: Default
	Background:


		Given  user enter valid username and password
		And user click to login button
		Then user should be directed to home page
		When User click Files button
		Then User see  title is Files - Symund - QA





	@B30G7-127
	Scenario: Verify that user can change folder view order by Name
		Given  User click Names  arrow button
		Then User can see all Files sorted by name in alphabetical order

	
	@B30G7-134
	Scenario: Verify that user can change folder view order by Size
		Given  User click Size  button
		Then User can see the list of Files sorted in order by size

	
	@B30G7-135
	Scenario: Verify that user can change folder view order by Modified date
		Given User click Modified arrow button
		Then User can see the list of Files sorted in order based on Modified dates

	
	@B30G7-136
	Scenario: Verify that User can select all the files at once and see the total values of all files in the first line when clicked on the “select all” checkbox at the left top corner of the list
		Given User click on Select all checkbox button
		And User can see that all checkboxses checked
		Then User should see total value of folders and files