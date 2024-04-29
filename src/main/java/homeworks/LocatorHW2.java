package homeworks;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorHW2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement home = driver.findElement(By.xpath("//a[.='Home']"));
        System.out.println("home = " + home.getText());

        WebElement forgotPassword = driver.findElement(By.xpath("//h2"));
        System.out.println("forgotPassword = " + forgotPassword.getText());

        WebElement email = driver.findElement(By.xpath("//label"));
        System.out.println("email = " + email.getText());

        WebElement emailInputBox = driver.findElement(By.xpath("//input[@type='text']"));
        emailInputBox.sendKeys("mike@smith.com");

        WebElement retrievePassword = driver.findElement(By.xpath("//button"));
        System.out.println("retrievePassword = " + retrievePassword.getText());


        Thread.sleep(2000);
        driver.quit();
    }
    /*
    XPATH PRACTICES
DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
3. Locate all the WebElements on the page using XPATH locator only (total of 6)
   a. “Home” link
   b. “Forgot password” header
   c. “E-mail” text
   d. E-mail input box
   e. “Retrieve password” button
4.Print text of a,b,c,e and put some email to d
     */
}
