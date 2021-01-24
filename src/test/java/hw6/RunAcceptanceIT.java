package hw6;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        plugin = {"io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"}
)
public class RunAcceptanceIT extends AbstractTestNGCucumberTests {

    @BeforeClass
    public void setUp() {
        System.out.println("Before Class set up");
    }
}