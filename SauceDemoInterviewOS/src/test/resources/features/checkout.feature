@checkout @demo
Feature: Sauce Demo Checkout

  Background:
    #Given navigate to SauceDemo login page
    When enter valid credentials
    And click on login button
    Then verify products title is displayed
    #And quit the browser

  @validPurchase
  Scenario: Checkout Successful
    When I add products to the shopping cart and verify they were added successfully
      | Test.allTheThings() T-Shirt (Red) |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Backpack               |
    And I click checkout
    Then I should be taken to Complete Checkout Page
    And Successful Message Displayed

  @invalidPurchase
  Scenario: Personal Info Error Message
    When I add products to the shopping cart and verify they were added successfully
      | Test.allTheThings() T-Shirt (Red) |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Backpack               |
    And I click checkout
    Then I should be taken to enter personal info
    Then Verify Error Message Displayed