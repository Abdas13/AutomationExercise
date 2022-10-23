package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class TC01  {
    HomePage homePage=new HomePage();
    LoginPage loginPage=new LoginPage();
    SignupPage signupPage=new SignupPage();
    AccountCreatedPage accountCreatedPage=new AccountCreatedPage();
    LoggedInPage loggedInPage=new LoggedInPage();
    Faker faker=new Faker();

    @Test
    public void testCase01(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        String actuallTitle = Driver.getDriver().getCurrentUrl();
        String expectedTitle = "https://automationexercise.com/";
        Assert.assertEquals(actuallTitle,expectedTitle);
        System.out.println(actuallTitle.toString());
        List<WebElement> list=Driver.getDriver().findElements(By.tagName("a"));
        for(WebElement link:list){
            System.out.println(link.getText()+" - "+link.getAttribute("href"));
        }

        homePage.loginButton.click();
        ReusableMethods.waitFor(2);
        loginPage.newUserName.sendKeys(faker.name().firstName());
        loginPage.newUserEmail.sendKeys(faker.internet().emailAddress());
        loginPage.newUserSignUp.click();

        signupPage.MrButton.click();
        signupPage.password.sendKeys(faker.internet().password(8,12,true,true));
        Select select;
        select=new Select(signupPage.daySelect);
        select.selectByIndex(12);
        select=new Select(signupPage.monthSelect);
        select.selectByIndex(5);
        select=new Select(signupPage.yearSelect);
        select.selectByVisibleText("1999");
        signupPage.newsLetterCheckBox.click();
        signupPage.offerCheckBox.click();
        signupPage.firstName.sendKeys(faker.name().firstName());
        signupPage.lastName.sendKeys(faker.name().lastName());
        signupPage.companyName.sendKeys(faker.company().name());
        signupPage.address1.sendKeys(faker.address().streetAddress());
        signupPage.address2.sendKeys(faker.address().buildingNumber());
        Select select3=new Select(signupPage.countrySelect);
        ReusableMethods.selectRandomTextFromDropdown(select3);
//        select=new Select(signupPage.countrySelect);
//        select.selectByVisibleText("Canada");
        signupPage.state.sendKeys(faker.address().state());
        signupPage.city.sendKeys(faker.address().cityName());
        signupPage.zipcode.sendKeys(faker.address().zipCode());
        signupPage.mobileNumber.sendKeys(faker.phoneNumber().cellPhone());
        signupPage.createAccountButton.click();
        String expected="ACCOUNT CREATED!";
        String actual=accountCreatedPage.AccountCreatedText.getText().toString();
        System.out.println(actual);
        Assert.assertEquals(actual,expected);

        accountCreatedPage.continueButton.click();
        String expectedLogged=" Logged in as ";
      //  Boolean actualLogged=loggedInPage.loggedinText.isDisplayed();
      //  Assert.assertEquals(expectedLogged,actualLogged);
      //  System.out.println(actualLogged);

     //   loggedInPage.deleteAccountButton.click();







    }
}
