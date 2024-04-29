package com.cydeo.selfPractice;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
Test Case 4 - Verify invalid email address error.
Steps to Automate:
1. Open this url  http://automationpractice.com/index.php
2. Click on sign in link.
3. Enter invalid email address in the email box and click enter.
4. Validate that an error message is displaying saying "Invalid email address."
 */
public class TC04 {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }
    @Test
    public void TC4() throws InterruptedException {
        WebElement signInButton = driver.findElement(By.cssSelector(".login"));
        signInButton.click();

        WebElement emailBox = driver.findElement(By.id("email_create"));
        emailBox.sendKeys("mike@smithcom");
        driver.findElement(By.id("SubmitCreate")).click();

        Thread.sleep(3000);
        //<li>Invalid email address.</li>

        WebElement errorMessage = driver.findElement(By.cssSelector("#create_account_error li"));
     //   WebElement errorMessage = driver.findElement(By.xpath("//div[@id = 'create_account_error']//li")); // doğru
      //  WebElement errorMessage = driver.findElement(By.xpath("//li[text()='Invalid email address.']"));  // doğru
        System.out.println("errorMessage = " + errorMessage);
        String actualMessage = errorMessage.getText();
     //   String actualMessage = errorMessage.getAttribute("value");    // hata veriyor.
        String expectedMessage = "Invalid email address.";

        Assert.assertEquals(actualMessage,expectedMessage,"error message verification failed");

    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }

}
