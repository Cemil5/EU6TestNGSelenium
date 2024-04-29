package com.cydeo.tests.day04_basicLocators;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class linkTextAndPartialLinkText {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading");

        WebElement link1 = driver.findElement(By.linkText("Example 2: Element on the page that is rendered after the " +
                "trigger"));
       // link1.click();

        WebElement link2 = driver.findElement(By.partialLinkText("Example 4"));
        link2.click();

    }
}
