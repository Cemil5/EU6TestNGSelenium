package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CalendarEventsGridPage {

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "//div[contains(text(),'Options')]")
    public WebElement optionsLink;

    @FindBy(xpath = "//input[@type='number']")
    public WebElement pageNumber;

    @FindBy(xpath = "//button[@data-toggle='dropdown']")
    public WebElement perPageNumber;

    @FindBy(xpath = "//label[contains(.,'Total of')]")
    public WebElement recordNumber;

    @FindBy (xpath = "//table//input[@type='checkbox']")
    public WebElement mainCheckBox;

    @FindBy (xpath = "//td[.='Testers Meeting']")
    public WebElement testersMeeting;

    public Boolean checkEachBoxes (){

        List<WebElement> checkBoxes = Driver.get().findElements(By.xpath("tbody//input[@type='checkbox']"));
        int size = checkBoxes.size();

        for (WebElement checkbox :checkBoxes) {
            if (!checkbox.isSelected()){
                return false;
            }
        }
        return true;
    }

    public Integer getRecordNumber(){
        String result= recordNumber.getText().split(" Of ")[1];
        System.out.println("getRecordNumber1 " + result);

        result= result.split(" Rec")[0];
        System.out.println("getRecordNumber " + result);
        return Integer.parseInt(result);
    }

    public Integer getTableRowNumber(){
        return Driver.get().findElements(By.xpath("//tbody//tr")).size();
    }








}
