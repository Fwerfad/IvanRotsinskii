package hw5.ex2;

import hw5.BaseTest;
import hw5.pages.DifferentElementPage;
import hw5.pages.HomePage;
import javafx.util.Pair;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ExerciseTwoTest extends BaseTest {

    @Test
    public void test() throws FileNotFoundException {
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        HomePage homePage = new HomePage(driver);
        driver.manage().window().maximize();
        Scanner scanner = new Scanner(new File("src/main/java/resources/properties.txt"));
        String login = scanner.next(), password = scanner.next();
        scanner.close();
        SoftAssert softAssert = new SoftAssert();
        // 1 Test site is opened
        softAssert.assertNotEquals(driver.getTitle(),"Page not found · GitHub Pages");
        // 2 Browser title equals "Home Page"
        softAssert.assertEquals(driver.getTitle(),"Home Page");
        // 3 Perform login
        homePage.login(login, password);
        softAssert.assertTrue(!homePage.getUserName().equals(""));
        // 4 Assert User name in the left-top side of screen that user is logged
        softAssert.assertEquals(homePage.getUserName(), "ROMAN IOVLEV");
        // 5 Open through the header menu Service -> Different Elements Page
        homePage.navToDifferentElementPage();
        DifferentElementPage differentElementPage = new DifferentElementPage(driver);
        softAssert.assertEquals(driver.getTitle(), "Different Elements");
        // 6 Select checkboxes
        ArrayList<Boolean> flags = differentElementPage.switchCheckboxes(new ArrayList<>(Arrays.asList("Water", "Wind")));
        softAssert.assertTrue(!flags.contains(false), "6 is wrong");
        // 7 Select radio
        boolean flag = differentElementPage.selectRadio("Selen");
        softAssert.assertTrue(flag, "7 is wrong");
        // 8 Select in dropdown
        flag = differentElementPage.selectInDropdown("Yellow");
        softAssert.assertTrue(flag, "8 is wrong");
        // 9 Assert that logs are displayed
        flags = differentElementPage.checkLogs(new ArrayList<>(Arrays.asList(new Pair<>("Colors:", "Yellow"),
                new Pair<>("Wind:", "true"), new Pair<>("Water:", "true"), new Pair<>("metal:", "Selen"))));
        softAssert.assertTrue(!flags.contains(false), "9 is wrong");
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
