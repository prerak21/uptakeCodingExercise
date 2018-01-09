package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testSetup.WebDriverSetup;

/**
 * Created by prerak thakkar
 */
public class HomePage extends WebDriverSetup {

    protected WebDriver driver;

    public HomePage(WebDriver driver) {

        this.driver = driver;
    }

    @FindBy(css = "div[class=\"l-site-header__brand\"] title")
    WebElement homePageTitle;

    @FindBy(css="li[class='site-nav__item is-activeproducts'] a[class*='desktop']")
    WebElement productsLink;

    @FindBy(css="li[class='site-nav__item is-activeindustries'] a[class*='desktop']")
    WebElement industriesLink;

    @FindBy(css="li[class='site-nav__item is-activecontact'] a[class*='desktop']")
    WebElement contactLink;

    @FindBy(css="div[class='l-form-modal']")
    WebElement contactForm;

    @FindBy(css="div[class='l-hero-header__content'] h1")
    WebElement homePageHeaderTitle;





    public boolean verifyHomePageHeaderTitle(){

        System.out.println("Verifying Home Page Header");
        return homePageHeaderTitle.getText().contains("UPTAKE PRODUCTS");
    }


    public ProductsPage clickProducts(){

        System.out.println("Navigate to Products Page");

        if(productsLink.isDisplayed()|| productsLink.isEnabled()){

            productsLink.click();
        } else {

            System.out.println("Products link not found");
        }

        return new ProductsPage(driver);
    }

    public HomePage clickContact(){

        System.out.println("Clicking on Contact");

        if(contactLink.isDisplayed() || contactLink.isEnabled()){

            contactLink.click();
        } else {

            System.out.println("Contact link not found");
        }
         return new HomePage(driver);

    }

    public boolean verifyContactFormDisplayed(){

        System.out.println("Verifying Contact form is displayed");

        return contactForm.isDisplayed();
    }


}
