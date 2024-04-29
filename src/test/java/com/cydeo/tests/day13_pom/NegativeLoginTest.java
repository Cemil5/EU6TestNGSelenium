package com.cydeo.tests.day13_pom;

import com.cydeo.pages.LoginPage;
import com.cydeo.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    @Test
    public void wrongPasswordTest(){

        //   String username = ConfigurationReader.get("driver_username");
        //  String password = ConfigurationReader.get("driver_password");

//        driver.findElement(By.id("prependedInput")).sendKeys("user1");
//        driver.findElement(By.id("prependedInput2")).sendKeys("somepassword");
//        driver.findElement(By.id("_submit")).click();

        LoginPage loginPage = new LoginPage();
        loginPage.usernameInput.sendKeys("user1");
        loginPage.passwordInput.sendKeys("somepassword");
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login");

    }

    @Test
    public void wrongUsernameTest(){

        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("someusername");
        loginPage.passwordInput.sendKeys("UserUser123");
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login");

    }

}
