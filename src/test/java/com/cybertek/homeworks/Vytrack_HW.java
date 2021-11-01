package com.cybertek.homeworks;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Vytrack_HW extends TestBase {
   /*
1. Go to “https://qa1.vytrack.com/"
2. Login as a store manager
3. Navigate to “Activities -> Calendar Events”
4. Verify that page subtitle "Options" is displayed
    */

    @Test
    public void test1(){
        extentLogger = report.createTest("Calendar Event test");

        extentLogger.info("Go to “https://qa1.vytrack.com/\"");
        LoginPage loginPage = new LoginPage();
        extentLogger.info("Login as a store manager");
        loginPage.loginAsStoremanager();

        extentLogger.info("Navigate to “Activities -> Calendar Events”");
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        extentLogger.info("Verify that page subtitle \"Options\" is displayed");
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        Assert.assertTrue(calendarEventsPage.optionsLink.isDisplayed(),"Verify that page subtitle \"Options\" is displayed");
    }

    /*
1. Go to “https://qa1.vytrack.com/"
2. Login as a store manager
3. Navigate to “Activities -> Calendar Events”
4. Verify that page number is equals to "1"
     */

    @Test
    public void test2(){
        extentLogger = report.createTest("Calendar Event test");

        extentLogger.info("Go to “https://qa1.vytrack.com/\"");
        LoginPage loginPage = new LoginPage();
        extentLogger.info("Login as a store manager");
        loginPage.loginAsStoremanager();

        extentLogger.info("Navigate to “Activities -> Calendar Events”");
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        extentLogger.info("Verify that page number is equals to \"1\"");
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        Assert.assertEquals(calendarEventsPage.pageNumber.getAttribute("value"),"1","Verify that page number is " +
                "equals to \"1\"");
    }

/*
1. Go to “https://qa1.vytrack.com/"
2. Login as a store manager
3. Navigate to “Activities -> Calendar Events”
4. Verify that view per page number is equals to "25"
 */

    @Test
    public void test3() {
        extentLogger = report.createTest("Calendar Event test");

        extentLogger.info("Go to “https://qa1.vytrack.com/\"");
        LoginPage loginPage = new LoginPage();
        extentLogger.info("Login as a store manager");
        loginPage.loginAsStoremanager();

        extentLogger.info("Navigate to “Activities -> Calendar Events”");
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        extentLogger.info("Verify that view per page number is equals to \"25\"");
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
      //  Assert.assertEquals(calendarEventsPage.perPageNumber.getAttribute("innerHTML"), "25", "Verify that view per
        //  ");
      //  BrowserUtils.waitFor(3);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[class='loader-mask shown']")));
     //   calendarEventsPage.waitUntilLoaderScreenDisappear();

        System.out.println(calendarEventsPage.perPageNumber.getText().trim());
        Assert.assertTrue(calendarEventsPage.perPageNumber.getAttribute("outerHTML").contains("25"), "Verify that " +
                "view per ");
    }
/*
Test case #4
1. Go to “https://qa1.vytrack.com/"
2. Login as a store manager
3. Navigate to “Activities -> Calendar Events”
4. Verify that number of calendar events (rows in the table) is equals to number of records
 */
@Test
public void test4() {
    extentLogger = report.createTest("Calendar Event test");

    extentLogger.info("Go to “https://qa1.vytrack.com/\"");
    LoginPage loginPage = new LoginPage();
    extentLogger.info("Login as a store manager");
    loginPage.loginAsStoremanager();

    extentLogger.info("Navigate to “Activities -> Calendar Events”");
    DashboardPage dashboardPage = new DashboardPage();
    dashboardPage.navigateToModule("Activities", "Calendar Events");

    extentLogger.info("Verify that number of calendar events (rows in the table) is equals to number of records");
    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
    calendarEventsPage.waitUntilLoaderScreenDisappear();

    Assert.assertEquals(calendarEventsPage.getTableRowNumber(),calendarEventsPage.getRecordNumber(),"rows in\n" +
            "the table) is equals to number of records");
    }
/*
1. Go to “https://qa1.vytrack.com/"
2. Login as a store manager
3. Navigate to “Activities -> Calendar Events”
4. Click on the top checkbox to select all
5. Verify that all calendar events were selected
 */
@Test
public void test5() {
    extentLogger = report.createTest("Calendar Event test");

    extentLogger.info("Go to “https://qa1.vytrack.com/\"");
    LoginPage loginPage = new LoginPage();
    extentLogger.info("Login as a store manager");
    loginPage.loginAsStoremanager();

    extentLogger.info("Navigate to “Activities -> Calendar Events”");
    DashboardPage dashboardPage = new DashboardPage();
    dashboardPage.navigateToModule("Activities", "Calendar Events");

    extentLogger.info("Click on the top checkbox to select all");
    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
    calendarEventsPage.waitUntilLoaderScreenDisappear();
    calendarEventsPage.mainCheckBox.click();

    extentLogger.info("Verify that all calendar events were selected");
    Assert.assertTrue(calendarEventsPage.checkEachBoxes(),"Verify that all calendar events were selected");
    }
    /*
Test Case #6
1. Go to “https://qa1.vytrack.com/"
2. Login as a store manager
3. Navigate to “Activities -> Calendar Events”
4. Select “Testers meeting”
5. Verify that following data is displayed:

Title       : Testers meeting
Description : This is a weekly testers meeting
Start       : Nov 27, 2019, 9:30 AM
End         : Nov 27, 2019, 10:30 AM
All-Day Event   : No
Organizer   : Stephan Haley
Guests      : Tom Smith
Recurrence  : Weekly every 1 week on Wednesday
Call Via Hangout : No
     */

    @Test
    public void test6() {

        extentLogger = report.createTest("Calendar Event test");

        extentLogger.info("Go to “https://qa1.vytrack.com/\"");
        LoginPage loginPage = new LoginPage();
        extentLogger.info("Login as a store manager");
        loginPage.loginAsStoremanager();

        extentLogger.info("Navigate to “Activities -> Calendar Events”");
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        extentLogger.info("Select “Testers meeting”");
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.testersMeeting.click();

        extentLogger.info("Verify that following data is displayed");
        Map<String, String> expectedTable = new LinkedHashMap<>();
        expectedTable.put("Title","Testers Meeting");
        expectedTable.put("Description","This is a a weekly testers meeting");
        expectedTable.put("Start","Nov 27, 2019, 9:30 AM");
        expectedTable.put("End","Nov 27, 2019, 10:30 AM");
        expectedTable.put("All-Day Event","No");
        expectedTable.put("Organizer","John Doe");
        expectedTable.put("Recurrence","Weekly every 1 week on Wednesday");
        expectedTable.put("Call Via Hangout","No");

        Map<String, String> actualTable = new LinkedHashMap<>();
        List<WebElement> lists = driver.findElements(By.xpath("//div[@class='responsive-block']/div"));

        for (WebElement list : lists) {
            String[] keyValue = list.getText().trim().split("\n");
            //    System.out.println( keyValue[0] + " : " + keyValue[1]);
            actualTable.put(keyValue[0], keyValue[1]);
        }
        Assert.assertEquals(actualTable,expectedTable);

//        for (WebElement list : lists) {
//            System.out.println(list.getText());
//        }
//        System.out.println("--------------------------");
//
//        System.out.println("get0 :" + lists.get(0).getText().trim().split("\n")[0]+ "|");
//        System.out.println("get1 :" + lists.get(0).getText().trim().split("\n")[1]+ "||");

//        int i = 1;
//        for ( String key:expectedTable.keySet()) {
//            System.out.println(lists.get(i).getText().trim()+" | " + expectedTable.get(key));
////           if (!lists.get(i).getText().trim().equals(expectedTable.get(key))){
////                System.out.println(lists.get(i).getText().trim()+" | " + expectedTable.get(key));
////                System.out.println("not equals");
////                break;
////            }
//            i +=2;
//        }



        /*
        for (int i = 1; i < lists.size(); i+=2) {
            if (lists.get(i).getText().trim().equals(expectedTable.get(key))
            System.out.println(lists.get(i).getText().trim() + "\n " + lists.get(i+1).getText().trim());
        }



        for (int i = 0; i < lists.size(); i+=2) {
            actualTable.put(lists.get(i).getText().trim(),lists.get(i+1).getText().trim());
            System.out.println(lists.get(i).getText().trim() + "\n " + lists.get(i+1).getText().trim());
        }

        for (String key : actualTable.keySet()){
            System.out.println(key + " | " + actualTable.get(key));
        }
*/

    }



}
