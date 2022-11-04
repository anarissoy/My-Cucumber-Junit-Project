Feature:

  @adidas
  Scenario:
    Given user is on the main page
    When user select Sony vaio i5 from laptop category, add to cart and accept pop up confirmation
    And user return to main page, select Dell i7 8gb from laptop category, add to cart and accept pop up confirmation
    And user delete Dell i7 8gb from cart
    And user click on Place order
    And user fill in all web form fields and click on Purchase
    And user capture and log purchase Id and Amount
    And Assert purchase amount equals expected
    Then user click on Ok


    #You have to implement the following Web automated checks over our DEMO ONLINE
    #SHOP: https://www.demoblaze.com/index.html
    #• Customer navigation through product categories: Phones, Laptops and Monitors
    #• Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.
    #• Navigate to "Laptop" → "Dell i7 8gb" and click on "Add to cart". Accept pop up confirmation.
    #• Navigate to "Cart" → Delete "Dell i7 8gb" from cart.
    #• Click on "Place order".
    #• Fill in all web form fields.
    #• Click on "Purchase"
    #• Capture and log purchase Id and Amount. user click on Ok
    #• Assert purchase amount equals expected.
    #• Click on "Ok"