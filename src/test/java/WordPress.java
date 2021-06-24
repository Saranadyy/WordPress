import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WordPress {
    WebDriver driver;
    String firstName = "Sara";
    String lastName = "Tawdrous";
    String pageTitle = "Log In — WordPress.com";
    String userName = "saranadyy@yahoo.com";
    String password = "Yasser1992";
    String displayName = "saranadyy9600";

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void drop() {
        driver.quit();
    }

    @Test
    public void testPageTitle() {
        driver.get("https://wordpress.com/me");

        String expectedPageTitle = driver.getTitle();

        Assert.assertEquals(pageTitle, expectedPageTitle);
    }

    @Test
    public void testFirstName2() {
        driver.get("https://wordpress.com/me");

        // Enter Username

        driver.findElement(By.id("usernameOrEmail")).sendKeys(userName);
        // Click Continue

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        // Enter Password
        driver.findElement(By.id("password")).sendKeys(password);
        // Click Login
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String expectedFirstName = driver.findElement(By.id("first_name")).getAttribute("value");
        Assert.assertEquals(firstName, expectedFirstName);
    }

    @Test
    public void testLastName() {
        driver.get("https://wordpress.com/me");

        //driver.findElement(By.xpath("//a[contains(text(),'Log In')]")).click();

        // Enter Username
        driver.findElement(By.id("usernameOrEmail")).sendKeys(userName);
        // Click Continue

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        // Enter Password
        driver.findElement(By.id("password")).sendKeys(password);
        // Click Login
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        // Click logout

        String expectedLastName = driver.findElement(By.id("last_name")).getAttribute("value");
        Assert.assertEquals(lastName, expectedLastName);
    }

    @Test
    public void testPublicDisplayName() {
        driver.get("https://wordpress.com/me");

        //driver.findElement(By.xpath("//a[contains(text(),'Log In')]")).click();

        // Enter Username
        driver.findElement(By.id("usernameOrEmail")).sendKeys(userName);
        // Click Continue

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        // Enter Password
        driver.findElement(By.id("password")).sendKeys(password);
        // Click Login
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        // Click logout

        String expectedDisplay_name = driver.findElement(By.id("display_name")).getAttribute("value");
        Assert.assertEquals(displayName, expectedDisplay_name);
    }
}