Feature: Appoverview page

  Background: all comman steps
    Given the user navigates to login page
    When user enters email as "Shivangmalik9897@gmail.com" and password as "Qwerty@123"
    And the user clicks on the Login button
    Then the user should be redirected to the Appoverview Page

  @regression
  Scenario: Verify app registration with valid detail
    And user clicks on registeranapp button
    Then user should redirect to the register an app screen
    When user enter the all valid details
    And user clicks on submit button
    Then application should be added
    And user redirect to the appoverview page

  @regression
  Scenario: Verify app registration with invalid detail
    And user clicks on registeranapp button
    Then user should redirect to the register an app screen
    When user enter the invalid details
    Then it should display inline error

 @regression
  Scenario: Verify appoverview page contain the table of registered app
    Then user should able to see the app table
   And table should contain the below fields
      | App ID   |
      | App Name |
      | Email    |
      | Country  |

  @sanity
  Scenario: Verify the pagination functionaltiy
    When user clicks on next page number
    Then it should redirects to the next page
@regression
Scenario: Verify the serach  functionality
When user enter appname as "DEMO" in serach bar
Then it should display the data of "DEMO" app
@regression
Scenario: Verify the app disabled/enable button
When user clicks on toggle button form app list
Then it should display alert realted to disable an app
When user clicks on disable button form alert
Then it should display app disable message
And app should be disabled 
When user clicks on toggle button form app list
Then it should display app enable message
And app should be enabled 
@regression
Scenario: Verify the app disable functionality
#When user clicks on toggle button form app list
#And user clicks on disable button form alert
#Then app should be disabled 
#When user clicks on edit button 
#Then it should be disabled
#When user clicks on app name
#Then user should not redirect to the app home page
@regression
Scenario: Verify the app redirection
When user clicks on appname from the applist
Then it should redirects to the application home page