package com.cydeo.tests.day03_WebElement_SendKeys;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmationMessage {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("firefox");
        driver.get("http://practice.cybertekschool.com/forgot_password");


        WebElement emailInputBox = driver.findElement(By.name("email"));

        String expectedEmail = "mike@smith.com";
        emailInputBox.sendKeys(expectedEmail);
        String actualEmail = emailInputBox.getAttribute("value");

        if (actualEmail.equals(expectedEmail)) {
            System.out.println("PASS email verification");
        } else {
            System.out.println("fail email verification");
        }

        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        System.out.println("retrievePasswordButton.getText() = " + retrievePasswordButton.getText());
        retrievePasswordButton.click();

        WebElement messageElement = driver.findElement(By.name("confirmation_message"));
        String expectedMessage = "Your e-mail's been sent!";
        String actualMessage = messageElement.getText();

        if (actualMessage.equals(expectedMessage)){
            System.out.println("PASS message");
        } else {
            System.out.println("FAIL message");
            System.out.println("expectedMessage = " + expectedMessage);
            System.out.println("actualMessage = " + actualMessage);
        }
     //   driver.close();
    }
}
/*
Verify confirmation message
open browser
go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
enter any email
verify that email is displayed in the input box
click on Retrieve password
verify that confirmation message says 'Your e-mail's been sent!'
 */