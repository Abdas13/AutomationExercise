package pages;

import com.google.j2objc.annotations.Weak;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoggedInPage {
    public LoggedInPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[@href='/delete_account']")
    public WebElement deleteAccountButton;

    @FindBy (xpath = "")
    public WebElement loggedinText;


}
