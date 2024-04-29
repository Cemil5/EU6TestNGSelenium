package com.cydeo.selfPractice;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GroupStudy_TC02 {

    /*
    Test Case 2 - Automate all the Menu links of techlistic.com

    Steps to Automate:
    1. Launch browser of your choice say., firefox, chrome etc.
    2. Open this URL -  https://www.techlistic.com/
    3. Maximize or set size of browser window.
    4. Click on 'Java' link and validate page title (Java Tutorial For Beginners).
    5. Navigate back to Home Page.
    6. Click on 'Selenium' link and validate page title (Selenium Webdriver Tutorial).
    7. Navigate back to Home Page.
    8. Click on 'Blogs' link and validate page title. (Best Selenium Blogs)
    9. Navigate back to Home Page.
    10. Click on 'TestNG Blogs' link and print the header.
    11. Close the browser.
    */

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.techlistic.com/");

        WebElement javaLink = driver.findElement(By.xpath("(//a[.='Java'])[1]"));
        javaLink.click();

        Thread.sleep(5000);

        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        // //a[@href='https://www.techlistic.com/p/java.html']
        String expectedTitle = "Java Tutorial For Beginners - Techlistic";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle, "validate java page title");
        driver.navigate().back();


        WebElement seleniumLink = driver.findElement(By.xpath("(//a[.='Selenium'])[1]"));
        seleniumLink.click();
        Thread.sleep(5000);
        expectedTitle = "Selenium Webdriver Tutorial - Techlistic";
        actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle, "Selenium page title verification failde");
        driver.navigate().back();

        WebElement blogLink = driver.findElement(By.xpath("(//a[.='Blogs'])[1]"));
        blogLink.click();
        Thread.sleep(5000);
        expectedTitle = "Best Selenium Blogs";
        actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle, "Blogs page title verification failed");
        driver.navigate().back();

        WebElement testNGLink = driver.findElement(By.xpath("(//a[.='TestNG'])[1]"));
        testNGLink.click();
        Thread.sleep(5000);
        System.out.println( "driver.getTitle() = " + driver.getTitle());

        WebElement header = driver.findElement(By.cssSelector(".post-title.entry-title"));
        System.out.println("header = " + header.getText());

    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }

}
