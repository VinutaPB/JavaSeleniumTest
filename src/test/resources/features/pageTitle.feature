Feature: Verify Page Title

  Scenario: Open Google and verify title
    Given I open the browser
    When I navigate to "https://www.google.com"
    Then the page title should be "Voogle"
