package com.cydeo.reviews.week_03_11_09_2021;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC05_SeleniumEasy {
    WebDriver driver;

    @BeforeClass
    public void setUP(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

    }

    @Test
    public void test1(){

        WebElement successMessage = driver.findElement(By.cssSelector("div#txtAge"));
        Assert.assertFalse(successMessage.isDisplayed(), "Verify “Success – Check box is checked” message is NOT displayed");

        WebElement checkBox = driver.findElement(By.cssSelector("input#isAgeSelected"));
        checkBox.click();
        Assert.assertTrue(successMessage.isDisplayed(),"Verify “Success – Check box is checked” message is displayed.");
    }
    /*
    TC #3: SeleniumEasy Checkbox Verification – Section 2
1. Open Chrome browser
2. Go to http://www.seleniumeasy.com/test/basic-checkbox-demo.html
3. Verify “Check All” button text is “Check All”
4. Click to “Check All” button
5. Verify all check boxes are checked
6. Verify button text changed to “Uncheck All”
     */

    @Test
    public void test2(){

        WebElement checkAllButton = driver.findElement(By.cssSelector("input#check1"));
        String expectedText = "Check All";
        String actualText = checkAllButton.getAttribute("value");
        Assert.assertEquals(actualText,expectedText);

        checkAllButton.click();
        for (int i=1; i<=4; i++) {
            String locator = "(//input[@class='cb1-element'])[" + i + "]";
            WebElement checkbox = driver.findElement(By.xpath(locator));
            Assert.assertTrue(checkbox.isSelected(), "Verify all check boxes are checked");
        }

        expectedText = "Uncheck All";
        actualText = checkAllButton.getAttribute("value");
        Assert.assertEquals(actualText,expectedText);
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
/*
TC #2: SeleniumEasy Checkbox Verification – Section 1
1. Open Chrome browser
2. Go to http://www.seleniumeasy.com/test/basic-checkbox-demo.html
3. Verify “Success – Check box is checked” message is NOT displayed.
4. Click to checkbox under “Single Checkbox Demo” section
5. Verify “Success – Check box is checked” message is displayed.


 */