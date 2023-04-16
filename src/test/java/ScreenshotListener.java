import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ScreenshotListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = ((BaseTest) result.getInstance()).driver;
        String testName = result.getName();
        takeScreenshot(driver, testName);
    }

    private void takeScreenshot(WebDriver driver, String testName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
            String screenshotName = testName + "_" + timestamp + ".png";
            FileUtils.copyFile(screenshot, new File(screenshotName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
