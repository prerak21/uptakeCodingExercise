package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testSetup.WebDriverSetup;

/**
 * Created by prerak thakkar
 */
public class ProductsPage extends WebDriverSetup{

    protected WebDriver driver;

    String currentURL = driver.getCurrentUrl();

    public ProductsPage(WebDriver driver){

        this.driver = driver;
    }

    @FindBy(css="div[class='l-site-header__brand'] a")
    WebElement homeButton;

    @FindBy(css="div[class='l-hero-header__content'] a")
    WebElement getDemoButton;

    @FindBy(css="div[class='l-hero-header__content'] h1")
    WebElement productsHeader;

    @FindBy(css="div[class='l-form-container ']")
    WebElement demoForm;



    public WebElement getHomeButton(){

        return homeButton;
    }

    public boolean verifyProductsPage(){

        System.out.println("Verifying Products link Navigation to correct page ");

        return currentURL.contains("products");
    }



    public ProductsPage clickDemoLink(){

        System.out.println("Clicking on Get A Demo button under Products");

        if(getDemoButton.isDisplayed() || getDemoButton.isEnabled()){

            getDemoButton.click();
        } else {

            System.out.println("Get A Demo Button not found");
        }

        return new ProductsPage(driver);
    }

    public boolean verifyDemoFormDisplay(){

        System.out.println("Verifying Demo Request Form is Displayed");

        return demoForm.isDisplayed();
    }



}
