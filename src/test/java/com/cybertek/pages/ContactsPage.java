package com.cybertek.pages;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactsPage extends BasePage{


    public void clickEmailBox (String email){

     //   BrowserUtils.waitForPageToLoad(20);
        waitUntilLoaderScreenDisappear();
     //   BrowserUtils.waitForVisibility(By.tagName("table"),20);
    //    BrowserUtils.waitForClickablility(By.tagName("table"),20);
     //   WebElement emailBox = Driver.get().findElement(By.xpath("//td[text()='mbrackstone9@example.com']"));
        WebElement emailBox = Driver.get().findElement(By.xpath("//td[text()='" + email + "']"));

       // BrowserUtils.waitForClickablility(emailBox, 10);

        emailBox.click();
    }




}
