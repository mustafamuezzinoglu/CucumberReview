package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.Swag_Labs_Login_Page;
import utilities.ConfigurationReader;
import utilities.Driver;

public class Swag_Labs_Login_Steps {

    Swag_Labs_Login_Page swagLabsLoginPage = new Swag_Labs_Login_Page();


    @Given("user goes to the login page")
    public void user_goes_to_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("swaglab.url"));
    }

    @When("user login with validate credentials")
    public void user_login_with_validate_credentials() {
        swagLabsLoginPage.userNameInputBox.sendKeys(ConfigurationReader.getProperty("swaglab.username"));
        swagLabsLoginPage.passwordInputBox.sendKeys(ConfigurationReader.getProperty("swaglab.password"));
        swagLabsLoginPage.loginButton.click();
    }

    @Then("user is on the dashboard")
    public void user_is_on_the_dashboard() {
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }

    @When("user login with invalid credentials")
    public void user_login_with_invalid_credentials() {
        swagLabsLoginPage.userNameInputBox.sendKeys("wrong username");
        swagLabsLoginPage.passwordInputBox.sendKeys("wrong password");
        swagLabsLoginPage.loginButton.click();
    }
    @Then("user gets error messages")
    public void user_gets_error_messages() {
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        String actualErrorMessage = swagLabsLoginPage.errorMessage.getText();
        Assert.assertEquals("This is alert error message", expectedErrorMessage, actualErrorMessage);

    }

}
