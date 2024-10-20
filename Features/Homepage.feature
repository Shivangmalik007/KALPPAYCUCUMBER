Feature: Home page
Background: all comman steps
    Given the user navigates to login page
    When user enters email as "Shivangmalik9897@gmail.com" and password as "Qwerty@123"
    And the user clicks on the Login button
    Then the user should be redirected to the Appoverview Page
    When user clicks on DEMO from the applist
    Then it should redirects to the application home page
    @regression
    Scenario: Verify home page contain the cards 
    Then home page contain the below cards
    |No of Transactions|
    |Todays no of transactions|
    |Payment Status|
    @regression
    Scenario: Verify the switch between per payment mode vs per payment gateway
    Then by default graph is on per payment gateway
    When user clicks on per payment mode
    Then it should change to per payment mode
  @regression
  Scenario: Verify the date filter functionality
  When user select start date as "16/09/2024" and end date as "07/10/2024" 
  And clicks on done button
  Then it should display data according to "16/09/2024 - 07/10/2024"
  @regression
  Scenario: Verify the days filter functionality
  When user clicks on days filter
  Then it should display dropdown contain below fields
  |Past 7 Days|
  |Past 30 Days|
  |Past 90 Days|
  When user click on any days filter
  Then it should display data according to the days
  @sanity 
  Scenario: Verify when user clear the date filter 
  When user select start date as "16/09/2024" and end date as "07/10/2024"
  And clicks on done button
  And clicks on clear button
  Then date filter should be removed
  And it should display by default data of past7days  