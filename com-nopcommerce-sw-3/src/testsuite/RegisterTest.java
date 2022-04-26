package testsuite;

import browserfactory.BaseTest;
import browserfactory.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        //find Register and click
        clickOnElement(By.className("ico-register"));

        //find 'Register' text and verify it
        assertVerifyText(By.tagName("h1"),"Register");
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        //find Register and click
        clickOnElement(By.className("ico-register"));

        //find radio element and click
        clickOnElement(By.id("gender-male"));

        //find first name and send value
        sendTextToElement(By.name("FirstName"),"Stuart");

        //find last name and send value
        sendTextToElement(By.name("LastName"),"Little");

        //use SELECT class for dropdown of DOB
        selectByValueFromDropDown(By.xpath("//select[@name='DateOfBirthDay']"),"22");
        selectByIndexFromDropDown(By.xpath("//select[@name='DateOfBirthMonth']"),9);
        selectByValueFromDropDown(By.xpath("//select[@name='DateOfBirthYear']"),"1997");

        //find emailfield and send values
        sendTextToElement(By.id("Email"),"stuart1523@gmail.com");

        //find companyfield and send values
        sendTextToElement(By.name("Company"),"Tesla");

        //find newsletter checkbox and click to unselect it
        clickOnElement(By.cssSelector("#Newsletter"));

        //find password field and send values
        sendTextToElement(By.cssSelector("#Password"),"Find123");

        //find confirm password field and send values
        sendTextToElement(By.name("ConfirmPassword"),"Find123");

        //find Register button and click
        clickOnElement(By.name("register-button"));

        String expectedText = "Your registration completed";
        //validate actual and expected text
        assertVerifyText(By.xpath("//div[contains(text(),'Your registration completed')]"),"Your registration completed");

    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
