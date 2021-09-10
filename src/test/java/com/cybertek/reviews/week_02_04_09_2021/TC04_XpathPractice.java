package com.cybertek.reviews.week_02_04_09_2021;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC04_XpathPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        String expectedResult = "Clicked on button one!";
    //    WebElement button1 = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        WebElement button1 = driver.findElement(By.xpath("//button[@class='btn btn-primary' and @onclick='button1()']"));

        button1.click();
        WebElement result = driver.findElement(By.xpath("//button[.='Button 1']"));
        String actualResult = result.getText();

        if (actualResult.equals(actualResult)){
            System.out.println("Pass");
        } else {
            System.out.println("fail");
            System.out.println("actualResult = " + actualResult);
            System.out.println("expectedResult = " + expectedResult);
        }

        Thread.sleep(2000);
        driver.close();
    }
}
