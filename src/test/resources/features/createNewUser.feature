Feature: Librarian should be able to create new user

  Scenario: Librarian create new user
    Given click "Users" and "Add User" buttons
    When enter valid information
    Then "The user has been creates." message should show up

  Scenario Outline: Add user should have specific parameters
    Given click "Users" and "Add User" buttons
    Then add user should have these <parameters>
    And full Name can be up to 64 characters long
    And full Name filed accepts only letter, dash, space, apostrophe
    Examples:
      | parameters |
      | Full Name  |
      | Password   |
      | Email      |
      | User Group |
      | Status     |
      | Start Date |
      | End Date   |
      | Address    |


  Scenario Outline: User Group should have 2 user types as Librarian and Students
    Given click "Users" and "Add User" buttons
    Then user group should have <types>
    Examples:
      | types     |
      | Librarian |
      | Students  |

  Scenario Outline: Status should have ACTIVE and INACTIVE
    Given click "Users" and "Add User" buttons
    Then status should have <choice>
    Examples:
      | choice   |
      | ACTIVE   |
      | INACTIVE |