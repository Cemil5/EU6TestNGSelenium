package com.cybertek.selfPractice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GroupStudy_TC01 {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();

        String expectedTitle = driver.getTitle();
        System.out.println("expectedTitle = " + expectedTitle);

        WebElement amazonPay = driver.findElement(By.xpath("//a[@class='nav-a']"));
    //    WebElement amazonPay = driver.findElement(By.className("nav-a"));
        amazonPay.click();
        System.out.println("driver.getTitle() = " + driver.getTitle());
        driver.navigate().back();
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Pass");
        } else {
            System.out.println("fail");
            System.out.println("expectedResult = " + expectedTitle);
            System.out.println("actualTitle = " + actualTitle);
        }
        driver.close();
    }
}
/*
Test Case 1 - Automate first Menu link of amazon.in and print page title

    Steps to Automate:
    1. Launch browser of your choice say., firefox, chrome etc.
    2. Open this URL -  https://www.amazon.in/
    3. Maximize or set size of browser window.
    4. Get the page title and print it.
    5. Now, click on first menu link say 'Amazon Pay' (or choose any other link from the menu list)
    6. Get the page title and print it.
    7. Navigate back to Home Page.
    8. Get the page title and print it. Verify that value matches with output of point no. 4
    9. Close the browser.
 */