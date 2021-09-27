package com.cybertek.reviews.week_05_25_09_2021;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ListElementsExample {
    WebDriver driver;
    Faker faker = new Faker();

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Registration Form")).click();

    }

    /*
Test case #2
Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
Step 2. Click on “Registration Form”
Step 3. Verify that following options for programming languages are displayed: C++, Java, JavaScript
     */
    @Test
    public void task2(){
        List<WebElement> elements = driver.findElements(By.cssSelector(".form-check.form-check-inline"));

        List <String> actualCodeNames = new ArrayList<>();

        for (WebElement element : elements) {
            actualCodeNames.add(element.getText());
        }

//        Assert.assertEquals(elements.get(0).getText(), "C++");
//        Assert.assertEquals(elements.get(1).getText(), "Java");
//        Assert.assertEquals(elements.get(2).getText(), "JavaScript");

        List <String> expectedCodeNames = Arrays.asList("C++", "Java", "JavaScript");
        System.out.println("expectedCodeNames = " + expectedCodeNames);

        Assert.assertEquals(actualCodeNames,expectedCodeNames);

    }

     /*
    Test case #5
Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 2. Click on “Registration Form”
Step 3. Enter any valid first name.
Step 4. Enter any valid last name.
Step 5. Enter any valid user name.
Step 6. Enter any valid password.
Step 7. Enter any valid phone number.
Step 8. Select gender.
Step 9. Enter any valid date of birth.
Step 10. Select any department.
Step 11. Enter any job title.
Step 12. Select java as a programming language.
Step 13. Click Sign up.
Step 14. Verify that following success message is displayed: “You've successfully completed
registration!”
Note: for using dropdown, please refer to the documentation: https://selenium.dev/selenium/
docs/api/java/org/openqa/selenium/support/ui/Select.html or, please watch short video about dropdowns
that is posted on canvas.
     */

    @Test
    public void test5() throws InterruptedException {
        driver.findElement(By.name("firstname")).sendKeys(faker.name().firstName());
        driver.findElement(By.cssSelector("[name='lastname']")).sendKeys(faker.name().lastName());
        driver.findElement(By.cssSelector("[name='username']")).sendKeys(faker.regexify("[a-z1-9]{10}"));
        driver.findElement(By.cssSelector("[name='email']")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.cssSelector("[name='password']")).sendKeys(faker.internet().password());
        driver.findElement(By.cssSelector("[name='phone']")).sendKeys("571-123-4567"); //faker.phoneNumber().cellPhone()
        driver.findElement(By.cssSelector("[value='male']")).click();
        driver.findElement(By.cssSelector("[name='birthday']")).sendKeys("12/12/2020");

        WebElement department = driver.findElement(By.name("department"));
        Select departmentDropDown = new Select(department);
        departmentDropDown.selectByIndex(1);

        WebElement jobTitle = driver.findElement(By.cssSelector("[name='job_title']"));
        Select jobTitleDropDown = new Select(jobTitle);
        jobTitleDropDown.selectByIndex(4);

        List<WebElement> programmingCheckBoxes = driver.findElements(By.xpath("//*[.='Select programming languages']/following-sibling::div/div"));
        programmingCheckBoxes.get(1).click();

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#wooden_spoon")).click();

//        String currentWindowHandle = driver.getWindowHandle();
//        Set<String> windowHandles = driver.getWindowHandles();
//
//        for (String handle : windowHandles) {
//            if(!handle.equals(currentWindowHandle)){
//                break;
//            }
//        }

        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p")));

        String expectedMessage = "You've successfully completed registration!";
        String actualMessage = driver.findElement(By.xpath("//p")).getText();

        Assert.assertEquals(actualMessage,expectedMessage,"registration failed");

    }

}
