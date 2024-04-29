package homeworks;

import com.cydeo.pages.TechrunchPage;
import com.cydeo.tests.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class commencis_techruch extends TestBase {

    @Test
    public void test1(){

        TechrunchPage techrunchPage = new TechrunchPage();
        driver.get("https://techcrunch.com/");
        for (WebElement element : techrunchPage.articles) {
            System.out.println(element);
        }


    }


}
