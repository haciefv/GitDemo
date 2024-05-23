@tag
Feature: Purchase the order from Ecommerce Website

  Description of the feature goes here.
  Background:
    Given I landed on Ecommerce page

  Scenario Outline: Positive test of Submitting the order
    Given Logged in with username <name>and password  <password>
    When I add <productName> to Cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is diplayed on Confirmation page
    Examples:
      | name               | password | productName |
      | haciefv@gmail.com" | Haci9509 | ZARA COAT 3 |


  Scenario: [Another Scenario Name]
    Given [Precondition or initial context]
    When [Action taken by the user]
    Then [Expected outcome or result]


