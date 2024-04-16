package pages;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    By leftNav = By.cssSelector(".oxd-main-menu + ul");
    By recruitment = By.xpath("//a[contains(@href,'Recruitment')]");
    By myInfo = By.xpath("//a[contains(@href,'MyDetails')]");
    By admin = By.xpath("//a[contains(@href,'AdminModule')]");

    private static final Logger Log =  LogManager.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify User Logged In Successfully")
    public boolean verifyLogin() {
        Log.info("Validating successful login");
        return isElementPresent(leftNav);
    }

    @Step("Navigate to recruitment page")
    public void goToRecruitmentPage() {
        Log.info("navigating to recruitment page");
        click(recruitment);
    }

    @Step("Navigate to my info page")
    public void goToMyInfoPage() {
        Log.info("navigating to my info page");
        click(myInfo);
    }

    @Step("Navigate to admin page")
    public void goToAdminPage() {
        Log.info("navigating to admin page");
        click(admin);
    }
}
