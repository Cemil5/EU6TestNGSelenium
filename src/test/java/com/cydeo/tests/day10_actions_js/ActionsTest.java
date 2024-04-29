package com.cydeo.tests.day10_actions_js;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionsTest {
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
    public void hoverTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img1 = driver.findElement(By.tagName("img"));

        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        actions.moveToElement(img1).perform();

        WebElement viewLink = driver.findElement(By.linkText("View profile"));

        Assert.assertTrue(viewLink.isDisplayed(),"verify link is displayed");
    }
    @Test
    public void dragAndDrop() throws InterruptedException {
     //  driver.get("http://practice.cybertekschool.com/drag_and_drop");
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        Actions actions = new Actions(driver);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));

        WebElement cookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
        cookies.click();
      //  Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.invisibilityOf(cookies));

        actions.dragAndDrop(source,target).perform();

        Thread.sleep(3000);

        driver.navigate().refresh();

        source = driver.findElement(By.id("draggable"));
        target = driver.findElement(By.id("droptarget"));
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().perform();
    }

    @Test
    public void clickJS() {
        driver.get("http://practice.cybertekschool.com/");
        WebElement dropdownLink = driver.findElement(By.linkText("Dropdown"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;

        jse.executeScript("arguments[0].click();",dropdownLink);

    }
    @Test
    public void typeWithJS(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));


        JavascriptExecutor jse = (JavascriptExecutor)driver;
        String text = "hello I came";
        jse.executeScript("arguments[0].setAttribute('value', '" + text +"')", inputBox);

    }

    @Test
    public void scrollDownAndUp() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        for (int i=0; i<10; i++){
            jse.executeScript("window.scrollBy(0,250)");
            Thread.sleep(500);
        }


        for (int i=0; i<10; i++){
            jse.executeScript("window.scrollBy(0,-250)");
            Thread.sleep(500);
        }
    }

    @Test
    public void scrollToElement() throws InterruptedException {
        driver.get("https://www.amazon.com/");

        WebElement lang = driver.findElement(By.id("icp-touch-link-language"));
        Thread.sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",lang);


    }

}
