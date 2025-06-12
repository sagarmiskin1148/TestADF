package tests;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import customAnnotation.TestId;
import pages.DashboardPage;


public class DashboardTest extends BaseTest {

	@Test(priority = 1, description = "Verify top navigation menu items are visible and clickable")
	@TestId(id = "ADF-DASH-01")
	public void validateTopNavigationMenuItems() throws InterruptedException 
	{
	    test.log(Status.INFO, "Login to the application...");
	    loginPage.loginValidUser();
	    

	    DashboardPage dashboardPage = new DashboardPage();

	    List<String> expectedMenus = Arrays.asList(
	        "Dashboard",
	        "Library",
	        "Playlists",
	        "Credit Tracker",
	        "Why AudioDigest?",
	        "CME/CE Resource Center"
	    );

	    test.log(Status.INFO, "Checking all top navigation menu items...");
	    boolean result = dashboardPage.areAllMenusVisibleAndClickable(expectedMenus);

	    if (!result)
	    {
	        test.log(Status.FAIL, "Some menu items are either not visible or not clickable.");
	    } else {
	        test.log(Status.PASS, "All expected menu items are visible and clickable.");
	    }

	    Assert.assertTrue(result, "All top navigation menu items should be visible and clickable");
	}
	
	
	
	
	@Test(priority = 2)
	public void validateRecentlyAddedLecturesSection() {
	    DashboardPage dashboard = new DashboardPage();

	    // Step 1: Section Visibility
	    boolean isVisible = dashboard.isRecentlyAddedSectionVisible();
	    test.log(Status.INFO, "Step 1: Recently Added Section Visible - Expected: true, Actual: " + isVisible);
	    Assert.assertTrue(isVisible, "'Recently Added' section should be visible.");

	    // Step 2: Heading Text Validation
	    String heading = dashboard.getRecentlyAddedHeadingText();
	    test.log(Status.INFO, "Step 2: Heading Text - Expected: 'Recently Added', Actual: '" + heading + "'");
	    Assert.assertEquals(heading, "Recently Added", "Heading should match exactly.");

	    // Step 3: Fetch and Log Lecture Info
	    List<DashboardPage.LectureCard> lectures = dashboard.getAllRecentlyAddedLectures();
	    test.log(Status.INFO, "Step 3: Total Recently Added Lectures Found: " + lectures.size());
	    Assert.assertTrue(lectures.size() > 0, "There should be at least one lecture displayed.");

	    for (int i = 0; i < lectures.size(); i++) {
	        DashboardPage.LectureCard lec = lectures.get(i);
	        test.log(Status.INFO, "Lecture #" + (i + 1));
	        test.log(Status.INFO, "Title: " + lec.getTitle());
	        test.log(Status.INFO, "Date: " + lec.getDate());
	        test.log(Status.INFO, "Credit: " + lec.getCredit());
	        test.log(Status.INFO, "Duration: " + lec.getDuration());
	        test.log(Status.INFO, "Play Button Visible: " + lec.isPlayButtonVisible());
	        test.log(Status.INFO, "Card Visible: " + lec.isVisible());

	        Assert.assertTrue(lec.isVisible(), "Lecture card not visible");
	        Assert.assertNotEquals(lec.getTitle(), "[Missing]", "Title is missing");
	        Assert.assertNotEquals(lec.getDate(), "[Missing]", "Date is missing");
	        Assert.assertNotEquals(lec.getDuration(), "[Missing]", "Duration is missing");
	        Assert.assertNotEquals(lec.getCredit(), "[Missing]", "Credit is missing");
	    }

	    test.log(Status.PASS, "Recently Added section and all lectures validated successfully.");
	}

}
