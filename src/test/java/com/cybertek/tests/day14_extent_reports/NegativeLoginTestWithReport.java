package com.cybertek.tests.day14_extent_reports;

import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashboardPage;
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
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login**");

        extentLogger.pass("Wrong username test is passed");

    }

    /*
     * open the chrome
     * go to qa1.vytrack
     * login as a sales manager
     * navigate to customers ->contacts
     * click on email mbrackstone9@example.com
     * verify that full name is Mariam Brackstone
     * verify that email is mbrackstone9@example.com
     * verify that phone number is +18982323434
     */

@Test
    public void CustomerValidation(){

    extentLogger = report.createTest("Customer Validation test");

    LoginPage loginPage = new LoginPage();
    extentLogger.info("login as a sales manager");
    loginPage.loginAsSalesManager();

    extentLogger.info("navigate to customers ->contacts");
    DashboardPage dashboardPage = new DashboardPage();
    dashboardPage.navigateToModule("Customers", "Contacts");

    extentLogger.info("click on email mbrackstone9@example.com");
    ContactsPage contacts = new ContactsPage();
    String email = "mbrackstone9@example.com";
    contacts.clickEmailBox(email);

    extentLogger.info("verify that full name is Mariam Brackstone");
    extentLogger.info("verify that email is mbrackstone9@example.com");
    extentLogger.info("verify that phone number is +18982323434");

    extentLogger.pass("Customer Validation test is passed");

}

}
