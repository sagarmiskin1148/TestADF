/*package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.ITestListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import pages.BasePage;

public class ExtentListenerClass implements ITestListener {

    private static final Logger log = LogManager.getLogger(ExtentListenerClass.class);

    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override 
    public void onStart(ITestContext context) {
        log.info("Extent Report Started");
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("Extent Report Finished");
        extent.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
        log.info("Test started: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED", ExtentColor.GREEN));
        log.info("Test passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED", ExtentColor.RED));
        extentTest.get().fail(result.getThrowable());
        log.error("Test failed: " + result.getName(), result.getThrowable());

        try {
            TakesScreenshot ts = (TakesScreenshot) BasePage.driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File screenshotsDir = new File(System.getProperty("user.dir") + "/ScreenShots/");
            if (!screenshotsDir.exists()) {
                boolean created = screenshotsDir.mkdir();
                log.info("ScreenShots folder created? " + created);
            }
            String path = screenshotsDir.getAbsolutePath() + File.separator + result.getName() + ".png";
            FileUtils.copyFile(src, new File(path));
            extentTest.get().addScreenCaptureFromPath(path, "Failed Screenshot");
            log.info("Screenshot saved at: " + path);
        } catch (IOException e) {
            log.error("IOException while saving screenshot: " + e.getMessage(), e);
        } catch (Exception e) {
            log.error("Exception in onTestFailure: " + e.getMessage(), e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED", ExtentColor.YELLOW));
        log.warn("Test skipped: " + result.getName());
    }

   
    public static ExtentTest getTest() {
        return extentTest.get();
    }
}
*/
