package com.cybertek.tests.day07_TestNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {

    @BeforeMethod
    public void setUp(){
        System.out.println("open browser");
    }

    @Test
    public void test1(){

        System.out.println("first assertion");
        Assert.assertEquals("title", "title ");

        System.out.println("second assertion");
        Assert.assertEquals("url","url");
    }
    @Test
    public void test2(){
        System.out.println("test case 2");
        Assert.assertEquals("test2", "test2", "verify test2");
    }

    @Test
    public void test3(){
        String expectedTitle = "Cyb";
        String actualTitle = "Cybertek";

        if (actualTitle.startsWith(expectedTitle)){
            System.out.println("true");
        }

        Assert.assertTrue(actualTitle.startsWith(expectedTitle), "verify title starts with Cyb");

    }

    @Test
    public void test4(){
        String email = "mike@smith.com";

        Assert.assertTrue(email.contains("@"),"verify email contains @");
    }

    @Test
    public void test5(){
        Assert.assertFalse(0>1, "verify that 0 is not greater than 1"); // no complain, test PASS
    }

    @Test
    public void test6(){
        Assert.assertNotEquals("one", "two");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("close browser");
    }

}
