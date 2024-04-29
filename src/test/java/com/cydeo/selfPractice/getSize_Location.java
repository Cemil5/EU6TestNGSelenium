package com.cydeo.selfPractice;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class getSize_Location {

    @Test
    public void done() {
        Driver.get().get("https://library3.cybertekschool.com/#dashboard");
        Driver.get().findElement(By.id("inputEmail")).sendKeys("librarian1256@library");
        Driver.get().findElement(By.id("inputPassword")).sendKeys("EgEUDEq6" + Keys.ENTER);

        BrowserUtils.waitFor(2);
        List<WebElement> size = Driver.get().findElements(By.xpath("//ul[@id='menu_item']//a"));

        for (WebElement each : size) {
            Actions actions = new Actions(Driver.get());
            actions.moveToElement(each).perform();
            System.out.println("size:" + each.getSize());
            System.out.println("location:" + each.getLocation());
        }


    }
}