@AmazonTest

Feature: users could navigate throw website, add item to cart and remove it

  ## Open amazon.com
  Background: guest user open url
    Given guest user navigate Amazon Website
    Then guest user should be in amazon home page

  ## Click on to show all categories
  Scenario: guest user click on hamburger-menu icon
    When guest user click on hamburger-menu icon
    Then Side menu of products opens


 ## From “Shop by Department” Click on "Computers", Then “Computers & Tablets”
  Scenario: guest user navigate to computers And Tablets Page
    Given guest user click on hamburger-menu icon
    When guest user click on Computers tab
    And  guest user click on Computers & Tablets tab
    Then computers And Tablets Page opens


 ## From the “Featured Brands” in the left side filters choose “Samsung Electronics”
  Scenario: guest user filters to Samsung Items
    Given guest user navigate to computers And Tablets Page
    When guest user click on samsung filter
    Then samsung checkbox is checked


 ## Click on any product and add it to the cart
 ##Validate that the product was added successfully to the cart
  Scenario: Add item to the Cart
    Given guest user navigate to computers And Tablets Page
      And guest user click on samsung filter
    When guest user click on product "2" block
      And guest user click on Add to cart button
    Then carts items increases by one

  ## Remove the product from the cart and validate that it was also removed successfully
  Scenario: guest user Remove item from cart
    Given guest user navigate to computers And Tablets Page
     And guest user click on samsung filter
    When guest user click on product "2" block
     And guest user click on Add to cart button
    When guest user navigate to cart
     And guest user Delete added product
    Then check cart items decreased by one
