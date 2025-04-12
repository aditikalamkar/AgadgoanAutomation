@E-Cart @UI
Feature: ECart Functionality for OpenCart E-commerce Website

  As a user of the OpenCart website
  I want to be able to log add item in cart
  So that I can order item after payment

  Background:
    Given I am on the OpenCart login page


   Scenario Outline:: Successful login with valid credentials
    Given I have entered a valid username and password
    When I click on the login button
    Then I should be logged in successfully
    When I search a product "<productName>"
    Then product should be available
    And I should allow to add it in cart
    Then Item should be added into cart
     Examples:
      | productName          |
      | HTC Touch HD | 
  
    