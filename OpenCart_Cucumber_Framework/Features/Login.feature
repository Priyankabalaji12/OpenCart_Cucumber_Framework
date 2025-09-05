Feature: Login with Valid Credentials

  @sanity @regression
  Scenario: Successful Login with Valid Credentials
    Given the user navigates to login page
    When user enters email as "rjpinky@gmail.com" and password as "Priyanka@12"
    And the user clicks on the Login button
    Then the user should be redirected to the MyAccount Page
    
    @regression
  Scenario Outline: Login Data Driven
    Given the user navigates to login page
    When user enters email as "<email>" and password as "<password>"
    And the user clicks on the Login button
    Then the user should be redirected to the MyAccount Page

    Examples: 
      | email                	    | password |
      | rjpinky@gmail.com 	      | Priyanka@12 |
      | pavanoltraining@gmail.com | test@123 |

