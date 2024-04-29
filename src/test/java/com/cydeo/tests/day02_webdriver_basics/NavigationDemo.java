package com.cydeo.tests.day02_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        // navigate to another website with different selenium method
        driver.navigate().to("http://www.facebook.com");

        Thread.sleep(3000); // waits for 3 seconds, java capability

        // goes back
        driver.navigate().back();

        Thread.sleep(1000);
        driver.navigate().forward();

        // refresh to webpage
        driver.navigate().refresh();
    }
}
