Feature: Admin Functionality
  Scenario: Add a new user in Admin section
    Given I am on the OrangeHRM login page
    When I enter username "Admin" and password "admin123"
    And I click the login button
    Then I should be redirected to the dashboard
    When I click the Admin side menu
    And I click the Add button
    And I click field dropdown user role and status
    And I enter fullname "Peter Mac", username "peterMac", password "password123", and confirm password "password123"
    And I click the Save button
    Then I should see the new user "peterMac" in the user list
#    And I click field dropdown status
#    And I enter first name ~John", last name "Doe", username "johndoe", and password "password123"
#    And I click the Save button
#    Then I should see the new user "johndoe" in the usemr list