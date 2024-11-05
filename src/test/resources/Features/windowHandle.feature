Feature: Testing window handling

  Scenario: Verify the entry of first name, last name
    Given I navigate to the main page
    When I click on "Start Trail" button
    And I navigated to another window
     Then I can enter "John" and "Sammuel"
    And navigate back to main page
     