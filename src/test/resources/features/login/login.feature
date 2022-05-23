Feature: Login
  Background:
    Given user is on login page

  Scenario Outline: Proper login credential
    When user logins with "<email>" and "<password>" as credentials
    Then user is on profiles page
    Examples:
      | email             | password |
      | susu9@yopmail.com | 123123   |

  Scenario Outline: Wrong login credential
    When user logins with "<email>" and "<password>" as credentials
    Then user see error message
    Examples:
      | email             | password |
      | susu9@yopmail.com | 111111   |