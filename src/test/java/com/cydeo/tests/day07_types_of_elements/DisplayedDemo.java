package com.cydeo.tests.day07_types_of_elements;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement usernameInput = driver.findElement(By.id("username"));
        System.out.println("usernameInput.isDisplayed() = " + usernameInput.isDisplayed());

        //TASK
        //verify username inputBox is not displayed on the screen
        // click start button
        // verify username displayed on the screen

        Assert.assertFalse(usernameInput.isDisplayed(),"verify username is not displayed");
        WebElement startButton = driver.findElement(By.cssSelector("div#start>button"));
        startButton.click();
        Thread.sleep(8000);
        Assert.assertTrue(usernameInput.isDisplayed(),"verify username is displayed");




    }

}
