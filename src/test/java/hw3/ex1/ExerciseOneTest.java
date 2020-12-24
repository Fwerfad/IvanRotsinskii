package hw3.ex1;

import hw3.BaseTest;
import hw3.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ExerciseOneTest extends BaseTest {
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
        // 4 Assert Username is logged
        softAssert.assertEquals(homePage.getUserName(), "ROMAN IOVLEV");
        // 5 Assert that there are 4 items on the header section are displayed and they have proper texts
        ArrayList<Boolean> flags = homePage.checkNavbarElementsNames(new ArrayList<>(Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS")));
        softAssert.assertTrue(!flags.contains(false));
        // 6 Assert that there are 4 images on the Index Page and they are displayed
        softAssert.assertEquals(homePage.getNumberOfBenefitIcons(), 4);
        // 7 Assert that there are 4 texts on the Index Page under icons and they have proper text
        softAssert.assertEquals(homePage.getNumberOfBenefitTexts(), 4);
        // 8 Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(homePage.checkIsFrameDisplayed(), "8 is wrong");
        // 9 Switch to the iframe and check that there is “Frame Button” in the iframe
        softAssert.assertTrue(homePage.checkIsFrameButtonIsDisplayed(), "9 is wrong");
        // 10 Switch to original window back
        // it's done in 9 point
        softAssert.assertEquals(driver.getTitle(),"Home Page");
        // 11 Assert that there are 5 items in the Left Section are displayed and they have proper text
        flags = homePage.checkSideBarElements(new ArrayList<>(Arrays.asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs")));
        softAssert.assertTrue(!flags.contains(false));
        // 12 Close Browser
        driver.close();
        softAssert.assertAll();
    }
}
