package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    By userName = By.name("username");
    By password = By.name("password");
    By submit = By.xpath("//button[@type='submit']");
    By invalidCredentialsMessage = By.xpath("//p[contains(@class,'alert')]");
    By userMenu = By.xpath("//i[contains(@class,'dropdown')]");
    By logOut = By.xpath("//a[contains(text(),'Logout')]");

    String baseURL = "https://opensource-demo.orangehrmlive.com/web/index.php/";

    private static final Logger Log =  LogManager.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Navigate to login page")
    public void goToLoginPage() {
        Log.info("navigating to login page");
        navgigate(baseURL);
    }

    @Step("Login to HRM portal")
    public void loginToHRM(String uName, String pwd) {
        Log.info("logging in to portal");
        clear(userName);
        writeText(userName, uName);
        clear(password);
        writeText(password,pwd);
        click(submit);
    }

    @Step("Verify Invalid Credentials Message")
    public boolean checkErrorMessage(){
        Log.info("verify error message");
        return isElementPresent(invalidCredentialsMessage);
    }

    @Step("Verify Logout functionality")
    public boolean logOut(){
        Log.info("Logout of the application");
        click(userMenu);
        click(logOut);
        return isElementPresent(userName);
    }
}
