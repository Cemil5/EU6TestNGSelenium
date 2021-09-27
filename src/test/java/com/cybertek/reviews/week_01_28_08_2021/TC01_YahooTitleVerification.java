package com.cybertek.reviews.week_01_28_08_2021;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC01_YahooTitleVerification {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver =  new ChromeDriver();
        driver.get("https://www.yahoo.com/");

        String expectedTitle = "Yahoo";
        String actualTitle = driver.getTitle();

        if(actualTitle.contains(expectedTitle)){
            System.out.println("Title is as expected. Verification passed");
        } else {
            System.out.println("Title is not as expected. Verification not passed");
        }
        Thread.sleep(2000);

//        System.out.println("title = " + actualTitle);
//        System.out.println(actualTitle.contains("Yahoo"));

        driver.close();

    }
}
/*
TC #1: YahooTitle Verification
1.Open Chrome browser
2.Go to https://www.yahoo.com/
3.Verify title:
Expected: Yahoo
TC #2: Cybertekpractice toolverifications
1.Open Chrome browser
2.Go to https://practice.cybertekschool.com/
3.Verify URL contains
Expected: cybertekschool
4.Verify title:
Expected: Practice
 */