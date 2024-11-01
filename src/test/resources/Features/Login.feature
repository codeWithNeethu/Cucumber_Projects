



Feature: feature to test login functionality
  
  Scenario: Check login is successful with valid credentials
    Given user is in login page
    When user enters <username> and <password>
    And clicks on Login button
    Then user is navigated to the home page

    
    #Examples:
    #| username | password|
    #| user1 | pass1 |
    #| user2 | pass2 |
    #
    