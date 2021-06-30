<h2>Java/Selenium/Cucumber</h2>
<br>

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
    
  
  <br>
  <br>
  
<b>TEST CASES</b>

- <i>[Pinterest] - Login with valid credentials	</i>

1) Navigate to "https://www.pinterest.com/"
2) Click on the "Log in" button
3) In the "Email" field enter "jjovanovictest@gmail.com"
4) In the "Password" field enter "Test123!"
5) Click on the "Log in" button

Expected result: User is logged in and he is redirected to homepage.
