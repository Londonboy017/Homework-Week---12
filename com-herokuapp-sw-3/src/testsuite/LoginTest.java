package testsuite;

import browserfactory.BaseTest;
import browserfactory.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends Utility {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        //from BaseTest class.. calling method
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){

        sendTextToElement(By.id("username"),"tomsmith");
        //to find the password field element
        sendTextToElement(By.name("password"),"SuperSecretPassword!");
        //find login element and click
        clickOnElement(By.cssSelector("i.fa.fa-2x.fa-sign-in"));
        //Verify expected text
        assertVerifyText(By.tagName("h2"),"Secure Area");
    }
    @Test
    public void verifyTheUsernameErrorMessage(){
       //find username fied and send values
        sendTextToElement(By.id("username"),"tomsmith1");

        //to find the password field element
        sendTextToElement(By.name("password"),"SuperSecretPassword!");

        //find login element and click
        clickOnElement(By.cssSelector("i.fa.fa-2x.fa-sign-in"));
        //find 'Your username is invalid!' erroe message on webpage
        assertVerifyText(By.xpath("//div[@id='flash']"),"Your username is invalid!");

    }
    @Test
    public void verifyThePasswordErrorMessage(){
//find username fied and send values
        sendTextToElement(By.id("username"),"tomsmith");

        //to find the password field element
        sendTextToElement(By.name("password"),"SuperSecretPassword");

        //find login element and click
        clickOnElement(By.cssSelector("i.fa.fa-2x.fa-sign-in"));
        //find 'Your username is invalid!' erroe message on webpage
        assertVerifyText(By.xpath("//div[@id='flash']"),"Your password is invalid!");
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
