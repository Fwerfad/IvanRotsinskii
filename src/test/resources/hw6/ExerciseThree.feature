Feature: Vip checkbox test
  In order to check functionality
  As a user
  I click buttons and check log
  Scenario: Vip checkbox Test
    Given I open JDI GitHub site
    And I login as user "Roman Iovlev"
    And I click on Service button in Header
    And I click on User Table button in Service dropdown
    When I select 'vip' checkbox for "Sergey Ivan"
    Then 1 log row has "Vip: condition changed to true" text in log section