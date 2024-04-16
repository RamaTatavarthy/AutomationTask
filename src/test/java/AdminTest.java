import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AdminTest extends BaseTest {

    @Test(priority = 0, description = "Search User")
    @Description("Search User")
    public void testSearchUser() {
        loginPage.goToLoginPage();
        loginPage.loginToHRM(testData.get("userName").toString(), testData.get("password").toString());
        assertTrue(homePage.verifyLogin(), "Login Successful");
        homePage.goToAdminPage();
        adminPage.searchUser(testData.get("keyword").toString());
        assertTrue(adminPage.verifySearchResult(testData.get("keyword").toString()), "search result found");
    }

    @Test(priority = 1, description = "Reset search result")
    @Description("Reset search result")
    public void testResetSearchResult() {
        loginPage.goToLoginPage();
        loginPage.loginToHRM(testData.get("userName").toString(), testData.get("password").toString());
        assertTrue(homePage.verifyLogin(), "Login Successful");
        homePage.goToAdminPage();
        adminPage.searchUser(testData.get("keyword").toString());
        assertTrue(adminPage.verifySearchResult(testData.get("keyword").toString()), "search result found");
        assertTrue(adminPage.verifyResetSearch(),"Search cleared");
    }
}
