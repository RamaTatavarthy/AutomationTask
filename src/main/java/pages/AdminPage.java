package pages;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AdminPage extends BasePage {

    public AdminPage(WebDriver driver) {
        super(driver);
    }
    private static final Logger Log =  LogManager.getLogger(AdminPage.class);

    By userSearch = By.xpath("//label[contains(text(),'Username')]/parent::div/following-sibling::div//input");
    By save = By.xpath("//button[@type='submit']");
    String searchResult = "//div[contains(text(),'#')]";
    By resetSearch = By.xpath("//div[@class='oxd-form-actions']//button[@type='button']");

    @Step("Search user")
    public void searchUser(String keyword){
        Log.info("search user");
        clear(userSearch);
        writeText(userSearch, keyword);
        javascriptClick(save);
    }

    @Step("Verify search result")
    public boolean verifySearchResult(String text){
        Log.info("verify search result");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(spinner));
        waitVisibility(getDynamicElement(searchResult, text));
        return driver.findElement(getDynamicElement(searchResult, text)).isDisplayed();
    }

    @Step("Verify reset search")
    public boolean verifyResetSearch(){
        Log.info("verify reset search");
        click(resetSearch);
        return readText(userSearch).isEmpty();
    }

}
