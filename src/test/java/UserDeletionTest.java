import org.testng.Assert;
import org.testng.annotations.Test;

public class UserDeletionTest extends BaseTest {

    @Test
    public void testUserDeletion() {
        driver.get(LocatorsConstants.LOGIN_PAGE_URL);

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.login("username", "password");

        UsersPage usersPage = homePage.clickUsersLink();

        int initialUserCount = usersPage.getUserCount();

        usersPage.deleteUser(1);

        int finalUserCount = usersPage.getUserCount();

        Assert.assertEquals(finalUserCount, initialUserCount - 1, "User was not deleted");

        usersPage.undoDeletion();

        int revertedUserCount = usersPage.getUserCount();

        Assert.assertEquals(revertedUserCount, initialUserCount, "User deletion undo failed");
    }
}