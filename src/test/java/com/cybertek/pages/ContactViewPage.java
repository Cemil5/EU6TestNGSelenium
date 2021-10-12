package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactViewPage extends BasePage {

    @FindBy(className = "user-name")
    public WebElement fullName;

    @FindBy(css = "a.email")
    public WebElement email;

    @FindBy(css = "a.phone")
    public WebElement phone;





}
