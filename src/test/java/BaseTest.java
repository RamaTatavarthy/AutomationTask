import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.*;
import utils.TestDataReader;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import static org.testng.Assert.assertTrue;

public class BaseTest {

    public ChromeOptions options;
    public WebDriver driver;
    public WebDriverWait wait;
    public Actions action;
    public JavascriptExecutor jse;
    public LoginPage loginPage;
    public HomePage homePage;
    public RecruitmentPage recruitmentPage;
    public ProfilePage profilePage;
    public AdminPage adminPage;
    public TestDataReader testDataReader;
    public HashMap testData;

    @BeforeTest
    public void setUp() {
        options = new ChromeOptions();
        options.addArguments("incognito");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        WebDriverManager.chromedriver().driverVersion("123").setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        action = new Actions(driver);
        jse = (JavascriptExecutor) driver;
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        recruitmentPage = new RecruitmentPage(driver);
        profilePage = new ProfilePage(driver);
        adminPage = new AdminPage(driver);
        testDataReader = new TestDataReader();
    }

    @BeforeMethod
    public void getData(Method method) throws IOException, ParseException {
        testData =  testDataReader.getTestData(System.getProperty("user.dir")
                +"\\src\\main\\resources\\testdata\\testdata.json", method.getName());
    }

    @AfterMethod
    public void logout() {
        try{
            if(homePage.verifyLogin())
                assertTrue(loginPage.logOut(), "logged out");
        }
        catch (Exception e){

        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
