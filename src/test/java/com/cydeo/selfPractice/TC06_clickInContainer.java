package com.cydeo.selfPractice;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*

 */
public class TC06_clickInContainer {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @Test
    public void tc05() throws InterruptedException {
        driver.get("https://demoqa.com/buttons");
//        driver.wait(3000);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        String javascript = "document.getElementById('jsU4n')";
//        String javascript = "document.evaluate('xpath here')";
//        String javascript = "document.evaluate('//header/a')";
//        String javascript = "document.evaluate(\n" +
//                "  //header/a,\n" +
//                "  document,\n" +
//                "  null,\n" +
//                "  XPathResult.FIRST_ORDERED_NODE_TYPE,\n" +
//                "  null\n" +
//                ");";

        String javascript = "document.evaluate(//header/a,document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue;";

        WebElement element = (WebElement) executor.executeScript(javascript);

//        WebElement element = driver.findElement(By.id("jsU4n"));
//        WebElement element = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
//        WebElement element = driver.findElement(By.xpath("//header/a"));
        executor.executeScript("arguments[0].click();", element);
        System.out.println();
     //   driver.findElement(By.)



    }
    @AfterClass
    public void tearDown (){
        driver.close();
    }
}
