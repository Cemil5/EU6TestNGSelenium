package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {

    public LoginPage(){
        // This page doesn't have common features with BasePage, and we didn't extend to BasePage. Other pages has
        // common features and we extend them.

        PageFactory.initElements(Driver.get(),this);    //we can use the annotation in this class
        // for locators by this keyword
    }


    // driver.findElement(By.id("prependedInput"));
  /*  @FindAll({
            @FindBy(id = "prependedInput"),
            @FindBy(name = "_username")
    })
    // we can use 8 different locators we learned
   */
    @FindBy(id = "prependedInput")
    public WebElement usernameInput;

    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    @FindBy(id = "_submit")
    public WebElement loginBtn;

    @FindBy(css = ".btn.btn-primary")
    public List<WebElement> buttons;

    public void login(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    public void loginAsStoremanager() {

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

        login(username, password);
    }

    public void loginAsDriver() {

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        login(username, password);
    }
    public void loginAsSalesManager () {

        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");

        login(username, password);
    }
}
