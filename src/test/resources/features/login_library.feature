@top @smoke
Feature: Library app login feature
  User Story:
  As a user, I should be able to login with correct
  credentials to different accounts

#  Background: Assuming user is on the login page


  @librarian @employee @lib
  Scenario: Login as librarian
    Given user is on the library login page
    When user enters librarian username
    And user enters librarian password
    Then user should see the dashboard

  @student @st
  Scenario: Login as student
    Given user is on the library login page
    When user enters student username
    And user enters student password
    Then books should be displayed