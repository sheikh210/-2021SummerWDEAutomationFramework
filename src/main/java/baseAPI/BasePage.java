package baseAPI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.util.Properties;

public class BasePage {

    public static WebDriver webDriver;
    public static WebDriverWait webDriverWait;
    DataReader dataReader;
    MySQLConnection database;
    Properties properties;
    private String absPath = System.getProperty("user.dir");
    private String secretPropRelPath = "/src/main/resources/secret.properties";
    private String propPath = absPath + secretPropRelPath;

    @BeforeSuite (alwaysRun = true)
    public void setUp() {
        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream(propPath);
            properties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            dataReader = new DataReader();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            database = new MySQLConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void driverInit() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriverWait = new WebDriverWait(webDriver, 20);
        webDriver.get(properties.getProperty("URL"));
        webDriver.manage().deleteAllCookies();
        webDriver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        webDriver.close();
    }

    @AfterSuite (alwaysRun = true)
    public void quitDriver() {
        webDriver.quit();
    }

    public void clickOnElement(WebElement element) {
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("COULD NOT CLICK ON ELEMENT");
        }
    }

    public void sendKeysToElement(WebElement element, String value) {
        try {
            element.sendKeys(value);
        } catch (TimeoutException e) {
            element.sendKeys(value);
        }
    }

}
