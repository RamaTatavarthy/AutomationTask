package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;
    public JavascriptExecutor jse;
    By spinner = By.xpath("div[contains(@class,'oxd-loading-spinner')]");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        jse = (JavascriptExecutor) driver;
    }

    public void navgigate(String URL) {
        driver.get(URL);
    }

    public void click(By by) {
        waitVisibility(by).click();
    }

    public void writeText(By by, String text) {
        waitVisibility(by).sendKeys(text);
    }

    public void uploadFile(By by, String text){
        driver.findElement(by).sendKeys(text);
    }

    public String readText(By by) {
        return waitVisibility(by).getText();
    }

    public boolean isElementPresent(By by){
        return waitVisibility(by).isDisplayed();
    }

    public WebElement waitVisibility(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitForClickable(By by) {
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public By getDynamicElement(String xpath, String replaceText) {
        return By.xpath(xpath.replaceAll("#", replaceText));
    }

    public void scrollInToView(By by) {
        jse.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(by));
    }

    public void javascriptClick(By by) {
        jse.executeScript("arguments[0].click();",driver.findElement(by));
    }

    public void clear(By by) {
        waitVisibility(by).clear();
    }
}
