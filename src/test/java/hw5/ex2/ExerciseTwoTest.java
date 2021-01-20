package hw5.ex2;

import hw5.BaseTest;
import hw5.pages.DifferentElementPage;
import hw5.steps.ActionStep;
import hw5.steps.AssertionStep;
import hw5.storynames.Epics;
import hw5.storynames.Features;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import javafx.util.Pair;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

@Epic(Epics.epicTwo)
public class ExerciseTwoTest extends BaseTest {

    @Test(description = "Второе задание: переключатели ")
    @Feature(Features.testTwo)
    @Story(Features.storyTwo)
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
        // 4 Assert User name in the left-top side of screen that user is logged
        assertionStep.checkLogin(login, "ROMAN IOVLEV");
        // 5 Open through the header menu Service -> Different Elements Page
        actionStep.navToDifferentElementPage();
        DifferentElementPage differentElementPage = new DifferentElementPage(driver);
        assertionStep.checkDifferentElementPage("Different Elements");
        // 6 Select checkboxes
        assertionStep.switchCheckboxes(actionStep.switchCheckboxes(new ArrayList<>(Arrays.asList("Water", "Wind"))));
        // 7 Select radio
        assertionStep.selectRadio(actionStep.selectRadio("Selen"));
        // 8 Select in dropdown
        assertionStep.selectInDropdown(actionStep.selectInDropdown("Yellow"));
        // 9 Assert that logs are displayed
        assertionStep.checkLogs(actionStep.checkLogs(new ArrayList<>(Arrays.asList(new Pair<>("Colors:", "Yellow"),
                new Pair<>("Wind:", "true"), new Pair<>("Water:", "true"), new Pair<>("metal:", "Selen")))));
        // 10 Close Browser
        assertionStep.close();
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
