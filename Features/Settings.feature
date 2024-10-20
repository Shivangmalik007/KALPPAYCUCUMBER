Feature: Verify the settings page feature

  Background: all comman steps
    Given the user navigates to login page
    When user enters email as "Shivangmalik9897@gmail.com" and password as "Qwerty@123"
    And the user clicks on the Login button
    Then the user should be redirected to the Appoverview Page
    
    

  @regression
  Scenario: Verify the add gateway functionality (cashfree)
    And user clicks on registeranapp button
    Then user should redirect to the register an app screen
    When user enter the all valid details
    And user clicks on submit button
    Then application should be added
    And user redirect to the appoverview page
    When user clicks on registered appname from the applist
    Then it should redirects to the application home page
    When user clicks on settings form side menu
    Then it should redirects to the generate api keys section
    When user clicks on paymentgatewaysettings
    Then it should redirects to the add gateway screen
    When user click on add gateway button
    Then it should redirects to the step1 screen
    When user select currency as "Rupeess"
    And user select gateway as "CASHFREE"
    And user enter details in below fileds
      | Client Id     | TEST101174745b697f67b69cc2101fb447471101               |
      | Client Secret | cfsk_ma_test_d6de65fcdabd3fb83f1d658c142c1ffb_bf823b8e |
    And user select payment methods
    And click on submit button
    Then it should redirect to the step 2
    When user enter click on mark as done button
    Then it should redirect to the step 3
    When user click on mark as done button
    Then status of the all three steps should be mark as inverification
@regression
  Scenario: Verify user able to initiate only 1 order after completing 3 steps
    When user clicks on addedapplication appname from the applist
    Then it should redirects to the application home page
    When user clicks on settings form side menu
    Then it should redirects to the generate api keys section
    When user clicks on generate api key button
    Given user navigates to testingwebsite
    When user enter valid details
    And select environment as "QA"
    And clicks on submit button
    Then it should redirect to the product page
    When user select currency "Rupeess"
    When user select the product
    And click on checkout button
    When user select payment method
    And complete the transaction
    Then it should redirect to the transaction status screen

  @regression
  Scenario: Verify user not able to order more than one order with out completing step 4
    When user clicks on addedapplication appname from the applist
    Then it should redirects to the application home page
    When user clicks on settings form side menu
    Then it should redirects to the generate api keys section
    When user clicks on regenerate api key button
    Given user navigates to testingwebsite
    And user enter valid details
    And select environment as "QA"
    And clicks on submit button
    Then it should redirect to the product page
    When user select currency "Rupeess"
    When user select the product
    And click on checkout button
    When user select payment method
    Then it should display error message related to the step4

  @regression
  Scenario: Verify when user complete the step 4
   When user clicks on addedapplication appname from the applist
    Then it should redirects to the application home page
    When user clicks on settings form side menu
    Then it should redirects to the generate api keys section
    When clicks on domain
    And user enter domain "netlify.app"
    And clicks on save button
    When user clicks on paymentgatewaysettings
    And clicks on edit button form cashfree gateway
    Then step4 contains domain as "netlify.app"
    When user clicks on mark as done button
    Then it should redirect to the APIkeyscreen
     When user clicks on paymentgatewaysettings
    And status of the gateway should be verified

  @regression
  Scenario: Verify the status of the transaction from transaction screen
     When user clicks on addedapplication appname from the applist
    Then it should redirects to the application home page
    When user clicks on settings form side menu
    Then it should redirects to the generate api keys section
    When user clicks on regenerate api key button
    Given user navigates to testingwebsite
    When user enter valid details
    And select environment as "QA"
    And clicks on submit button
    Then it should redirect to the product page
    When user select currency "Rupeess"
    When user select the product
    And click on checkout button
    When user select payment method
    And complete the transaction
    Then it should redirect to the transaction status screen
    When user go the transaction screen
    Then it should display the transaction with same status as on transaction screen
@regression
Scenario: Verify when user interact with invalid domain 
When user clicks on addedapplication appname from the applist
    Then it should redirects to the application home page
    When user clicks on settings form side menu
    Then it should redirects to the generate api keys section
     When clicks on domain
     And click on edit button form domain
     And user enter domain "google.app"
    And clicks on save button
    And clicks on generate api section
    When user clicks on regenerate api key button
    Given user navigates to testingwebsite
    When user enter valid details
    And select environment as "QA"
    And clicks on submit button
    Then it should redirect to the product page
    When user select currency "Rupeess"
    When user select the product
    And click on checkout button
    When user select payment method
    Then it should display error message realted to the invalid domain 