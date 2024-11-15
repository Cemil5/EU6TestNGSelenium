package com.cydeo.tests.day08_types_of_elements_2;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        System.out.println("buttons.size() = " + buttons.size());

        Assert.assertEquals(buttons.size(),6, "buttons size is different than 6");

        //iter + enter to get each loop with shortcut
        for (WebElement button : buttons) {
            Assert.assertTrue(button.isDisplayed(),"verify each button is displayed");
            System.out.println("button.isDisplayed() = " + button.isDisplayed());

            //System.out.println("button.getText() = " + button.getText());
        }

        //click second button
        buttons.get(1).click();
    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        driver.findElement(By.tagName("butttt"));

       // List<WebElement> buttons = driver.findElements(By.tagName("button"));

    }


}
