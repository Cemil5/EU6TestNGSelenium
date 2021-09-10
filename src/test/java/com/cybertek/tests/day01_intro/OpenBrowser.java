package com.cybertek.tests.day01_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class OpenBrowser {

    public static void main(String[] args) {

//        // we have to enter this line every time we want to open chrome
//        // hey webdrivemanager, can you make chrome ready for me for automation
//        WebDriverManager.chromedriver().setup();
//
//        //WebDriver represent the browser
//        //we are creating driver for chrome browser
//        //new ChromeDriver() --> this part will open chrome browser
//        WebDriver driver = new ChromeDriver();
//
//        // .get(url) method used for navigation to page
//        driver.get("https://google.com");

        // this line allows selenium to automate firefox browser
//        WebDriverManager.firefoxdriver().setup();
//
//        WebDriver driver =new FirefoxDriver();
//
//        driver.get("https://facebook.com");

        WebDriverManager.edgedriver().setup();
        WebDriver driver1 = new EdgeDriver();
        driver1.get("https://instagram.com");
    }

}
