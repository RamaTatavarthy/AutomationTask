import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test(priority = 0, description = "Login with valid credentials")
    @Description("Login with valid user name and password")
    public void testValidLogin() {
        loginPage.goToLoginPage();
        loginPage.loginToHRM(testData.get("userName").toString(), testData.get("password").toString());
        assertTrue(homePage.verifyLogin(), "Login Successful");
    }

    @Test(priority = 1, description = "Login with invalid credentials")
    @Description("Login with invalid user name and password")
    public void testInvalidLogin() {
        loginPage.goToLoginPage();
        loginPage.loginToHRM(testData.get("userName").toString(), testData.get("password").toString());
        assertTrue(loginPage.checkErrorMessage(), "Login Successful");
    }
}

