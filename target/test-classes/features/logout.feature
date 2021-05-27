@logout
Feature: User should be able to Log out
  Background:
    Given the user is on the dashboard page
  Scenario: Verify that the log out button is located under username dropdown
    When user navigates to the top corner of the page
    And clicks on the user name item
    And the logout button should be clickable
    And user clicks the button
    Then user should be in the login page