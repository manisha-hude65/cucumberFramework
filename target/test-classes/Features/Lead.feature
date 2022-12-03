@All
Feature: Lead functionality

Background:
Given user should be on login page
When user enters the valid userid and password and click on login button
Then user shold be navigated to home page and can see logout link appear on top right corner

@lead
Scenario: CreateandVerifyLeadwithMandatoryFields_TC03
When user clicks on new lead link
And user enters the all mandatory fields and click on save button
Then lead should be created successfully
