package computers;

import browserfactory.Utility;
import com.google.common.collect.Ordering;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.json.JsonInput;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void VerifyPriceOrderLowToHigh() throws InterruptedException,NumberFormatException {
        //click on computers
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        //click on Desktop
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h2[1]/a[1]"));

        Thread.sleep(1000);
        List<WebElement> beforeFilter = driver.findElements(By.xpath("//span[contains(@class, 'actual-price')]"));
        List<Double> beforeFilterPriceList = new ArrayList();

        for (WebElement p : beforeFilter) {
            beforeFilterPriceList.add(Double.parseDouble(p.getText().trim().replace(",", "").replace(",", "")));
           // boolean check = Ordering.natural().isOrdered(beforeFilterPriceList);
        }

        //sort by Price : Low to High
        selectByValueFromDropDown(By.id("products-orderby"), "10");
        Thread.sleep(1000);
        List<WebElement> afterFilter = driver.findElements(By.xpath("//span[contains(@class, 'actual-price')]"));
        List<Double> afterFilterPriceList = new ArrayList<>();

        for (WebElement q : afterFilter) {
           afterFilterPriceList.add(Double.parseDouble(q.getText().replace("$","").replace(",","")));
        }

        Collections.sort(beforeFilterPriceList,Collections.reverseOrder());
       Assert.assertEquals(beforeFilterPriceList, afterFilterPriceList);
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws ElementClickInterceptedException, InterruptedException {
        //click on computers
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        //click on Desktop
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h2[1]/a[1]"));
        //sort A to Z
        selectByValueFromDropDown(By.id("products-orderby"),"5");
        Thread.sleep(1000);
        //click on Add to cart
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));
        //verify the text
        assertVerifyText(By.xpath("//h1[contains(text(),'Build your own computer')]"),"Build your own computer");
        //select the processor,RAM,
        selectByVisibleTextFromDropDown(By.name("product_attribute_1"),"2.2 GHz Intel Pentium Dual-Core E2200");
        selectByValueFromDropDown(By.id("product_attribute_2"),"5");
        //select HDD radio
        clickOnElement(By.id("product_attribute_3_7"));
        clickOnElement(By.id("product_attribute_4_9"));
        Thread.sleep(1000);
        clickOnElement(By.id("product_attribute_5_12"));
        Thread.sleep(1000);
        //verify the price
        System.out.println(driver.findElement(By.cssSelector("#price-value-1")).getText());
       assertVerifyText(By.cssSelector("#price-value-1"),"$1,475.00");

        //click on add to cart
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        //verify the message
        assertVerifyText(By.xpath("//p[@class=\"content\"]"),"The product has been added to your shopping cart");
        //close the title bar
        clickOnElement(By.xpath("//span[@class=\"close\"]"));
        //mouse hover on shopping cart
        mouseHoverOnElement(By.className("cart-label"));
        //click on go to cart
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));

        //verify the message
        assertVerifyText(By.tagName("h1"),"Shopping cart");
        //change the quantity
        Actions actions =new Actions(driver);
        driver.findElement(By.xpath("//tbody/tr/td[5]/input")).sendKeys(Keys.CONTROL+"a");
        Thread.sleep(3000);
        //update the quantity
       sendTextToElement(By.xpath("//tbody/tr/td[5]/input"),"2");
       //click on update shopping cart
        clickOnElement(By.id("updatecart"));
        //verify the updated price
        Thread.sleep(1000);
        //verify the total price
        assertVerifyText(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"),"$2,950.00");
        //click on checkbox of terms and condition
        clickOnElement(By.xpath("//input[@name='termsofservice']"));
        //click on check out
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //verify welcome message
        assertVerifyText(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"),"Welcome, Please Sign In!");
        //click on checkout as guest
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
        //fill all mandatory details
        sendTextToElement(By.id("BillingNewAddress_FirstName"),"Jay");
        sendTextToElement(By.name("BillingNewAddress.LastName"),"Shah");
        sendTextToElement(By.name("BillingNewAddress.Email"),"jshah1@gmail.com");
        selectByValueFromDropDown(By.id("BillingNewAddress_CountryId"),"239");

        sendTextToElement(By.id("BillingNewAddress_City"),"NewYork");
        sendTextToElement(By.name("BillingNewAddress.Address1"),"2,Ganesh Street");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"),"234N");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"),"5467890234");
        //click on continue
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));
        //click on radio button
        clickOnElement(By.id("shippingoption_1"));
        //click on continue
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));
        //click on creditcard radio
        clickOnElement(By.id("paymentmethod_1"));
        //cick on continue
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
        //select master card
        selectByVisibleTextFromDropDown(By.id("CreditCardType"),"Master card");
        //fill all card details
         sendTextToElement(By.id("CardholderName"),"Jay");
         sendTextToElement(By.id("CardNumber"),"2222420000001113");
         selectByValueFromDropDown(By.id("ExpireMonth"),"2");
         selectByValueFromDropDown(By.id("ExpireYear"),"2024");
         sendTextToElement(By.id("CardCode"),"459");
         clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));
         //verify payment method,shipping method,price
        assertVerifyText(By.xpath("//span[contains(text(),'Credit Card')]"),"Credit Card");
        assertVerifyText(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]"),"Next Day Air");
        assertVerifyText(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"),"$2,950.00");
        //click on confirm
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        //verify thank you text
        assertVerifyText(By.xpath("//h1[contains(text(),'Thank you')]"),"Thank you");
        assertVerifyText(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"),"Your order has been successfully processed!");
        //click on continue
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        //verify welcome message
        assertVerifyText(By.xpath("//h2[contains(text(),'Welcome to our store')]"),"Welcome to our store");
    }
    @After
    public void tearDown() {
        closeBrowser();
    }


}
