@login
Feature: Users should be able to login
#select appropriate tag depending on your scenario implementation (user or employee)

  Background: User is already in the log in page
    Given the user is on the login page

  @login_as_user
  Scenario: Verify login with different user types
  Given the user logged in as "user"


  @login_as_employee
  Scenario: Verify login with different user types
  Given the user logged in as "employee"

