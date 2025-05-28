package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
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

public class ExtentListenerClass implements ITestListener {

    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Extent Report Started");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Extent Report Finished");
        extent.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED", ExtentColor.GREEN));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED", ExtentColor.RED));
        extentTest.get().fail(result.getThrowable());

        try {
            TakesScreenshot ts = (TakesScreenshot) pages.BasePage.driver;

            File src = ts.getScreenshotAs(OutputType.FILE);

            // Create ScreenShots folder if it doesn't exist
            File screenshotsDir = new File(System.getProperty("user.dir") + "/ScreenShots/");
            if (!screenshotsDir.exists()) {
                boolean created = screenshotsDir.mkdir();
                System.out.println("ScreenShots folder created? " + created);
            }

            String path = screenshotsDir.getAbsolutePath() + File.separator + result.getName() + ".png";

            FileUtils.copyFile(src, new File(path));

            extentTest.get().addScreenCaptureFromPath(path, "Failed Screenshot");
            System.out.println("Screenshot saved at: " + path);

        } catch (IOException e) {
            System.err.println("IOException while saving screenshot: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Exception in onTestFailure: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED", ExtentColor.YELLOW));
    }
}
