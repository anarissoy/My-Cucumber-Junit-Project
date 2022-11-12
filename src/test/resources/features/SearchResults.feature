@smoke
Feature: As a user, I should be able to login as librarian. When I go to Users


  @top4
  Scenario: Table columns names
    Given I am on the login page
    And I login as a librarian
    And I click on "Users" link
    Then table should have following column names:
      | Actions   |
      | User ID   |
      | Full Name |
      | Email     |
      | Group     |
      | Status    |

#Feature: As a user, I should be able to login as librarian. When I go to Users
#  page, table
#
#  Scenario: Table columns names
#Given I am on the login page
#And I login as a librarian
#And I click on "Users" link
#Then table should have following column names:
#| Actions   |
#| User ID   |
#| Full Name |
#| Email     |
#| Group     |
#| Status    |