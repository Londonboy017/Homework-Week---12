package testsuite;

import browserfactory.BaseTest;
import browserfactory.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        //from BaseTest class.. calling method
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //find userName WebElement and sen values
        sendTextToElement(By.id("user-name"),"standard_user");

        //to find the password field element
        sendTextToElement(By.name("password"),"secret_sauce");

        //find login element and click
        clickOnElement(By.id("login-button"));

        //validate actual and expected text
        assertVerifyText(By.xpath("//span[contains(text(),'Products')]"),"PRODUCTS");
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //find userName WebElement and sen values
        sendTextToElement(By.id("user-name"),"standard_user");

        //to find the password field element
        sendTextToElement(By.name("password"),"secret_sauce");

        //find login element and click
        clickOnElement(By.id("login-button"));

        //count 'PRODUCTS ' on webpage by using item label
        List<WebElement> productsList = driver.findElements(By.cssSelector("div.inventory_item"));
        int sizeOfList = productsList.size();
        System.out.println("Count of products displayed on page is : "+sizeOfList);
        int expecteditems =6;
        Assert.assertEquals("List of products mismatch",expecteditems,sizeOfList);
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
