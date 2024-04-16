import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ProfileUpdateTest extends BaseTest {

    @Test(priority = 0, description = "Change Profile Picture")
    @Description("Change profile picture")
    public void testChangeProfilePic() {
        loginPage.goToLoginPage();
        loginPage.loginToHRM(testData.get("userName").toString(), testData.get("password").toString());
        assertTrue(homePage.verifyLogin(), "Login Successful");
        homePage.goToMyInfoPage();
        profilePage.changeProfilePicture();
        profilePage.verifySuccessMessage();
    }

    @Test(priority = 1, description = "Change Other Email")
    @Description("Change other email")
    public void testUpdateContactDetails() {
        loginPage.goToLoginPage();
        loginPage.loginToHRM(testData.get("userName").toString(), testData.get("password").toString());
        assertTrue(homePage.verifyLogin(), "Login Successful");
        homePage.goToMyInfoPage();
        profilePage.updateContactDetails(testData.get("email").toString());
        profilePage.verifySuccessMessage();
    }
}

