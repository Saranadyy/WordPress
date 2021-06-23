import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WordPress {
  WebDriver driver;

  @BeforeMethod
    public void setUp() {
    WebDriverManager.chromedriver().setup();
    driver= new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize();

  }

  @Test
  public void testFirstName2() throws InterruptedException {
    driver.get("https://wordpress.com/me");
    Thread.sleep(2000);
    //driver.findElement(By.xpath("//a[contains(text(),'Log In')]")).click();

        // Enter Username
        driver.findElement(By.id("usernameOrEmail")).sendKeys("Enter Username");
        // Click Continue
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        // Enter Password
        driver.findElement(By.id("password")).sendKeys("Enter Password");
        // Click Login
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        // Click logout
        driver.findElement(By.xpath("//button[@title='Log out of WordPress.com']")).click();


  }
}
