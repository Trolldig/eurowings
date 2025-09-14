Feature: Eurowings - Login

  Background:
    Given I access the homepage
    And I accept cookies

  @main
  Scenario: Validate Successful Login
    When I click on the profile icon
    And I enter a username
    And I enter a password
    And I click the login button
    And I click on the profile icon
    Then I should be presented with the flyout meta navigation