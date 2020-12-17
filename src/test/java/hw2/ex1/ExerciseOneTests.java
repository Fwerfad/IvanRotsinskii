package hw2.ex1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ExerciseOneTests {
    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        System.out.println("1");
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void setupTest() {
        System.out.println("2");
        this.driver = new ChromeDriver();
    }

    @Test
    public void simpleTest() {
        System.out.println(driver);
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        System.out.println(driver.getTitle());
        driver.close();
        Assert.assertTrue(true);
    }

    @AfterClass
    public void teardown() {
        System.out.println("3");
        if (driver != null) {
            driver.quit();
        }
    }
}
