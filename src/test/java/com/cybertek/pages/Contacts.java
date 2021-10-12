package com.cybertek.pages;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contacts extends BasePage{

    public Contacts() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy (className = "user-name")
    WebElement fullName;


    public void clickEmailBox (String email){

      //  BrowserUtils.waitForPageToLoad(20);
        BrowserUtils.waitForVisibility(By.tagName("table"),20);
        WebElement emailBox = driver.findElement(By.xpath("//td[text()='mbrackstone9@example.com']"));
     //   WebElement emailBox = driver.findElement(By.xpath("//td[text()='" + email + "']"));

        System.out.println("emailBox.getText() = " + emailBox.getText());
        BrowserUtils.waitForClickablility(emailBox, 10);

        emailBox.click();
    }




}
