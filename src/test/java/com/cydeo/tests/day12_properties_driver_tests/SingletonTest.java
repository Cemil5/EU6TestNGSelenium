package com.cydeo.tests.day12_properties_driver_tests;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {

   // @Test
    public void test1(){

        String s1 = Singleton.getInstance();
        String s2 = Singleton.getInstance();

        /*
        result:
        str is null, assigning value it
        it has value, just returning it
*/
    }

    @Test
    public void test2(){
       // WebDriver driver = WebDriverFactory.getDriver("chrome");


        WebDriver driver = Driver.get();
        driver.get("https://www.google.com");

    }
    @Test
    public void test3(){

        WebDriver driver = Driver.get();
        driver.get("https://www.amazon.com");

    }

}
