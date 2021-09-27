package com.cybertek.tests.day09_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframeTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/iframe");

        // to switch using name or ID attribute of iframe
        driver.switchTo().frame("mce_0_ifr");

        Thread.sleep(2000);
        // clear the text : Your content goes here.
        driver.findElement(By.cssSelector("#tinymce")).clear();
        // sends Mike Smith
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Mike Smith");

        // goes back to first frame ( main html)
        // goes back to first frame, useful when we have switched  multiple frames
        driver.switchTo().defaultContent();

        // 2. switching with INDEX
        driver.switchTo().frame(0); // only baby html is counted, ignores main html

        Thread.sleep(2000);
        // clear the text : Your content goes here.
        driver.findElement(By.cssSelector("#tinymce")).clear();
        // sends Mike Smith
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Mike Smith with INDEX");

        // Second way to switch parent
        driver.switchTo().parentFrame();

        // 3. switching with webelement
        WebElement iframeElement = driver.findElement(By.tagName("iframe"));

        driver.switchTo().frame(iframeElement);
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Mike Smith with WEBELEMENT");
    }

    @Test
    public void test2() {
        driver.get("http://practice.cybertekschool.com/nested_frames");

        driver.switchTo().frame("frame-top");
       // driver.switchTo().frame(0);

        // switching to middle
        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.id("content")).getText());

        // switching to right
        driver.switchTo().parentFrame();
        driver.switchTo().frame(2);
        System.out.println(driver.findElement(By.tagName("body")).getText());

        // switching to bottom
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        System.out.println(driver.findElement(By.tagName("body")).getText());


    }
}
