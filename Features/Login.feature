Feature: Login functionality

  @sanity @regression
  Scenario: Successful Login with Valid Credentials
    Given the user navigates to login page
    When user enters email as "Shivangmalik9897@gmail.com" and password as "Qwerty@123"
    And the user clicks on the Login button
    Then the user should be redirected to the Appoverview Page

 
#Feature: Login with invalid credentials
      @regression
      Scenario: Verify login with invalid Credentails
      Given the user navigates to login page
      When user enters email as "shivangmalik9897@gmail.com" and password as "Qerty@123"
      And the user clicks on the Login button
      Then it should display error message