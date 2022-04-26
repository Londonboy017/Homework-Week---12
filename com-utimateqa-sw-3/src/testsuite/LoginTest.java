package testsuite;

import browserfactory.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends Utility {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        //from Utility class.. calling method
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //Find log in link and click on login link
        clickOnElement(By.xpath("//a[contains(text(),'Sign In')]"));

        //validate actual and expected message
        assertVerifyText(By.xpath("//h1[@class='page__heading']"),"Welcome Back!");
    }

    @Test
    public void verifyTheErrorMessage(){
        //Find log in link and click on login link
        clickOnElement(By.xpath("//a[contains(text(),'Sign In')]"));
        //find email filed element and send values
        sendTextToElement(By.id("user[email]"),"jay1234@gmail.com");

        //to find the password field element and send values
        sendTextToElement(By.name("user[password]"),"Jay@1233");

        //find sign in button element and click
        clickOnElement(By.xpath("//input[@class='button button-primary g-recaptcha']"));

        //validate actual and expected text
        assertVerifyText(By.xpath("//li[contains(text(),'Invalid email or password.')]"),"Invalid email or password.");
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
