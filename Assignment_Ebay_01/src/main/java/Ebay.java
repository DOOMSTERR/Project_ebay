import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.Assert;
import java.time.Duration;

public class Ebay {
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
    public void testFilters() throws InterruptedException {
        System.out.println("Test started");

        // Navigate to Electronics > Cell Phones & accessories
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'Electronics')])[2]"))).click();
        System.out.println("Clicked Electronics");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Cell Phones, Smart Watches & Accessories'])[1]"))).click();
        System.out.println("Clicked Cell Phones & Accessories");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'Cell Phones & Smartphones')])[1]"))).click();
        System.out.println("Clicked Cell Phones & Smartphones");


        // Pop-up Clicked
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='All Filters'])[1]"))).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        System.out.println("Closed pop-up");


        // Condition Selection
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='x-overlay__wrapper--left']//div[22]"))).click();
        System.out.println("Opened Condition filter");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.findElement(By.cssSelector("#c3-subPanel-LH_ItemCondition_New_cbx")).click();
        System.out.println("Selected New Condition");


        // Price Selection
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='x-overlay__wrapper--left']//div[23]"))).click();
        System.out.println("Opened Price filter");

        WebElement min_ele = driver.findElement(By.xpath("//input[@aria-label='Minimum Value, US Dollar']"));
        min_ele.click();
        min_ele.sendKeys("100");
        System.out.println("Set minimum price to 100");

        WebElement max_ele = driver.findElement(By.xpath("//input[@aria-label='Maximum Value, US Dollar']"));
        max_ele.click();
        max_ele.sendKeys("300");
        max_ele.sendKeys(Keys.ENTER);
        System.out.println("Set maximum price to 300");


        // Item Location Selection
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='x-overlay__wrapper--left']//div[25]"))).click();
        System.out.println("Opened Item Location filter");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.findElement(By.cssSelector("input[value='North America']")).click();
        System.out.println("Selected North America");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Apply']"))).click();
        System.out.println("Applied filters");


        // Verify filters
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='button'])[4]"))).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // 1st Check
        WebElement filterCondition_1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='brm__item-label'])[1]")));
        String filter_1 = filterCondition_1.getText();
        System.out.println("Filter 1 text: " + filter_1);
        if ("Condition: New".equals(filter_1)) {
            System.out.println("Filter 1 - Condition filter is applied");
        }
        Assert.assertNotNull("Condition: New", filter_1);

        // 2nd Check
        WebElement filterCondition_2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='brm__item-label'])[2]")));
        String filter_2 = filterCondition_2.getText();
        System.out.println("Filter 2 text: " + filter_2);
        if ("Price: $100.00 to $200.00".equals(filter_2)) {
            System.out.println("Filter 2 - Price filter is applied");
        }
        Assert.assertNotNull("Price: $100.00 to $200.00", filter_2);

        // 3rd Check
        WebElement filterCondition_3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='brm__item-label'])[3]")));
        String filter_3 = filterCondition_3.getText();
        System.out.println("Filter 3 text: " + filter_3);
        if ("Item Location: North America".equals(filter_3)) {
            System.out.println("Filter 3 - Item Location filter is applied");
        }
        Assert.assertNotNull("Item Location: North America", filter_3);
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
