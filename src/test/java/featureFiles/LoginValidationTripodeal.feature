#Author: Sourav Kumar Bal
@tripodeal_login
Feature: To Validate The Login Scenario for tripodeal.com

  Scenario: Valid username and valid password
    Given Login page opened
    When user enters valid email
    And user enters valid password
    And user clicks on Login button
    Then user will be logged in successfully

  Scenario: Valid username and invalid password
    Given Login page opened
    When user enters valid email
    And user enters invalid password
    And user clicks on Login button
    Then invalid credientials error message will be displayed
