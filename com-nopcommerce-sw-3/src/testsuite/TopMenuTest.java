package testsuite;

import browserfactory.BaseTest;
import browserfactory.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToComputerPageSuccessfully(){
        //find computer tab and click
        clickOnElement(By.linkText("Computers"));

        //validate actual and expected text
        assertVerifyText(By.tagName("h1"),"Computers");
    }
    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully(){
        //find electronics tab and click
        clickOnElement(By.linkText("Electronics"));

        //validate actual and expected text
        assertVerifyText(By.tagName("h1"),"Electronics");
    }
    @Test
    public void userShouldNavigateToApparelPageSuccessfully(){
        //find Apparel tab and click
        clickOnElement(By.linkText("Apparel"));
        //validate actual and expected text
        assertVerifyText(By.xpath("//h1[contains(text(),'Apparel')]"),"Apparel");
    }
    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully(){
        //find Digital downloads tab and click
        clickOnElement(By.linkText("Digital downloads"));

        //validate actual and expected text
        assertVerifyText(By.xpath("//h1[contains(text(),'Digital downloads')]"),"Digital downloads");
    }
    @Test
    public void userShouldNavigateToBooksPageSuccessfully(){
        //find Books tab and click
        clickOnElement(By.linkText("Books"));

        //validate actual and expected text
        assertVerifyText(By.xpath("//h1[contains(text(),'Books')]"),"Books");
    }
    @Test
    public void userShouldNavigateToJewelryPageSuccessfully(){
        //find Jewelry tab and click
        clickOnElement(By.xpath("//a[contains(text(),'Jewelry')]"));

        //validate actual and expected text
        assertVerifyText(By.xpath("//h1[contains(text(),'Jewelry')]"),"Jewelry");
    }
    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully(){
        //find Gift Cards tab and click
        clickOnElement(By.xpath("//a[contains(text(),'Gift Cards')]"));

        //validate actual and expected text
        assertVerifyText(By.xpath("//h1[contains(text(),'Gift Cards')]"),"Gift Cards");
    }
@After
    public void tearDown(){
       closeBrowser();
}
}
