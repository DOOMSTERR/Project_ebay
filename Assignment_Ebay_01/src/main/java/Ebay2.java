import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.Assert;
import java.time.Duration;

public class Ebay2 {
    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Abhishek Kumar\\Documents\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void testSearch() throws InterruptedException {
        System.out.println("Test started");

        WebElement search_ele = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='gh-ac']")));
        System.out.println("Search bar located");

        search_ele.click();
        System.out.println("Clicked on search bar");

        search_ele.sendKeys("MacBook");
        System.out.println("Typed 'MacBook' in search bar");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        search_ele.clear();
        System.out.println("Cleared the search bar");

        search_ele.sendKeys("Computers/Tablets & Networking");
        System.out.println("Typed 'Computers/Tablets & Networking' in search bar");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='gh-btn']"))).click();
        System.out.println("Clicked the search button");

        WebElement valid_search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Computers/Tablets & Networking']")));
        String search_1 = valid_search.getText();
        System.out.println("Verify the correct result are shown based on the Search Input provided: " + search_1);
        if ("Item Location: North America".equals(search_1)) {
            System.out.println("The correct reuslt page is visible");
        }
        Assert.assertNotNull("", search_1);

        System.out.println("Test completed");
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
