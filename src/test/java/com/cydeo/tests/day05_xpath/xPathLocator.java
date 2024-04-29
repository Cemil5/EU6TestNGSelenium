package com.cydeo.tests.day05_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class xPathLocator {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement button2 = driver.findElement(By.xpath("//button[@onclick='button2()']"));
        button2.click();

        Thread.sleep(2000);

        // any button element which has onclick attribute and its value is button1()
        WebElement button1 = driver.findElement(By.xpath("//button[@*k='button1()']"));
        button2.click();

        Thread.sleep(2000);

        driver.close();

    }


}
