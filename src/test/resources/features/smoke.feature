@smoke
  Feature: Smoke test

    @smoke1
    Scenario: Login, add product in shopping cart and logout
      Given I go to automationteststore page
      When I log in as "John"
      Then I verify sign in as first name "John"
      And I remove all items from shopping cart
      Given  I click to FRAGRANCE menu button
      When  I verify FRAGRANCE subproduct page open and I click Women category
      And I verify WOMEN category page open and I click Beauty Eau de Parfum product
      And I verify Beauty Eau de Parfum in product details and I click Add to cart
      Then I verify Beauty Eau de Parfum in table and I click Checkout
      When I verify ORDER SUMMARY contains Beauty Eau de Parfum and click to confirm order
      And I verify checkout success and click continue
      Then I logout and verify authentication status

