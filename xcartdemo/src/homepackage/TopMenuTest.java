package homepackage;

import browserfactory.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import sun.nio.cs.UTF_32LE;

public class TopMenuTest extends Utility {
    String baseUrl ="https://mobile.x-cart.com/";
    @Before
    public  void SetUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyUserShouldNavigateToShippingPageSuccessfully(){
        //click on Shipping
        clickOnElement(By.linkText("Shipping"));
        //verify the text
        assertVerifyText(By.xpath("//h1[@id='page-title']"),"Shipping");
    }
    @Test
    public void verifyUserShouldNavigateToNewPageSuccessfully(){
        //click on New!
        clickOnElement(By.linkText("New!"));
        //verify the text
        assertVerifyText(By.xpath("//h1[@id='page-title']"),"New arrivals");
    }
    @Test
    public void verifyUserShouldNavigateToComingsoonPageSuccessfully(){
        //click on Coming soon
        clickOnElement(By.linkText("Coming soon"));
        //verify the text
        assertVerifyText(By.xpath("//h1[@id='page-title']"),"Coming soon");
    }
    @Test
    public void verifyUserShouldNavigateToContactUsPageSuccessfully(){
        //click on Contact us
        clickOnElement(By.linkText("Contact us"));
        //verify the text
        assertVerifyText(By.xpath("//h1[@id='page-title']"),"Contact us");
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
