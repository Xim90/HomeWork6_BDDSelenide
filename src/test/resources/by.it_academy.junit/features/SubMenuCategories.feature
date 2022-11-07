Feature: As a user
  I want to get ability to use menu categories
  So that i can

  Scenario:Submenu should contain division by prices, cities and brands
    Given the user opens Onliner website
    When the user hover on the 'Автобарахолка' section
    Then submenu is displayed and I see division by prices, cities and brands

  Scenario: Submenu should contain division by prices, cities and number of rooms
    Given  the user opens Onliner website
    When the user hover on the 'Дома и квартиры' section
    Then submenu is displayed and I see division by prices, cities and number of rooms