#Author: Sourav Kumar Bal
@accountoverview
Feature: To validate accounts overview functionality

  Scenario: Validation of overview page navigation
    Given User is logged in with correct userid and password
    When User click on acconts overview button
    Then Overview Page should open 
