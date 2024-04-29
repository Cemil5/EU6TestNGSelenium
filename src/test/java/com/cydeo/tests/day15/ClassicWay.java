package com.cydeo.tests.day15;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ClassicWay {
   // WebDriver driver = Driver.get();
    WebDriver driver = WebDriverFactory.getDriver("chrome");

    public ClassicWay(){
        // This page doesn't have common features with BasePage, and we didn't extend to BasePage. Other pages has
        // common features and we extend them.

        PageFactory.initElements(driver,this);    //we can use the annotation in this class
        // for locators by this keyword
    }

    @FindBy(css = "div[class='loader-mask shown']")
    @CacheLookup
    protected WebElement loaderMask;

    @FindBy(id = "prependedInput")
    public WebElement usernameInput;

    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    @FindBy(id = "_submit")
    public WebElement loginBtn;

    @FindBy(css = ".btn.btn-primary")
    public List<WebElement> buttons;


    @BeforeMethod
    public void setUp(){
     //   driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }


    @Test
    public void testVyTrack(){
        driver.get("https://qa1.vytrack.com");

        usernameInput.sendKeys("salesmanager120");
        passwordInput.sendKeys("UserUser123");
        loginBtn.click();

        driver.navigate().to("https://qa1.vytrack.com/contact");


        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
      //  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.tagName("table"))));

        WebElement element = driver.findElement(By.xpath("//td[text()='mbrackstone9@example.com']"));
      //  System.out.println("element.getText() = " + element.getText());
      //  wait.until(ExpectedConditions.elementToBeClickable(element));

        element.click();



    }


}
