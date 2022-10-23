package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage  {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//input[@data-qa='signup-name']")
    public WebElement newUserName;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    public WebElement newUserEmail;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    public WebElement newUserSignUp;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    public WebElement loginEmail;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    public WebElement loginPassword;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    public WebElement loginButton;
}
