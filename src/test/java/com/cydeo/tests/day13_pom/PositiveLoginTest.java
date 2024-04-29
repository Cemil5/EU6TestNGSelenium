package com.cydeo.tests.day13_pom;

import com.cydeo.pages.LoginPage;
import com.cydeo.tests.TestBase;
import com.cydeo.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Scanner;

public class PositiveLoginTest extends TestBase {

    @Test
    public void loginAsDriver(){

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");

    }

    @Test
    public void loginAsStoremanager(){

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

//        loginPage.usernameInput.sendKeys(username);
//        loginPage.passwordInput.sendKeys(password);
//        loginPage.loginBtn.click();

        loginPage.login(username,password);

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");

    }

    @Test
    public void loginAsStoremanager2(){

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

        loginPage.loginAsStoremanager();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/");

    }
    private static String s2 = null;
    @Test
    public void test5(){
        Scanner s = new Scanner(System.in);
        s.nextInt();
        s.nextLine();
        double pi = Math.PI;
        final String s1;
       // System.out.println(s1);
        s1 = "aeiaui";
        s2 = "aeiu" + s1;
    }

}
