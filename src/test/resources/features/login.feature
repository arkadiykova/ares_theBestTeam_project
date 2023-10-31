@login
Feature: Users should be able to login
#select appropriate tag depending on your scenario implementation (user or employee)

  Background: User is already in the log in page
    Given the user is on the login page

  @login_as_user
  Scenario: Verify login as a regular user
  Given the user logged in as "user"
  Then they should have access to user-specific features


  @login_as_employee
  Scenario: Verify login with different user types
  Given the user logged in as "employee"
  Then they should have access to employee-specific features

   #Given: the user loged in username as "username1" and password as "password"