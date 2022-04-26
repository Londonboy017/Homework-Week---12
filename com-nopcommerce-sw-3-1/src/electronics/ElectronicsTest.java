package electronics;

import browserfactory.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.regex.Matcher;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void textVerified() {
        //mouse hove on Electronics tab
        mouseHoverOnElement(By.xpath("//a[@href=\"/electronics\"]"));
        //click on cell phones
        clickOnMouseHoverOnElement(By.xpath("//a[text()='Cell phones ']"));
        //verify text
        assertVerifyText(By.tagName("h1"), "Cell phones");
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //mouse hove on Electronics tab
        mouseHoverOnElement(By.xpath("//a[@href=\"/electronics\"]"));
        //click on cell phones
        clickOnMouseHoverOnElement(By.xpath("//a[text()='Cell phones ']"));
        //verify text
        assertVerifyText(By.tagName("h1"), "Cell phones");
        //click on list view tab
        clickOnElement(By.xpath("//a[@class=\"viewmode-icon list\"]"));
        Thread.sleep(1000);
        //click on nokia lumia 1020
        clickOnElement(By.xpath("//a[@href=\"/nokia-lumia-1020\"]"));
        //verify the price
        assertVerifyText(By.id("price-value-20"), "$349.00");
        //select the quantity
        Actions actions = new Actions(driver);
        driver.findElement(By.id("product_enteredQuantity_20")).sendKeys(Keys.CONTROL + "a");
        Thread.sleep(3000);
        //update the quantity
        sendTextToElement(By.id("product_enteredQuantity_20"), "2");
        //click on add to cart
        clickOnElement(By.id("add-to-cart-button-20"));
        //verify the message
        assertVerifyText(By.xpath("//p[@class=\"content\"]"), "The product has been added to your shopping cart");
        //close the title bar
        clickOnElement(By.xpath("//span[@class=\"close\"]"));
        //mouse hover on shopping cart
        mouseHoverOnElement(By.className("cart-label"));
        //click on go to cart
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        //verify the message
        assertVerifyText(By.tagName("h1"), "Shopping cart");
        //verify the quantity
        Thread.sleep(3000);
        // identify element
        WebElement xyz = driver.findElement(By.xpath("//input[@class=\"qty-input\"]"));
        // get value attribute with getAttribute()
        String qty = xyz.getAttribute("value");
        //verify the quantity
        Assert.assertEquals("Error> Quantity mismatch:", "2", qty);
        //verify the price
        assertVerifyText(By.xpath("//tbody/tr[1]/td[6]/span[1]"), "$698.00");
        //click on checkbox of terms and condition
        clickOnElement(By.xpath("//input[@name='termsofservice']"));
        //click on check out
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //verify the text welcome
        assertVerifyText(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"), "Welcome, Please Sign In!");
        //click on registration
        clickOnElement(By.xpath("//a[@class ='ico-register']"));
        //verify the text
        assertVerifyText(By.tagName("h1"), "Register");
        //find radio element and click
        clickOnElement(By.id("gender-male"));
        //find first name and send value
        sendTextToElement(By.name("FirstName"), "Stuart");

        //find last name and send value
        sendTextToElement(By.name("LastName"), "Roysla");

        //use SELECT class for dropdown of DOB
        selectByValueFromDropDown(By.xpath("//select[@name='DateOfBirthDay']"), "2");
        selectByIndexFromDropDown(By.xpath("//select[@name='DateOfBirthMonth']"), 9);
        selectByValueFromDropDown(By.xpath("//select[@name='DateOfBirthYear']"), "1977");

        //find emailfield and send values
        sendTextToElement(By.id("Email"), "stuart980@gmail.com");

        //find companyfield and send values
        sendTextToElement(By.name("Company"), "Tesla");

        //find newsletter checkbox and click to unselect it
        clickOnElement(By.cssSelector("#Newsletter"));

        //find password field and send values
        sendTextToElement(By.cssSelector("#Password"), "Find123");

        //find confirm password field and send values
        sendTextToElement(By.name("ConfirmPassword"), "Find123");

        //find Register button and click
        clickOnElement(By.name("register-button"));

        String expectedText = "Your registration completed";
        //validate actual and expected text
        assertVerifyText(By.xpath("//div[contains(text(),'Your registration completed')]"), "Your registration completed");
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        assertVerifyText(By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart");

        clickOnElement(By.id("termsofservice"));
        clickOnElement(By.id("checkout"));

        sendTextToElement(By.id("BillingNewAddress_FirstName"), "Stuart");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Part");
        // sendTextToElement(By.id("BillingNewAddress_Email"),"stuart134@gmail.com");

        selectByValueFromDropDown(By.id("BillingNewAddress_CountryId"), "2");
        sendTextToElement(By.id("BillingNewAddress_City"), "burly");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "10 street");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "Bt5 R44");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "75894525873");
        clickOnElement(By.xpath("//button[text() = 'Continue']"));

        clickOnElement(By.id("shippingoption_2"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//div[@id='shipping-method-buttons-container']/button"));

        clickOnElement(By.xpath("//input[@id='paymentmethod_1']")); //credit card
        clickOnElement(By.xpath("//div[@id='checkout-step-payment-method']/div/button"));//continue

        selectByVisibleTextFromDropDown(By.id("CreditCardType"), "Visa");
        sendTextToElement(By.id("CardholderName"), "abc");
        sendTextToElement(By.id("CardNumber"), "5232 1478 4876 3353");

        selectByVisibleTextFromDropDown(By.id("ExpireMonth"), "02");
        selectByVisibleTextFromDropDown(By.id("ExpireYear"), "2023");

        sendTextToElement(By.id("CardCode"), "000");
        clickOnElement(By.xpath("//div[@id='payment-info-buttons-container']/button"));

        assertVerifyText(By.xpath("//li[@class='payment-method']/span[2]"), "Credit Card");
        assertVerifyText(By.xpath("//li[@class='shipping-method']/span[2]"), "2nd Day Air");
        assertVerifyText(By.xpath("//td[@class='subtotal']/span"), "$698.00");
        clickOnElement(By.xpath("//button[text()='Confirm']"));

        assertVerifyText(By.xpath("//h1[contains(text(),'Thank you')]"), "Thank you");
        assertVerifyText(By.xpath("//div[@class='section order-completed']//strong"), "Your order has been successfully processed!");
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        assertVerifyText(By.xpath("//h2[contains(text(),'Welcome to our store')]"), "Welcome to our store");

        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
        String url = driver.getCurrentUrl();
        Assert.assertEquals("https://demo.nopcommerce.com/", url);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
