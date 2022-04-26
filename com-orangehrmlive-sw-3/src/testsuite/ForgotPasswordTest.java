package testsuite;

import browserfactory.BaseTest;
import browserfactory.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends Utility {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setBaseUrl() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully() {
        //find element for 'Forgot your password?' link
        clickOnElement(By.xpath("//a[contains(text(),'Forgot your password?')]"));
     //verify expected text
        assertVerifyText(By.tagName("h1"),"Forgot Your Password?");

    }


    @After
    public void tearDown() {
        closeBrowser();
    }
}
