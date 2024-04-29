package homeworks;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class _RegistrationForm {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
         driver = WebDriverFactory.getDriver("chrome");
         driver.manage().window().maximize();
         driver.get("https://practice-cybertekschool.herokuapp.com");
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
         driver.findElement(By.partialLinkText("Registration")).click();
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
     //   driver.close();
    }

    @Test
    public void test1(){
        WebElement birthInputBox = driver.findElement(By.cssSelector("[name='birthday']"));
        birthInputBox.sendKeys("wrong_dob");

        String expectedMessage = "The date of birth is not valid";
        String actualMessage = driver.findElement(By.cssSelector("[data-bv-validator='date']")).getText();

        Assert.assertEquals(actualMessage,expectedMessage,"verification of date of birth message failed");

    }

    /*
    Test case #1
Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 2. Click on “Registration Form”
Step 3. Enter “wrong_dob” into date of birth input box.
Step 4. Verify that warning message is displayed:
“The date of birth is not valid”
*/
    /*
Test case #2
Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 2. Click on “Registration Form”
Step 3. Verify that following options for programming languages are displayed: C++, Java, JavaScript
     */

    @Test
    public void test2(){
        List<WebElement> programmingCheckBoxes = driver.findElements(By.xpath("//*[.='Select programming languages']/following-sibling::div/div"));
        String [] expectedLanguages = {"C++", "Java", "JavaScript"};

        System.out.println(programmingCheckBoxes.size());
        Assert.assertEquals(programmingCheckBoxes.size(), 3, "check box size is not 3");

        for (int i=0; i<3; i++) {
            String actualLanguages = programmingCheckBoxes.get(i).getText();
            Assert.assertEquals(actualLanguages,expectedLanguages[i], actualLanguages + " is not displayed");
        }

    }

    /*
    Test case #3
Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 2. Click on “Registration Form”
Step 3. Enter only one alphabetic character into first name input box.
Step 4. Verify that warning message is displayed:
“first name must be more than 2 and less than 64 characters long”
     */

    @Test
    public void test3(){
        WebElement firstNameInputBox = driver.findElement(By.cssSelector("[name='firstname']"));
        firstNameInputBox.sendKeys("E");
        String expectedMessage = "first name must be more than 2 and less than 64 characters long";
        String actualMessage = driver.findElement(By.xpath("//input[@name='firstname']/following-sibling::small[@data" +
                "-bv-validator='stringLength']")).getText();

        Assert.assertEquals(actualMessage,expectedMessage,"first name message failed");
    }

    /*
    Test case #4
Step 1. Go to https://practicecybertekschool.herokuapp.com
Step 2. Click on “Registration Form”
Step 3. Enter only one alphabetic character into last name input box.
Step 4. Verify that warning message is displayed:
“The last name must be more than 2 and less than 64 characters long”
     */
    @Test
    public void test4(){
        WebElement firstNameInputBox = driver.findElement(By.cssSelector("[name='lastname']"));
        firstNameInputBox.sendKeys("E");
        String expectedMessage = "The last name must be more than 2 and less than 64 characters long";
        String actualMessage = driver.findElement(By.xpath("//input[@name='lastname']/following-sibling::small[@data" +
                "-bv-validator='stringLength']")).getText();

        Assert.assertEquals(actualMessage,expectedMessage,"first name message failed");
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
        driver.findElement(By.cssSelector("[name='firstname']")).sendKeys("abc");
        driver.findElement(By.cssSelector("[name='lastname']")).sendKeys("def");
        driver.findElement(By.cssSelector("[name='username']")).sendKeys("deffhij");
        driver.findElement(By.cssSelector("[name='email']")).sendKeys("mike@smith.com");
        driver.findElement(By.cssSelector("[name='password']")).sendKeys("deffhijag");
        driver.findElement(By.cssSelector("[name='phone']")).sendKeys("571-123-4567");
        driver.findElement(By.cssSelector("[value='male']")).click();
        driver.findElement(By.cssSelector("[name='birthday']")).sendKeys("12/12/2020");

        WebElement department = driver.findElement(By.cssSelector("[name='department']"));
        Select departmentDropDown = new Select(department);
        departmentDropDown.selectByIndex(1);

        WebElement jobTitle = driver.findElement(By.cssSelector("[name='job_title']"));
        Select jobTitleDropDown = new Select(jobTitle);
        jobTitleDropDown.selectByIndex(4);

        List<WebElement> programmingCheckBoxes = driver.findElements(By.xpath("//*[.='Select programming languages']/following-sibling::div/div"));
        programmingCheckBoxes.get(1).click();

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#wooden_spoon")).click();

        String currentWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles) {
            if(!handle.equals(currentWindowHandle)){
                break;
            }
        }

        String expectedMessage = "You've successfully completed registration!";
        String actualMessage = driver.findElement(By.xpath("//p")).getText();

        Assert.assertEquals(actualMessage,expectedMessage,"registration failed");

    }


}
