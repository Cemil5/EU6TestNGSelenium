package com.cybertek.tests.day15;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ClassicWay {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
      //  driver.close();
    }


    @Test
    public void testVyTrack(){
        driver.get("https://qa1.vytrack.com");

        driver.findElement(By.id("prependedInput")).sendKeys("salesmanager120");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();

        driver.navigate().to("https://qa1.vytrack.com/contact");


        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.tagName("table"))));

        WebElement element = driver.findElement(By.xpath("//td[text()='mbrackstone9@example.com']"));
        System.out.println("element.getText() = " + element.getText());
        wait.until(ExpectedConditions.elementToBeClickable(element));

        element.click();



    }


}
