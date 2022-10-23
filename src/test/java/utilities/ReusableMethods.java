package utilities;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import utilities.Driver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class ReusableMethods {

    //Switching Widows
    public static void switchToWindows(String targetTitle) {
        String origin = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
            Driver.getDriver().switchTo().window(origin);
        }
    }

    public static void hover(WebElement element) {
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(element).perform();
    }

    public static List<String> getElementsText(By locator) {
        List<WebElement> elems = Driver.getDriver().findElements(locator);
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : elems) {
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }

    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Explicit Wait
    }

    public static WebElement waitForVisibility(WebElement element, int TimeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(TimeToWaitInSec));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibility(By locator, int TimeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(TimeToWaitInSec));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickabilitiy(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForClickabilitiy(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
    }

    public static void waitForPageToLoad(long timeOutInSecond) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeOutInSecond));
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after" + timeOutInSecond + "second");
        }
    }

    public static WebElement fluentWait(final WebElement webElement, int timeInSec) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(Driver.getDriver())
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(5));
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver webDriver) {
                return webElement;
            }
        });
        return element;
    }
    public static void doubleClick (WebElement element){
        new Actions(Driver.getDriver()).doubleClick(element).build().perform();
    }
    public static void selectCheckBox (WebElement element , Boolean check){
        if (check){
            if(!element.isSelected()){
                element.click();
            }
        } else {
            if(element.isSelected()){
                element.click();
            }
        }
    }
    public static String getPopupMessage (final WebDriver driver){
        String message = null;
        try {
            Alert alert = driver.switchTo().alert();
            message= alert.getText();
            alert.accept();
        }catch (Exception e){
            message=null;
        }
        System.out.println("Message " + message);
        return message;
    }
    public static String cancelPopupMessageBox (final WebDriver driver) {
        String message = null;
        try {
            Alert alert = driver.switchTo().alert();
            message = driver.getTitle();
            alert.dismiss();
        } catch (Exception e) {
            message = null;
        }
        return message;
    }
    public static void insertText (WebDriver driver, By locator, String value){
        WebElement field = driver.findElement(locator);
        field.clear();
        field.sendKeys(value);
    }

    public static void selectDropdown (WebDriver driver, By locator, String value){
        new Select(driver.findElement(locator)).selectByVisibleText(value);
    }
    public static void selectSearchDropdown (WebDriver driver, By locator, String value){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
        driver.findElement(locator).sendKeys(Keys.TAB);
    }
    public static WebElement selectRandomTextFromDropdown(Select select) {
        Random random = new Random();
        List<WebElement> weblist = select.getOptions();
        int optionIndex = 1 + random.nextInt(weblist.size() - 1);
        select.selectByIndex(optionIndex);
        return select.getFirstSelectedOption();
    }
    public static void selectFromDropDown(WebElement selectData, String value){
        Select selectElement = new Select(selectData);
        selectElement.selectByValue(value);

    }


}