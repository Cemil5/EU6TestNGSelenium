package com.cybertek.tests.day04_basicLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class nameLocatorButton2 {
   public static void main(String[] args) {

      WebDriverManager.chromedriver().setup();
      WebDriver driver = new ChromeDriver();
      driver.get("http://practice.cybertekschool.com/multiple_buttons");

      WebElement button2 = driver.findElement(By.name("button2"));
      button2.click();

      WebElement result = driver.findElement(By.id("result"));
      System.out.println(result.getText());

   }
}
