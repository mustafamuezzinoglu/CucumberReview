package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Swag_Labs_Login_Page {


    public Swag_Labs_Login_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy( id = "user-name")
    public WebElement userNameInputBox;

    @FindBy( id = "password")
    public WebElement passwordInputBox;

    @FindBy( id = "login-button")
    public WebElement loginButton;

    @FindBy(tagName = "h3")
    public WebElement errorMessage;

}
