package com.cybertek.interviewQuestions;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MoneyGamingSignUp {

    @Test
    public void tc1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://moneygaming.qa.gameaccount.com/sign-up.shtml");

        WebElement firstName = driver.findElement(By.id("forename"));
        firstName.sendKeys("Cemil");
        WebElement surname = driver.findElement(By.cssSelector("input[name='map(lastName)']"));
        surname.sendKeys("Sahin");

        String expectedText = "I accept the Terms and Conditions and certify that I am over the age of 18.";
    //  WebElement termsConditions = driver.findElement(By.cssSelector("div#termsCheckbox"));
     // WebElement termsConditions = driver.findElement(By.xpath("//input[@name='map(terms)']/following-sibling::*"));
        WebElement termsConditions = driver.findElement(By.cssSelector("input[name='map(terms)']~div"));
        String actualText = termsConditions.getText();
        Assert.assertEquals(actualText, expectedText);

        WebElement termsBox = driver.findElement(By.cssSelector("input[name='map(terms)']"));
        termsBox.click();
        Assert.assertTrue(termsBox.isSelected(),"verify if terms and conditions box is selected");

        driver.findElement(By.cssSelector("input[alt='Join Now']")).click();

        WebElement validationMessage = driver.findElement(By.cssSelector("label[for='map(email)']"));
        System.out.println(validationMessage.getText());
        Assert.assertEquals(validationMessage.getText(), ("This field is required"),"verify that message appears " +
                "under " +
                "the date of" +
                "        birth box");

        Thread.sleep(2000);
        driver.close();
    }
}
/*
        1. Navigate to: https://moneygaming.qa.gameaccount.com/sign-up.shtml
        2. Enter your first name and surname in the form
        3. Verify the text of Checkbox with text 'I accept the Terms and Conditions and certify that I am over the age of 18.'
        4. Check and verify if it is selected
        4. Submit the form by clicking the JOIN NOW button
        5. Validate that a validation message with text ‘ This field is required’ appears under the date of
        birth box
*/