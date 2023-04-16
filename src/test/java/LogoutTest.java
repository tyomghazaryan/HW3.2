import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test
    public void testLogout() {
        driver.get(LocatorsConstants.LOGIN_PAGE_URL);

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.login("username", "password");

        homePage.logout();

        Assert.assertEquals(driver.getCurrentUrl(), LocatorsConstants.LOGIN_PAGE_URL, "Logout failed but user was not redirected to login page");
    }
}
