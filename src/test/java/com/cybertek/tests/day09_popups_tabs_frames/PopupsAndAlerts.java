package com.cybertek.tests.day09_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsAndAlerts {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
     //   driver.quit();
    }

    @Test
    public void test1() {
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
        driver.findElement(By.cssSelector("[name='j_idt303:j_idt304']")).click(); // span[text()='Confirm']

        driver.findElement(By.cssSelector("[name='j_idt303:j_idt307']")).click();
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        driver.findElement(By.cssSelector("[onclick='jsAlert()']")).click();

        //switch to JS alert pop up

        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();

        driver.findElement(By.cssSelector("[onclick='jsConfirm()']")).click();
        Thread.sleep(2000);
        alert.dismiss();

        driver.findElement(By.cssSelector("[onclick='jsPrompt()']")).click();
        Thread.sleep(2000);
        alert.sendKeys("test");
        alert.accept();

        // chrome alerts example: https://web-push-book.gauntface.com/demos/notification-examples/

    }


}
