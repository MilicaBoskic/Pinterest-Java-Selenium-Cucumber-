Feature: Login

#001
  Scenario Outline: Validate Login
    Given I am on the homepage
    When I click on the Log in button
    And I enter "<email>" in the Email field
    And I enter "<password>" in the Password field
    And I click on Log in button
    Then I should see the "<result>"

    Examples:
      | email                    | password | result                      |
      | jjovanovictest@gmail.com | Test123! | https://www.pinterest.com/  |


#004
  Scenario: Verify that site name is visible
    Given I am on the homepage
    Then I should see the site name

#006
  Scenario: Verify that Pinterest logo is visible
    Given I am on the homepage
    Then I should see the Pinterest logo in the upper left corner
