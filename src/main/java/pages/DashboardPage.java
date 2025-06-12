package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;



public class DashboardPage extends BasePage 
{

    private By topMenuItems = By.xpath("//ul[@class='megamenu']//a");
    private By recentlyAddedHeading= By.xpath("//h1[normalize-space()=' Recently Added']"); 
    private By lectureCards = By.xpath("(//ul[@class='libitems'])[1]");

    public String getCurrentPageUrl()
    {
        return driver.getCurrentUrl();
    }

    public List<String> getAllTopMenuTexts() 
    {
        List<WebElement> elements = driver.findElements(topMenuItems);
        List<String> menuTexts = new ArrayList<>();

        for (WebElement element : elements) 
        {
            String text = element.getText().trim();
            if (!text.isEmpty()) {
                menuTexts.add(text);
            }
        }
        return menuTexts;
    }

    public boolean areAllMenusVisibleAndClickable(List<String> expectedMenus)
    {
        List<WebElement> elements = driver.findElements(topMenuItems);
        List<String> actualMenus = new ArrayList<>();

        test.log(Status.INFO, "Menu Validation Start");

        for (WebElement el : elements) {
            try {
                String text = el.getText().trim();
                if (!text.isEmpty()) {
                    if (el.isDisplayed() && el.isEnabled())
                    {
                        actualMenus.add(text.toLowerCase());
                        test.log(Status.INFO, "Menu: '" + text + "' is visible and clickable.");
                    } else {
                        test.log(Status.WARNING, "Menu: '" + text + "' is NOT visible or clickable.");
                    }
                }
            } catch (Exception e) {
                test.log(Status.FAIL, "Exception while checking menu item: " + e.getMessage());
            }
        }

        test.log(Status.INFO, "Expected Menus: " + expectedMenus.toString());
        test.log(Status.INFO, "Actual Menus Found: " + actualMenus.toString());


     
        List<String> normalizedExpectedMenus = new ArrayList<>();
        for (String menu : expectedMenus) {
            normalizedExpectedMenus.add(menu.toLowerCase());
        }

        return actualMenus.containsAll(normalizedExpectedMenus);
    }
    
    
    
  
    
  
  

    public boolean isRecentlyAddedSectionVisible() {
        try {
            boolean visible = driver.findElement(recentlyAddedHeading).isDisplayed();
            test.log(Status.INFO, "'Recently Added' section visible: " + visible);
            return visible;
        } catch (Exception e) {
            test.log(Status.WARNING, "Recently Added' heading not found.");
            return false;
        }
    }

    public String getRecentlyAddedHeadingText() {
        try {
            String heading = driver.findElement(recentlyAddedHeading).getText().trim();
            test.log(Status.INFO, "Recently Added Heading: " + heading);
            return heading;
        } catch (Exception e) {
            return "[Heading Not Found]";
        }
    }

    public List<LectureCard> getAllRecentlyAddedLectures() {
        List<LectureCard> lectureList = new ArrayList<>();
        List<WebElement> cards = driver.findElements(lectureCards);
        test.log(Status.INFO, "Total lectures found: " + cards.size());

        for (int i = 0; i < cards.size(); i++) {
            LectureCard card = new LectureCard(cards.get(i));
            lectureList.add(card);

            test.log(Status.INFO, "\n Lecture #" + (i + 1));
            test.log(Status.INFO, "Title: " + card.getTitle());
            test.log(Status.INFO, "Date: " + card.getDate());
            test.log(Status.INFO, "Credit: " + card.getCredit());
            test.log(Status.INFO, "Duration: " + card.getDuration());
            test.log(Status.INFO, "Play Button Visible: " + card.isPlayButtonVisible());
            test.log(Status.INFO, "Card Visible: " + card.isVisible());
        }

        return lectureList;
    }


    public class LectureCard {
        private WebElement card;

        public LectureCard(WebElement card) {
            this.card = card;
        }

        public boolean isVisible() {
            try {
                return card.isDisplayed();
            } catch (Exception e) {
                return false;
            }
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
            } catch (NoSuchElementException e) 
            {
                return "[Missing]";
            }
        }
    }
}    
    


