@GoogleSearch @UI
Feature: Google Search

  As a user of the google website
  I want to be able to search anything on it
  So that I can access relevant information

  Background:
    Given I am on the google search page


  Scenario Outline: google search using keywords
    Given I have entered valid "<kewords>"
    When I click google search button
    Then I should see an search results appeared indicating "<kewords>" in it

    Examples:
      | kewords            |
      | Automation Testing |
