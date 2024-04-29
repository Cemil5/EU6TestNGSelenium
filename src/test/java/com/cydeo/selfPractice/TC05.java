package com.cydeo.selfPractice;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
Test Case 5: Verify “Gmail” Link existence in Google Home page.

Test Steps:
1. Launch the Browser
2. Navigate to Google Home page (“https://www.google.co.in”)
3. Return the “Gmail” displayed status
Verification Point/s:
Verify the existence of “Gmail” Link
 */
public class TC05 {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @Test
    public void tc05(){
        driver.get("https://www.google.co.in");

        WebElement gmailLink = driver.findElement(By.className("gb_f"));

     //   driver.findElement(By.)

        Assert.assertTrue(gmailLink.isDisplayed(),"gmail is not displayed");


    }
    @AfterClass
    public void tearDown (){
        driver.close();
    }
}
