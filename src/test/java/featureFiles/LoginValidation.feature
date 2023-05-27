#Author:Sourav Kumar Bal
@login
Feature: To Validate The Login Scenario

  Scenario: Valid username and valid password
    Given Login page is opened
    When I enter valid username
    And I enter valid password
    And I click on signin button
    Then Login should be successful
 
