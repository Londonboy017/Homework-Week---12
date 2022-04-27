package hotdeals;

import browserfactory.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HotDealsTest extends Utility {
    String baseUrl ="https://mobile.x-cart.com/";
    @Before
    public  void SetUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifySaleProductsArrangeAlphabetically() throws InterruptedException {
        //mouse hover on Hot deals
        mouseHoverOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/child::span"));
        //mouse hove and click on sale
        clickOnMouseHoverOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/child::ul/descendant::a[@href='sale_products/']"));
        //Verify the text
        assertVerifyText(By.tagName("h1"),"Sale");
        mouseHoverOnElement(By.className("sort-by-label"));
        clickOnElement(By.partialLinkText("Name A -"));
        assertVerifyText(By.xpath("//span[contains(text(),'Name A - Z')]"),"Name A - Z");
    }
    @Test
    public void verifySaleProductsPriceArrangeLowToHigh() {
        //mouse hover on Hot deals
        mouseHoverOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/child::span"));
        //mouse hove and click on sale
        clickOnMouseHoverOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/child::ul/descendant::a[@href='sale_products/']"));
        //Verify the text
        assertVerifyText(By.tagName("h1"),"Sale");
        mouseHoverOnElement(By.className("sort-by-label"));
        clickOnElement(By.partialLinkText("Price Low"));
        assertVerifyText(By.xpath("//span[contains(text(),'Price Low - High')]"),"Price Low - High");
    }
    @Test
    public void verifySaleProductsArrangeByRates(){
        //mouse hover on Hot deals
        mouseHoverOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/child::span"));
        //mouse hove and click on sale
        clickOnMouseHoverOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/child::ul/descendant::a[@href='sale_products/']"));
        //Verify the text
        assertVerifyText(By.tagName("h1"),"Sale");
        mouseHoverOnElement(By.className("sort-by-label"));
        clickOnElement(By.xpath("//ul[@class='display-sort sort-crit grid-list']/li[7]/child::a"));
        assertVerifyText(By.xpath("//span[contains(text(),'Rates')]"),"Rates");
    }
    @Test
    public void verifyBestSellersProductsArrangeByZToA() throws InterruptedException {
        //mouse hover on Hot deals
        mouseHoverOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/child::span"));
        //mouse hove and click on BestSeller
        clickOnMouseHoverOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/ul[1]/li[2]/child::a"));
        //Verify the text
        assertVerifyText(By.tagName("h1"),"Bestsellers");
        //actual product list
        List<WebElement> originalProductList = driver.findElements(By.xpath("//ul[@class='products-grid grid-list']/child::li/child::div/h5/a"));
        //create the list object
        List<String> sortPriceList = new ArrayList();
        //add all web element value to list object
        for (WebElement element : originalProductList) {
            sortPriceList.add(element.getText());
        }
        Collections.sort(sortPriceList, Collections.reverseOrder());
        //sort by Z to A
        mouseHoverOnElement(By.className("sort-by-label"));
        clickOnElement(By.partialLinkText("Name Z -"));
        Thread.sleep(1000);
        List<WebElement> actualProductListElements = driver.findElements(By.xpath("//ul[@class='products-grid grid-list']/child::li/child::div/h5/a"));
        //create the list object
        List<String> actualPriceList = new ArrayList();
        //add all web element value to list object
        for (WebElement element : actualProductListElements) {
            actualPriceList.add(element.getText());
        }
        Assert.assertEquals(sortPriceList, actualPriceList);
    }
    @Test
    public void verifyBestSellersProductsPriceArrangeHighToLow() throws InterruptedException {
        //mouse hover on Hot deals
        mouseHoverOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/child::span"));
        //mouse hover and click on BestSeller
        clickOnMouseHoverOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/ul[1]/li[2]/child::a"));
        //Verify the text
        assertVerifyText(By.tagName("h1"),"Bestsellers");
        //sort by Z to A
        mouseHoverOnElement(By.className("sort-by-label"));
        //actual product list
        List<WebElement> originalProductList = driver.findElements(By.xpath("//ul[@class='products-grid grid-list']/child::li/child::div/descendant::span[@class='price product-price']"));
        //create the list object
        List<Double> sortPriceList = new ArrayList();
        /*remove $ sign and add the sortPriceList
        //add all web element value to list object*/
        for (WebElement element : originalProductList) {
            sortPriceList.add(Double.valueOf(element.getText().replace("$", "")));
        }
        Collections.sort(sortPriceList, Collections.reverseOrder());
        //Mouse hover on “Sort By”
        mouseHoverOnElement(By.xpath("//div[@class='sort-box']"));
        //select “Price: Low to High”
        clickOnElement(By.partialLinkText("Price High - L"));
        Thread.sleep(1000);
        List<WebElement> actualProductListElements = driver.findElements(By.xpath("//ul[@class='products-grid grid-list']/child::li/child::div/descendant::span[@class='price product-price']"));
        //create the list object
        List<Double> actualPriceList = new ArrayList();
        /*remove $ sign and add the sortPriceList
        add all web element value to list object*/
        for (WebElement element : actualProductListElements) {
            actualPriceList.add(Double.valueOf(element.getText().replace("$", "")));
        }
        Assert.assertEquals(sortPriceList, actualPriceList);
    }
    @Test
    public void verifyBestSellersProductsArrangeByRates() throws InterruptedException {
        //mouse hover on Hot deals
        mouseHoverOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/child::span"));
        //mouse hover and click on BestSeller
        clickOnMouseHoverOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/ul[1]/li[2]/child::a"));
        //Verify the text
        assertVerifyText(By.tagName("h1"),"Bestsellers");
        //actual product list
        List<WebElement> originalProductList = driver.findElements(By.xpath("//div[@class='stars-row full']"));
        //create the list object
        List<Object> sortPriceList = new ArrayList();
        /*add all web element value to list object
        & Get width of rating*/
        for (WebElement element : originalProductList) {
        sortPriceList.add(String.valueOf(element.getAttribute("style")));
        }
        Collections.sort(sortPriceList,Collections.reverseOrder());
        //sort by Rates
        mouseHoverOnElement(By.className("sort-by-label"));
        clickOnElement(By.xpath("//*[@id=\"XLite-Module-CDev-Bestsellers-View-BestsellersPage-sortby-1\"]/li[6]/a"));
        Thread.sleep(1000);
        List<WebElement> actualProductListElements = driver.findElements(By.xpath("//div[@class='stars-row full']"));
        //create the list object
        List<Object> actualPriceList = new ArrayList();
        /*
        add all web element value to list object*/
        for (WebElement element : actualProductListElements) {
            actualPriceList.add(element.getAttribute("style"));
        }
        //verification by Star rating width
        Assert.assertEquals(sortPriceList, actualPriceList);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
