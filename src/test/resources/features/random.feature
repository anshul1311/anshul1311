Feature: Test register user

  Background: : Create Random User
    Given Random user api
    When This api is hit
    Then A random user is generated

  @happily
  Scenario: Register the user on website and Place order
    Given url for registration
    And user clicks on register button
    When user fills firstname as "firstname" and lastname as "lastname" and email as "email" in registration details
    And user should be able to register
    When searching the product
    And add the product to cart
    And filling all the address details
    Then user should be able to place the order
    And success screen should be displayed

  @Negative
  Scenario: : User already exists
    Given url for registration
    And user clicks on register button
    When user fills firstname as "Eva" and lastname as "Shelton" and email as "eva.shelton@example.com" in registration details
    Then user already exists message is shown
