package com.cybertek.reviews.week_01_28_09_2021;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;


public class TC02_CybertekPracticeVerification {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize(); // to maximize to web page

        driver.get("http://practice.cybertekschool.com/");

        String expectedURL = "cybertekschool";
        String actualURL = driver.getCurrentUrl();

        if (actualURL.contains(expectedURL)){
            System.out.println("URL verification PASSED");
        } else{
            System.out.println("URL verification FAILED");
        }

        driver.quit();

    }

}
/*
TC #2: Cybertekpractice toolverifications
1.Open Chrome browser
2.Go to http://practice.cybertekschool.com/
3.Verify URL contains
Expected: cybertekschool
4.Verify title:
Expected: Practice
 */