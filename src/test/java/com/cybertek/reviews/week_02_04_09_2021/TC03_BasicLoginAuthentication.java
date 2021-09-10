package com.cybertek.reviews.week_02_04_09_2021;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Locale;

public class TC03_BasicLoginAuthentication {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        String expectedTitle = "Web Orders Login";
        String actualTitle = driver.getTitle();

        WebElement username = driver.findElement(By.id("ctl00_MainContent_username"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();

        String expectedHomePageTitle = "Web Orders";
        String actualHomePageTitle = driver.getTitle();

        if (actualTitle.toLowerCase(Locale.ROOT).equals(expectedTitle.toLowerCase(Locale.ROOT))) {
            System.out.println("PASS homepage");
        } else {
            System.out.println("FAIL homepage");
            System.out.println("expectedTitle = " + expectedTitle);
            System.out.println("actualTitle = " + actualTitle);
        }

        if (actualHomePageTitle.toLowerCase(Locale.ROOT).equals(expectedHomePageTitle.toLowerCase(Locale.ROOT))) {
            System.out.println("PASS after login");
        } else {
            System.out.println("FAIL after login");
            System.out.println("actualHomePageTitle = " + actualHomePageTitle);
            System.out.println("expectedHomePageTitle = " + expectedHomePageTitle);
        }

    }
}
/*
Basic login authentication
- Go to:  http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
- Verify title equals: String expectedTitle = "Web Orders Login"
- Enter username: Tester
- Enter password: test
- Click “Sign In” button
- Verify title equals: String expectedHomePageTitle = "Web Orders"
 */