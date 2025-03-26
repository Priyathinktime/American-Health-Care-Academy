   @fulltest
Feature: User Login

Background: Navigate to Login Page
  Given User navigates to the login page "https://app.cpraedcourse.com/user/login?version=v2"


 @SU_TC07_Login_with_InValid_Username_valid_Password
Scenario: TC_07 Login with Invalid Username valid  Password
  Given User is on the login page
  When User enters invalid login credentials:
    | Field    | Value              |
    | Username | JohnDoeShank       |
    | Password | 123456             |
  And User clicks on the Login button
  Then User should see an error message "The Username/Password combination doesn't match. Please try again."
  

