package com.cybertek.tests.day07_TestNG;

import org.testng.annotations.*;

public class BeforeAfterMethod {

    @BeforeClass
    public void setUpClass(){
        System.out.println("--BEFORE CLASS--");
        System.out.println("executed one time before the class");
    }

    @Test
    public void test1(){
        System.out.println("first test case");
    }

    @Test
    public void test2(){
        System.out.println("second test case");
    }

    @Test
    public void test3(){
        System.out.println("third test case");
    }

    @BeforeMethod
    public void setUp(){
        System.out.println("after method");
        System.out.println("WebDriver, Opening Browser");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("after method");
        System.out.println("closing browser, quit");
    }
    @AfterClass
    public void tearDownClass(){
        System.out.println("--AFTER CLASS--");
        System.out.println("Some Reporting Code Here");
    }
}
