Feature: login in to the application

#Scenario: positive test validating login
Scenario Outline: positive test validating login

Given Intialize Browser with Chrome
And Navigate to "http://www.qaclickacademy.com/" site
And click on login link on home page to land on sign in page

#When user enters "NonRestrictedUser@abc.com" and "123456" and logs in
When user enters "<username>" and "<password>" and logs in 
Then verify that user is successfully logged in
And close the browser

Examples:
|username	|password	|
|NonRestrictedUser@abc.com	|123456	|
|RestrictedUser@xyz.com	|678910	|