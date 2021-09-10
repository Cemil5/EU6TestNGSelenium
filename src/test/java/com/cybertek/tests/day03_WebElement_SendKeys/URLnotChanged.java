package com.cybertek.tests.day03_WebElement_SendKeys;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class URLnotChanged {
    public static void main(String[] args) {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        String expected = "http://practice.cybertekschool.com/forgot_password";
        driver.get(expected);

        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        String actual = driver.getCurrentUrl();
        if (actual.equals(expected)) {
            System.out.println("test case passed");
        } else {
            System.out.println(" failed");
        }

        driver.close();
    }

}
/*
Verify URL not changed
-open chrome browser
-go to http://practice.cybertekschool.com/forgot_password Links to an external site.
-click on Retrieve password
-verify that url did not change
 */