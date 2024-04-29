package com.cydeo.selfPractice;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupStudy_TC06 {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @Test
    public void test6() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book for beginners");
        driver.findElement(By.id("nav-search-submit-button")).click();
        driver.findElement(By.cssSelector("input#low-price")).sendKeys("18");
        driver.findElement(By.cssSelector("input#high-price")).sendKeys("50");
        driver.findElement(By.cssSelector("span#a-autoid-1")).click();

        driver.findElement(By.xpath("//span[text()='Paperback']")).click();

        WebElement englishCheckBox = driver.findElement(By.xpath("(//span[text()='English']/../div)[1]"));

        Assert.assertFalse(englishCheckBox.isSelected(),"english checkbox selected");
        Thread.sleep(2000);
        englishCheckBox.click();

        String expectedText = "1-16 of 792 results for";
        String actualText = driver.findElement(By.xpath("//span[contains(text(),'results')]")).getText();

        Assert.assertEquals(actualText,expectedText,"failed");
    }
}

/*
    Test Case 6:

    Test Steps:
    1. Launch the Browser
    2. Navigate to url (“https://www.amazon.com/”)
    3. Type "java book for beginners" in searchbox
    4. Click search button
    5. Enter min and max price under Price title (left side of the page)
    6. Click on Go button
    7. Click on "Paperback" under Book Format
    8. Verify "English" checkbox is NOT checked
    9. Select "English" as book language
    10. Print how many results are shown (1-16 of 792 results for)
    */