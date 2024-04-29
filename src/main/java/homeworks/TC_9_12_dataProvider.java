package homeworks;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC_9_12_dataProvider {
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

    /*
Test case #10
Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
Step 2. And click on “Status Codes”.
Step 3. Then click on “301”.
Step 4. Verify that following message is displayed:
“This page returned a 301 status code”
 */


/*
Test case #11
Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 3. And click on “Status Codes”.
Step 4. Then click on “404”.
Step 5. Verify that following message is displayed:
“This page returned a 404 status code”
*/

/*
Test case #12
Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 3. And click on “Status Codes”.
Step 4. Then click on “500”.
Step 5. Verify that following message is displayed:
“This page returned a 500 status code”
 */

    //This method will provide data to any test method that declares that its Data Provider
//is named "statusCodes"
    @DataProvider(name = "statusCodes")
    public Object[][] createData1() {
        return new Object[][] {
                { "200" },
                { "301"},
                {"404"},
                {"500"}
        };
    }
    //This test method declares that its data should be supplied by the Data Provider
//named "statusCodes"
    @Test(dataProvider = "statusCodes")
    public void test9_12 (String code) {

        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Status Codes")).click();

        driver.findElement(By.linkText(code)).click();

        String actualText = driver.findElement(By.cssSelector(".example>p")).getText();
        actualText = actualText.split("\\.")[0];

        String expectedText = "This page returned a " + code + " status code";
        Assert.assertEquals(actualText,expectedText,"text of " + code +" not as expected");
    }






    @DataProvider (name="testdatas")
    public Object[][] getData(){

        Object[][] datas = {
                {"https://practice-cybertekschool.herokuapp.com/","Status Codes","200", "//p[contains(., '200 status')]" },
                {"https://practice-cybertekschool.herokuapp.com/","Status Codes","301", "//p[contains(., '301 status')]" },
                {"https://practice-cybertekschool.herokuapp.com/","Status Codes","404", "//p[contains(., '404 status')]" },
                {"https://practice-cybertekschool.herokuapp.com/","Status Codes","500", "//p[contains(., '500 status')]" },
        };

        return datas;
    }

    @Test (dataProvider = "testdatas")
    public void test9_12(String par1, String par2, String par3, String par4){

        driver.get(par1);

        driver.findElement(By.linkText(par2)).click();

        driver.findElement(By.linkText(par3)).click();

        String expectedResult = "This page returned a "+ par3 + " status code.";

        String actualResult = driver.findElement(By.xpath(par4)).getText();

        Assert.assertTrue(actualResult.contains(expectedResult), "Verify that "+ par3 +" status message is displayed");
    }








    @Test
public void test9_12() {

    driver.get("https://practice-cybertekschool.herokuapp.com");
    driver.findElement(By.linkText("Status Codes")).click();

    String [] codes = {"200", "301", "404", "500"};

    for (int i=0; i<4; i++){
        List<WebElement> codelist = driver.findElements(By.cssSelector(".example>ul>li>a"));
        Assert.assertEquals(codelist.size(),4, "list size not 4");

//        WebDriverWait wait = new WebDriverWait(driver,10);
//        wait.until(ExpectedConditions.elementToBeClickable(codelist.get(i)));
        codelist.get(i).click();

        String actualText = driver.findElement(By.cssSelector(".example>p")).getText();
        actualText = actualText.split("\\.")[0];

        String expectedText = "This page returned a " + codes[i] + " status code";
        Assert.assertEquals(actualText,expectedText,"text of " + codes[i] +" not as expected");

        driver.navigate().back();
    }
}

}