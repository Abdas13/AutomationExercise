package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import utilities.Driver;

public class Deneme {
    @Test
    public void deneme(){
        Driver.getDriver().get("https://www.amazon.com");
        Driver.getDriver().findElement(By.xpath("//div/input[@id='twotabsearchtextbox']")).sendKeys("Jabra Headset"+ Keys.ENTER);
        Driver.getDriver().findElements(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]"));

    }
}
