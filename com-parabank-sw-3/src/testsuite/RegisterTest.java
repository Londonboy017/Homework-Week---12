package testsuite;

import browserfactory.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.rmi.CORBA.Util;

public class RegisterTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSigningUpPageDisplay() {
        //find Register and click
        clickOnElement(By.xpath("//a[text()='Register']"));

        //validate actual and expected text
        assertVerifyText(By.xpath("//h1[text()='Signing up is easy!']"),"Signing up is easy!");
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        //find Register and click
        clickOnElement(By.xpath("//a[text()='Register']"));

        //find first name and send value
        sendTextToElement(By.xpath("//input[@id=\"customer.firstName\"]"),"kesha");

        //find last name and send value
        sendTextToElement(By.name("customer.lastName"),"Patel");
        //find address field and send value
        sendTextToElement(By.id("customer.address.street"),"11,Xy Street");

        //find city field and send value
        sendTextToElement(By.xpath("//input[@name='customer.address.city' or @id='customer.address.city']"),"Colindale,London");
        //find city field and send value
        sendTextToElement(By.xpath("//input[@name='customer.address.state']"),"N/A");

        //find ZipCode field and send values
        sendTextToElement(By.id("customer.address.zipCode"),"NW0 9FC");

        //find phone number field and send values
        sendTextToElement(By.name("customer.phoneNumber"),"7469508204");

        //find SSN and send values
        sendTextToElement(By.name("customer.ssn"),"n/a");

        //find userName and send values
        sendTextToElement(By.name("customer.username"),"Keshal23");

        //find password field and send values
        sendTextToElement(By.name("customer.password"),"Find@134");

        //find confirm password field and send values
        sendTextToElement(By.name("repeatedPassword"),"Find@134");

        //find registor button and click
        clickOnElement(By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input"));


        //validate actual and expected text
        assertVerifyText(By.xpath("//p[contains(text(),'Your account was created successfully. You are now logged in')]"),"Your account was created successfully. You are now logged in.");
    }

    @After
    public void tearDown() {
        closeBrowser();
    }


}
