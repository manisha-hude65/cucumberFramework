@All
Feature: Login functionality

Background:
Given user should be on login page
@abc
Scenario: InvalidLoginTC01
When user enters the invalid userid and password and click on login button
Then user should get an error msg "Invalid credentials"
And user can validate logo as well


@abc
Scenario: ValidLoginTC02
When user enters the valid userid and password and click on login button
Then user shold be navigated to home page and can see logout link appear on top right corner
When user click on logout link
Then user should be navigated to login page