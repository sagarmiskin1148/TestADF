// Split version of DashboardTests class

package tests;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import customAnnotation.TestId;
import pages.DashboardPage;

public class DashboardTest extends BaseTest {

    @Test(priority = 1, description = "Verify all top navigation menu items are visible")
    @TestId(id = "ADF-DASH-001")
    public void verifyTopNavigationMenusVisibility() {
        test.log(Status.INFO, "Login and verify visibility of top menu items");
        loginPage.loginValidUser();

        DashboardPage dashboardPage = new DashboardPage();
        List<String> expectedMenus = Arrays.asList(
                "Dashboard", "Library", "Playlists",
                "Credit Tracker", "Why AudioDigest?",
                "CME/CE Resource Center");

        boolean result = dashboardPage.areAllMenusVisible(expectedMenus);

        if (result) {
            test.log(Status.PASS, "All top navigation menu items are visible");
        } else {
            test.log(Status.FAIL, "Some top navigation menu items are not visible");
        }

        Assert.assertTrue(result, "Menu visibility verification failed");
    }

    
    @Test(priority = 2, description = "Verify all top navigation menu items are clickable")
    @TestId(id = "ADF-DASH-002")
    public void verifyTopNavigationMenusClickable() {
        test.log(Status.INFO, "Login and verify clickability of top menu items");
        loginPage.loginValidUser();

        DashboardPage dashboardPage = new DashboardPage();
        List<String> expectedMenus = Arrays.asList(
                "Dashboard", "Library", "Playlists",
                "Credit Tracker", "Why AudioDigest?",
                "CME/CE Resource Center");

        boolean result = dashboardPage.areAllMenusClickable(expectedMenus);

        if (result) {
            test.log(Status.PASS, "All top navigation menu items are clickable");
        } else {
            test.log(Status.FAIL, "Some top navigation menu items are not clickable");
        }

        Assert.assertTrue(result, "Menu clickability verification failed");
    }

    @Test(priority = 3, description = "Verify Recently Added section visibility")
    @TestId(id = "ADF-DASH-003")
    public void verifyRecentlyAddedSectionVisible() {
        loginPage.loginValidUser();
        DashboardPage dashboard = new DashboardPage();

        boolean isVisible = dashboard.isRecentlyAddedSectionVisible();
        test.log(Status.INFO, "Recently Added section visible: " + isVisible);
        Assert.assertTrue(isVisible, "'Recently Added' section should be visible.");
    }

    
    @Test(priority = 4, description = "Verify Recently Added section heading")
    @TestId(id = "ADF-DASH-004")
    public void verifyRecentlyAddedHeading() {
        loginPage.loginValidUser();
        DashboardPage dashboard = new DashboardPage();

        String heading = dashboard.getRecentlyAddedHeadingText();
        test.log(Status.INFO, "Heading Text - Expected: 'Recently Added', Actual: '" + heading + "'");
        Assert.assertEquals(heading, "Recently Added", "Heading should match exactly.");
    }

    
    
    @Test(priority = 5, description = "Verify Recently Added section contains at least one lecture")
    @TestId(id = "ADF-DASH-005")
    public void verifyRecentlyAddedLectureCount() {
        loginPage.loginValidUser();
        DashboardPage dashboard = new DashboardPage();

        List<DashboardPage.LectureCard> lectures = dashboard.getAllRecentlyAddedLectures();
        test.log(Status.INFO, "Total Recently Added Lectures Found: " + lectures.size());
        Assert.assertTrue(lectures.size() > 0, "There should be at least one lecture displayed.");
    }

    
    
    @Test(priority = 6, description = "Verify details of each Recently Added lecture card")
    @TestId(id = "ADF-DASH-006")
    public void verifyEachRecentlyAddedLectureDetails() {
        test.log(Status.INFO, "Step 1: Login to the application");
        loginPage.loginValidUser();

        DashboardPage dashboard = new DashboardPage();
        test.log(Status.INFO, "Step 2: Fetching all recently added lecture cards");

        List<DashboardPage.LectureCard> lectures = dashboard.getAllRecentlyAddedLectures();
        test.log(Status.INFO, "Total lectures found: " + lectures.size());

        Assert.assertTrue(lectures.size() > 0, "No recently added lectures found.");

        int lectureCounter = 1;
        for (DashboardPage.LectureCard lec : lectures) {
            test.log(Status.INFO, "-------- Lecture " + lectureCounter + " --------");

            String title = lec.getTitle();
            String date = lec.getDate();
            String credit = lec.getCredit();
            String duration = lec.getDuration();
            boolean isVisible = lec.isVisible();
            boolean isPlayVisible = lec.isPlayButtonVisible();

            // Log each field
            test.log(Status.INFO, "Title: " + title);
            test.log(Status.INFO, "Date: " + date);
            test.log(Status.INFO, "Credit: " + credit);
            test.log(Status.INFO, "Duration: " + duration);
            test.log(Status.INFO, "Play Button Visible: " + isPlayVisible);
            test.log(Status.INFO, "Card Visible: " + isVisible);

            // Validations
            Assert.assertTrue(isVisible, "Lecture card is not visible");
            Assert.assertNotEquals(title, "[Missing]", "Title is missing");
            Assert.assertNotEquals(date, "[Missing]", "Date is missing");
            Assert.assertNotEquals(duration, "[Missing]", "Duration is missing");
            Assert.assertNotEquals(credit, "[Missing]", "Credit is missing");

            test.log(Status.PASS, "Lecture #" + lectureCounter + " validated successfully");
            lectureCounter++;
        }

        test.log(Status.PASS, "All recently added lecture cards validated successfully");
    }


    }

