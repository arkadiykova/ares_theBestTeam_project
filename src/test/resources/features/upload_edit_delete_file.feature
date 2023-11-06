@B30G7-110
Feature: Upload/Edit/Delete file module functionality

  US: As a user, I should be able to upload a file, move or delete any selected file under the Files module

Background: User is already logged in to account
  Given user is logged in as a "user"
  And the user navigates to "Files" module

Scenario: User can upload a file
  When user clicks Add new button
  And user clicks Upload file button and upload any file
  Then user should see new uploaded file

Scenario: User can create a new folder
  When user clicks Add new button
  And user clicks New folder button
  And user enters "ABC" as name of the folder
  Then user should see new created folder "ABC"

Scenario: User can delete any selected item from it's three dots menu
  When user clicks three dote menu of any file
  Then user should be able to click Delete file or folder button

Scenario: User can see the total number of files and folders under the files list table
  Then user should see the total number of files and folders