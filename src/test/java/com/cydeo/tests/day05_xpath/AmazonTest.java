package com.cydeo.tests.day05_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("selenium");

        WebElement goButton = driver.findElement(By.id("nav-search-submit-button"));
        goButton.click();

        WebElement getResults = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/span[1]"));
        String actualText = getResults.getText();
       System.out.println("actualText = " + actualText);

        WebElement getSearchedWord = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small " +
                "a-spacing-top-small']/span[3]"));
        String searchedWord = getSearchedWord.getText();
      //  System.out.println("SearchedWord = " + searchedWord);
        actualText += " " + searchedWord;
        String expectedText = "1-48 of 214 results for \"selenium\"";
        if (actualText.equals(expectedText)){
            System.out.println("pass");
        } else {
            System.out.println("fail");
            System.out.println("expectedText = " + expectedText);
            System.out.println("actualText = " + actualText);
        }
        Thread.sleep(2000);
        driver.quit();
    }
}
/*
go to amazon.com
search for selenium
click search button
verify 1-48 of 304 results for "selenium"
 */