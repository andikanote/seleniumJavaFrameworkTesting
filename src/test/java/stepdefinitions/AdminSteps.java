package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.messages.types.Hook;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AdminPage;
import pages.DashboardPage;

import java.time.Duration;

public class AdminSteps {

    DashboardPage dashboardPage;
    AdminPage adminPage;

    @When("I click the Admin side menu")
    public void i_click_the_admin_side_menu() {
        dashboardPage = new DashboardPage(Hooks.driver);
        dashboardPage.clickAdminMenu();
    }

    @And("I click the Add button")
    public void i_click_the_add_button() {
        adminPage = new AdminPage(Hooks.driver);
        adminPage.clickAddButton();
    }

    @And("I click field dropdown user role and status")
    public void i_click_field_dropdown_user_role(){
        adminPage = new AdminPage(Hooks.driver);
        adminPage.clickFieldUserRole();
        adminPage.clickListDropdownAdmin();
        adminPage.clickFieldStatus();
        adminPage.clickListDropdownEnabled();
    }

    @And("I enter fullname {string}, username {string}, password {string}, and confirm password {string}")
    public void i_enter_fullname_username_password_and_confirm_password(String fullName, String username, String password, String ConfirmPassword) {
        adminPage.enteredFullName(fullName);
        adminPage.clickListFullName();
        adminPage.enterUsername(username);
        adminPage.enterPassword(password);
        adminPage.enterConfirmPassword(ConfirmPassword);
    }

    @And("I click the Save button")
    public void i_click_the_save_button() {
        adminPage.clickSaveButton();
    }

    @Then("I should see the new user {string} in the user list")
    public void i_should_see_the_new_user_in_the_user_list(String username) {
        boolean isUserFound = adminPage.isUserInList(username);
        Assert.assertTrue("New user is not found in the list", isUserFound);
    }
}