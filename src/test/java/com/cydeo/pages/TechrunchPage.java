package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TechrunchPage {
    void Techrunch_basePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(css = "div.river.river--homepage >div>article")
    public List<WebElement> articles;



}
