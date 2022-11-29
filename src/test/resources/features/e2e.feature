@e2e
  Feature: End to end test

    @e2e1
    Scenario:   Login, add products to cart and logout
      Given I go to automationteststore page
      When I log in as "John"
      Then I verify sign in as first name "John"
      And I go to Manage Address Book and delete previous entries
      And I remove all items from shopping cart
      Given I mouse over "Makeup" and click to "Nails" and verify subProduct name
      When I click to "Fluid shine nail polish" product and put Qty 4
      Then I verify "Fluid shine nail polish" in product details and click Add to cart
      And I verify "Fluid shine nail polish" as product name display in cart
      Then I click to continue shopping
      Given I mouse over "Fragrance" and click to "Women" and verify subProduct name
      When I click to "Obsession Night Perfume" product and put Qty 2
      Then I verify "Obsession Night Perfume" in product details and click Add to cart
      And I verify "Obsession Night Perfume" as product name display in cart
      Then I click to continue shopping
      Given I mouse over "Apparel & accessories" and click to "Shoes" and verify subProduct name
      When I click to "Ruby Shoo Womens Jada T-Bar" product and put size "UK 6 "
      Then I verify "Ruby Shoo Womens Jada T-Bar" in product details and click Add to cart
      And I verify "Ruby Shoo Womens Jada T-Bar" as product name display in cart
      And I remove "Fluid shine nail polish" from shopping cart
      When I verify percent of taxes for "John" and click checkout
      And I verify Shipping and Payment belongs to "John" and click to Edit Shipping
      Given I click button Change Address
      When I set "Mia" shipping address and click continue
      And I verify Shipping belongs to "Mia" and click to Confirm Order
      And I verify checkout success and click continue
      Then I logout and verify authentication status

