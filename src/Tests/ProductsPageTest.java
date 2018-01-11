package Tests;

import PageObjects.HomePage;
import PageObjects.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testSetup.WebDriverSetup;

/**
 * Created by prerak thakkar.
 */
public class ProductsPageTest extends WebDriverSetup{

    private WebDriver driver;

    private HomePage homePage;

    private ProductsPage productsPage;

    @BeforeClass
    public void setUp(){

        driver = getDriver();
    }



    @Test
    public void requestADemoTest() throws Exception{

        homePage = new HomePage(driver);
        productsPage = homePage.clickProducts();

        productsPage.clickDemoLink();

        Assert.assertTrue(productsPage.verifyDemoFormDisplay());
    }



}
