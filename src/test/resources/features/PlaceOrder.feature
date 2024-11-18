Feature: Place Order


Background: User Login
    Given User is on login page 
    When User enters "standard_user", "secret_sauce"
    Then User should be on Home page

Scenario: Selenium SearchAdd item to cart
    Given User should be on Home page 
    When user add item to cart
    Then Item must be added

Scenario: Checkout order
    Given User is on cart page 
    When User do Checkout
    Then Should navigate to checkout page