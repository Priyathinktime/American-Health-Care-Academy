@GroupUser @fulltest @SingleUser
Feature: Group Registration

  @C_TC_01_Corporate_Registration_with_Valid_Details 
  Scenario: C_TC_01 Corporate Registration with Valid Details
  Given User navigate to "https://staging2-cpraedcourse.gitview.net/groupdiscount" for Group registration 
  When User enters the Corporate registration details:
    | Field         | Value               |
    | First Name    | John                |
    | Last Name     | Doe                 |
    | Company Name  | Thinktime           |
    | Phone Number  | 0987654123          |
    | Email Address | john.doe@example.com|
    | Create Password   | Secure@123      |
    | Confirm Password  | Secure@123      |
   And User clicks on the Register button
   Then User should redirected to the Corporate dashboard page

