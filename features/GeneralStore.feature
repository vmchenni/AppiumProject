@GeneralStore
  Feature: General Store
    Scenario: General store testing
      Given user launches general store app
      Given User Selects "Bolivia" from dropdown

#      And Verify the toast message
      Then Enter your name as "Vish"
      Then Select Female Radio button
      Then User click on Lets shop button
      And Scroll tll "Air Jordan 9 Retro" is displayed
      Then Click on add to cart button for "Air Jordan 9 Retro"