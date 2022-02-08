Feature: BBNow Order Priority to binning flow in UAT
  Scenario: BBNow Order Placement to Binning flow using rest assured api automation
    Given I do all prerequisites setup in "UAT" env
    Then I make order id "1001089571" top priority
    Then I do job assignment
    Then I do bag linking
    Then I do task completion
    Then I do pick completion
    Then I check for available bin location and bin the order