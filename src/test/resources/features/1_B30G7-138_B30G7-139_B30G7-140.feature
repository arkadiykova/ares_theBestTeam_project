@B30G7-137
Feature: Default
	Background:


	Given  user enter valid username and password
	And user click to login button
	Then user should be directed to home page





	@B30G7-127
	Scenario: Verify that user can change folder view order by Name
		Given User click Files button
		When  User see  title is Files - Symund - QA
		Then User click Names  arrow button
		Then User can see all Files sorted by name in alphabetical order
		#Then User click Names  arrow button

	
	@B30G7-134
	Scenario: Verify that user can change folder view order by Size
		Given User is on qa.symund.com home page
		When User see  title is Files - Symund - QA
		Then User click Size arrow button
		Then User can see the list of Files in order by size	

	
	@B30G7-135
	Scenario: Verify that user can change folder view order by Modified date
		Given User is on qa.symund.com home page
		When User click Files button
		And User see  title is Files - Symund - QA
		Then User click Modified arrow button
		Then User can see the list of Files in order based on Modified dates	

	
	@B30G7-136
	Scenario: Verify that User can select all the files at once and see the total values of all files in the first line when clicked on the “select all” checkbox at the left top corner of the list
		Given User is on qa.symund.com home page
		When User see  title is Files - Symund - QA
		When User click on Select all checkbox button
		And User can see that all checkboxses checked
		Then User should see total value of folders and files