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
    

#005
  
  Scenario: Verify that Log in button is visible  
    Given I am on the homepage  
    Then I should see the Login button in the upper right corner
  
  
#006
  
  Scenario: Verify that Pinterest logo is visible  
    Given I am on the homepage   
    Then I should see the Pinterest logo in the upper left corner
    
  
#007
  
  Scenario: Verify that text in the center of the page is visible   
    Given I am on the homepage  
    Then I should see the text in the center of the page

  
#008
  
  Scenario Outline: Verify that all elements are present on homepage when user is logged in   
    Given I am on the homepage  
    When I click on the Log in button  
    And I enter "<email>" in the Email field  
    And I enter "<password>" in the Password field  
    And I click on Log in button  
    Then I should see the all elements
  

    Examples:
      | email                    | password |
      | jjovanovictest@gmail.com | Test123! |

  <br>
