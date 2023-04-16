import org.testng.Assert;
import org.testng.annotations.Test;

public class WrongCredentialsTest extends BaseTest {

    @Test
    public void testWrongCredentials() {
        driver.get(LocatorsConstants.LOGIN_PAGE_URL);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("wrong_username", "wrong_password");

        Assert.assertEquals(driver.getCurrentUrl(), LocatorsConstants.LOGIN_PAGE_URL, "Login failed but user was not redirected to login page");
    }
}
