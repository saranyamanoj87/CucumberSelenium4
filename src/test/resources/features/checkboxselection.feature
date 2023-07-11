Feature: select against a specific name



  Scenario: Navigate to a Primereact URL, select the checkbox against BlueBand.
    Given I opened primereact website
    When I click on the checkbox against "Blue Band" checkbox
    Then I should see checkbox "Blue Band" get selected successfully
  