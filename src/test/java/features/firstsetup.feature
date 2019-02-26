Feature: Setup the GnuCash App
  Scenario: Setup the GnuCash App with new account
    euro
    Given I launch the GnuCash App for the first time
    And I am in the configurator
    When I dismiss the welcome screen
    And I select eur as currency
    And I select default accounts
    And I disable the crash reports
    And I agree with the review
    Then I see the news popup
    And I end up in the accounts page
