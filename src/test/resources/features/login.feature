Feature: Login OrangeRM

  Scenario: Success login with valid credentials
    Given I am on the OrangeHRM login page
    When I enter username "Admin" and password "admin123"
    And I click the login button
    Then I should be redirected to the dashboard

  Scenario: Invalid login with wrong credentials
    Given I am on the OrangeHRM login page
    When I enter username "Admin" and password "wrongpassword"
    And I click the login button
    Then I should see an error message "Invalid credentials"