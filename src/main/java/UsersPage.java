import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class UsersPage extends BasePage {

    @FindBy(css = ".user-list")
    private WebElement userList;

    public UsersPage(WebDriver driver) {
        super(driver);
    }

    public boolean isUserListDisplayed() {
        return userList.isDisplayed();
    }
}
