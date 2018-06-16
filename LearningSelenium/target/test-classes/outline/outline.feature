Feature: Login

Background: 
Given user navigates to Facebook

Scenario Outline: 
When I enter Username as "<username>" and Password as "<password>"
Then login should be unsuccessful

 Examples:
    | username | password |
    |  uss     |  pass    |
    |  uss2    |  pass2   |