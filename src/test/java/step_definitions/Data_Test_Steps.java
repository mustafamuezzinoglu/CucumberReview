package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.Vidual_validation_shoppingPage;
import utilities.Driver;

public class Data_Test_Steps {

    Vidual_validation_shoppingPage sp = new Vidual_validation_shoppingPage();
    String actualPrice;

    @When("user provide {string}")
    public void user_provide(String name) {
        WebElement price = Driver.getDriver().findElement(By.xpath("(//div[.='" + name + "']/../../../div)[2]/div"));
        actualPrice = (String) ((JavascriptExecutor) Driver.getDriver()).executeScript("return arguments[0].childNodes[1].textContent;", price);
    }
    @Then("the price should equal to {string}")
    public void the_price_should_equal_to(String expectedPrice) {
        Assert.assertEquals(expectedPrice,actualPrice);
    }
}
