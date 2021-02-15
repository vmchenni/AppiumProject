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
          Then User click on cart icon
          Then long press on terms and condition
          Then Click on close button of terms and condition
          And tap on visit website
          And verify edit box on webview
