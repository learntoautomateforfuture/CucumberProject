Feature: Search functionality in the Application.
#This is how background can be used to eliminate duplicate steps 

Background: 
   Given User navigates to Amazon site

# Scenario 1
@SmokeTest @RegressionTest
Scenario: Search for a Electronic Product

When Search data is entered
And Click on the search button
Then Search result is displayed


