Feature: Search functionality in the Application.

# Scenario 2
@RegressionTest
Scenario Outline: Search a product from a list

Given User navigates to Amazon site
When Search data as "<data>" is entered
And Click on the search button
Then Search result is displayed

Examples:
|data|
|toys|
|mobiles|