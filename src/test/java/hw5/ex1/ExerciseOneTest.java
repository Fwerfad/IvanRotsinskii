package hw5.ex1;

import hw5.BaseTest;
import hw5.pages.HomePage;
import hw5.steps.ActionStep;
import hw5.steps.AssertionStep;
import hw5.storynames.Epics;
import hw5.storynames.Features;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

@Epic(Epics.epicOne)
public class ExerciseOneTest extends BaseTest {
    @Test(description = "Первое задание: Открытие сайта и проверка")
    @Feature(Features.testOne)
    @Story(Features.storyOne)
    @Owner("Ivan Ivanovich")
    public void test() throws FileNotFoundException {
        ActionStep actionStep = new ActionStep(driver ,"https://jdi-testing.github.io/jdi-light/index.html");
        AssertionStep assertionStep = new AssertionStep(driver ,"https://jdi-testing.github.io/jdi-light/index.html");
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");

        // 1 Test site is opened
        assertionStep.checkTitle();
        // 2 Browser title equals "Home Page"
        assertionStep.titleEquals("Home Page");
        // 3 Perform login
        actionStep.getCredos("src/main/java/resources/properties.txt");
        String login = actionStep.login();
        assertionStep.login(login);
        // 4 Assert Username is logged
        assertionStep.checkLogin(login, "ROMAN IOVLEV");
        // 5 Assert that there are 4 items on the header section are displayed and they have proper texts
        assertionStep.checkElements(actionStep.checkElements());
        // 6 Assert that there are 4 images on the Index Page and they are displayed
        assertionStep.checkImages(actionStep.getNumberOfBenefitIcons(), 4);
        // 7 Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertionStep.checkTexts(actionStep.getNumberOfBenefitTexts(), 4);
        // 8 Assert that there is the iframe with “Frame Button” exist
        assertionStep.checkFrame(actionStep.checkFrame());
        // 9 Switch to the iframe and check that there is “Frame Button” in the iframe
        assertionStep.checkFrameButton(actionStep.checkFrameButton());
        // 10 Switch to original window back
        // it's done in 9 point
        assertionStep.checkReturned();
        // 11 Assert that there are 5 items in the Left Section are displayed and they have proper text
        assertionStep.checkLeftBarElements(actionStep.checkSideBarElements(new ArrayList<>(Arrays.asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs"))));
        // 12 Close Browser
        assertionStep.close();
    }
}
