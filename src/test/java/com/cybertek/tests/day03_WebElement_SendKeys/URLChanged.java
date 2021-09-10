package com.cybertek.tests.day03_WebElement_SendKeys;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class URLChanged {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        String expected = "http://practice.cybertekschool.com/forgot_password";
        driver.navigate().to(expected);

        WebElement emailInputBox = driver.findElement(By.name("email"));
        emailInputBox.sendKeys("mike@smith.com");

        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        String expectedUrl = "http://practice.cybertekschool.com/email_sent";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.equals(expectedUrl)){
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
    }
}
/*
Verify URL changed
open chrome browser
go to http://practice.cybertekschool.com/forgot_password Links to an external site.
enter any email
click on Retrieve password
verify that url changed to http://practice.cybertekschool.com/email_sent
 */