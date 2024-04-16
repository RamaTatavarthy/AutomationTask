package pages;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage extends BasePage {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }
    private static final Logger Log =  LogManager.getLogger(ProfilePage.class);

    By profilePicture = By.xpath("//div[contains(@class,'employee-image')]//img");
    By addPic = By.xpath("//button[contains(@class,'image-action')]//i");
    By changePicture = By.xpath("//input[@type='file']");
    By save = By.xpath("//button[@type='submit']");
    By successMessage = By.xpath("//p[contains(@class,'toast-message')]");
    By firstName = By.name("firstName");
    By lastName = By.name("lastName");
    By contactDetails = By.xpath("//a[contains(@href,'contactDetails')]");
    By otherEmail = By.xpath("//label[contains(text(),'Other Email')]/parent::div/following-sibling::div//input");

    @Step("Change Profile Picture")
    public void changeProfilePicture(){
        Log.info("change profile picture");
        click(profilePicture);
        wait.until(ExpectedConditions.elementToBeClickable(addPic));
        uploadFile(changePicture, System.getProperty("user.dir")
                +"\\src\\main\\resources\\profilepic.jpg");
        click(save);
    }

    @Step("Update Contact Details")
    public void updateContactDetails(String email){
        Log.info("change profile details");
        click(contactDetails);
        clear(otherEmail);
        writeText(otherEmail, email);
        javascriptClick(save);
    }

    @Step("Verify success message")
    public boolean verifySuccessMessage(){
        Log.info("verify success message");
        return isElementPresent(successMessage);
    }
}
