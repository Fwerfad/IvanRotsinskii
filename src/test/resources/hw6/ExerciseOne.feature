Feature: Different Element Page test
  In order to check functionality
  As a user
  I click buttons and check logs

  Scenario: Different Element Page test
  Given I open JDI GitHub site
  When I login as user "Roman Iovlev"
    And I click on "Service" button in Header and I click on "Different Elements Page" button in Service dropdown
    And I select checkboxes
      | Water | Wind |
    And I select radio "Selen"
    And I select in dropdown "Yellow"
  Then UserName should be "ROMAN IOVLEV"
    And Title is "Different Elements"
    And There should be 4 rows in logs, each corresponding to one of the previous actions
      | Colors:Yellow | Wind:true | Water:true | metal:Selen |
    And Close the browser