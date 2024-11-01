Feature: Testing iFrame and Window Handling

  Scenario: Verify text inside an iframe
    Given I navigate to the iframe page
    When I switch to the iframe
    Then I can see "Your content goes here." inside the iframe

  Scenario: Verify new window handling
    Given I navigate to the multiple windows page
    When I click on "Click Here" link
    Then I switch to the new window
    And I verify the text "New Window" in the new window
    And I close the new window and return to the original window
