package com.cybertek.tests.day11_webTables;

import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesExample {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }

    @Test
    public void test1(){
        WebElement table = driver.findElement(By.xpath("//table[1]"));
        System.out.println("table.getText() = " + table.getText());

        Assert.assertTrue(table.getText().contains("John"));
    }

    @Test
    public void test2(){
        // how many colums we have?
        List<WebElement> headers = driver.findElements(By.xpath("//table[1]//th"));
        System.out.println("headers.size() = " + headers.size());

        for (WebElement header : headers) {
            System.out.println("header.getText() = " + header.getText());
        }
    }
    @Test
    public void tableSize() {
        // how many colums we have?
        List<WebElement> headers = driver.findElements(By.xpath("//table[1]//th"));
        System.out.println("headers.size() = " + headers.size());

        List<WebElement> allRows = driver.findElements(By.xpath("//table[1]//tr"));
        System.out.println("allrows.size() = " + allRows.size());

        List<WebElement> rows = driver.findElements(By.xpath("//table[1]//tbody/tr"));
        System.out.println("rows.size() = " + rows.size());
    }
    @Test
    public void getRow(){
        List<WebElement> rows = driver.findElements(By.xpath("//table[1]//tbody/tr"));
       // System.out.println("rows 2 = " + rows.get(1).getText());

        for (int i = 0; i < rows.size(); i++) {
            System.out.println("rows " + (i+1) + " = " + rows.get(i).getText());
        }
        for (WebElement row : rows) {
            System.out.println("row.getText() = " + row.getText());
        }
    }
    @Test
    public void eachCellinOneRow(){
        List<WebElement> elements = driver.findElements(By.xpath("//table[1]//tbody/tr[1]/td"));
        for (WebElement element : elements) {
            System.out.println("element.getText() = " + element.getText());
        }
    }

    @Test
    public void singleCell(){
       WebElement cell = driver.findElement(By.xpath("//table[1]//tbody/tr[3]/td[5]"));
        System.out.println("cell.getText() = " + cell.getText());
    }

    @Test
    public void allCell(){
        int rowNumber = getNumberOfRows();
        int colNumber = getNumberOfColumns();

        for (int row =1; row <= rowNumber;row++){
            for (int col =1; col <= colNumber;col++){
                String cellXpath = "//table[1]//tbody/tr["+row+"]/td["+col+"]";
                WebElement cell = driver.findElement(By.xpath(cellXpath));
                System.out.println(cell.getText());
            }
        }
    }

    @Test
    public void CellInRelationToAnotherCellInSameRow(){

        String firstName = "Jason";
        String xpath = "//table[1]//td[.='"+firstName+"']/../td[3]";
        WebElement email = driver.findElement(By.xpath(xpath));
        System.out.println(email.getText());
    }


    private int getNumberOfColumns() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[1]//th"));
        return headers.size();
    }

    private int getNumberOfRows() {
        List<WebElement> rows = driver.findElements(By.xpath("//table[1]//tbody/tr"));
        return rows.size();
    }


    @Test
    public void testVyTrack(){
        driver.get("https://qa1.vytrack.com");

        driver.findElement(By.id("prependedInput")).sendKeys("salesmanager120");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();

        driver.navigate().to("https://qa1.vytrack.com/contact");


        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.tagName("table"))));

        WebElement element = driver.findElement(By.xpath("//td[text()='mbrackstone9@example.com']"));
        System.out.println("element.getText() = " + element.getText());
        element.click();

    }


}
