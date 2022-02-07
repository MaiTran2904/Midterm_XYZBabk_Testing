Feature: Manage Customer

  Scenario: Add a new customer with valid data 
  	Given user is on manager page
  	And verify manager page
  	When user clicks on Add Customer button
  	And user enters <firstname> and <lastname> and <postcode>
  	And user clicks Add Customer button
  	And user accepts alert
  	Then the message is displayed
  
  Scenario: Cannot add a new customer with invalid data 
  	Given user is on manager page
  	And verify manager page
  	When user clicks on Add Customer button
  	And user enters <firstname> and <lastname>
  	And user clicks Add Customer button
  	Then the message is displayed
  
  Scenario: Successfully opened a new account
  	Given user is on manager page
  	And verify manager page
  	When user clicks Open Account button
  	And user selects <account> and <currency>
  	And user clicks Process button
  	And user accepts alert
  	Then the message is displayed
  
   Scenario: Cannot open an account without choosing an account
  	Given user is on manager page
  	And verify manager page
  	When user clicks Open Account button
  	And user selects <currency>
  	And user clicks Process button
  	Then the message is displayed
  
  
  Scenario: Search an existing Account
    Given user is on manager page
  	And verify manager page
    When user clicks Customer button
    And user searches an existing customer
  	Then the message is displayed

  Scenario: Search non-existing account
    Given user is on manager page
  	And verify manager page
    When user clicks Customer button
    And user searches customer name does not exist
  	Then the message is displayed
