package homeworks;

import com.cydeo.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _TempMail_tc06 {
    WebDriver driver;
    Faker faker = new Faker();
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @Test
    public void testCase06() throws InterruptedException {

        driver.get("https://www.tempmailaddress.com/");
        String email = driver.findElement(By.cssSelector("div>#email")).getText();
        System.out.println("email = " + email);

        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.partialLinkText("Sign Up")).click();

        WebElement inputFullName = driver.findElement(By.cssSelector("input[name='full_name']"));
        inputFullName.sendKeys(Faker.instance().name().fullName());

        WebElement inputEmail = driver.findElement(By.cssSelector("input[name='email']"));
        inputEmail.sendKeys(email);

        WebElement signUpButton = driver.findElement(By.cssSelector("button[name='wooden_spoon']"));
        signUpButton.click();

        String actualMessage = driver.findElement(By.cssSelector("#content>div>h3")).getText();
        String expectedMessage = "Thank you for signing up. Click the button below to return to the home page.";

        Assert.assertEquals(actualMessage, expectedMessage);

        driver.get("https://www.tempmailaddress.com/");
        Thread.sleep(3000);
        String actualIncomingEmail = driver.findElement(By.xpath("(//span[@class='odMobil'])[1]")).getAttribute("innerHTML");
        String expectedIncomingEmail = "do-not-reply@practice.cybertekschool.com";

        Assert.assertEquals(actualIncomingEmail, expectedIncomingEmail);

        driver.findElement(By.xpath("//tbody[@id='schranka']/tr[1]")).click();
        String actualEmail = driver.findElement(By.cssSelector("#odesilatel")).getText();
        String expectedEmail = "do-not-reply@practice.cybertekschool.com";

        Assert.assertEquals(actualEmail, expectedEmail);

        String actualMailSubject = driver.findElement(By.cssSelector("#predmet")).getText();
        String expectedMailSubject = "Thanks for subscribing to practice.cybertekschool.com!";

        Assert.assertEquals(actualMailSubject, expectedMailSubject);

    }

    @Test
    public void test6() {

        driver.get("https://www.tempmailaddress.com/");
        String email = driver.findElement(By.cssSelector("span#email")).getText();
        System.out.println("email = " + email);

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.partialLinkText("Sign")).click();

        driver.findElement(By.cssSelector("[name='full_name']")).sendKeys("test test");
        driver.findElement(By.cssSelector("[name='email']")).sendKeys(email);
        driver.findElement(By.cssSelector("[name='wooden_spoon']")).click();

        String actualText = driver.findElement(By.cssSelector("[name='signup_message']")).getText();
        String expectedText = "Thank you for signing up. Click the button below to return to the home page.";
        Assert.assertEquals(actualText,expectedText,"sign up verification failed");

        driver.findElement(By.cssSelector("#wooden_spoon")).click();

        driver.get("https://www.tempmailaddress.com/");

        String expectedMaildAddress = "do-not-reply@practice.cybertekschool.com";
        String odMobil = driver.findElement(By.className("odMobil")).getAttribute("innerHTML");
        Assert.assertEquals(odMobil,expectedMaildAddress);


        driver.findElement(By.xpath("//table//td[2]")).click();

        expectedMaildAddress = "do-not-reply@practice.cybertekschool.com";
        String actualMailAddress = driver.findElement(By.id("odesilatel")).getText();

        Assert.assertEquals(actualMailAddress,expectedMaildAddress);

        String expectedSubject = "Thanks for subscribing to practice.cybertekschool.com!";
        String actualSubject = driver.findElement(By.id("predmet")).getText();
        Assert.assertEquals(actualSubject,expectedSubject);

    }
    /*
Test case #6
Step 1. Go to "https://www.tempmailaddress.com/"
Step 2. Copy and save email as a string.
Step 3. Then go to “https://practicecybertekschool.herokuapp.com”
Step 4. And click on “Sign Up For Mailing List".
Step 5. Enter any valid name.
Step 6. Enter email from the Step 2.
Step 7. Click Sign Up
Step 8. Verify that following message is displayed:
“Thank you for signing up. Click the button below to return to the home page.”
Step 9. Navigate back to the “https://www.tempmailaddress.com/”
Step 10. Verify that you’ve received an email from
“do-not-reply@practice.cybertekschool.com”
Step 11. Click on that email to open it.
Step 12. Verify that email is from: “do-notreply@practice.cybertekschool.com”
Step 13. Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”
 */



    /*
    Test case #8
Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 2. And click on “Autocomplete”.
Step 3. Enter “United States of America” into country input box.
Step 4. Verify that following message is displayed:
“You selected: United States of America”
     */

    @Test
    public void test8(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Autocomplete")).click();
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        driver.findElement(By.cssSelector("[type='button']")).click();

        String actualText = driver.findElement(By.id("result")).getText();
        String expectedText = "You selected: United States of America";
        Assert.assertEquals(actualText,expectedText,"country text verify failed");

    }
    @Test
    public void test_7(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("File Upload")).click();

        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/file.txt";
        String fullPath = projectPath + "/" + filePath;

        driver.findElement(By.id("file-upload")).sendKeys(fullPath);

        driver.findElement(By.id("file-submit")).click();

        String actualFilename = driver.findElement(By.id("uploaded-files")).getText();

        Assert.assertEquals(actualFilename,"file.txt");
    }
}

/*
Test case #7
Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 2. And click on “File Upload".
Step 3. Upload any file with .txt extension from your computer.
Step 4. Click “Upload” button.
Step 5. Verify that subject is: “File Uploaded!”
Step 6. Verify that uploaded file name is displayed.
Note: use element.sendKeys(“/file/path”) with specifying path to the file for uploading. Run this
method against “Choose File” button.
 */
