@functional
Feature: Login functionality test

  @functional1
  Scenario: Login with valid credentials
    Given I go to automationteststore page
    When I click Login or register
    And I fill out Login Name from customer "John"
    And I fill out Password from customer "John"
    Then I click Login
    And I verify sign in as first name "John"
    Then I logout and verify authentication status

  @functional2
  Scenario: Login with valid existing Login Name and different existing valid Password
    Given I go to automationteststore page
    When I click Login or register
    And I fill out Login Name from customer "John"
    And I fill out Password from customer "Tom"
    Then I click Login
    And I verify alert "Error: Incorrect login or password provided."


  @functional3
  Scenario: Login with invalid Password and valid Login Name
    Given I go to automationteststore page
    When I click Login or register
    And I fill out Login Name from customer "Mia"
    And I fill out Password from customer "Tom"
    Then I click Login
    And I verify alert "Error: Incorrect login or password provided."

  @functional4
  Scenario: Test function "Forgot yor password?"
    Given I go to automationteststore page
    When I click Login or register
    And I click Forgot your password?
    And I fill out Login Name and E-Mail Address "John"
    Then I click reset continue button
    And I verify success alert "Success: Password reset link has been sent to your e-mail address."


  @functional5
  Scenario: Test function "Forgot yor login?"
    Given I go to automationteststore page
    When I click Login or register
    And I click Forgot your login?
    And I fill out Last Name and E-Mail Address "John"
    Then I click reset continue button
    And I verify success alert "Success: Your login name reminder has been sent to your e-mail address."

