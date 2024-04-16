import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class RecruitmentTest extends BaseTest {

    @Test(priority = 0, description = "Add candidate")
    @Description("Add new candidate to HRM")
    public void addNewCandidate() {
        loginPage.goToLoginPage();
        loginPage.loginToHRM(testData.get("userName").toString(), testData.get("password").toString());
        assertTrue(homePage.verifyLogin(), "Login Successful");
        homePage.goToRecruitmentPage();
        recruitmentPage.addNewCandidate(testData.get("firstName").toString(),
                testData.get("lastName").toString(), testData.get("email").toString());
        assertTrue(recruitmentPage.verifySuccessMessage(), "New candidate added");
    }

    @Test(priority = 1, description = "Remove Candidate")
    @Description("Remove candidate from HRM")
    public void removeCandidate() {
        loginPage.goToLoginPage();
        loginPage.loginToHRM(testData.get("userName").toString(), testData.get("password").toString());
        assertTrue(homePage.verifyLogin(), "Login Successful");
        homePage.goToRecruitmentPage();
        recruitmentPage.addNewCandidate(testData.get("firstName").toString(),
                testData.get("lastName").toString(), testData.get("email").toString());
        assertTrue(recruitmentPage.verifySuccessMessage(), "New candidate added");
        homePage.goToRecruitmentPage();
        recruitmentPage.deleteCandidate(testData.get("firstName").toString());
        assertTrue(recruitmentPage.verifySuccessMessage(), "Candidate remvoed");
    }
}
