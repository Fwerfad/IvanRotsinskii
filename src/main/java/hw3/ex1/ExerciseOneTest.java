package hw2.ex1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class ExerciseOneTest {
    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void setupTest() {
        this.driver = new ChromeDriver();
    }

    @Test
    public void test() {
        this.driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        driver.manage().window().maximize();
        SoftAssert softAssert = new SoftAssert();
        // 1 Test site is opened
        softAssert.assertNotEquals(driver.getTitle(),"Page not found · GitHub Pages");
        // 2 Browser title equals "Home Page"
        softAssert.assertEquals(driver.getTitle(),"Home Page");
        // 3 Perform login
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys("Roman");
        driver.findElement(By.id("password")).sendKeys("Jdi1234");
        driver.findElement(By.id("login-button")).click();
        softAssert.assertTrue(!driver.findElement(By.id("user-name")).getText().equals(""));
        // 4 Assert Username is logged
        String username = driver.findElement(By.id("user-name")).getText();
        softAssert.assertEquals(username, "ROMAN IOVLEV");
        // 5 Assert that there are 4 items on the header section are displayed and they have proper texts
        boolean[] flags = {false, false, false, false};
        for (WebElement elem : driver.findElement(By.className("navbar-nav")).findElements(By.tagName("li"))) {
            switch (elem.getText()) {
                case ("HOME"):
                    flags[0] = true;
                    break;
                case ("CONTACT FORM"):
                    flags[1] = true;
                    break;
                case ("SERVICE"):
                    flags[2] = true;
                    break;
                case("METALS & COLORS"):
                    flags[3] = true;
                    break;
            }
        }
        softAssert.assertTrue(flags[0] && flags[1] && flags[2] && flags[3]);
        // 6 Assert that there are 4 images on the Index Page and they are displayed
        int counter = 0;
        WebElement root = driver.findElement(By.cssSelector("div[class='row clerafix benefits']"));
        for (WebElement elem : root.findElements(By.className("icons-benefit"))) {
            if (elem.isDisplayed()) {
                counter++;
            }
        }
        softAssert.assertEquals(counter, 4);
        // 7 Assert that there are 4 texts on the Index Page under icons and they have proper text
        counter = 0;
        for (WebElement elem : driver.findElements(By.className("benefit"))) {
            if (!elem.findElement(By.className("benefit-txt")).getText().equals("")) {
                counter++;
            }
        }
        softAssert.assertEquals(counter, 4);
        // 8 Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(driver.findElement(By.id("frame")).isDisplayed());
        // 9 Switch to the iframe and check that there is “Frame Button” in the iframe
        softAssert.assertEquals(driver.switchTo().frame("frame").findElement(By.id("frame-button")).isDisplayed(), true);
        // 10 Switch to original window back
        driver.switchTo().defaultContent();
        // 11 Assert that there are 5 items in the Left Section are displayed and they have proper text
        flags = new boolean[] {false, false, false, false, false};
        for (WebElement elem : driver.findElement(By.className("sidebar-menu")).findElements(By.tagName("li"))) {
            switch (elem.getText()) {
                case ("Home"):
                    flags[0] = true;
                    break;
                case ("Contact form"):
                    flags[1] = true;
                    break;
                case ("Service"):
                    flags[2] = true;
                    break;
                case("Metals & Colors"):
                    flags[3] = true;
                    break;
                case("Elements packs"):
                    flags[4] = true;
                    break;
            }
        }
        softAssert.assertTrue(flags[0] && flags[1] && flags[2] && flags[3] && flags[4]);
        // 12 Close Browser
        driver.close();
        softAssert.assertAll();
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
