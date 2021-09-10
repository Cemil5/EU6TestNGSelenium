package com.cybertek.homeworks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorHW {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.com/");

// TC 1 print number of results
        WebElement searchTerm = driver.findElement(By.xpath("//input[@type='text']"));
        searchTerm.sendKeys("search");
        WebElement searchButton = driver.findElement(By.xpath("//input[@type='submit']"));
        searchButton.click();

        WebElement result = driver.findElement(By.xpath("//h1/span[1]"));
        System.out.println("result = " + result.getText());

        Thread.sleep(2000);
// TC 2 title contains Selenium?
        driver.navigate().to("https://www.ebay.com/");
        searchTerm = driver.findElement(By.xpath("//input[@type='text']"));
        searchTerm.sendKeys("Selenium");
        searchButton = driver.findElement(By.xpath("//input[@type='submit']"));
        searchButton.click();
        String  actualTitle = driver.getTitle();
        String  expectedTitle = "selenium";

        if (actualTitle.contains(expectedTitle)){
            System.out.println("pass ebay");
        } else {
            System.out.println("fail ebay");
            System.out.println("actualTitle = " + actualTitle);
            System.out.println("expectedTitle = " + expectedTitle);
        }
        Thread.sleep(2000);
//TC 3 verify url ends with `Selenium_(software)
        driver.navigate().to("https://www.wikipedia.org/");
        WebElement searchBox = driver.findElement(By.id("searchInput"));
        searchBox.sendKeys("selenium webdriver");
        searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
        searchButton.click();

        WebElement seleniumSoftware = driver.findElement(By.xpath("//ul[@class='mw-search-results']/li[1]/div[1]/a"));
        seleniumSoftware.click();
        String actualURL = driver.getCurrentUrl();
        String expected = "Selenium_(software)";
        if (actualURL.endsWith(expected)){
            System.out.println("pass wiki");
        } else {
            System.out.println("fail wiki");
            System.out.println("expected = " + expected);
            System.out.println("actualURL = " + actualURL);
        }
        Thread.sleep(2000);
        driver.quit();
    }
    /*
    Test case 1
Go to Ebay
enter search term
click on search button
print number of results

Test case 2
Go to Ebay
search Selenium
click on search button
verify title contains Selenium

Test case 3
Go to wikipedia.org (Links to an external site.)
enter search term `selenium webdriver`
click on search button
click on search result `Selenium (software)`
verify url ends with `Selenium_(software)'
     */
}
