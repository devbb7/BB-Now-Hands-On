Feature: BBNow Order Placement to Binning flow using rest assured api automation
  Scenario: BBNow Order Placement to Binning flow using rest assured api automation
    Given I do all prerequisites setup in "QAS" env
    Then I add items to cart
    Then I create PO order
    Then I create order
    Then I do payment success
    Then I make order top priority
    Then I do job assignment
    Then I do bag linking
    Then I do task completion
    Then I do pick completion
    Then I check for available bin location and bin the order
