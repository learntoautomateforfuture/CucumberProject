Feature: Create Account Functionality.
#This is how background can be used to eliminate duplicate steps 

Background: 
   Given User navigates to Amazon site
   
# Scenario 1
@NegativeTest
Scenario: Create a account with invalid data

When SignIn is clicked
Then Click on create your amazon account
And Enter the invalid details and continue
| Fields                 | Values              |
| YourName	             | Tom                 |
| PhoneNumber            | 123456789           |
| Email Address          | someone@someone.com |
| Password               | Password1           |
Then Error message should be displayed