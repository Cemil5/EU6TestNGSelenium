package com.cydeo.tests.day04_basicLocators;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocatorTest   {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullName = driver.findElement(By.name("full_name"));
        fullName.sendKeys("Mike Smith");

        // proper way
//        WebElement emailInput = driver.findElement(By.name("email"));
//        emailInput.sendKeys("mike@smith.com");

        // lazy way
        driver.findElement(By.name("email")).sendKeys("mike@smith.com");
        String actualName = fullName.getAttribute("value");

        // lazy way
        driver.findElement(By.name("wooden_spoon")).click();


        if (actualName.equals("Mike Smith")){
            System.out.println("pass");
        } else{
            System.out.println("fail");
        }

    }
}
