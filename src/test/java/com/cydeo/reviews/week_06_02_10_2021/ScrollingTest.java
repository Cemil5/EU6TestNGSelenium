package com.cydeo.reviews.week_06_02_10_2021;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ScrollingTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
      //  driver.quit();
    }
    @Test
    public void testActionClass() throws InterruptedException {
        Actions actions = new Actions(driver);

        WebElement cybertekSchool = driver.findElement(By.linkText("Cybertek School"));
     //   cybertekSchool.click();
        actions.moveToElement(cybertekSchool).perform();

        Thread.sleep(3000);

        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP).perform();

        Thread.sleep(3000);

        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }

    @Test
    public void scrollTestJSE() throws InterruptedException {

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        // scroll down
        jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        Thread.sleep(3000);
        // scroll up
        jse.executeScript("window.scrollBy(0,-document.body.scrollHeight)");

    }

}
