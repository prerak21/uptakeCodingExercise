package testSetup;

import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by prerak thakkar
 */
public class WebDriverSetup {

    private WebDriver driver;

    static String driverPath = "lib/chromedriver.exe";


    public WebDriver getDriver() {
        return driver;
    }

    private void setDriver(String browserType, String URL) {

        if(browserType.equalsIgnoreCase("chrome")){

            driver = launchChrome(URL);

        } 
    }

    private static WebDriver launchChrome(String URL ){

        System.out.println("Launch Chrome browser");

        System.setProperty("webdriver.chrome.driver", driverPath);

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to(URL);

        return driver;
    }

    @Parameters({ "browserType", "URL" })
    @BeforeClass
    public void WebDriverSetup(String browserType, String URL ){
        try {

            setDriver(browserType, URL);
        } catch(Exception e ){

            System.out.println(e.getStackTrace());
        }
    }

    @AfterClass
    public void tearDown(){

        driver.quit();
    }
}
