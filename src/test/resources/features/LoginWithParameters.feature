@smoke
Feature: Login with parameters

@lib11
  Scenario: Login as librarian 11
    Given I am on the login page
    When I enter username "librarian11@library"
    And I enter password "fsRRgXxB"
    And click the sign in button
    Then dashboard should be displayed

@lib12
  Scenario: Login as librarian 12
    Given I am on the login page
    When I enter username "librarian12@library"
    And I enter password "wHhJQDSK"
    And click the sign in button
    Then dashboard should be displayed
    And there should be 1366 users
  #number can be whatever you have there

  @lib13
  Scenario: Login as librarian same line
    Given I am on the login page
    When User login using "librarian1@library" and "qU9mrvur"
    Then dashboard should be displayed
    And there should be 1366 users
 #number can be whatever you have there