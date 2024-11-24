Feature: Logout functionality for Orange HRM

  @test2
  Scenario: Logout from the application
    Given User is logged into the Orange HRM application with username "admin" and password "admin123"
    When User logs out
    Then User should be redirected to the login page
