Feature: Setup Wizard in the GnuCash App
  Scenario: Setup the GnuCash App with new default accounts with euro currency and not send crash reports
    Given I launch the GnuCash App for the first time
    And I am in the configurator
    When I dismiss the welcome screen
    And I select eur as currency
    And I select default accounts
    And I disable the crash reports
    And I agree with the review
    Then I see the news popup
    And I end up in the accounts page

  Scenario: Setup the GnuCash App with no account with other currency and sending crash reports
    Given I launch the GnuCash App for the first time
    And I am in the configurator
    When I dismiss the welcome screen
    And I select other as currency
    And I select BEF
    And I select no accounts
    And I enable the crash reports sending
    And I agree with the review
    Then I see the news popup
    And I end up in the empty account page