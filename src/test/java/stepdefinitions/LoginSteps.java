package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Hook;
import org.junit.Assert;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginSteps {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Given("I am on the OrangeHRM login page")
    public void i_am_on_the_orange_hrm_login_page() {
        loginPage = new LoginPage(Hooks.driver);
        Hooks.driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password){
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("I click the login button")
    public void i_click_the_login_button(){
        loginPage.clickLoginButton();
    }

    @Then("I should be redirected to the dashboard")
    public void i_should_be_redirected_to_the_dashboard(){
        dashboardPage = new DashboardPage(Hooks.driver);
        String actualHeaderText = dashboardPage.getDashboardHeaderText();
        String expectedHeaderText = "Dashboard";
        Assert.assertEquals("Dashboard header text is not as expected", expectedHeaderText, actualHeaderText);
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String expectedErrorMessage) {
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals("Error message is not as expected", expectedErrorMessage, actualErrorMessage);
    }
}
