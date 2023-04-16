import org.testng.Assert;
import org.testng.annotations.Test;

public class UsersNavigationTest extends BaseTest {

    @Test
    public void testUsersNavigation() {
        driver.get(LocatorsConstants.LOGIN_PAGE_URL);

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.login("username", "password");

        UsersPage usersPage = homePage.clickUsersLink();

        Assert.assertTrue(usersPage.isUserListDisplayed(), AssertionMessages.USER_LIST_NOT_DISPLAYED);
    }
}
