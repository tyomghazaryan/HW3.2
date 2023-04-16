import org.testng.Assert;
import org.testng.annotations.Test;

public class UserDetailsTest extends BaseTest {

    @Test
    public void testUserDetails() {
        driver.get(LocatorsConstants.LOGIN_PAGE_URL);

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.login("username", "password");

        UsersPage usersPage = homePage.clickUsersLink();

        UserDetailsModal userDetailsModal = usersPage.clickUserDetails(1);

        Assert.assertEquals(userDetailsModal.getUserName(), "John Doe", "User name not found or incorrect");
        Assert.assertEquals(userDetailsModal.getUserEmail(), "johndoe@example.com", "User email not found or incorrect");

        userDetailsModal.close();
    }
}