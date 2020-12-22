package hw2.ex2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ExerciseTwoTest {
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
        softAssert.assertNotEquals(driver.getTitle(), "Page not found · GitHub Pages");
        // 2 Browser title equals "Home Page"
        softAssert.assertEquals(driver.getTitle(), "Home Page");
        // 3 Perform login
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys("Roman");
        driver.findElement(By.id("password")).sendKeys("Jdi1234");
        driver.findElement(By.id("login-button")).click();
        softAssert.assertEquals(driver.findElement(By.id("user-name")).getText().equals(""), false);
        // 4 Assert User name in the left-top side of screen that user is logged
        String username = driver.findElement(By.id("user-name")).getText();
        softAssert.assertEquals(username, "ROMAN IOVLEV");
        // 5 Open through the header menu Service -> Different Elements Page
        for (WebElement elem : driver.findElement(By.className("navbar-nav")).findElements(By.tagName("li"))) {
            if (elem.getText().equals("SERVICE")) {
                elem.click();
                for (WebElement elem2 : elem.findElement(By.className("dropdown-menu")).findElements(By.tagName("li"))) {
                    if (elem2.getText().equals("DIFFERENT ELEMENTS")) {
                        elem2.findElement(By.tagName("a")).click();
                        break;
                    }
                }
                break;
            }
        }
        softAssert.assertEquals(driver.getTitle(), "Different Elements");
        // 6 Select checkboxes
        boolean[] flags = {false, false};
        for (WebElement elem : driver.findElements(By.className("label-checkbox"))) {
            switch (elem.getText()) {
                case "Water":
                    flags[0] = true;
                    elem.findElement(By.tagName("input")).click();
                    break;
                case "Wind":
                    flags[1] = true;
                    elem.findElement(By.tagName("input")).click();
                    break;
            }
        }
        softAssert.assertTrue(flags[0] && flags[1]);
        // 7 Select radio
        boolean flag = false;
        for (WebElement elem : driver.findElements(By.className("label-radio"))) {
            if (elem.getText().equals("Selen")) {
                elem.findElement(By.tagName("input")).click();
                flag = elem.findElement(By.tagName("input")).isSelected();
            }
        }
        softAssert.assertTrue(flag);
        // 8 Select in dropdown
        flag = false;
        for (WebElement elem : driver.findElement(By.tagName("select")).findElements(By.tagName("option"))) {
            if (elem.getText().equals("Yellow")) {
                elem.click();
                flag = elem.isSelected();
            }
        }
        softAssert.assertTrue(flag);
        // 9 Assert that logs are displayed
        flags = new boolean[] {false, false, false, false};
        for (WebElement elem : driver.findElement(By.className("panel-body-list")).findElements(By.tagName("li"))) {
            String[] str = elem.getText().split(" ");
            switch (str[1]) {
                case "Colors:":
                    flags[0] = str[5].equals("Yellow");
                    break;
                case "Wind:":
                    flags[1] = str[5].equals("true");
                    break;
                case "Water:":
                    flags[2] = str[5].equals("true");
                    break;
                case "metal:":
                    flags[3] = str[5].equals("Selen");
                    break;
            }
        }
        softAssert.assertTrue(flags[0] && flags[1] && flags[2] && flags[3]);
        // 10 Close Browser
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
