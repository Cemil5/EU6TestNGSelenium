package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HoverOverTest {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //     driver.quit();
    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/hovers");

        List<WebElement> imgs = driver.findElements(By.tagName("img"));
        Assert.assertTrue(imgs.size()>0, "img size is 0");

        List<WebElement> h5 = driver.findElements(By.tagName("h5"));
        Assert.assertEquals(h5.size(), imgs.size(),"sizes not equal");

        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver,10);

       for (int i=0; i<imgs.size(); i++){
            actions.moveToElement(imgs.get(i)).perform();
         //   wait.until(ExpectedConditions.visibilityOf(h5.get(i)));
         //   System.out.println("h5.get().getText() = " + h5.get(i).getText());
            Assert.assertTrue(h5.get(i).isDisplayed(), "name is not displayed");
       }

    }


}
