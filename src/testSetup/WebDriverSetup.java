package testSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by prerak thakkar
 */
public class WebDriverSetup {

    private static  WebDriver driver;

    //static String driverPath = "lib/chromedriver.exe";
    static String geckoDriverPath = "lib/geckodriver.exe";


    public WebDriver getDriver() {
        return driver;
    }

    private void setDriver(String browserType, String URL) {

        if(browserType.equalsIgnoreCase("chrome")){

         driver = launchChrome(URL);


        } else if (browserType.equalsIgnoreCase("firefox")){

            driver = launchFirefox(URL);
        }
    }

    private static WebDriver launchFirefox(String URL){

        System.out.println("Launch Firefox browser");

        System.setProperty("webdriver.gecko.driver", geckoDriverPath);
        driver = new FirefoxDriver();
        driver.get(URL);
        System.out.println(URL);
        return driver;
    }

    private static WebDriver launchChrome(String URL ){

        System.out.println("Launch Chrome browser");



        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");





        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        options.addArguments("disable-extensions");
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        options.addArguments("disable-notifications");
        options.setAcceptInsecureCerts(true);

         driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

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
