package tests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.BasePage;
import pages.LoginPage;
import utilities.ExtentListenerClass;
import utilities.ExtentManager;

@Listeners(utilities.ExtentListenerClass.class)
public class BaseTest {

    protected LoginPage loginPage;
    protected static ExtentReports extent;

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
        loginPage = new LoginPage();
      
    }

    @AfterMethod
    public void afterMethod() {
        BasePage.QuitDriver();
    }

    // ✅ Get current test instance from listener
    protected ExtentTest getExtentTest() {
        return ExtentListenerClass.getTest();
    }
}
