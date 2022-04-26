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
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setBaseUrl() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //find username filed and send values
        sendTextToElement(By.id("txtUsername"),"Admin");
        //find password field and send values
        sendTextToElement(By.name("txtPassword"),"admin123");
        //find element for Login button and click
        clickOnElement(By.className("button"));
        //find 'welcome' on webpage and verify the text
        WebElement welcome = driver.findElement(By.id("welcome"));
        String actualText= getTextFromElement(By.id("welcome"));
        //check 'welcome' is displayed or not.
        if(welcome.isDisplayed()){
            System.out.println("'welcome' is displayed");
        }else {
            System.out.println("'welcome' is not displayed");
        }

    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
