package com.cydeo.tests.day02_webdriver_basics;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFactory {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("firefox");

        driver.get("https://www.google.com");

        String title = driver.getTitle();
        System.out.println("title = " + title);


    }
}
