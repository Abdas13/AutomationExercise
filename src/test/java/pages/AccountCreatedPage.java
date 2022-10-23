package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.WeakHashMap;

public class AccountCreatedPage {
    public AccountCreatedPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[@data-qa='continue-button']")
    public WebElement continueButton;

    @FindBy(xpath ="//*[@id=\"form\"]/div/div/div/h2/b")
    public WebElement AccountCreatedText;

    @FindBy (xpath =" //*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")
    public WebElement deleteAccountButton;


}
