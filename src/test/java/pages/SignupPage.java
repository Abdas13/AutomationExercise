package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

public class SignupPage {
    public SignupPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id="id_gender1")
    public WebElement MrButton;

    @FindBy(id="id_gender2")
    public WebElement MrsButton;

    @FindBy(xpath = "//input[@data-qa='password']")
    public WebElement password;

    @FindBy(xpath = "//select[@data-qa='days']")
    public WebElement daySelect;

    @FindBy(xpath = "//select[@data-qa='months']")
    public WebElement monthSelect;

    @FindBy(xpath = "//select[@data-qa='years']")
    public WebElement yearSelect;

    @FindBy(xpath = "//input[@id='newsletter']")
    public WebElement newsLetterCheckBox;

    @FindBy(id="optin")
    public WebElement offerCheckBox;

    @FindBy(xpath = "//input[@data-qa='first_name']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@data-qa='last_name']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@data-qa='company']")
    public WebElement companyName;

    @FindBy(xpath = "//input[@data-qa='address']")
    public WebElement address1;

    @FindBy(xpath = "//input[@data-qa='address2']")
    public WebElement address2;

    @FindBy(xpath = "//select[@data-qa='country']")
    public WebElement countrySelect;

    @FindBy(xpath = "//input[@data-qa='state']")
    public WebElement state;

    @FindBy(xpath = "//input[@data-qa='city']")
    public WebElement city;

    @FindBy(xpath = "//input[@data-qa='zipcode']")
    public WebElement zipcode;

    @FindBy(xpath = "//input[@data-qa='mobile_number']")
    public WebElement mobileNumber;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    public WebElement createAccountButton;

}
