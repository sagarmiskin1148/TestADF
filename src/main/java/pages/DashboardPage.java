// DashboardPage.java
package pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.Status;
import utils.WaitUtils;

public class DashboardPage extends BasePage {

    // Locators
    private By topMenuItems = By.xpath("//ul[@class='megamenu']//a");
    private By recentlyAddedHeading = By.xpath("//h1[normalize-space()=' Recently Added']");
    private By lectureCards = By.xpath("(//ul[@class='libitems'])[1]");

    
    
    
    // Expected menus
    public static final List<String> EXPECTED_TOP_MENUS = Arrays.asList(
        "Dashboard", 
        "Library",
        "Playlists", 
        "Credit Tracker", 
        "Why AudioDigest?",
        "CME/CE Resource Center"
    );

    
    
    public String getCurrentPageUrl() {
        return driver.getCurrentUrl();
    }

    
    
    public boolean areAllMenusVisible(List<String> expectedMenus) 
    {
        test.log(Status.INFO, "Validating visibility of all top menu items...");
        List<WebElement> elements = driver.findElements(topMenuItems);
        List<String> actualMenus = new ArrayList<>();

        for (WebElement el : elements) {
            try {
                String text = el.getText().trim();
                if (!text.isEmpty() && el.isDisplayed()) {
                    actualMenus.add(text.toLowerCase());
                }
            } catch (Exception e) {
                test.log(Status.WARNING, "Exception in menu visibility check: " + e.getMessage());
            }
        }

        return actualMenus.containsAll(expectedMenus.stream().map(String::toLowerCase).toList());
    }

    
    
    public boolean areAllMenusClickable(List<String> expectedMenus) 
    {
        test.log(Status.INFO, "Validating clickability of all top menu items...");
        List<WebElement> elements = driver.findElements(topMenuItems);
        List<String> actualMenus = new ArrayList<>();

        for (WebElement el : elements)
        {
            try {
                String text = el.getText().trim();
                if (!text.isEmpty() && el.isDisplayed() && el.isEnabled()) {
                    actualMenus.add(text.toLowerCase());
                }
            } catch (Exception e) {
                test.log(Status.WARNING, "Exception in menu clickability check: " + e.getMessage());
            }
        }

        return actualMenus.containsAll(expectedMenus.stream().map(String::toLowerCase).toList());
    }

    
    
    public boolean isRecentlyAddedSectionVisible() {
        try {
            WebElement heading = WaitUtils.waitForVisibility(driver, recentlyAddedHeading, 30);
            return heading.isDisplayed();
        } catch (Exception e) {
            test.log(Status.WARNING, "Recently Added section not visible: " + e.getMessage());
            return false;
        }
    }

    
    
    public String getRecentlyAddedHeadingText() {
        try {
            return driver.findElement(recentlyAddedHeading).getText().trim();
        } catch (Exception e) {
            return "[Missing]";
        }
    }

    
   
    public List<LectureCard> getAllRecentlyAddedLectures() {
        List<LectureCard> lectureList = new ArrayList<>();
        List<WebElement> cards = driver.findElements(lectureCards);

        for (WebElement card : cards) {
            lectureList.add(new LectureCard(card));
        }
        return lectureList;
    }

    
    
    
    public class LectureCard {
        private WebElement card;

        public LectureCard(WebElement card) {
            this.card = card;
        }

        public boolean isVisible() {
            return card.isDisplayed();
        }

        public String getTitle() {
            return getChildTextSafe(".item-title span[id*='Lecture_Link']");
        }

        public String getDate() {
            return getChildTextSafe("span[id*='Date_Lbl']");
        }

        public String getCredit() {
            return getChildTextSafe("span[id*='Credits_Lbl']");
        }

        public String getDuration() {
            return getChildTextSafe("span[id*='Length_Lbl']");
        }

        public boolean isPlayButtonVisible() {
            try {
                WebElement playBtn = card.findElement(By.cssSelector("a[title='Play Lecture']"));
                return playBtn.isDisplayed();
            } catch (NoSuchElementException e) {
                return false;
            }
        }

        
        
        private String getChildTextSafe(String cssSelector) {
            try {
                return card.findElement(By.cssSelector(cssSelector)).getText().trim();
            } catch (NoSuchElementException e) {
                return "[Missing]";
            }
        }
    }
}
