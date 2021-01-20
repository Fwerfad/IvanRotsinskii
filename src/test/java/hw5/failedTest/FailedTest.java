package hw5.failedTest;

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

@Epic(Epics.epicOne)
public class FailedTest extends BaseTest {

    @Test(description = "Первое задание: падение")
    @Feature(Features.testOne)
    @Story(Features.storyOne)
    @Owner("Ivan Ivanovich")
    public void test() throws Exception {
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
        throw new Exception("Intentional stop");
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
