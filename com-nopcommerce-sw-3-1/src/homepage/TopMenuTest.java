package homepage;

import browserfactory.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String name) {
        if (name == "Computers") {
            //find computer tab and click
            clickOnElement(By.linkText("Computers"));
            //get title
            String title=driver.getTitle();
            //validate page navigation by assert title
            Assert.assertEquals("title not matched: ","nopCommerce demo store. Computers",title);

        } else if (name == "Electronics") {
            clickOnElement(By.linkText("Electronics"));
            String title=driver.getTitle();
            //validate page navigation by assert title
            Assert.assertEquals("title not matched: ","nopCommerce demo store. Electronics",title);

        } else if (name == "Apparel") {
            clickOnElement(By.linkText("Apparel"));
            String title=driver.getTitle();
            //validate page navigation by assert title
            Assert.assertEquals("title not matched: ","nopCommerce demo store. Apparel",title);
        } else if (name == "Digital downloads") {
            clickOnElement(By.linkText("Digital downloads"));
            String title=driver.getTitle();
            //validate page navigation by assert title
            Assert.assertEquals("title not matched: ","nopCommerce demo store. Digital downloads",title);
        } else if (name == "Books") {
            clickOnElement(By.linkText("Books"));
            String title=driver.getTitle();
            //validate page navigation by assert title
            Assert.assertEquals("title not matched: ","nopCommerce demo store. Books",title);
        } else if (name == "Jewelry") {
            clickOnElement(By.linkText("Jewelry"));
            String title=driver.getTitle();
            //validate page navigation by assert title
            Assert.assertEquals("title not matched: ","nopCommerce demo store. Jewelry",title);
        } else if (name == "Gift Cards") {
            clickOnElement(By.xpath("//a[contains(text(),'Gift Cards')]"));
            String title=driver.getTitle();
            //validate page navigation by assert title
            Assert.assertEquals("title not matched: ","nopCommerce demo store. Gift Cards",title);
        } else {
            System.out.println("Please enter valid Top-menu name or check actual Top-menu name");
        }
    }
    @Test
    public void verifyPageNavigation() {
        selectMenu("Computers");
        selectMenu("Electronics");
        selectMenu("Apparel");
        selectMenu("Digital downloads");
        selectMenu("Books");
        selectMenu("Jewelry");
        selectMenu("Gift Cards");
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
