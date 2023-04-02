package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DashboardPage;
import pages.Vy_Track_Login_Page;
import utilities.Driver;

public class vy_Track_Login_Steps {

    Vy_Track_Login_Page loginPage = new Vy_Track_Login_Page();
    DashboardPage dashboardPage = new DashboardPage();


    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get("https://qa1.vytrack.com/user/login");
    }

    @When("user enters {string} and {string} as credentials")
    public void user_enters_and_as_credentials(String username, String password) {
        loginPage.userNameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.submitBtn.click();

    }

    @Then("user is on the dashboard page")
    public void user_is_on_the_dashboard_page() throws InterruptedException {
        Thread.sleep(3000);
        String actual = dashboardPage.header.getText();
        String expected = "Quick Launchpad";
        Assert.assertEquals(expected, actual);
    }


    @Then("user is getting alert message")
    public void user_is_getting_alert_message() {
        String actual = loginPage.msg.getText();
        String expectedMsg = "Invalid user name or password.";
        Assert.assertEquals(expectedMsg, actual);
    }

}
