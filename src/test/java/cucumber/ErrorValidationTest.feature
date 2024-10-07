
@tag
Feature: Error Validation
  I want to use this template for my feature file


  @ErrorValidation
  Scenario Outline: Testing with Wrong credentials
    Given I landed on e-Commerce page
    When Logged in with username <name> and password <password>
    Then "Incorrect email or password." message is displayed

    Examples: 
      | name												| password 						|
      | student@rajeshlearnings.com |	Rajeshlearning		|
