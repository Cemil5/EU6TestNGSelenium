package com.cybertek.tests.day14_extent_reports;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {

    @Test
    public void wrongPasswordTest(){

        extentLogger = report.createTest("Wrong password test");
        LoginPage loginPage = new LoginPage();

        extentLogger.info("enter username user1");
        loginPage.usernameInput.sendKeys("user1");

        extentLogger.info("enter password somepassword");
        loginPage.passwordInput.sendKeys("somepassword");

        extentLogger.info("click login button");
        loginPage.loginBtn.click();

        extentLogger.info("verify page url");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login");

        extentLogger.pass("Wrong password test is passed");
    }

    @Test
    public void wrongUsernameTest(){

        extentLogger = report.createTest("Wrong password test");


        LoginPage loginPage = new LoginPage();
        extentLogger.info("enter username someusername");
        loginPage.usernameInput.sendKeys("someusername");

        extentLogger.info("enter password UserUser123");
        loginPage.passwordInput.sendKeys("UserUser123");

        extentLogger.info("click login button");
        loginPage.loginBtn.click();

        extentLogger.info("verify page url");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login");

        extentLogger.pass("Wrong username test is passed");

    }

}
