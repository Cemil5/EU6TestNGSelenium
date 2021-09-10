package com.cybertek.tests.day02_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndUrl {
    public static void main(String[] args) {
        // task open chrome and nav. to http://practice.cybertekschool.com

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com");

        // getting title with selenium
        String title = driver.getTitle();
        System.out.println("title = " + title);

        // getCurrentUrl --> get the url from browser
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);


    }
}
