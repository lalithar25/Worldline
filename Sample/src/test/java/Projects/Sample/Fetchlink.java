package Projects.Sample;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;
public class Fetchlink {
    private WebDriver driver;
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/documentation/");
    }
    @Test
    public void testFetchAllLinks() {
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        for (WebElement link : allLinks) {
            System.out.println(link.getText() + " - " + link.getAttribute("href"));
        }
    }
    @Test
    public void testSpecificLinkAvailability() {
        WebElement specificLink = driver.findElement(By.partialLinkText("Downloads"));
        Assert.assertNotNull(specificLink, "Specific link is not available.");
    }
    @Test
    public void testSpecificLinkAvailability2() {
        WebElement specificLink = driver.findElement(By.partialLinkText("IE Driver Server"));
        Assert.assertNotNull(specificLink, "Specific link is not available.");
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
