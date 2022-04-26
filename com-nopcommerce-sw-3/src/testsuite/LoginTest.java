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
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        //from BaseTest class.. calling method
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //Find log in link and click on login link
        clickOnElement(By.linkText("Log in"));

        //This is from requirement
        String expectedMessage = "Welcome, Please Sign In!";

        //Find the welcome text element and get the text
        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]\n"));
        String actualMessage = actualMessageElement.getText();

        //validate actual and expected message
        assertVerifyText(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]\n"), "Welcome, Please Sign In!");
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Find log in link and click on login link
        clickOnElement(By.linkText("Log in"));

        //to find the email field element
        sendTextToElement(By.id("Email"), "jay12345@gmail.com");

        //to find the password field element
        sendTextToElement(By.name("Password"), "Jay@123");

        //find login element and click
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));

        //find logout button on webpage
        WebElement logoutElement = driver.findElement(By.className("ico-logout"));

        if (logoutElement.isDisplayed()) {
            System.out.println("Verification Successful - 'Log out' is displayed on the web page");
        } else {
            System.out.println("Verification Unsuccessful - 'Log out' is not displayed on the web page");
        }
    }

    @Test
    public void verifyTheErrorMessage() {
        //Find log in link and click on login link
        clickOnElement(By.linkText("Log in"));

        //to find the email field element
        sendTextToElement(By.id("Email"), "jay1234@gmail.com");

        //to find the password field element
        sendTextToElement(By.name("Password"), "Jay@12");

        //find login element and click
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));

        //validate actual and expected text
        assertVerifyText(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]"), "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found");

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
