package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testSetup.WebDriverSetup;

/**
 * Created by prerak thakkar
 */
public class ProductsPage extends WebDriverSetup{

    protected WebDriver driver;



    public ProductsPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(css="div[class='l-site-header__brand'] a")
    private WebElement homeButton;

    @FindBy(css="div[class='l-site__header']")
    private WebElement siteContent;

    @FindBy(css="div[class='l-hero-header__content'] a")
    private WebElement getDemoButton;

    @FindBy(css="div[class='l-hero-header__content'] h1")
    private WebElement productsHeader;

    @FindBy(css="div[class='l-form-container ']")
    private WebElement demoForm;




    public boolean verifyProductsPage(){

        System.out.println("Verifying Products link Navigation to correct page ");

        String currentURL = driver.getCurrentUrl();

        return currentURL.contains("products");
    }



    public ProductsPage clickDemoLink() throws Exception{

        System.out.println("Clicking on Get A Demo button under Products");

        if(getDemoButton.isDisplayed() || getDemoButton.isEnabled()){

            getDemoButton.click();

            WebDriverWait wait = new WebDriverWait(driver, 2);

            wait.until(ExpectedConditions.visibilityOf(demoForm));
        } else {

            System.out.println("Get A Demo Button not found");
        }

        return new ProductsPage(driver);
    }

    public boolean verifyDemoFormDisplay(){

        System.out.println("Verifying Demo Request Form is Displayed");

        return demoForm.isDisplayed();
    }

    public HomePage clickHomeButton(){
        System.out.println("Navigating to HomePage");

        siteContent.click();

        if(homeButton.isDisplayed() ||  homeButton.isEnabled()){

            homeButton.click();
        } else {

            System.out.println("Home Button not found");
        }

        return new HomePage(driver);

    }



}
