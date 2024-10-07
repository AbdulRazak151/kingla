
@tag
Feature: Title of your feature
  I want to use this template for my feature file



  @ErrorValidation
  Scenario Outline: Title of your scenario outline
 		Given I landed on Ecommerce Page
    When Loginned in with username <name> and password <password>
    Then "Incorrect email or password." message is displayed

    Examples: 
      | name  						     | password   |
      | abdulrazak@yopmail.com | Abdul@12 |
