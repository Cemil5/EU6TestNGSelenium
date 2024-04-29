package com.cydeo.tests.day13_pom;

import com.cydeo.pages.CalendarEventsPage;
import com.cydeo.pages.CreateCalendarEventsPage;
import com.cydeo.pages.DashboardPage;
import com.cydeo.pages.LoginPage;
import com.cydeo.tests.TestBase;
import com.cydeo.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatOptionsTests extends TestBase {

 /*VERIFY RADIO BUTTONS
    Open Chrome browser
    Login as driver
    Go to Activities->Calendar Events
    Click on create calendar events
    Click on repeat
    Verify that repeat every days is checked
    verify that repeat weekday is not checked
    * */

    @Test
    public void test1(){

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();



        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.navigateToModule("Activities", "Calendar Events");

        calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForClickablility(calendarEventsPage.createCalendarEvent,5);
     //   BrowserUtils.waitFor(3);
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();

        Assert.assertTrue(createCalendarEventsPage.days.isSelected(),"Verify that repeat every days is checked");
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected(), "verify that repeat weekday is not checked");

    }

     /*
     VERIFY REPEAT OPTIONS
        Open Chrome browser
        Login as driver
        Go to Activities->Calendar Events
        Click on create calendar events button
        Click on repeat checkbox
        Verify that repeat options are Daily, Weekly, Monthly,Yearly(in this order)
     */

    @Test
    public void test2(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();

     //  Verify that repeat options are Daily, Weekly, Monthly,Yearly(in this order)

     //   Select repeatOpts = new Select(createCalendarEventsPage.repeatOptions);
        Select repeatOpts = createCalendarEventsPage.repeatOptionsList();

        List<WebElement> repeatList = repeatOpts.getOptions();
        Assert.assertEquals(repeatList.size(),4,"list size");

     //  ArrayList<String> expectedList = new ArrayList<>();
     //  expectedList.addAll(Arrays.asList("Daily", "Weekly", "Monthly", "Yearly"));
        List<String> expectedList = Arrays.asList("Daily", "Weekly", "Monthly", "Yearly");

        ArrayList<String> actualList = new ArrayList<>();

        for (WebElement text : repeatList){
            actualList.add(text.getText());
        }
        // browserUtils kullanımı
        List<String> actualList2 = BrowserUtils.getElementsText(repeatList);
        Assert.assertEquals(actualList,expectedList,"verify list");

    }



}
