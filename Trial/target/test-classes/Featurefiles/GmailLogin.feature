Feature: To check login with invalid details

@testGmail
Scenario: validating email on signin page
Given I am on Gmail signin page
When I enter invalid email
And click on Next button
Then I get an error message