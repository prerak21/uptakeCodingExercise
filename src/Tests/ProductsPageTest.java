package Tests;

import PageObjects.HomePage;
import PageObjects.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import testSetup.WebDriverSetup;

/**
 * Created by prerak thakkar.
 */
public class ProductsPageTest extends WebDriverSetup{

    HomePage homePage;
    ProductsPage productsPage;


    @Test
    public void requestADemoTest(){

        productsPage.clickDemoLink();
        Assert.assertTrue(productsPage.verifyDemoFormDisplay());
    }

    @Test
    public void navigateToHomePageTest(){

        productsPage.getHomeButton().click();

        Assert.assertTrue(homePage.verifyHomePageHeaderTitle());

    }



}
