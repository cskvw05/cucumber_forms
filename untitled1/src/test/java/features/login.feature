
Feature: Login functionality for Orange HRM

  @test1
  Scenario: Login and validate the dashboard title
    Given User is on the Orange HRM login page
    When User logs in with username "admin" and password "admin123"
    Then User should see the dashboard title as "OrangeHRM"
