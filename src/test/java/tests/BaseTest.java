package tests;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.BasePage;
import pages.LoginPage;
import utilities.ExtentManager;

public class BaseTest {

    protected LoginPage loginPage;
    protected static ExtentReports extent;
    protected static ExtentTest test;

    @BeforeSuite
    public void beforeSuite() {
        extent = ExtentManager.getInstance();
    }

    @AfterSuite
    public void afterSuite() {
        if (extent != null) {
            extent.flush();
        }
    }

    @BeforeMethod
    public void beforeMethod(Method method) throws IOException {
        BasePage.InitWebDriver();
        test = extent.createTest(method.getName());
        BasePage.test = test;

        loginPage = new LoginPage();
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        try {
            if (result.getStatus() == ITestResult.FAILURE) {
                test.fail(result.getThrowable());

                TakesScreenshot ts = (TakesScreenshot) BasePage.driver;
                File src = ts.getScreenshotAs(OutputType.FILE);
                String path = System.getProperty("user.dir") + "/ScreenShots/" + result.getName() + ".png";
                FileUtils.copyFile(src, new File(path));

                test.addScreenCaptureFromPath(path, "Failed Screenshot");

            } else if (result.getStatus() == ITestResult.SUCCESS) {
                test.pass("Test Passed");
            } else if (result.getStatus() == ITestResult.SKIP) {
                test.skip("Test Skipped");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BasePage.QuitDriver();
        }
    }
}
