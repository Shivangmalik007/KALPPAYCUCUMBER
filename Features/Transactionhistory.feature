Feature: Verify the transaction history feature
 Background: all comman steps
    Given the user navigates to login page
    When user enters email as "Shivangmalik9897@gmail.com" and password as "Qwerty@123"
    And the user clicks on the Login button
    Then the user should be redirected to the Appoverview Page
    When user clicks on DEMO from the applist
    Then it should redirects to the application home page
    @regression
   Scenario: Verify the transaction status filter
    When user clicks on transaction from side menu
    And select transaction filter as "Success"
    Then it should display "SUCCESS" transactions only
    @regression
    Scenario: Verify the transaction table
    When user clicks on transaction from side menu
    Then it should display transaction table and contain below fileds
    |Transaction ID|
    |Creation Date|
    |Last Update|
    |Payment Mode|
    |Payment Gateway|
    |Currency|
    |Amount|
    |Status|