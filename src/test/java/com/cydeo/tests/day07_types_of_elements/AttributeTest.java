package com.cydeo.tests.day07_types_of_elements;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AttributeTest {

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioBtn = driver.findElement(By.id("blue"));
        System.out.println("blueRadioBtn.getAttribute(\"value\") = " + blueRadioBtn.getAttribute("value"));
        System.out.println("blueRadioBtn.getAttribute(\"type\") = " + blueRadioBtn.getAttribute("type"));
        // get the value of checked
        System.out.println("blueRadioBtn.getAttribute(\"checked\") = " + blueRadioBtn.getAttribute("checked"));
        // when we use non exist attribute it will return null to us.
        System.out.println(blueRadioBtn.getAttribute("href"));

        System.out.println(blueRadioBtn.getAttribute("outerHTML"));

        System.out.println(blueRadioBtn.getAttribute("innerHTML"));

        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement button2 = driver.findElement(By.name("button2"));

        System.out.println(button2.getAttribute("outerHTML"));
        System.out.println(button2.getAttribute("innerHTML"));
        String outerHTML = button2.getAttribute("outerHTML");
        String text = button2.getText();
        System.out.println(outerHTML +"  " + text);

        Assert.assertTrue(outerHTML.contains("Button 2"));
        driver.close();
    }


}
