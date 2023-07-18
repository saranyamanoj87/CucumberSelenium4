Feature: Fill the form

  Scenario: Fill the form and submit it successfully
    Given I opened website
    When I fill the form with correct details
    Then I should see popup window saying Thanks