
@tag
Feature: Purchase the order from the e-commerce website
  I want to use this template for my feature file 
  
  Background:
  Given I landed on e-Commerce page

  @Subitorder
  Scenario Outline: Posting test of submitting the order
    Given Logged in with username <name> and password <password>
    When I add product <productname> from cart
    And checkout <productname> and submit the order
    Then "Thankyou for the order." message displayed on confirmation page

    Examples: 
      | name												| password 						| productname	|
      | student@rajeshlearnings.com |	Rajeshlearning@1		|	ZARA COAT 3	|
     
      
      
