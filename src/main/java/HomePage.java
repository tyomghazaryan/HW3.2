import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends BasePage {

    @FindBy(css = ".dashboard-title")
    private WebElement dashboardTitle;

    @FindBy(xpath = "//a[@href='/users']")
    private WebElement usersLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getDashboardTitle() {
        return dashboardTitle.getText();
    }

    public UsersPage clickUsersLink() {
        usersLink.click();
        return new UsersPage(driver);
    }
}
