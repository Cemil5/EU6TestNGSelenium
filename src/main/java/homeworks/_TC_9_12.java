package homeworks;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class _TC_9_12 {
    WebDriver driver;
    List<WebElement> codelist;

    @BeforeClass
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Status Codes")).click();

        codelist = driver.findElements(By.cssSelector(".example>ul>li>a"));
        //  List<WebElement> codelist = driver.findElements(By.xpath("//a[contains(@href,'status_codes/')]"));

        Assert.assertEquals(codelist.size(),4, "list size not 4");

//    for (WebElement code : codelist) {
//        System.out.println("code.getText() = " + code.getText());
//    }
    }
    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
/*
Optional: If you want to to be a real selenium hero,
use @DataProvider for tests cases from 9
through 12.
Please use following documentation: https://testng.org/doc/documentationmain.html#parameters-dataproviders

Test case #9
Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
Step 2. And click on “Status Codes”.
Step 3. Then click on “200”.
Step 4. Verify that following message is displayed:
“This page returned a 200 status code”
*/
@Test
    public void test9()  {

    codelist.get(0).click();
   // driver.findElement(By.linkText("200")).click();

    String actualText = driver.findElement(By.cssSelector(".example>p")).getText();
    actualText = actualText.split("\\.")[0];
 //   actualText = actualText.substring(0, actualText.indexOf("."));
    String expectedText = "This page returned a 200 status code";
    System.out.println(actualText);
    Assert.assertEquals(actualText,expectedText,"text of 200 not as expected");
}

    /*
Test case #10
Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
Step 2. And click on “Status Codes”.
Step 3. Then click on “301”.
Step 4. Verify that following message is displayed:
“This page returned a 301 status code”
 */
    @Test
    public void test10(){

        codelist.get(1).click();

        String actualText = driver.findElement(By.cssSelector(".example>p")).getText();
        actualText = actualText.split("\\.")[0];
        //   actualText = actualText.substring(0, actualText.indexOf("."));
        String expectedText = "This page returned a 301 status code";
        System.out.println(actualText);
        Assert.assertEquals(actualText,expectedText,"text of 301 not as expected");
    }

/*
Test case #11
Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 3. And click on “Status Codes”.
Step 4. Then click on “404”.
Step 5. Verify that following message is displayed:
“This page returned a 404 status code”
*/
@Test
public void test11(){

    codelist.get(2).click();

    String actualText = driver.findElement(By.cssSelector(".example>p")).getText();
    actualText = actualText.split("\\.")[0];
    //   actualText = actualText.substring(0, actualText.indexOf("."));
    String expectedText = "This page returned a 404 status code";
    System.out.println(actualText);
    Assert.assertEquals(actualText,expectedText,"text of 404 not as expected");
}

/*
Test case #12
Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 3. And click on “Status Codes”.
Step 4. Then click on “500”.
Step 5. Verify that following message is displayed:
“This page returned a 500 status code”
 */
@Test
    public void test9_12(){
        String [] codes = {"200", "301", "404", "500"};

        for (int i=0; i<4; i++){
            codelist.get(2).click();

            String actualText = driver.findElement(By.cssSelector(".example>p")).getText();
            actualText = actualText.split("\\.")[0];
            String expectedText = "This page returned a " + codes[i] + "status code";
            System.out.println(actualText);
            Assert.assertEquals(actualText,expectedText,"text of " + codes[i] +" not as expected");
        }
}

}