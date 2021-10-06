package com.cybertek.pages;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);    //we can use the annotation in this class
        // for locators by this keyword
    }


    // driver.findElement(By.id("prependedInput"));
    @FindBys({
            @FindBy(id = "prependedInput"),
            @FindBy(name = "_username")
    })// we can use 8 different locators we learned
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

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

        loginPage.login(username, password);
    }
}
