package com.cydeo.tests.day10_fileUpload;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class FileUploadTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //     driver.quit();
    }

    @Test
    public void fileUploadDynamicly(){
        driver.get("http://practice.cybertekschool.com/upload");

        WebElement chooseFile = driver.findElement(By.id("file-upload"));


        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/file.txt";
        String fullPath = projectPath + "/" + filePath;

        driver.findElement(By.id("file-upload")).sendKeys(fullPath);

        driver.findElement(By.id("file-submit")).click();

        String actualFilename = driver.findElement(By.id("uploaded-files")).getText();

        Assert.assertEquals(actualFilename,"file.txt");


    }
    @Test
    public void fileUpload(){
        driver.get("http://practice.cybertekschool.com/upload");

        WebElement chooseFile = driver.findElement(By.id("file-upload"));

        //copy-paste path:  "C:\Users\bilgi-999\OneDrive - thzxg.ywmne\Desktop\file.txt"
        chooseFile.sendKeys("C:/Users/bilgi-999/OneDrive - thzxg.ywmne/Desktop/file.txt");
        chooseFile.sendKeys("src/test/resources/file.txt");

        driver.findElement(By.id("file-submit")).click();

        String actualFilename = driver.findElement(By.id("uploaded-files")).getText();

        Assert.assertEquals(actualFilename,"file.txt");
    }
    @Test
    public void test1(){
        System.out.println(System.getProperty("user.dir"));
    }

}
