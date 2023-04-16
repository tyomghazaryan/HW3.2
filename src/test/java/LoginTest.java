
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test
    public void testLogin() {
        driver.get(LocatorsConstants.LOGIN_PAGE_URL);

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.login("username", "password");

        String actualTitle = homePage.getDashboardTitle();
        String expectedTitle = "Dashboard";
        Assert.assertEquals(actualTitle, expectedTitle, AssertionMessages.DASHBOARD_TITLE_NOT_FOUND);
    }
}
