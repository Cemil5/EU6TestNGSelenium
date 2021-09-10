package com.cybertek.homeworks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumEasyCheckBox {
    @Test
    public void Section1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement checkbox = driver.findElement(By.xpath("//div[@class='panel-body']/div[2]"));
        Assert.assertFalse(checkbox.isDisplayed(), "Verify “Success – Check box is checked” message is NOT displayed");

        driver.findElement(By.cssSelector("input#isAgeSelected")).click();

        Assert.assertTrue(checkbox.isDisplayed(),"Verify “Success – Check box is checked” message is displayed");
        Thread.sleep(2000);
        driver.close();
    }
    @Test
    public void Section2() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement checkAllButton = driver.findElement(By.cssSelector("#check1"));
        Assert.assertTrue(checkAllButton.getAttribute("value").equals("Check All"),"Verify “Check All” button text is “Check All”");
        checkAllButton.click();

        WebElement option1 = driver.findElement(By.xpath("(//input[@class='cb1-element'])[1]"));
        Assert.assertTrue(option1.isSelected());
        WebElement option2 = driver.findElement(By.xpath("(//input[@class='cb1-element'])[2]"));
        Assert.assertTrue(option2.isSelected());
        WebElement option3 = driver.findElement(By.xpath("(//input[@class='cb1-element'])[3]"));
        Assert.assertTrue(option3.isSelected());
        WebElement option4 = driver.findElement(By.xpath("(//input[@class='cb1-element'])[4]"));
        Assert.assertTrue(option4.isSelected());

        Assert.assertTrue(checkAllButton.getAttribute("value").equals("Uncheck All"),"Verify button text changed to “Uncheck All”");

        Thread.sleep(2000);
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

TC #3: SeleniumEasy Checkbox Verification – Section 2
1. Open Chrome browser
2. Go to http://www.seleniumeasy.com/test/basic-checkbox-demo.html
3. Verify “Check All” button text is “Check All”
4. Click to “Check All” button
5. Verify all check boxes are checked
6. Verify button text changed to “Uncheck All”

 */