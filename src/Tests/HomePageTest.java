package Tests;

import PageObjects.HomePage;
import PageObjects.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testSetup.WebDriverSetup;

/**
 * Created by prerak thakkar.
 */
public class HomePageTest  extends WebDriverSetup{

    private WebDriver driver;

//    private HomePage homePage;

    private ProductsPage productPage;


    @BeforeClass
    public void setUp(){

        driver = getDriver();
    }

    @Test
    public void homePageLinksTest(){

        try{

            HomePage homePage = new HomePage(driver);
            homePage.verifyHomePageHeaderTitle();
            productPage = homePage.clickProducts();

            productPage.verifyProductsPage();

        } catch(Exception e){

            System.out.println(e.getStackTrace());
        }


    }


}
