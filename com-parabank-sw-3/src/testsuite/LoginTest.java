package testsuite;

import browserfactory.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.rmi.CORBA.Util;

public class LoginTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        //from BaseTest class.. calling method
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //find username filed and sen values
        sendTextToElement(By.xpath("//input[@name=\"username\"]"), "Kapil123");

        //to find the password field element
        sendTextToElement(By.xpath("//input[@name=\"password\"]"), "Find@123");

        //find login element and click
        clickOnElement(By.xpath("//input[@value=\"Log In\"]"));

        //validate actual and expected text
        assertVerifyText(By.tagName("h1"), "Accounts Overview");
    }
    @Test
    public void verifyTheErrorMessage() {
        //find username element
        sendTextToElement(By.xpath("//input[@name=\"username\"]"), "london23");

        //to find the password field element
        sendTextToElement(By.xpath("//input[@name=\"password\"]"), "Hind$123");

        //find login element and click
        clickOnElement(By.xpath("//input[@value=\"Log In\"]"));

        //validate actual and expected text
        assertVerifyText(By.tagName("h1"), "The username and password could not be verified.");
    }
@Test
public void userShouldLogOutSuccessfully(){
//find username filed and sen values
    sendTextToElement(By.xpath("//input[@name=\"username\"]"),"Kapil123");

    //to find the password field element
    sendTextToElement(By.xpath("//input[@name=\"password\"]"),"Find@123");

    //find login element and click
    clickOnElement(By.xpath("//input[@value=\"Log In\"]"));

    //find logout element and click
    clickOnElement(By.xpath("//a[@href=\"/parabank/logout.htm\"]"));

    //validate actual and expected text
    assertVerifyText(By.xpath("//h2[contains(text(),'Customer Login')]"),"Customer Login");
}
    @After
    public void tearDown() {
        closeBrowser();
    }
}