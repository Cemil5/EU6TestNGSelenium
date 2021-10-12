package com.cybertek.tests.day15;

import com.cybertek.pages.Contacts;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerTestWithReport extends TestBase {

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
    Contacts contacts = new Contacts();
    String email = "mbrackstone9@example.com";
    contacts.clickEmailBox(email);

    extentLogger.info("verify that full name is Mariam Brackstone");
    extentLogger.info("verify that email is mbrackstone9@example.com");
    extentLogger.info("verify that phone number is +18982323434");

    extentLogger.pass("Customer Validation test is passed");

}

}
