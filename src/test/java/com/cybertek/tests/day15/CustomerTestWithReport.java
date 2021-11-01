package com.cybertek.tests.day15;

import com.cybertek.pages.ContactInfoPage;
import com.cybertek.pages.ContactsPage;
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

    String email = "mbrackstone9@example.com";
    String fullName = "Mariam Brackstone";
    String phone = "+18982323434";

    extentLogger = report.createTest("Customer Validation test");

    LoginPage loginPage = new LoginPage();
    extentLogger.info("login as a sales manager");
    loginPage.loginAsSalesManager();

    extentLogger.info("navigate to customers ->contacts");
    DashboardPage dashboardPage = new DashboardPage();
    dashboardPage.navigateToModule("Customers", "Contacts");

    extentLogger.info("click on email " + email);
    ContactsPage contactsPage = new ContactsPage();
    contactsPage.clickEmailBox(email);

    extentLogger.info("verify that full name is " + fullName);
    ContactInfoPage contactInfoPage = new ContactInfoPage();
    Assert.assertEquals(contactInfoPage.fullName.getText(), fullName, "verify full name");

    extentLogger.info("verify that email is "+ email);
    Assert.assertEquals(contactInfoPage.email.getText(), email, "verify email");

    extentLogger.info("verify that phone number is " + phone);
    Assert.assertEquals(contactInfoPage.phone.getText(),phone, "verify phone number");

    extentLogger.pass("passed");

    }

}
