package com.cydeo.tests.day16_DataDrivenFramework;

import com.cydeo.pages.DashboardPage;
import com.cydeo.pages.LoginPage;
import com.cydeo.tests.TestBase;
import com.cydeo.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class DDFLoginTest extends TestBase {
    @DataProvider
    public Object [][] userData(){

        ExcelUtil qa3short = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA3-short");

        String [][] dataArray =qa3short.getDataArrayWithoutFirstRow();

        return dataArray;
    }

    @Test(dataProvider = "userData")
    public void test1(String username,String password,String firstName,String lastName){
        extentLogger=report.createTest("Test "+firstName+" "+lastName);
        LoginPage loginPage = new LoginPage();

        loginPage.login(username,password);

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();

        String actualFullName = dashboardPage.getUserName();
        String expectedFullName = firstName+" "+lastName;

        Assert.assertEquals(actualFullName,expectedFullName,"verify fullname");
        extentLogger.pass("PASSED");
    }

    @Test()
    public void test2(){
        System.out.println(Arrays.deepToString(userData()));
    }

}
