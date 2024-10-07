
@tag1
Feature: Purchase the order from Ecommerce Website
  
Background: 
Given I landed on Ecommerce Page


  @Regression
  Scenario Outline: Positive Test of sumbiting order
    Given Loginned in with username <name> and password <password>
		When i add product <productName> to Cart
    And Checkout <productName> and submit the order
    Then "Thankyou for the order." message is displayed on Confirmation Page 
   
 Examples: 
      | name  						| password   | productName |
      | abdulrazak@yopmail.com | Abdul@1234 | ZARA COAT 3 |
     
