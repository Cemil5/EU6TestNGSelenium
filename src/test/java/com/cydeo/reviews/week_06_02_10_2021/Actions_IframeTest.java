package com.cydeo.reviews.week_06_02_10_2021;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Actions_IframeTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //  driver.quit();
    }
//1. Go to [https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2](https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2)
//2. Switch to iframe.
//3. Double click on the text “Double-click me to change my text color.”
//4. Assert: Text’s “style” attribute value contains “red”.

    @Test
    public void test(){
        driver.switchTo().frame("iframeResult");

        WebElement demoText = driver.findElement(By.id("demo"));
        Actions actions = new Actions(driver);

        actions.doubleClick(demoText).perform();

      //  String fullWebElement = demoText.getAttribute("outerHTML");
        String fullWebElement = demoText.getAttribute("style");

        Assert.assertTrue(fullWebElement.contains("red"));
    }

}
