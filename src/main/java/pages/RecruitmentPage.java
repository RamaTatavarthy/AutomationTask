package pages;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecruitmentPage extends BasePage {

    By addCandidate = By.xpath("//div[@class='orangehrm-header-container']//button");
    By firstName = By.name("firstName");
    By lastName = By.name("lastName");
    By email = By.xpath("//label[contains(text(),'Email')]/parent::div/following-sibling::div//input");
    By saveDetails = By.xpath("//button[@type='submit']");
    By successMessage = By.xpath("//p[contains(@class,'toast-message')]");
    String delete = "//div[contains(text(),'#')]/parent::div/following-sibling::div//i[contains(@class,'trash')]";
    By deleteConfirmation = By.xpath("//div[contains(@role,'dialog')]//i[contains(@class,'trash')]");

    private static final Logger Log =  LogManager.getLogger(RecruitmentPage.class);

    public RecruitmentPage(WebDriver driver) {
        super(driver);
    }

    @Step("Adding new candidate")
    public void addNewCandidate(String fName, String lName, String emailAddr) {
        Log.info("adding new candidate");
        click(addCandidate);
        writeText(firstName, fName);
        writeText(lastName, lName);
        writeText(email, emailAddr);
        click(saveDetails);
    }

    @Step("Verify success message")
    public boolean verifySuccessMessage(){
        Log.info("verify success message");
        return isElementPresent(successMessage);
    }

    @Step("Deleting candidate")
    public void deleteCandidate(String fName) {
        Log.info("Deleting candidate");
        click(getDynamicElement(delete, fName));
        click(deleteConfirmation);
        click(saveDetails);
    }
}
