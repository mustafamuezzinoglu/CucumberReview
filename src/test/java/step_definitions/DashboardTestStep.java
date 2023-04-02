package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.DashboardPage;
import pages.Vy_Track_Login_Page;
import utilities.ConfigurationReader;

import java.util.ArrayList;
import java.util.List;

public class DashboardTestStep {


    Vy_Track_Login_Page loginPage = new Vy_Track_Login_Page();
    DashboardPage dashboardPage = new DashboardPage();

    @Then("user should see menu option")
    public void user_should_see_menu_option(List<String> expectedOptions) throws InterruptedException {
        Thread.sleep(3000);
    List <String> actualOptions = new ArrayList<>();
    for (WebElement menu:dashboardPage.options) {
        actualOptions.add(menu.getText());

    }

    Assert.assertEquals(expectedOptions, actualOptions);
    }


    @When("user enters as different {string}")
    public void user_enters_as_different(String role) {
        String username = "";
        String password = "";
        switch (role){
            case "user1":
                username = ConfigurationReader.getProperty("driver_username");
                password = ConfigurationReader.getProperty("driver_password");

            case "sales manager":
                username = ConfigurationReader.getProperty("sales_manager_username");
                password = ConfigurationReader.getProperty("sales_manager_password");

            case "store manager":
                username = ConfigurationReader.getProperty("store_manager_username");
                password = ConfigurationReader.getProperty("store_manager_password");

        }
        loginPage.userNameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.submitBtn.click();
    }


}
